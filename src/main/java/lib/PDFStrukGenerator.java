/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
//bilham


import java.io.IOException;

public class PDFStrukGenerator {
    public static void generateStrukPDF(String pdfPath, String[][] items, String total) {
        // Membuat dokumen baru
        try (PDDocument document = new PDDocument()) {
            // Membuat halaman baru
            PDPage page = new PDPage();
            document.addPage(page);

            // Menambahkan konten ke halaman
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Menambahkan judul
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
                contentStream.newLineAtOffset(220, 750);
                contentStream.showText("STRUK PEMBELIAN");
                contentStream.endText();

                // Menambahkan tabel
                float yPosition = 700;
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

                // Header tabel
                contentStream.beginText();
                contentStream.newLineAtOffset(100, yPosition);
                contentStream.showText("Item");
                contentStream.endText();

                contentStream.beginText();
                contentStream.newLineAtOffset(300, yPosition);
                contentStream.showText("Harga");
                contentStream.endText();

                yPosition -= 20;

                // Data item (Contoh)
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                for (String[] item : items) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(100, yPosition);
                    contentStream.showText(item[0]);
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.newLineAtOffset(300, yPosition);
                    contentStream.showText(item[1]);
                    contentStream.endText();

                    yPosition -= 20;
                }

                // Total
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, yPosition);
                contentStream.showText("Total");
                contentStream.endText();

                contentStream.beginText();
                contentStream.newLineAtOffset(300, yPosition);
                contentStream.showText(total);
                contentStream.endText();
            }

            // Menyimpan dokumen
            document.save(pdfPath);
            System.out.println("Struk PDF berhasil dibuat: " + pdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}