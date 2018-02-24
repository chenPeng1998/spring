package spring.t4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//配置类
@Configuration
@ComponentScan("spring.t4")
@EnableAspectJAutoProxy//开启对AspectJ代理的支持
public class Config {
}
