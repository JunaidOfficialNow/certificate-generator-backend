package com.example.certificategenerator;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Override
    public void createParticipationCertificate(ParticipationCertificateBody body) {
        String templatePath = "src/main/resources/templates/1.pdf";
        try {
            Document pdfDocument = new Document(templatePath);
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("{{name}}");
            pdfDocument.getPages().accept(textFragmentAbsorber);
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                textFragment.setText(body.name);
            }
            pdfDocument.save("src/main/resources/outputs/" + body.name + ".pdf");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
