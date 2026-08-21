package akshitasharma0683_dev.smoly.Dao;

import akshitasharma0683_dev.smoly.Entity.Certificate;

/**
 * CertificateServiceDao
 */
public interface CertificateServiceDao {
    public Certificate createCertificate(
            String recipientName,
            String certificateTitle,
            String organizationName);

    public Certificate getByVerificationCode(String verificationCode);

    public Certificate getCertificateById(Long id);
}
