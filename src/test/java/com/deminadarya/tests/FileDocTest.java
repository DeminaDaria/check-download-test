package com.deminadarya.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
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

    @Test
    void shouldHaveDocxFileContent() throws IOException {
        XWPFWordExtractor extractor;
        XWPFDocument document;
        String docxFilePath = "src/test/resources/files/5.docx";
        String expectedData = "Свойства Бэкенда";

        try {
            document = new XWPFDocument(OPCPackage.open(new FileInputStream(docxFilePath)));
            extractor = new XWPFWordExtractor(document);
            String wordText = extractor.getText();

            Assertions.assertTrue(wordText.contains(expectedData));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
