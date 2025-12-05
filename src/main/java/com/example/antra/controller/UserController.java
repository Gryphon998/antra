package com.example.antra.controller;

import com.example.antra.Dto.ArticleUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UserController {
    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        String url = "https://jsonmock.hackerrank.com/api/article_users";
        ArticleUserResponse response = restTemplate.getForObject(url, ArticleUserResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers(@RequestParam int page) {
        String url = "https://jsonmock.hackerrank.com/api/article_user?page=" + page;
        ArticleUserResponse response = restTemplate.getForObject(url, ArticleUserResponse.class);
        return ResponseEntity.ok(response);
    }
}
