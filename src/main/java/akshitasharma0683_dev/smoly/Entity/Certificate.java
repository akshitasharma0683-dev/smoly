package akshitasharma0683_dev.smoly.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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

    public Certificate() {
    }

    public Certificate(Long id, String certificateId, String recipientName, String certificateTitle,
            String organizationName, LocalDate issueDate, String verificationCode) {
        this.id = id;
        this.certificateId = certificateId;
        this.recipientName = recipientName;
        this.certificateTitle = certificateTitle;
        this.organizationName = organizationName;
        this.issueDate = issueDate;
        this.verificationCode = verificationCode;
    }

    public Long getId() {
        return id;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getCertificateTitle() {
        return certificateTitle;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setCertificateTitle(String certificateTitle) {
        this.certificateTitle = certificateTitle;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "Certificate [id=" + id + ", certificateId=" + certificateId + ", recipientName=" + recipientName
                + ", certificateTitle=" + certificateTitle + ", organizationName=" + organizationName + ", issueDate="
                + issueDate + ", verificationCode=" + verificationCode + "]";
    }
    
    
}
