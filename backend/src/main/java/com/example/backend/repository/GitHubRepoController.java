package com.example.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubRepoController {
    private final GitHubRepoService gitHubService;

    @Autowired
    public GitHubRepoController(GitHubRepoService gitHubService) {
        this.gitHubService = gitHubService;
    };

    @GetMapping("/projects")
    public List<GitHubRepo> getRepositories() {
        return gitHubService.getAllRepositories();
    };
}
