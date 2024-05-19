package org.example.springsollefteaalpinawebb.controller;
import org.example.springsollefteaalpinawebb.model.FacebookPicture;
import org.example.springsollefteaalpinawebb.service.FacebookPictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class FacebookPictureController {

    private final FacebookPictureService facebookPictureService;

    public FacebookPictureController(FacebookPictureService facebookPictureService) {
        this.facebookPictureService = facebookPictureService;
    }

    @GetMapping("/facebook-pictures")
    public List<FacebookPicture> getFacebookPictures() {
        return facebookPictureService.getFacebookPictures();
    }

    @GetMapping("/facebook-picture/{id}")
    public ResponseEntity<String> getFacebookPicture(@PathVariable String id) {
        try {
            String base64Image = facebookPictureService.getPictureAsBase64(id);
            return ResponseEntity.ok(base64Image);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching image");
        }
    }
}