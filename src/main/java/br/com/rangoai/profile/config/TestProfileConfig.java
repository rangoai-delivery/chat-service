package br.com.rangoai.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Profile("test")
public class TestProfileConfig {

	@Bean
	boolean initialize() {

		return true;

	}

}