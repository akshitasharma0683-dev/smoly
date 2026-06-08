package akshitasharma0683_dev.smoly.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akshitasharma0683_dev.smoly.service.QrCodeService;
@RestController
@RequestMapping("/qr")
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQr(
            @RequestParam String text) throws Exception {

        return qrCodeService.generateQrCode(text);
    }
}
