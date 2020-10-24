package com.monkey.controller.center;

import com.monkey.controller.BaseController;
import com.monkey.pojo.Users;
import com.monkey.pojo.bo.center.CenterUserBO;
import com.monkey.resource.FileUpload;
import com.monkey.service.center.CenterUserService;
import com.monkey.utils.CookieUtils;
import com.monkey.utils.DateUtil;
import com.monkey.utils.JsonResult;
import com.monkey.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tao
 * @date 2020/10/23 7:22 下午
 */
@Api(value = "用户信息接口", tags = {"用户信息相关接口"})
@RestController
@RequestMapping("userInfo")
public class CenterUserController extends BaseController {

    @Resource
    private CenterUserService centerUserService;

    @Resource
    private FileUpload fileUpload;

    @ApiOperation(value = "用户头像修改", notes = "用户头像修改", httpMethod = "POST")
    @PostMapping("uploadFace")
    public JsonResult uploadFace(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "file", value = "用户头像", required = true)
            MultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response) {

        // 定义头像保存的地址
        // String fileSpace = IMAGE_USER_FACE_LOCATION;
        String fileSpace = fileUpload.getImageUserFaceLocation();

        // 在路径上为每一个用户增加一个userId, 用于区分不同用户上传
        String uploadPathPrefix = File.separator + userId;

        // 开始文件上传
        if (file != null) {
            // 获得文件上传的文件名称
            String fileName = file.getOriginalFilename();
            FileOutputStream fileOutputStream = null;
            try {
                if (StringUtils.isNotBlank(fileName)) {
                    // face-{userId}.png
                    String[] fileNameArr = fileName.split("\\.");
                    // 获取文件的后缀名
                    String suffix = fileNameArr[fileNameArr.length - 1];
                    // 文件名称重组, 覆盖式上传，增量式：额外拼接当前时间
                    String newFileName = "face-" + userId + "." + suffix;

                    // 上传的头像最终保存的位置
                    String finalFacePath = fileSpace + uploadPathPrefix + File.separator + newFileName;

                    // 用于提供给web服务访问的地址
                    uploadPathPrefix += ("/" + newFileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null) {
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    InputStream inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            return JsonResult.errorMsg("文件不能为空");
        }

        // 获取图片服务地址
        String imageServerUrl = fileUpload.getImageServerUrl();

        // 由于浏览器可能存在缓存的情况，所以在这里，我们需要加上时间戳来保证更新后的图片可以及时更新
        String finalUserFaceUrl = imageServerUrl + uploadPathPrefix + "?t=" + DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN);

        // 更新用户头像到数据库
        Users user = centerUserService.updateUserFace(userId, finalUserFaceUrl);

        setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);

        // TODO 后续会改，增加令牌token，会整合进redis，分布式会话

        return JsonResult.ok();
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST")
    @PostMapping("update")
    public JsonResult update(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @RequestBody @Valid CenterUserBO centerUserBO,
            BindingResult bindingResult,
            HttpServletRequest request,
            HttpServletResponse response) {

        // 判断bindingResult是否包含错误的验证信息，如果有，则直接return
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            return JsonResult.errorMap(errors);
        }

        Users user = centerUserService.updateUserInfo(userId, centerUserBO);
        setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);

        // TODO 后续会改，增加令牌token，会整合进redis，分布式会话

        return JsonResult.ok(user);
    }

    private Map<String, String> getErrors(BindingResult result) {

        Map<String, String> map = new HashMap<>();

        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            // 发生错误验证所对应的一个属性
            String errorField = fieldError.getField();
            // 验证错误的信息
            String errorMessage = fieldError.getDefaultMessage();
            map.put(errorField, errorMessage);
        }

        return map;
    }

    private void setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
    }
}
