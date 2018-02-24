package spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScope {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(ScopeConfig.class);
        SingletonService s1=context.getBean(SingletonService.class);
        SingletonService s2=context.getBean(SingletonService.class);
        ProtoTypeService p1=context.getBean(ProtoTypeService.class);
        ProtoTypeService p2=context.getBean(ProtoTypeService.class);
        System.out.println("Sig : "+s1.equals(s2));
        System.out.println("pro : "+p1.equals(p2));

    }
}
