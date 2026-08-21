package akshitasharma0683_dev.smoly.Dao;

import akshitasharma0683_dev.smoly.Entity.Certificate;
/**
 * PdfServiceDao
 */
public interface PdfServiceDao {
    public String generateCertificate(
            Certificate certificate
    ) throws Exception;

}
