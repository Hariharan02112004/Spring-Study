package com.Projects.JobApplication.SpringAOP;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAOPClass {
    public static final Logger = LoggerFactory.getLogger(SpringAOPClass.class);
    @Before("execution(* com.telusko.JobApp.service.JobService.*(..))")
    public void logMethod(){
        Logger.info("Method called");
    }

}