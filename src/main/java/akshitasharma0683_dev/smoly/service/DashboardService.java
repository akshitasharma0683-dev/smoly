package akshitasharma0683_dev.smoly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akshitasharma0683_dev.smoly.DTO.DashboardStats;
import akshitasharma0683_dev.smoly.Dao.DashboardServiceDao;
import akshitasharma0683_dev.smoly.repository.CertificateRepository;
import akshitasharma0683_dev.smoly.repository.UrlRepository;
import akshitasharma0683_dev.smoly.repository.UserRepository;
import java.util.List;

import akshitasharma0683_dev.smoly.Entity.Certificate;
import akshitasharma0683_dev.smoly.Entity.User;
@Service
public class DashboardService implements DashboardServiceDao{

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    public DashboardStats getDashboardStats(){

        DashboardStats stats = new DashboardStats();

        stats.setTotalLinks(urlRepository.count());

        stats.setTotalUsers(userRepository.count());

        stats.setTotalCertificates(certificateRepository.count());

        stats.setLatestUrl(
                urlRepository.findTopByOrderByCreatedAtDesc()
        );

        stats.setTotalClicks(
                urlRepository.getTotalClicks()
        );

        return stats;
    }


    // for user dashboard
        @Override
    public List<Certificate> getUserCertificates(User user) {

        return certificateRepository
                .findByUserOrderByIssueDateDesc(user);
    }

    @Override
    public long getCertificateCount(User user) {

        return certificateRepository.countByUser(user);
    }
}
