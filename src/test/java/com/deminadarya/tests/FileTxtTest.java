package com.deminadarya.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTxtTest {

    @Test
    void downloadFile() throws IOException {
        open("https://github.com/microsoft/pict/blob/main/doc/sample-models/create_volume.txt");
        File downloadFile = $("#raw-url").download();
        Assertions.assertTrue(downloadFile.isFile());
    }

    @Test
    void shouldHaveContent() throws IOException {
        open("https://github.com/microsoft/pict/blob/main/doc/sample-models/create_volume.txt");
        File downloadFile = $("#raw-url").download();
        String fileContent = FileUtils.readFileToString(downloadFile, "UTF-8");
        Assertions.assertTrue(fileContent.contains("Create and format  volume"));
    }

    @Test
    void shouldHaveNameFile() throws IOException {
        open("https://github.com/microsoft/pict/blob/main/doc/sample-models/create_volume.txt");
        File downloadFile = $("#raw-url").download();
        String nameFile = downloadFile.getName();
        assertEquals(nameFile, "create_volume.txt");
    }
}
