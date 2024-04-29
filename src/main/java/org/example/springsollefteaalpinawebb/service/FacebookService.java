package org.example.springsollefteaalpinawebb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class FacebookService {
    private static final String FB_FEED_URL = "https://graph.facebook.com/v19.0/me/feed?access_token=EAAXGz0wlGFMBOZBJlEKZC6wJtG2Rjvlp4WDdrK5Vxb46pcoFcGNHoIHPyO0FjZCOSNEm8lkC8XeuNoySWnZA12EnG6J3ZC7zWHGDluO4e0WOvfTTHVzhzZAFzAoMitMZAUlt18ZC4GDaLTuZB4uIJeURqpph5BcmMEXpgrQZAUYV84TfjNayNfZA5nriYBJ8zDnpJE3I9XR4MEtCt49rNMKqMv6ZAvcZD";

    private final JsonParsingService jsonParsingService;

    @Autowired
    public FacebookService(JsonParsingService jsonParsingService) {
        this.jsonParsingService = jsonParsingService;
    }

    public List<String> getFacebookFeed() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(FB_FEED_URL, String.class);
        List<String> messages = jsonParsingService.parseJsonString(response);
        return messages;
    }
}