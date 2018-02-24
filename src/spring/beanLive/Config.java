package spring.beanLive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.beanLive")
public class Config {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanService beanService(){
        return new BeanService();
    }
}
