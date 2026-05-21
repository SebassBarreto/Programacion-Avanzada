package edu.prueba.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EjemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjemploApplication.class, args);
    }

    @Bean
//metodo para configurar el acceso al proyecto desde otros dominio o puertos
//este metodo permite resolver el problema con las politicas CORS de los navegadores

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //la direccion /** es para que se permita conectar a todos los servicios de /
                //allowedMethods("*").allowedHeaders("*")  deja pasar los metodos y los headers
                // si el backend esta en el mismo dominio y puerto del frontend, no hay necesidad de este metodo
                //o en su defecto se coloca la misma direccion y puerto

                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8383")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };
    }
}
