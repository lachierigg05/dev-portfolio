package com.example.backend.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for handling GitHub repository operations.
 * Provides endpoints for retrieving GitHub repository information.
 *
 * @author Lachie Rigg
 * @version 1.0
 * @since 1.0
 */
@RestController
public class GitHubRepoController {
    /** Service layer for GitHub repository operations */
    private final GitHubRepoService gitHubService;

    /**
     * Constructs a new GitHubRepoController with the required service.
     *
     * @param gitHubService the service to handle GitHub repository operations
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
