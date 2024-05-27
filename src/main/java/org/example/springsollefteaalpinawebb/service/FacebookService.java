package org.example.springsollefteaalpinawebb.service;
import org.example.springsollefteaalpinawebb.model.Facebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacebookService {

    private static final String FB_FEED_URL = "https://graph.facebook.com/v19.0/me/feed?access_token=EAAXGz0wlGFMBO3mzyqCNjdxlFggrdUN8ostbESq1B6aHgFA3azqojCIpqfbeBHfhncnUEugAGzZCpAZBL5CzhCQoNw3cpj22LaRZBDMtiCdt1QZABATRjnowcMQhxn0tt6pJZC6T89FR0b3NYn4GvXZAIIm3vNvZBATDJJX4RzMv08tuEW6SS43ZCdPZCw5qllhUZD";

    private final JsonParsingService jsonParsingService;

    @Autowired
    public FacebookService(JsonParsingService jsonParsingService) {
        this.jsonParsingService = jsonParsingService;
    }

    public List<Facebook> getFacebookFeed() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(FB_FEED_URL, String.class);
        List<Facebook> facebookPosts = jsonParsingService.parseJsonString(response);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

        return facebookPosts.stream()
                .map(facebook -> {
                    LocalDate date = LocalDate.parse(facebook.getCreatedTime(), formatter);
                    facebook.setCreatedTime(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    return facebook;
                })
                .collect(Collectors.toList());
    }
}