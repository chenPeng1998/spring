package spring.t1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestFunc {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DiCinfig.class);
        UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("word"));
        context.close();
    }
}
