package com.deminadarya.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePdfTest {

    TestData testData = new TestData();

    @Test
    void shouldPdfHaveContent() throws IOException {
        PDF pdf = new PDF(new File(testData.getPdfFilePath()));
        assertThat(pdf, containsText("wanted@funbox.ru"));
    }

    @Test
    void PdfFilePageCount() throws IOException {
        PDF pdf = new PDF(new File(testData.getPdfFilePath()));
        int pageCount = pdf.numberOfPages;
        assertEquals(6, pageCount);
    }

    @Test
    void PdfFileGetTitle() throws IOException {
        String expectedTitle = "Квалификационные задания для Ruby разработчиков";
        PDF pdf = new PDF(new File(testData.getPdfFilePath()));
        String title = pdf.title;
        assertEquals(expectedTitle, title);
    }
}
