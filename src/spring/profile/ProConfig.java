package spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("spring.profile")
public class ProConfig {
    @Bean
    @Profile("mysql")
    public ProfileDemo mysqlProfileDemo(){
        return new ProfileDemo("mysql");
    }
    @Bean
    @Profile("orc")
    public ProfileDemo orcProfileDemo(){
        return new ProfileDemo("orc");
    }
}
