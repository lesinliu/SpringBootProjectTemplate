package com.project.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class AopConfig {
    private static Logger logger = LoggerFactory.getLogger(AopConfig.class);

    /**
     * 切入点
     */
    @Pointcut("execution(* com.project.demo.controller.TestController.*(..)) ")
    public void executionService() {}

    /**
     * 方法调用之前调用
     *
     * @param joinPoint
     */

    @Before(value = "executionService()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("Before");
    }
    /**
     * 方法之后调用
     *
     * @param joinPoint
     * @param returnValue 方法返回值
     */

    @AfterReturning(pointcut = "executionService()", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        logger.info("AfterReturning");
    }

    /**
     * 统计方法执行耗时Around环绕通知
     *
     * @param joinPoint
     * @return
     */

    @Around("executionService()")
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("Around");
        return obj;
    }


}
