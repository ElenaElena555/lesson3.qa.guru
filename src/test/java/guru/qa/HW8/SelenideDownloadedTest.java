package guru.qa.HW8;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.assertj.Assertions;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDownloadedTest {
    @DisplayName("Check the Text-File")
    @Test
    void downloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File textFile = $("#raw-url").download();
        try (InputStream stream = new FileInputStream(textFile)) {
            byte[] fileContent = stream.readAllBytes();
            String content = new String(fileContent, StandardCharsets.UTF_8);
            Assertions.assertThat(content).contains("JUnit 5");

        }
    }

    @DisplayName("Check the PDF file")
    @Test
    void pdfParsingTest() throws Exception {
        try (InputStream pdfFile = getClass().getClassLoader().getResourceAsStream("Hello.pdf")) {
            PDF pdf = new PDF(pdfFile);
            Assertions.assertThat(pdf).containsText("zip");
        }

    }

    @DisplayName("Check the XLSX file")
    @Test
    void xlsParsingTest() throws Exception {
        try (InputStream xlsFile = getClass().getClassLoader().getResourceAsStream("ClientOrgEntityAccessImport.xlsx")) {
            XLS xls = new XLS(xlsFile);
            String stringCellValue = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
            Assertions.assertThat(stringCellValue).contains("ClientID");
        }
    }

    @DisplayName("Check the CSV file")
    @Test
    void csvParsingTest() throws Exception {
        try (InputStream csvFile = getClass().getClassLoader().getResourceAsStream("teachers.csv");
             CSVReader csv = new CSVReader(new InputStreamReader(csvFile, StandardCharsets.UTF_8))) {
            List<String[]> content = csv.readAll();
            org.assertj.core.api.Assertions.assertThat(content).contains(
                    new String[]{"name", "surname"},
                    new String[]{"Elena", "Sharapova"});
        }
    }

    @DisplayName("Check the ZIP-XLSX file")
    @Test
    void zipParsingTest() throws Exception {
        ZipFile zf = new ZipFile(new File("src/test/resources/Table1.zip"));
        try (ZipInputStream zip = new ZipInputStream(getClass().getClassLoader().getResourceAsStream("Table1.zip"))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                org.assertj.core.api.Assertions.assertThat(entry.getName()).isEqualTo("Table1.xlsx");
                try (InputStream inputStream = zf.getInputStream(entry)) {
                    XLS xls = new XLS(inputStream);
                    String stringCellValue = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    org.assertj.core.api.Assertions.assertThat(stringCellValue).contains("Client ID");
                }
            }
        }
    }

    @DisplayName("Check the ZIP-PDF file")
    @Test
    void zipPDFParsingTest() throws Exception {
        ZipFile zf = new ZipFile(new File("src/test/resources/PDFZIP.zip"));
        try (ZipInputStream zip = new ZipInputStream(getClass().getClassLoader().getResourceAsStream("PDFZIP.zip"))) {
            ZipEntry entry1;
            while ((entry1 = zip.getNextEntry()) != null) {
                org.assertj.core.api.Assertions.assertThat(entry1.getName()).contains("Hello.pdf");
                try (InputStream inputStream = zf.getInputStream(entry1)) {
                    PDF pdf = new PDF(inputStream);
                    Assertions.assertThat(pdf).containsText("Аdvanced");
                }

            }
        }
    }

    @DisplayName("Check the CSV-PDF file")
    @Test
    void zipPNGParsingTest() throws IOException {
        ZipFile zf = new ZipFile(new File("src/test/resources/Image.zip"));
        try (ZipInputStream zip = new ZipInputStream(getClass().getClassLoader().getResourceAsStream("Image.zip"))) {
            ZipEntry entry1;
            while ((entry1 = zip.getNextEntry()) != null) {
                org.assertj.core.api.Assertions.assertThat(entry1.getName()).contains("fish.png");
                try (InputStream inputStream = zf.getInputStream(entry1)) {
                    BufferedImage img = ImageIO.read(inputStream);
                    Assertions.assertThat(img.getHeight()).isEqualTo(311);
                    Assertions.assertThat(img.getWidth()).isEqualTo(800);
                }
            }
        }
    }
}
