package spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(Config.class);
        AwareService awareService=context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}
