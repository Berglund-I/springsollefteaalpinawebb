package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.Facebook;
import org.example.springsollefteaalpinawebb.service.FacebookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class FacebookController {

    private final FacebookService facebookService;

    public FacebookController(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @GetMapping("/facebook-feed")
    public List<Facebook> getFacebookFeed() {
        return facebookService.getFacebookFeed();
    }
}