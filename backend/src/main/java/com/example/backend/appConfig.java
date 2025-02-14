package com.example.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appConfig {
	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);
    	/**
	 * Rest template bean to be used to make rest calls
	 * within a class
	 *
	 * @param builder builder class for a rest template
	 * @return rest template to make rest calls
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		logger.info("Initialising RestTempalte bean");
        return builder.build();
	}
}
