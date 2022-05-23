package com.example.demo.cars.service;

import com.example.demo.cars.dal.CarEntity;
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
public class CarPDFExport {
    private List<CarEntity> carEntityList;

    public void generate(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("Zoznam áut", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {1,2,2,2,2,3,3,3,3});
        table.setSpacingBefore(5);

        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cena", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Dvere", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Osoby", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Kufor", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Bezpecnost", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("STK", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("EK", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("PZP", font));
        table.addCell(cell);

        for(CarEntity carEntity : carEntityList){
            table.addCell(String.valueOf(carEntity.getId()));
            table.addCell(carEntity.getPrice());
            table.addCell(String.valueOf(carEntity.getDoors()));
            table.addCell(String.valueOf(carEntity.getPersons()));
            table.addCell(carEntity.getLug_boot());
            table.addCell(carEntity.getSafety());
            table.addCell(String.valueOf(carEntity.getTKEndDate()));
            table.addCell(String.valueOf(carEntity.getEKEndDate()));
            table.addCell(String.valueOf(carEntity.getPZPEndDate()));
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
