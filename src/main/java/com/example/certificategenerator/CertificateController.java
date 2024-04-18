package com.example.certificategenerator;


import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Paths;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @PostMapping("/generate")
    public ResponseEntity<String> generateCertificate() throws Exception {
        String templateNo = "1";
        String templatePath = "src/main/resources/templates/" + templateNo + ".pdf";
        PdfDocument pdfDoc = PdfDocument.fromFile(Paths.get(templatePath));
        pdfDoc.replaceText(PageSelection.firstPage(), "RecipientName", "Sample  name");
        pdfDoc.saveAs(Paths.get("src/main/resources/outputs/sample.pdf"));
        pdfDoc.close();
        return ResponseEntity.ok("Success") ;
    }

    @GetMapping("/download")
    public ResponseEntity<FileSystemResource> downloadPdf() {
        String  FILE_PATH = "src/main/resources/outputs/sample.pdf";
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", file.getName());
        headers.setContentLength(file.length());
        FileSystemResource resource = new FileSystemResource(file);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
