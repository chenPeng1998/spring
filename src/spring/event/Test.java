package spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(Config.class);
        DemoPublish demoPublish=context.getBean(DemoPublish.class);
        demoPublish.publish("hello");
        context.close();
    }
}
