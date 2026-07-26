package akshitasharma0683_dev.smoly.DTO;
import akshitasharma0683_dev.smoly.Entity.urlMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStats {

    private long totalLinks;
    private long totalClicks;
    private long totalCertificates;
    private long totalUsers;

private urlMapping latestUrl;
    // getters/setters
}