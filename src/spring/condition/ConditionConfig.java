package spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsService(){
        return new WindowsService();
    }
    @Bean
    @Conditional(LinxCondition.class)
    public ListService linuxService(){
        return new LinuxService();
    }
}
