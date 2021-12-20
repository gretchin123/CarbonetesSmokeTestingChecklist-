package SmokeTesting;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import xpaths.PublicImageXpaths;

import java.awt.image.ByteLookupTable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_PublicImages {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final PublicImageXpaths PublicImageLocators = new PublicImageXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {


        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        driver.navigate().to("https://tconsole.carbonetes.com/public-analysis");
        driver.manage().window().maximize();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("PublicImage");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String Image = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement inputImage = driver.findElement(By.xpath(PublicImageLocators.ImageTextField()));
            inputImage.click();
            inputImage.sendKeys(Image);
            Thread.sleep(3000);

            WebElement Analyzebtn = driver.findElement(By.xpath(PublicImageLocators.AnalyzeBtn()));
            Analyzebtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Valid")) {
                driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]")).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue("Successfully scan image");

            }//End code
        }

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}

