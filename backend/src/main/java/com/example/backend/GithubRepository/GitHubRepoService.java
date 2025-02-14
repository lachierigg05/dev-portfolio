package com.example.backend.GithubRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubRepoService {
    private final GitHubRepoRepository gitHubRepoRepository;
    private final RestClient restClient;
    private static final Logger logger = LoggerFactory.getLogger(GitHubRepoService.class);

    private static final String GITHUB_USERNAME = "lachierigg05";
    private static final String GITHUB_API_URL = "https://api.github.com/users/" + GITHUB_USERNAME + "/repos";

    public GitHubRepoService(RestClient restClient, GitHubRepoRepository gitHubRepoRepository) {
        this.gitHubRepoRepository = gitHubRepoRepository;
        this.restClient = restClient;
    }

    /**
     * Method to get all repositories from the database.
     * This method retrieves the repositories stored in the database,
     * optionally sorted by a field (e.g., name or creation date).
     *
     * @return a list of GitHub repositories stored in the database
     */
    public List<GitHubRepo> getAllRepositories() {
        // Retrieve all repositories from the database, sorted alphanumerically by name
        return gitHubRepoRepository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    /**
     * Method to update the database with the current repos
     * on the user's GitHub account.
     * This will also check if any repositories are no longer present
     * on GitHub and remove them from the database.
     */
    public void updateRepositories() {
        // Fetch repositories from GitHub API
        GitHubRepo[] repos = restClient.get()
                .uri(GITHUB_API_URL)
                .retrieve()
                .body(GitHubRepo[].class);

        if (repos != null) {
            logger.info("Repositories found - pulling repositories from Github");

            // Get the list of repositories from the database
            List<GitHubRepo> existingRepos = gitHubRepoRepository.findAll();

            // Convert GitHub API response to a list for easy comparison
            List<GitHubRepo> currentRepos = Arrays.asList(repos);

            // Loop through the repositories in the database
            for (GitHubRepo existingRepo : existingRepos) {
                // Check if the repository is present in the current GitHub repositories
                boolean existsOnGithub = currentRepos.stream()
                        .anyMatch(r -> r.getID().equals(existingRepo.getID()));

                // If the repository is not found on GitHub anymore, delete it from the database
                if (!existsOnGithub) {
                    logger.info("Repository {} no longer exists on GitHub. Removing from database.", existingRepo.getName());
                    gitHubRepoRepository.delete(existingRepo);
                }
            }
        } else {
            logger.error("Failed to retrieve repositories from GitHub.");
        }
    }
}