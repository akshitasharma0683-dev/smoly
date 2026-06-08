package akshitasharma0683_dev.smoly.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akshitasharma0683_dev.smoly.Entity.Certificate;
import akshitasharma0683_dev.smoly.repository.CertificateRepository;

@Service
public class CertificateService {
    
    @Autowired
    private CertificateRepository certificateRepository;

    public Certificate createCertificate(
            String recipientName,
            String certificateTitle,
            String organizationName) {

        Certificate certificate = new Certificate();

        certificate.setRecipientName(recipientName);
        certificate.setCertificateTitle(certificateTitle);
        certificate.setOrganizationName(organizationName);

        certificate.setIssueDate(LocalDate.now());

        certificate.setCertificateId(
            "SM-" + UUID.randomUUID()
                    .toString()
                    .substring(0,8)
                    .toUpperCase()
        );

        certificate.setVerificationCode(
            UUID.randomUUID()
                .toString()
                .replace("-","")
                .substring(0,12)
        );

        return certificateRepository.save(certificate);
    }

    public Certificate getByVerificationCode(String verificationCode) {

    return certificateRepository
            .findByVerificationCode(verificationCode)
            .orElseThrow(() ->
                    new RuntimeException("Certificate not found"));
}
}
