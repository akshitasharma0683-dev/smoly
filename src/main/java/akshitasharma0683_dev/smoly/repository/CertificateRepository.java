package akshitasharma0683_dev.smoly.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import akshitasharma0683_dev.smoly.Entity.Certificate;
@Repository
public interface CertificateRepository
        extends JpaRepository<Certificate, Long> {

    Optional<Certificate> findByVerificationCode(String verificationCode);

}
