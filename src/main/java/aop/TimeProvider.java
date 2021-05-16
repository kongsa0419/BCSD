package aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Aspect
public class TimeProvider {
    @AfterReturning(pointcut = "execution( * controller.ProductController.*(..))")
    public void printCurrentTime(JoinPoint jp){
        String current = "";
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
            current = fmt.format(System.currentTimeMillis());
            System.out.print("(AOP) CURRENT TIME : "+ current + "\n");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
