package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GitHubRepoRepository extends JpaRepository<GitHubRepo, Long> {
}
