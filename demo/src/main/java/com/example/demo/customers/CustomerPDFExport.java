package com.example.demo.customers;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.Setter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Setter
public class CustomerPDFExport {
    private List<CustomerEntity> customerEntityList;

    public void generate(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("Zoznam customerov", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {1,2,2,3,3});
        table.setSpacingBefore(5);

        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("R_cislo", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Meno", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Priezvisko", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("C_obcianskeho", font));
        table.addCell(cell);

        for(CustomerEntity customerEntity : customerEntityList){
            table.addCell(String.valueOf(customerEntity.getCustomer_id()));
            table.addCell(String.valueOf(customerEntity.getIdentification_number()));
            table.addCell(String.valueOf(customerEntity.getCustomer_firstname()));
            table.addCell(String.valueOf(customerEntity.getCustomer_lastname()));
            table.addCell(String.valueOf(customerEntity.getO_number()));
        }

        document.add(table);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("___________________"));
        document.add(new Paragraph("Podpísaný/á"));
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateTime = dateFormat.format(new Date());
        document.add(new Paragraph(currentDateTime));
        document.close();
    }
}
