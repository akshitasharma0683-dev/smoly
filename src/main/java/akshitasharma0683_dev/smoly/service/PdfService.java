package akshitasharma0683_dev.smoly.service;

import akshitasharma0683_dev.smoly.Entity.Certificate;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public void generateCertificate(
            Certificate certificate
    ) throws Exception {

        PDDocument document = new PDDocument();

        PDPage page = new PDPage(
                new PDRectangle(
                        PDRectangle.A4.getHeight(),
                        PDRectangle.A4.getWidth()
                )
        );

        document.addPage(page);

        ClassPathResource resource =
                new ClassPathResource(
                        "static/certificate-template.png"
                );

        PDImageXObject image =
                PDImageXObject.createFromFileByContent(
                        resource.getFile(),
                        document
                );

        PDPageContentStream content =
                new PDPageContentStream(
                        document,
                        page
                );

        // Background Template
        content.drawImage(
                image,
                0,
                0,
                page.getMediaBox().getWidth(),
                page.getMediaBox().getHeight()
        );

        String recipientName =
                certificate.getRecipientName();

        String certificateTitle =
                certificate.getCertificateTitle();

        String organizationName =
                certificate.getOrganizationName();

        String issueDate =
                certificate.getIssueDate().toString();

        String certificateId =
                certificate.getCertificateId();

        float pageWidth =
                page.getMediaBox().getWidth();

        // =========================
        // Recipient Name
        // =========================

        PDType1Font nameFont =
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_BOLD
                );

        float nameSize = 34;

        float nameWidth =
                nameFont.getStringWidth(recipientName)
                        / 1000 * nameSize;

        float nameCenterX =
                (pageWidth - nameWidth) / 2;

        drawText(
                content,
                recipientName,
                nameCenterX,
                345,
                nameFont,
                nameSize
        );

        // =========================
        // Certificate Title
        // =========================

        PDType1Font titleFont =
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_ROMAN
                );

        float titleSize = 18;

        float titleWidth =
                titleFont.getStringWidth(certificateTitle)
                        / 1000 * titleSize;

        float titleCenterX =
                (pageWidth - titleWidth) / 2;

        drawText(
                content,
                certificateTitle,
                titleCenterX,
                285,
                titleFont,
                titleSize
        );

        // =========================
        // Description
        // =========================

        String description =
                "For successfully completing the requirements and demonstrating outstanding performance.";

        PDType1Font descFont =
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_ROMAN
                );

        float descSize = 13;

        float descWidth =
                descFont.getStringWidth(description)
                        / 1000 * descSize;

        float descCenterX =
                (pageWidth - descWidth) / 2;

        drawText(
                content,
                description,
                descCenterX,
                235,
                descFont,
                descSize
        );

        // =========================
        // Organization Name
        // =========================

        drawText(
                content,
                organizationName,
                120,
                115,
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_ROMAN
                ),
                14
        );

        // =========================
        // Signature Label
        // =========================

        drawText(
                content,
                "Authorized Signatory",
                620,
                115,
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_ITALIC
                ),
                12
        );

        // =========================
        // Issue Date
        // =========================

        drawText(
                content,
                "Issue Date: " + issueDate,
                120,
                70,
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_ROMAN
                ),
                11
        );

        // =========================
        // Certificate ID
        // =========================

        drawText(
                content,
                "Certificate ID: " + certificateId,
                560,
                70,
                new PDType1Font(
                        Standard14Fonts.FontName.TIMES_ROMAN
                ),
                11
        );

        content.close();

        document.save(
                "generated-certificate.pdf"
        );

        document.close();
    }

    private void drawText(
            PDPageContentStream content,
            String text,
            float x,
            float y,
            PDType1Font font,
            float size
    ) throws Exception {

        content.beginText();

        content.setFont(
                font,
                size
        );

        content.newLineAtOffset(
                x,
                y
        );

        content.showText(
                text
        );

        content.endText();
    }
}
