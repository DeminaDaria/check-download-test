package com.deminadarya.tests;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileZipTest {

    TestData testData = new TestData();

    @Test
    void shouldHaveNameZipFile() throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(testData.getZipFilePath()));
        ZipEntry nameFile;
        String expectedResult = null;
        while ((nameFile = zipInputStream.getNextEntry()) != null) {
            expectedResult = nameFile.getName();
        }
        Assertions.assertTrue(expectedResult.contains("testfile"));
        zipInputStream.close();
    }

    @Test
    void shouldHaveContainText() throws IOException {
        String expectedResult = null;

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(testData.getZipFilePath()))) {
            ZipEntry nameFile;

            while ((nameFile = zipInputStream.getNextEntry()) != null) {
                expectedResult = IOUtils.toString(zipInputStream, StandardCharsets.UTF_8);
            }
        }
        Assertions.assertEquals(expectedResult, "Hello world!");
    }
}
