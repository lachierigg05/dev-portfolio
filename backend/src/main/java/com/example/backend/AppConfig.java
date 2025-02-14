package com.example.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	/**
	 * Creates and returns a {@link RestClient} bean to be used for making REST calls.
	 * The {@link RestClient} is a non-blocking, reactive web client for making HTTP requests.
	 *
	 * @return a {@link RestClient} instance for making HTTP requests
	 */
	@Bean
	public RestClient restClient() {
		logger.info("Initialising WebClient Bean...");
		return RestClient.create();
	}
}