package com.example.certificategenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ironsoftware.ironpdf.License;


@SpringBootApplication
public class CertificateGeneratorApplication {

    public static void main(String[] args) {
        License.setLicenseKey("IRONSUITE.HUMBLEDYER.GMAIL.COM.17070-260D194C0A-DQ6H43S-NKHKM6Y6MM7K-QLMSVMWFRVKQ-3G6B34ELBRFO-HGNXXSQIEFRX-IVPEMT2QEMIK-OJVYKQLNNDIW-T3DHVF-TQPWICPLS7KMEA-DEPLOYMENT.TRIAL-OTRMYA.TRIAL.EXPIRES.17.MAY.2024");
        SpringApplication.run(CertificateGeneratorApplication.class, args);
    }

}