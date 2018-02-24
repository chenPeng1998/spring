package spring.el;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig el=context.getBean(ElConfig.class);
        el.outputResource();
        context.close();

    }
}
