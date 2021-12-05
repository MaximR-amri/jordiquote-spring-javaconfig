package be.syntra.common;

import be.syntra.cowsay.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")

public class AppConfig {

    @Bean(initMethod = "initLogger")
    public LoggerConfig loggerConfig(){ //the method name is bean id
        return new LoggerConfig();
    }
    @Bean
    public QuoteDao quoteDao(){
        return new QuoteDaoMysql();
    }
    @Bean
    public CowSay cowSay(){
        return new OriginalCowSay(quoteDao());
    }
}
