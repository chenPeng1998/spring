package spring.t4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 编写切面
 */
@Aspect//声明一个切面
@Component//让切面成为spring容器管理的bean
public class LogAspect {
    @Pointcut("@annotation(spring.t4.Action)")//声明切点
    public void annotationPointCut(){}
    @After("annotationPointCut()")//声明建言 使用@poincut定义的切点
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        Action action=method.getAnnotation(Action.class);//反射获得属性
        System.out.println("注解式拦截"+action.name());
    }

    @Before("execution(* spring.t4.DemmonMetondService.*(..))")//声明建言 直接使用拦截规则作为参数
    public void before(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法式规则式拦截"+method.getName());
    }
}
