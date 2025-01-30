package com.example.backend.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Repositories")
public class GitHubRepo {
    @Id
    private String id;
    private String name;
    private String description;

    public GitHubRepo(){};

    public String getID() { return id; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
