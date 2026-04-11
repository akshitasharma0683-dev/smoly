package akshitasharma0683_dev.smoly.controller;

import akshitasharma0683_dev.smoly.DTO.UrlRequest;
import akshitasharma0683_dev.smoly.Entity.urlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import akshitasharma0683_dev.smoly.service.UrlService;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlRequest request) {

        String shortUrl = urlService.createShortUrl(request.getUrl());

        return ResponseEntity.ok(Map.of("shortUrl", shortUrl));
    }
    /*🔹 Create short URL
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String originalUrl) {

        String shortUrl = urlService.createShortUrl(originalUrl);

        return ResponseEntity.ok(shortUrl);
    }*/



    @GetMapping("/{shortCode:[a-zA-Z0-9]+}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode) {
        String originalUrl = urlService.getOriginalUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", originalUrl)
                .build();
    }

}