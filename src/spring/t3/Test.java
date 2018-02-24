package spring.t3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(FunConfig.class);
        UserFunctionService userFunctionService=context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.SayHello("wold"));
        context.close();
    }
}
