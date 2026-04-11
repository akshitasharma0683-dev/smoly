package akshitasharma0683_dev.smoly.repository;

import akshitasharma0683_dev.smoly.Entity.urlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface UrlRepository extends JpaRepository<urlMapping, Long> {

    Optional<urlMapping> findByShortCode(String shortCode);


}
