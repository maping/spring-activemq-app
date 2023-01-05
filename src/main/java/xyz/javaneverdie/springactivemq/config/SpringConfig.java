
package xyz.javaneverdie.springactivemq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages ="xyz.javaneverdie.springactivemq")
@Import({ MessageConfiguration.class })
public class SpringConfig {
    
}
