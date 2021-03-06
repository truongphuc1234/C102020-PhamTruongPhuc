package cg.wbd.grandemonstration.concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }

    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.findAll(..))")
    public void log(){

    }
}
