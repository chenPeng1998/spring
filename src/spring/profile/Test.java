package spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("orc");
        context.register(ProConfig.class);
        context.refresh();

        ProfileDemo profileDemo=context.getBean(ProfileDemo.class);
        System.out.println(profileDemo.getContent());

    }
}
