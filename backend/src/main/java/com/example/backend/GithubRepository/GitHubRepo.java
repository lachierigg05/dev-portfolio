package com.example.backend.GithubRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

/**
 * Entity class representing a GitHub GithubRepository.
 * Maps to the "Repositories" table in the database.
 *
 * @author Lachie Rigg
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name="Repositories")
public class GitHubRepo {
    /** Unique identifier for the GithubRepository
     * Maps to Github's GithubRepository ID.
     */
    @Id
    @NonNull
    private String id;
    
    /** 
     * Name of the GithubRepository
     * This is the name of the repo as it appears on Github 
     */
    @NonNull
    private String name;
    
    /** 
     * Description of the GithubRepository
     * Can be null if the GithubRepository has no description.
     */
    private String description;

    /**
     * Default constructor required by JPA
     */
    public GitHubRepo() { 
        this.id = "";
        this.name = ""; 
    }

    /**
     * Parameterised constructor
     */
    public GitHubRepo(@NonNull String id, @NonNull String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the GithubRepository's unique identifier
     * @return String id - the GithubRepository ID
     */
    @NonNull
     public String getID() { 
        return id; 
    }

    /**
     * Gets the GithubRepository name
     * @return String name - the GithubRepository name
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Gets the GithubRepository description
     * @return the GithubRepository description
     */
    public String getDescription() {
        return description;
    }
}