package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.article;
import Repositories.ArticleRepository;

@Service
public class articleImpl implements articleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<article> getArticleById(String id) {
        return articleRepository.findById(id);
    }

    @Override
    public article saveArticle(article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(String id) {
        articleRepository.deleteById(id);
    }
}
