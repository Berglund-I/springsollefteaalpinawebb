package org.example.springsollefteaalpinawebb.service;

import org.example.springsollefteaalpinawebb.model.Facebook;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FacebookService {
    private static final String FB_FEED_URL = "https://graph.facebook.com/v19.0/me/feed?access_token=EAAXGz0wlGFMBO1hLEqArz2jYR7dpLyKkZBeqyxVBcCmumgVU1JBRDYneQktEjLaBtFDCTS2jOnf2D9AzwC4WexYhk0vF5JmLgDEabCNNvQtCEceap8sFm8J9jM4teYZCJhjHfJsngrubTYZArsUhnolfWXixcZBGYAKwjjFl0eaXZBr3z5jPkTnYD";

    public Facebook[] getFeed() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(FB_FEED_URL, Facebook[].class);
    }
}
