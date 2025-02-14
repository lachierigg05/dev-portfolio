package com.example.backend.repository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubRepoService {
    private final GitHubRepoRepository gitHubRepoRepository;
    private final RestClient restClient;
    
    private static final String GITHUB_USERNAME = "lachierigg05";
    private static final String GITHUB_API_URL = "https://api.github.com/users/" + GITHUB_USERNAME + "/repos";
    
    public GitHubRepoService(RestClient restClient, GitHubRepoRepository gitHubRepoRepository) {
        this.gitHubRepoRepository = gitHubRepoRepository;
        this.restClient = restClient;
    }

    /**
     * Simple methods to return the list of github repos 
     * stored in the database 
     * 
     * @return list of github repos from the user
     */
    public List<GitHubRepo> getAllRepositories() {
        return gitHubRepoRepository.findAll();
    }

    /**
     * Method to update the database with the current repos 
     * on the users github account. 
     * 
     */
    public void updateRepositories() {
        GitHubRepo[] repos = restClient.get()
                .uri(GITHUB_API_URL)
                .retrieve()
                .body(GitHubRepo[].class);
            
        if (repos != null) {
            for (GitHubRepo r : repos) {
                System.out.println(r.getName());
                gitHubRepoRepository.saveAll(Arrays.asList(repos));
            }
        }
    }
}
