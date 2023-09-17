package com.deminadarya.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileXmlTest {

    TestData testData = new TestData();

    @Test
    void shouldXlsxHaveContent() {
        String expectedData = "Describe the Pre-Requisite in this sheet.";
        XLS xls = new XLS(new File(testData.getXlsFilePath()));
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void shouldXlsxRow() {
        String expectedData = "For Mobile App";
        XLS xls = new XLS(new File(testData.getXlsFilePath()));
        String sellValue = xls.excel.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
        Assertions.assertEquals(expectedData, sellValue);
    }

    @Test
    void shouldXlsxSheet() {
        String expectedData = "Menu Name";
        XLS xls = new XLS(new File(testData.getXlsFilePath()));
        String sellValue = xls.excel.getSheetAt(1).getRow(2).getCell(0).getStringCellValue();
        Assertions.assertEquals(expectedData, sellValue);
    }

    @Test
    void shouldXlsxSheetCount() {
        int expectedData = 5;
        XLS xls = new XLS(new File(testData.getXlsFilePath()));
        int sheetCount = xls.excel.getNumberOfSheets();
        Assertions.assertEquals(expectedData, sheetCount);
    }
}
