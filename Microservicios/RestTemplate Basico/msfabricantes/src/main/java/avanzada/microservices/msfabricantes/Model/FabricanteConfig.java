package avanzada.microservices.msfabricantes.Model;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FabricanteConfig {
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}