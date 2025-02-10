package com.example.backend.repository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubRepoService {
    private final GitHubRepoRepository gitHubRepoRepository;
    private final RestTemplate restTemplate;

    public GitHubRepoService(RestTemplate restTemplate, GitHubRepoRepository gitHubRepoRepository) {
        this.gitHubRepoRepository = gitHubRepoRepository;
        this.restTemplate = restTemplate;
    }

    public List<GitHubRepo> getAllRepositories() {
        return gitHubRepoRepository.findAll();
    }

    // TODO - Add scheduled task for deployment -> @Scheduled(fixedRate = 86400000)
    public void updateRepositories() {
        GitHubRepo[] repos = restTemplate.getForObject("https://api.github.com/users/lachierigg05/repos", GitHubRepo[].class);
        
        if (repos != null) {
            for (GitHubRepo r : repos) {
                System.out.println(r.getName());
                gitHubRepoRepository.saveAll(Arrays.asList(repos));
            }
        }
    }
}
