package com.monkey.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author tao
 * @date 2020/10/9 8:48 下午
 */
@Aspect
@Component
public class ServiceLogAspect {

    public static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * AOP通知
     * 1. 前置通知：在方法调用之前执行
     * 2. 后置通知：在方法正常调用之后执行
     * 3. 环绕通知：在方法调用之前和之后，都分别可以执行的通知
     * 4. 异常通知：如果在方法调用过程中发生异常，则通知
     * 5. 最终通知：在方法调用之后通知
     */
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("====== 开始执行 {}.{} ======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        // 记录开始时间
        long begin = System.currentTimeMillis();

        // 执行目标service
        Object result = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();
        long takeTime = end - begin;

        if (takeTime > 3000) {
            logger.error("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else if (takeTime > 2000) {
            logger.warn("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else {
            logger.info("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }

        return result;
    }
}

