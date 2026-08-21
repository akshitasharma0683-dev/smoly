package akshitasharma0683_dev.smoly.Dao;

import akshitasharma0683_dev.smoly.Entity.urlMapping;

/**
 * UrlServiceDao
 */
public interface UrlServiceDao {
    public String createShortUrl(String originalUrl);
    public String getOriginalUrl(String shortCode);
    public urlMapping getStats(String shortCode);

}
