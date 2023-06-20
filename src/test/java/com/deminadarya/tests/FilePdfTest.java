package com.deminadarya.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePdfTest {

    @Test
    void shouldPdfHaveContent() throws IOException {
        String pdfFilePath = "src/test/resources/files/2.pdf";
        PDF pdf = new PDF(new File(pdfFilePath));
        assertThat(pdf, containsText("wanted@funbox.ru"));
    }

    @Test
    void PdfFilePageCount() throws IOException {
        String pdfFilePath = "src/test/resources/files/2.pdf";
        PDF pdf = new PDF(new File(pdfFilePath));
        int pageCount = pdf.numberOfPages;
        assertEquals(6, pageCount);
    }

    @Test
    void PdfFileGetTitle() throws IOException {
        String pdfFilePath = "src/test/resources/files/2.pdf";
        String expectedTitle = "Квалификационные задания для Ruby разработчиков";
        PDF pdf = new PDF(new File(pdfFilePath));
        String title = pdf.title;
        assertEquals(expectedTitle, title);
    }
}
