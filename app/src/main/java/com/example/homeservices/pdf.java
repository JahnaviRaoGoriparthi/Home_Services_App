package com.example.homeservices;

        import com.itextpdf.text.Document;
        import com.itextpdf.text.DocumentException;
        import com.itextpdf.text.Paragraph;
        import com.itextpdf.text.pdf.PdfWriter;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;

public class pdf {

    public static void generatePdf(String name, String address, String phoneNumber, String SUCCESS_TRANSACTION) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File("myPdf.pdf")));
            document.open();
            document.add(new Paragraph("Name:  " + name));
            document.add(new Paragraph("Address: " + address));
            document.add(new Paragraph("Phone Number: " + phoneNumber));
            document.add(new Paragraph("SUCCESS TRANSACTION:"+SUCCESS_TRANSACTION));
            document.addTitle("PAY ");
           // document.add(new Paragraph("Email: " + email));
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
