package br.com.empresa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpresaConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
