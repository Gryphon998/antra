package com.example.antra.dto;

import lombok.Data;

@Data
public class ArticleUser {
    private int id;
    private String username;
    private String about;
    private int submitted;
    private String updated_at;
    private int submission_count;
    private int comment_count;
    private String created_at;
}
