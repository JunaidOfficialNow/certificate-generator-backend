package com.example.certificategenerator;

public interface CertificateService {
    void createAppreciationCertificate(AppreciationCertificateBody body);
    void createAchievementCertificate(AchievementCertificateBody body);
    void createCompletionCertificate(CompletionCertificateBody body);
    void createRecognitionCertificate(RecognitionCertificateBody body);
}
