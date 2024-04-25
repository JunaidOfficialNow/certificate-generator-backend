package com.example.certificategenerator;

public interface PDFService {
    void generateAppreciationCertificate(AppreciationRequest body);
    void generateAchievementCertificate(AchievementRequest body);
    void generateCompletionCertificate(CompletionRequest body);
    void generateRecognitionCertificate(RecognitionRequest body);
}
