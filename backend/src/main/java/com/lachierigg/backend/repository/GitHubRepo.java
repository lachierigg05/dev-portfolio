package com.lachierigg.backend.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

/**
 * Entity class representing a GitHub repository.
 * Maps to the "Repositories" table in the database.
 *
 * @author Your Name
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name="Repositories")
public class GitHubRepo {
    /** Unique identifier for the repository
     * Maps to Github's repository ID. 
     */
    @Id
    @NonNull
    private String id;
    
    /** 
     * Name of the repository
     * This is the name of the repo as it appears on Github 
     */
    @NonNull
    private String name;
    
    /** 
     * Description of the repository
     * Can be null if the repository has no description. 
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
     * Gets the repository's unique identifier
     * @return String id - the repository ID
     */
    @NonNull
     public String getID() { 
        return id; 
    }

    /**
     * Gets the repository name
     * @return String name - the repository name
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Gets the repository description
     * @return the repository description
     */
    public String getDescription() {
        return description;
    }
}