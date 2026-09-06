package akshitasharma0683_dev.smoly.service;
import akshitasharma0683_dev.smoly.Entity.User;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akshitasharma0683_dev.smoly.Dao.CertificateServiceDao;
import akshitasharma0683_dev.smoly.Entity.Certificate;
import akshitasharma0683_dev.smoly.repository.CertificateRepository;

@Service
public class CertificateService implements CertificateServiceDao {

    @Autowired
    private CertificateRepository certificateRepository;


public Certificate createCertificate(
        String recipientName,
        String certificateTitle,
        String organizationName,
        String template) {

    return createCertificate(
            recipientName,
            certificateTitle,
            organizationName,
            template,
            null
    );
}

   public Certificate createCertificate(
        String recipientName,
        String certificateTitle,
        String organizationName,
        String template,
        User user) {

    Certificate certificate = new Certificate();

    certificate.setRecipientName(recipientName);
    certificate.setCertificateTitle(certificateTitle);
    certificate.setOrganizationName(organizationName);

    certificate.setTemplate(
            template == null || template.isBlank()
                    ? "CLASSIC"
                    : template.toUpperCase()
    );

    certificate.setUser(user);

    certificate.setIssueDate(LocalDate.now());

    certificate.setCertificateId(
            "SM-" + UUID.randomUUID()
                    .toString()
                    .substring(0, 8)
                    .toUpperCase()
    );

    certificate.setVerificationCode(
            UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 12)
    );

    return certificateRepository.save(certificate);
}

    public Certificate getByVerificationCode(String verificationCode) {

        return certificateRepository
                .findByVerificationCode(verificationCode)
                .orElseThrow(() ->
                        new RuntimeException("Certificate not found"));
    }

    public Certificate getCertificateById(Long id) {

        return certificateRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Certificate not found"));
    }
}