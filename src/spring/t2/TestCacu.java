package spring.t2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class TestCacu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        AnnotationConfigApplicationContext
                context=new AnnotationConfigApplicationContext(CaConfig.class);
        UserCaculateService userCaculateService=context.getBean(UserCaculateService.class);
        System.out.println(userCaculateService.useCacu(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
    }
}
