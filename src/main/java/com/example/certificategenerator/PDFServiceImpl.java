package com.example.certificategenerator;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.texts.PdfTextReplaceOptions;
import com.spire.pdf.texts.PdfTextReplacer;
import com.spire.pdf.texts.ReplaceActionType;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class PDFServiceImpl implements PDFService {

    @Override
    public void generateAppreciationCertificate(AppreciationRequest body) {
        String templatePath = "src/main/resources/templates/1.pdf";
        try {
            PdfDocument doc = new PdfDocument();
            doc.loadFromFile(templatePath);
            PdfTextReplaceOptions textReplaceOptions = new PdfTextReplaceOptions();
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.IgnoreCase));
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));
            PdfPageBase page = doc.getPages().get(0);
            PdfTextReplacer textReplacer = new PdfTextReplacer(page);
            textReplacer.setOptions(textReplaceOptions);
            textReplacer.replaceAllText("{{name}}", body.name);
            textReplacer.replaceAllText("{{supervisor}}", body.supervisor);
            textReplacer.replaceAllText("{{manager}}", body.manager);
            doc.saveToFile("src/main/resources/outputs/" + body.name + ".pdf");
            doc.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void generateAchievementCertificate(AchievementRequest body) {
        String templatePath = "src/main/resources/templates/2.pdf";
        try {
         PdfDocument doc = new PdfDocument();
            doc.loadFromFile(templatePath);
            PdfTextReplaceOptions textReplaceOptions = new PdfTextReplaceOptions();
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.IgnoreCase));
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));
            PdfPageBase page = doc.getPages().get(0);
            PdfTextReplacer textReplacer = new PdfTextReplacer(page);
            textReplacer.setOptions(textReplaceOptions);
            textReplacer.replaceAllText("{{name}}", body.name);
            textReplacer.replaceAllText("{{representative1}}", body.representative1);
            textReplacer.replaceAllText("{{representative2}}", body.representative2);
            doc.saveToFile("src/main/resources/outputs/" + body.name + ".pdf");
            doc.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void generateCompletionCertificate(CompletionRequest body) {
        String templatePath = "src/main/resources/templates/3.pdf";
        try {
            PdfDocument doc = new PdfDocument();
            doc.loadFromFile(templatePath);
            PdfTextReplaceOptions textReplaceOptions = new PdfTextReplaceOptions();
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.IgnoreCase));
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));
            PdfPageBase page = doc.getPages().get(0);
            PdfTextReplacer textReplacer = new PdfTextReplacer(page);
            textReplacer.setOptions(textReplaceOptions);
            textReplacer.replaceAllText("{{name}}", body.name);
            textReplacer.replaceAllText("{{chief}}", body.chief);
            textReplacer.replaceAllText("{{mentor}}", body.mentor);
            doc.saveToFile("src/main/resources/outputs/" + body.name + ".pdf");
            doc.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void generateRecognitionCertificate(RecognitionRequest body) {
        String templatePath = "src/main/resources/templates/4.pdf";
        try {
            PdfDocument doc = new PdfDocument();
            doc.loadFromFile(templatePath);
            PdfTextReplaceOptions textReplaceOptions = new PdfTextReplaceOptions();
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.IgnoreCase));
            textReplaceOptions.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));
            PdfPageBase page = doc.getPages().get(0);
            PdfTextReplacer textReplacer = new PdfTextReplacer(page);
            textReplacer.setOptions(textReplaceOptions);
            textReplacer.replaceAllText("{{name}}", body.name);
            textReplacer.replaceAllText("{{CEO}}", body.ceo);
            textReplacer.replaceAllText("{{HEAD}}", body.head);
            doc.saveToFile("src/main/resources/outputs/" + body.name + ".pdf");
            doc.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
