package spring.executor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncService asyncService=context.getBean(AsyncService.class);
        for (int i=0;i<10;i++){
            asyncService.executeTask(i);
            asyncService.executeTaskPius(i);
        }
        context.close();
    }
}
