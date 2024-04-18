package com.example.certificategenerator;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/certificates")
public class CertificateController {

    @PostMapping("/generate")
    public String generateCertificate(@RequestBody() String  body) {

        return  "Hello";
    }
}
