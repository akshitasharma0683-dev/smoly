package akshitasharma0683_dev.smoly.controller;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> shortenUrl(@RequestBody UrlRequest request,
                                        HttpServletRequest httpRequest) {

        try {
            String shortCode = urlService.createShortUrl(request.getUrl());

            String baseUrl = httpRequest.getRequestURL()
                    .toString()
                    .replace(httpRequest.getRequestURI(), "");

            String shortUrl = baseUrl + "/" + shortCode;

            return ResponseEntity.ok(Map.of("shortUrl", shortUrl));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Invalid URL"));
        }
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