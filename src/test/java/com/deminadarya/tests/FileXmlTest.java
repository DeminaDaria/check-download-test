package com.deminadarya.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileXmlTest {

    @Test
    void shouldXlsxHaveContent() {
        String xlsFilePath = "src/test/resources/files/3.xlsx";
        String expectedData = "Describe the Pre-Requisite in this sheet.";
        XLS xls = new XLS(new File(xlsFilePath));
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void shouldXlsxRow() {
        String xlsFilePath = "src/test/resources/files/3.xlsx";
        String expectedData = "For Mobile App";
        XLS xls = new XLS(new File(xlsFilePath));
        String sellValue = xls.excel.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
        Assertions.assertEquals(expectedData, sellValue);
    }

    @Test
    void shouldXlsxSheet() {
        String xlsFilePath = "src/test/resources/files/3.xlsx";
        String expectedData = "Menu Name";
        XLS xls = new XLS(new File(xlsFilePath));
        String sellValue = xls.excel.getSheetAt(1).getRow(2).getCell(0).getStringCellValue();
        Assertions.assertEquals(expectedData, sellValue);
    }

    @Test
    void shouldXlsxSheetCount() {
        String xlsFilePath = "src/test/resources/files/3.xlsx";
        int expectedData = 5;
        XLS xls = new XLS(new File(xlsFilePath));
        int sheetCount = xls.excel.getNumberOfSheets();
        Assertions.assertEquals(expectedData, sheetCount);
    }
}
