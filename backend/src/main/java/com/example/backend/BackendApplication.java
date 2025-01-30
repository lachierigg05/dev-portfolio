package com.example.backend;

import com.example.backend.repository.GitHubRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendApplication {
	private final GitHubRepoService gitHubRepoService;

	@Autowired
	public BackendApplication(GitHubRepoService gitHubRepoService) {
		this.gitHubRepoService = gitHubRepoService;
	}

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run() throws Exception {
		return args -> {
			gitHubRepoService.updateRepositories();
		};
	}

}
