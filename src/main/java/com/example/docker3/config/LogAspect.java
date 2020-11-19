package com.example.docker3.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//日志

/**
 * 2112121
 */
@Component
@Aspect
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * //.*.*代表所有子目录下的所有方法，最后括号里(..)的两个..代表所有参数
     */
    @Pointcut("execution(public * com.example.docker3.controller.*.*(..))")
    public void requestLog() {
    }

    @Before("requestLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            logger.info("url={}", request.getRequestURL());
            logger.info("method={}", request.getMethod());
            logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("args={}", Arrays.toString(joinPoint.getArgs()));

        }
    }

    @AfterReturning(returning = "object", pointcut = "requestLog()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }
}