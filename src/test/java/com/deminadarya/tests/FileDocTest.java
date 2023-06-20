package com.deminadarya.tests;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FileDocTest {

    @Test
    void shouldHaveDocxParagraphCount() throws IOException {
        String docxFilePath = "src/test/resources/files/5.docx";
        int expectedData = 75;
        XWPFDocument document = new XWPFDocument(new FileInputStream(docxFilePath));
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        int paragraphCount = paragraphs.size();

        Assertions.assertEquals(expectedData, paragraphCount);
    }

    void shouldHaveDocxFileContent() throws IOException {
        String docxFilePath = "src/test/resources/files/5.docx";
        String expectedData = "Свойства Бэкенда";

        XWPFDocument document = new XWPFDocument(new FileInputStream(docxFilePath));

    }
}
