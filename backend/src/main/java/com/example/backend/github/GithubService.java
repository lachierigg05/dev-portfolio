package com.example.backend.github;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;

import java.util.List;

@Service
public class GithubService {

    @Value("${github.token}")
    private String githubToken;

    private final RestTemplate restTemplate;

    public GithubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Repository> getRepositories(String username) {
        String url = String.format("https://api.github.com/users/%s/repos", username);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + githubToken);

        HttpEntity<List<Repository>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Repository>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Repository>>() {}
        );

        return response.getBody();
    }
}
