package com.monkey.exception;

import com.monkey.utils.JsonResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @author tao
 * @date 2020/10/24 2:05 下午
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 上传文件超过500k，捕获异常：MaxUploadSizeExceededException
     * @param exceededException
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public JsonResult handleMaxUploadFile(MaxUploadSizeExceededException exceededException) {
        return JsonResult.errorMsg("文件上传大小不能超过500k，请压缩图片或降低图片质量再上传！");
    }
}
