package com.example.backend;

import com.example.backend.repository.GitHubRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

/**
 * The main spring boot application class
 */
@SpringBootApplication
public class BackendApplication {
	private final GitHubRepoService gitHubRepoService;
	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);

	/**
	 * Constructor for backend application
	 * @param gitHubRepoService the service class for the gitHubRepo
	 */
	@Autowired
	public BackendApplication(GitHubRepoService gitHubRepoService) {
		this.gitHubRepoService = gitHubRepoService;
	}

	/**
	 * Entry point for the application
	 */
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

	/**
	 * Rest template bean to be used to make rest calls
	 * within a class
	 *
	 * @param builder builder class for a rest template
	 * @return rest template to make rest calls
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/**
	 * Bean to update repositories from the Github api to the database
	 * This method is executed after the application context is loaded and right before the Spring Applicaiton run method is completed
	 *
	 * @return a Command Line Runner instance
	 * @throws Exception if an error occurs during the updating of repositories
	 */
	@Bean
	@Profile("!test")
	public CommandLineRunner run() throws Exception {
		return args -> {
			try {
				gitHubRepoService.updateRepositories();
			} catch (Exception e) {
				System.err.println("Error updating repositories: " + e.getMessage());
				logger.error("Error updating repositories - repositories not updated.");
			}
		};
	}

}
