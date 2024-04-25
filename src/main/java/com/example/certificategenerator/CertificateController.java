package com.example.certificategenerator;


import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/certificates")
@CrossOrigin(origins= "*")
public class CertificateController {

    private final PDFService service;
    public CertificateController(PDFService service) {
        this.service = service;
    }

    @PostMapping("/generate-appreciation-certificate")
    public ResponseEntity<String> generateCertificate(@RequestBody AppreciationRequest body) throws Exception {
         this.service.generateAppreciationCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }

    @PostMapping("/generate-achievement-certificate")
    public ResponseEntity<String> generateAchievementCertificate(@RequestBody AchievementRequest body) throws Exception {
        this.service.generateAchievementCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }

    @PostMapping("/generate-completion-certificate")
    public ResponseEntity<String> generateCompletionCertificate(@RequestBody CompletionRequest body) throws Exception {
        this.service.generateCompletionCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }

    @PostMapping("/generate-recognition-certificate")
    public ResponseEntity<String> generateRecognitionCertificate(@RequestBody RecognitionRequest body) throws Exception {
        this.service.generateRecognitionCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }


    @GetMapping("/download/{filename}")
    public ResponseEntity<FileSystemResource> downloadPdf(@PathVariable String filename) {
        String FILE_PATH = "src/main/resources/outputs/" + filename + ".pdf";
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
