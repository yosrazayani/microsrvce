package controllers;


import Entity.article;
import Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/")
    public article createArticle(@RequestBody article article) {
        return articleRepository.save(article);
    }

    @GetMapping("/findAll")
    public List<article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<article> getArticleById(@PathVariable String id) {
        return articleRepository.findById(id);
    }

    @PutMapping("/{id}")
    public article updateArticle(@PathVariable String id, @RequestBody article articleDetails) {
        Optional<article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            article article = optionalArticle.get();
            article.setTitle(articleDetails.getTitle());
            article.setContent(articleDetails.getContent());
            article.setAuthor(articleDetails.getAuthor());
            return articleRepository.save(article);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleRepository.deleteById(id);
    }
}
