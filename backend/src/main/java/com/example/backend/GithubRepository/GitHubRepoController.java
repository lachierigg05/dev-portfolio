package com.example.backend.GithubRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for handling GithubRepository operations.
 * Provides endpoints for retrieving GithubRepository information.
 *
 * @author Lachie Rigg
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class GitHubRepoController {
    /** Service layer for GithubRepository operations */
    private final GitHubRepoService gitHubService;

    /**
     * Constructs a new GitHubRepoController with the required service.
     *
     * @param gitHubService the service to handle GithubRepository operations
     */
    public GitHubRepoController(GitHubRepoService gitHubService) {
        this.gitHubService = gitHubService;
    }

    /**
     * Retrieves all GitHub repositories from the database.
     *
     * @return List<GitHubRepo> a list of all GitHub repositories
     */
    @GetMapping("/projects")
    public List<GitHubRepo> getRepositories() {
        return gitHubService.getAllRepositories();
    }
}
