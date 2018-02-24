package spring.t3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunConfig {
    @Bean
    public FuncService funcService(){
        return new FuncService();
    }
    @Bean
    public UserFunctionService userFunctionService(){
        return new UserFunctionService();
    }
}
