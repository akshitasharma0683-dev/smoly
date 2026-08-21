package akshitasharma0683_dev.smoly.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificateId;

    private String recipientName;

    private String certificateTitle;

    private String organizationName;

    private LocalDate issueDate;

    private String verificationCode;

    // User who created the certificate
    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private User user;


    public Certificate() {
    }


    public Certificate(
            Long id,
            String certificateId,
            String recipientName,
            String certificateTitle,
            String organizationName,
            LocalDate issueDate,
            String verificationCode,
            User user) {

        this.id = id;
        this.certificateId = certificateId;
        this.recipientName = recipientName;
        this.certificateTitle = certificateTitle;
        this.organizationName = organizationName;
        this.issueDate = issueDate;
        this.verificationCode = verificationCode;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }


    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }


    public String getCertificateTitle() {
        return certificateTitle;
    }

    public void setCertificateTitle(String certificateTitle) {
        this.certificateTitle = certificateTitle;
    }


    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }


    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Certificate [id=" + id
                + ", certificateId=" + certificateId
                + ", recipientName=" + recipientName
                + ", certificateTitle=" + certificateTitle
                + ", organizationName=" + organizationName
                + ", issueDate=" + issueDate
                + ", verificationCode=" + verificationCode
                + "]";
    }
}