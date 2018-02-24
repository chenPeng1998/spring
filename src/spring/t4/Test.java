package spring.t4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(Config.class);
        DemmoAnnotationService das=context.getBean(DemmoAnnotationService.class);
        DemmonMetondService dms=context.getBean(DemmonMetondService.class);
        das.add();
        dms.add();
        context.close();
    }
}
