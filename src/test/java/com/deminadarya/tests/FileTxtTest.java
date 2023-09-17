package com.deminadarya.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class FileTxtTest {

    TestData testData = new TestData();

    @Test
    void shouldHaveContent() throws IOException {
        String fileContent = FileUtils.readFileToString(new File(testData.getTxtFilePath()), "UTF-8");
        String expectedContent = "Create and format a volume";

        Assertions.assertTrue(fileContent.contains(expectedContent));
    }

    @Test
    void shouldContainsString() throws IOException {
        String expectedContent = "Create and format a volume";
        String actualData = FileUtils.readFileToString(new File(testData.getTxtFilePath()), "UTF-8");

        assertThat(actualData, containsString(expectedContent));
    }
}
