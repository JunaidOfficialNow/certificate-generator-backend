package com.example.certificategenerator;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Override
    public void createAppreciationCertificate(AppreciationCertificateBody body) {
        String templatePath = "src/main/resources/templates/1.pdf";
        try {
            Document pdfDocument = new Document(templatePath);
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("{{name}}");
            pdfDocument.getPages().accept(textFragmentAbsorber);
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            for (TextFragment textFragment1 : (Iterable<TextFragment>) textFragmentCollection) {
                textFragment1.setText(body.name);
            }

            TextFragmentAbsorber textFragmentAbsorber2 = new TextFragmentAbsorber("{{representative1}}");
            pdfDocument.getPages().accept(textFragmentAbsorber2);
            TextFragmentCollection textFragmentCollection2 = textFragmentAbsorber2.getTextFragments();
            for (TextFragment textFragment2 : (Iterable<TextFragment>) textFragmentCollection2) {
                textFragment2.setText(body.representative1);
            }

            TextFragmentAbsorber textFragmentAbsorber3 = new TextFragmentAbsorber("{{representative2}}");
            pdfDocument.getPages().accept(textFragmentAbsorber3);
            TextFragmentCollection textFragmentCollection3 = textFragmentAbsorber3.getTextFragments();
            for (TextFragment textFragment3 : (Iterable<TextFragment>) textFragmentCollection3) {
                textFragment3.setText(body.representative2);
            }
            pdfDocument.save("src/main/resources/outputs/" + body.name + ".pdf");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
