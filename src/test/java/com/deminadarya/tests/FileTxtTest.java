package com.deminadarya.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class FileTxtTest {

    @Test
    void shouldHaveContent() throws IOException {
        String txtFilePath = "src/test/resources/files/1.txt";
        String fileContent = FileUtils.readFileToString(new File(txtFilePath), "UTF-8");
        String expectedContent = "Create and format a volume";

        Assertions.assertTrue(fileContent.contains(expectedContent));
    }

    @Test
    void shouldContainsString() throws IOException {
        String txtFilePath = "src/test/resources/files/1.txt";
        String expectedContent = "Create and format a volume";
        String actualData = FileUtils.readFileToString(new File(txtFilePath), "UTF-8");

        assertThat(actualData, containsString(expectedContent));
    }
}
