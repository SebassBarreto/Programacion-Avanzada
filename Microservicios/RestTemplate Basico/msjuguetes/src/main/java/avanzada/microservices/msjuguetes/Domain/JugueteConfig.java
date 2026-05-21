
package avanzada.microservices.msjuguetes.Domain;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JugueteConfig {
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
    
     @Bean
    public RestTemplate resTemplateBean() {
        return new RestTemplate();
    }
}
