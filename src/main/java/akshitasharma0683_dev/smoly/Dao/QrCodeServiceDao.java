package akshitasharma0683_dev.smoly.Dao;

/**
 * QrCodeServiceDao
 */
public interface QrCodeServiceDao {
    public byte[] generateQrCode(String text) throws Exception;
}
