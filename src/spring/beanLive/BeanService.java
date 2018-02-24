package spring.beanLive;

public class BeanService {
 public  void init(){
     System.out.println("@Bean-init-method");
 }
 public void destroy(){
     System.out.println("@Bean-destroy-method");
 }

    public BeanService() {
        super();
        System.out.println("初始化构造函数－BeanService");
    }
}
