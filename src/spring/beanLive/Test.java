package spring.beanLive;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(Config.class);
        BeanService beanService=context.getBean(BeanService.class);
        context.close();
    }
}
