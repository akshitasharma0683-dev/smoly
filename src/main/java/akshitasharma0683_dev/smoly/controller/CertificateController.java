package akshitasharma0683_dev.smoly.controller;


import akshitasharma0683_dev.smoly.Entity.Certificate;
import akshitasharma0683_dev.smoly.service.CertificateService;
import akshitasharma0683_dev.smoly.service.PdfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/certificate")
@CrossOrigin(origins = "*")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

        @Autowired
    private PdfService pdfService;


    // Create Certificate
    @PostMapping("/create")
    public ResponseEntity<Certificate> createCertificate(
            @RequestBody Map<String, String> request) {

        Certificate certificate = certificateService.createCertificate(
                request.get("recipientName"),
                request.get("certificateTitle"),
                request.get("organizationName")
        );

        return ResponseEntity.ok(certificate);
    }

    // Verify Certificate
    @GetMapping("/verify/{verificationCode}")
    public ResponseEntity<?> verifyCertificate(
            @PathVariable String verificationCode) {

        Certificate certificate =
                certificateService.getByVerificationCode(verificationCode);

        return ResponseEntity.ok(certificate);
    }

@GetMapping("/pdf/{id}")
public ResponseEntity<String> generateCertificatePdf(
        @PathVariable Long id) {

    try {

        Certificate certificate =
                certificateService.getCertificateById(id);

        pdfService.generateCertificate(
                certificate
        );

        return ResponseEntity.ok(
                "Certificate PDF Generated Successfully"
        );

    } catch (Exception e) {

        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }
}

}