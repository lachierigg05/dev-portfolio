package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for GitHubRepo entities.
 * Provides CRUD operations for GitHubRepo objects.
 */
public interface GitHubRepoRepository extends JpaRepository<GitHubRepo, String> {
}
