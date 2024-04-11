package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.News;
import org.example.springsollefteaalpinawebb.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class NewsController {

    @Autowired
            private NewsRepository newsRepository;
    @GetMapping("news")
    public List<News> getNews(){
        return this.newsRepository.findAll(); // Localhost does not work
    }
}
