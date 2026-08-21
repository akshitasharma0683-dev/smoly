package akshitasharma0683_dev.smoly.Dao;

import java.util.List;

import akshitasharma0683_dev.smoly.DTO.DashboardStats;
import akshitasharma0683_dev.smoly.Entity.Certificate;
import akshitasharma0683_dev.smoly.Entity.User;

/**
 * DashboardServiceDao
 */
public interface DashboardServiceDao {

    public DashboardStats getDashboardStats();

        List<Certificate> getUserCertificates(User user);

    long getCertificateCount(User user);
}
