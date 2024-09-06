package com.example.homeservices;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.itextpdf.text.Chunk;
        import com.itextpdf.text.Document;
        import com.itextpdf.text.DocumentException;
        import com.itextpdf.text.Element;


        import com.itextpdf.text.Font;
        import com.itextpdf.text.Paragraph;
        import com.itextpdf.text.pdf.PdfContentByte;
        import com.itextpdf.text.pdf.PdfPTable;
        import com.itextpdf.text.pdf.PdfPCell;
        import com.itextpdf.text.pdf.PdfWriter;

        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
public class payment1 extends AppCompatActivity {
    String SPname,SPmobile,SPaddress,Bname,Bnumber,Baddress,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);
        Bundle bundle = getIntent().getExtras();
        SPname=bundle.getString("SPname");
        SPaddress=bundle.getString("SPaddress");
       SPmobile=bundle.getString("SPmobile");
         Bname=bundle.getString("Bname");
         Bnumber=bundle.getString("Bnumber");
         Baddress=bundle.getString("Baddress");
      amount=bundle.getString("amount");
        TextView t1=findViewById(R.id.txt);

        Button downloadButton = findViewById(R.id.gen);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i3=new Intent(payment1.this,Endpage.class);
                startActivity(i3);
                generatePDF();
            }
        });
    }

    private void generatePDF() {
        // Create a new PDF document using iText
        Document document = new Document();

        try {
            // Create a PdfWriter instance to write the PDF file
            String filePath = getExternalFilesDir(null).getAbsolutePath() + File.separator + "example.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            // Open the PDF document
            document.open();

            //header section
            // Add the heading to the PDF document
            Paragraph paraHeading = new Paragraph();
            paraHeading.setAlignment(Element.ALIGN_CENTER);
            paraHeading.setSpacingAfter(10);
            Chunk chunkHeading = new Chunk("RECEIPT OF ONLINE BILL PAYMENT"+"\n\n\nFrom HOME_SERVICES", new Font(Font.FontFamily.HELVETICA, 24));
            chunkHeading.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 0.3f, null);
            paraHeading.add(chunkHeading);
            document.add(paraHeading);
            document.add(new Paragraph("\n\nFrom :"+"\nHOME_SERVICES"));
            document.add(new Paragraph("\n\nTo:\nBookie_Name  :"+Bname+"\n\n\n"));
            PdfPTable table = new PdfPTable(3);
            table.addCell("");
            table.addCell("NAME");
            table.addCell("PHONE NO");
            table.addCell("CUSTOMER");
            table.addCell(Bname);
            table.addCell(Bnumber);
            table.addCell("S.PROVIDER");
            table.addCell(SPname);
            table.addCell(SPmobile);
            PdfPCell mergedCell = new PdfPCell(new com.itextpdf.text.Paragraph("               "+"AMOUNT PAID:"));
            mergedCell.setColspan(2);
            table.addCell(mergedCell);
            table.addCell(amount);

            document.add(table);

            document.close();

            Toast.makeText(this, "PDF file saved to: " + filePath, Toast.LENGTH_LONG).show();

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

    }

}