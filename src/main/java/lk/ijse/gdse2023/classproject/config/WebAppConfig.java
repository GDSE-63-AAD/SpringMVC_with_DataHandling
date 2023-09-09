package lk.ijse.gdse2023.classproject.config;

import lk.ijse.gdse2023.classproject.WebAppInitializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan
@ComponentScan(basePackageClasses = WebAppInitializer.class)
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
