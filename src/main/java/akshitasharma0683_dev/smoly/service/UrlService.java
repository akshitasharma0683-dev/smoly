package akshitasharma0683_dev.smoly.service;

import akshitasharma0683_dev.smoly.Entity.urlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import akshitasharma0683_dev.smoly.repository.UrlRepository;
import java.util.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {


    @Autowired
    private UrlRepository urlRepository;

    public String createShortUrl(String originalUrl) {

        originalUrl = originalUrl.trim();

        if (originalUrl.isEmpty()) {
            throw new RuntimeException("URL cannot be empty");
        }
        // ✅ Add https if missing
        if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
            originalUrl = "https://" + originalUrl;
        }

        // ✅ Validate URL
        try {
            new java.net.URL(originalUrl).toURI();
        } catch (Exception e) {
            throw new RuntimeException("Invalid URL");
        }

        // ✅ Check duplicate
        Optional<urlMapping> existing = urlRepository.findByOriginalUrl(originalUrl);
        if (existing.isPresent()) {
            return existing.get().getShortCode();
        }

        // ✅ Create new
        String shortCode = generateShortCode();

        urlMapping url = new urlMapping();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        url.setCreatedAt(LocalDateTime.now());
        url.setClickCount(0);

        urlRepository.save(url);

        return shortCode;
    }

    // 🔹 Get Original URL (for redirect)
    public String getOriginalUrl(String shortCode) {

        urlMapping url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        // increase click count
        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);

        return url.getOriginalUrl();
    }

    public urlMapping getStats(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
    // 🔹 Generate Short Code
    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
