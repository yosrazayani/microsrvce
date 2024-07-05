package com.Service;

import java.util.List;
import java.util.Optional;

import Entity.article;

public interface articleService {
    List<article> getAllArticles();
    Optional<article> getArticleById(String id);  // Note: Using String as ID type
    article saveArticle(article article);  // Changed to saveArticle to match method name convention
    void deleteArticle(String id);  // Note: Using String as ID type
}
