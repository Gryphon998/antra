package com.example.antra.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleUserResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<ArticleUser> data;
}
