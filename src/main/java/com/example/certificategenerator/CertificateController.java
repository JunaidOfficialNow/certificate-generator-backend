package com.example.certificategenerator;


import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Paths;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @PostMapping("/generate-participation-certificate")
    public ResponseEntity<String> generateCertificate() throws Exception {
        String templateNo = "1";
        String templatePath = "src/main/resources/templates/" + templateNo + ".pdf";
        PdfDocument pdfDoc = PdfDocument.fromFile(Paths.get(templatePath));
        pdfDoc.replaceText(PageSelection.firstPage(), "RecipientName", "Sample  name");
        pdfDoc.saveAs(Paths.get("src/main/resources/outputs/sample.pdf"));
        pdfDoc.close();
        return ResponseEntity.ok("Success") ;
    }

    @PostMapping("/generate-achievement-certificate")
    public ResponseEntity<String> generateAchievementCertificate(@RequestBody AchievementCertificateBody body) throws Exception {
        String templatePath = "src/main/resources/templates/2.pdf";
        PdfDocument pdfDoc = PdfDocument.fromFile(Paths.get(templatePath));
        pdfDoc.replaceText(PageSelection.firstPage(), "{{name}}", body.name);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{representative1}}", body.representative1);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{representative2}}", body.representative2);
        pdfDoc.saveAs(Paths.get("src/main/resources/outputs/"+ body.name + ".pdf"));
        pdfDoc.close();
        return ResponseEntity.ok("Success") ;
    }

    @PostMapping("/generate-completion-certificate")
    public ResponseEntity<String> generateCompletionCertificate(@RequestBody CompletionCertificateBody body) throws Exception {
        String templatePath = "src/main/resources/templates/3.pdf";
        PdfDocument pdfDoc = PdfDocument.fromFile(Paths.get(templatePath));
        pdfDoc.replaceText(PageSelection.firstPage(), "{{name}}", body.name);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{description}}", body.description);
//        pdfDoc.replaceText(PageSelection.firstPage(), "{{course_duration}}", body.course_duration);
//        pdfDoc.replaceText(PageSelection.firstPage(), "{{position}}", body.position);
//        pdfDoc.replaceText(PageSelection.firstPage(), "{{institution}}", body.institution);
//        pdfDoc.replaceText(PageSelection.firstPage(), "{{designation}}", body.designation);
//        pdfDoc.replaceText(PageSelection.firstPage(), " {{PRINCI_NAME}} ", body.princi_name);
//        pdfDoc.replaceText(PageSelection.firstPage(), "{{COORDINATOR_NAME}}", body.coordinator_name);
        pdfDoc.saveAs(Paths.get("src/main/resources/outputs/"+ body.name + ".pdf"));
        pdfDoc.close();
        return ResponseEntity.ok("Success") ;
    }

    @PostMapping("/generate-recognition-certificate")
    public ResponseEntity<String> generateRecognitionCertificate(@RequestBody RecognitionCertificateBody body) throws Exception {
        String templatePath = "src/main/resources/templates/4.pdf";
        PdfDocument pdfDoc = PdfDocument.fromFile(Paths.get(templatePath));
        pdfDoc.replaceText(PageSelection.firstPage(), "{{name}}", body.name);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{month}}", body.month);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{year}}", body.year);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{SUPERVISOR}}", body.supervisor);
        pdfDoc.replaceText(PageSelection.firstPage(), "{{MANAGER}}", body.manager);
        pdfDoc.saveAs(Paths.get("src/main/resources/outputs/"+ body.name + ".pdf"));
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
