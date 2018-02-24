package spring.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(ScheduleConfig.class);

    }
}
