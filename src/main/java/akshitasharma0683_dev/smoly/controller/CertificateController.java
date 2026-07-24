package akshitasharma0683_dev.smoly.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import akshitasharma0683_dev.smoly.Entity.Certificate;
import akshitasharma0683_dev.smoly.service.CertificateService;
import akshitasharma0683_dev.smoly.service.PdfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
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
public ResponseEntity<Resource> generateCertificatePdf(
        @PathVariable Long id) {

    try {

        Certificate certificate =
                certificateService.getCertificateById(id);

        String fileName =
                pdfService.generateCertificate(
                        certificate
                );

        Path path =
                Paths.get(fileName);

        Resource resource =
                new UrlResource(
                        path.toUri()
                );


                
        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                resource.getFilename() +
                                "\""
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(resource);

    } catch (Exception e) {

        throw new RuntimeException(e);
    }
}
}