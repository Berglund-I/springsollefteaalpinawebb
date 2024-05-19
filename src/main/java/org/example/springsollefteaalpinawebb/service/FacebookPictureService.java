package org.example.springsollefteaalpinawebb.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.example.springsollefteaalpinawebb.model.FacebookPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.nio.file.Path;

@Service
public class FacebookPictureService {
    private static final String FB_PHOTOS_URL = "https://graph.facebook.com/v19.0/me/photos?access_token=EAAXGz0wlGFMBO3mzyqCNjdxlFggrdUN8ostbESq1B6aHgFA3azqojCIpqfbeBHfhncnUEugAGzZCpAZBL5CzhCQoNw3cpj22LaRZBDMtiCdt1QZABATRjnowcMQhxn0tt6pJZC6T89FR0b3NYn4GvXZAIIm3vNvZBATDJJX4RzMv08tuEW6SS43ZCdPZCw5qllhUZD";

    private final JsonParsingService jsonParsingService;

    @Autowired
    public FacebookPictureService(JsonParsingService jsonParsingService) {
        this.jsonParsingService = jsonParsingService;
    }

    public String getPictureAsBase64(String pictureId) throws Exception {
        String accessToken = "EAAXGz0wlGFMBO3mzyqCNjdxlFggrdUN8ostbESq1B6aHgFA3azqojCIpqfbeBHfhncnUEugAGzZCpAZBL5CzhCQoNw3cpj22LaRZBDMtiCdt1QZABATRjnowcMQhxn0tt6pJZC6T89FR0b3NYn4GvXZAIIm3vNvZBATDJJX4RzMv08tuEW6SS43ZCdPZCw5qllhUZD";
                String urlString = "https://graph.facebook.com/" + pictureId + "/picture?type=large&access_token=" + accessToken;

        URL url = new URL(urlString);
        Path tempFile = Files.createTempFile("image", ".tmp");
        try (InputStream in = url.openStream()) {
            Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
        }

        byte[] fileContent = Files.readAllBytes(tempFile);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return encodedString;
    }

    public List<FacebookPicture> getFacebookPictures() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(FB_PHOTOS_URL, String.class);
        List<FacebookPicture> facebookPictures = jsonParsingService.parseJsonStringToPictures(response);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

        return facebookPictures.stream()
                .map(facebookPicture -> {
                    LocalDate date = LocalDate.parse(facebookPicture.getCreatedTime(), formatter);
                    facebookPicture.setCreatedTime(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    return facebookPicture;
                })
                .collect(Collectors.toList());
    }

}
