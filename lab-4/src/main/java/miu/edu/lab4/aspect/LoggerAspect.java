package miu.edu.lab4.aspect;
import miu.edu.lab4.model.Logger;
import miu.edu.lab4.service.ApplicationLoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.ZoneId;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private ApplicationLoggerService applicationLoggerService;
    private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoggerAspect.class.getName());


    @Around("execution(* edu.miu.lab4.controller.*.*(..))")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            //Execution method
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //Save log
        try {
            saveLog(point, beginTime);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }


    private void saveLog(ProceedingJoinPoint joinPoint, long time) throws Throwable {
        Logger applicationLog = new Logger();
        long start = System.nanoTime();
         joinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(joinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        applicationLog.setTime(finish-start);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        applicationLog.setDate(Instant.ofEpochMilli(time)
                .atZone(ZoneId.of("America/New_York")).toLocalDate());
        applicationLog.setOperation(request.getMethod());
        applicationLog.setPrinciple("Test Principle");
        applicationLog.setOperation("Test Operation");
        applicationLoggerService.saveApplicationLog(applicationLog);
    }


}

