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

    private final CertificateService service;
    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @PostMapping("/generate-appreciation-certificate")
    public ResponseEntity<String> generateCertificate(@RequestBody AppreciationCertificateBody body) throws Exception {
         this.service.createAppreciationCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }

    @PostMapping("/generate-achievement-certificate")
    public ResponseEntity<String> generateAchievementCertificate(@RequestBody AchievementCertificateBody body) throws Exception {
        this.service.createAchievementCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }

    @PostMapping("/generate-completion-certificate")
    public ResponseEntity<String> generateCompletionCertificate(@RequestBody CompletionCertificateBody body) throws Exception {
        this.service.createCompletionCertificate(body);
        return ResponseEntity.ok("{\"success\":true}");
    }

    @PostMapping("/generate-recognition-certificate")
    public ResponseEntity<String> generateRecognitionCertificate(@RequestBody RecognitionCertificateBody body) throws Exception {
        this.service.createRecognitionCertificate(body);
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
