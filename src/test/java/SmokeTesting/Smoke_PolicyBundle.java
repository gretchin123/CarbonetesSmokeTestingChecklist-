package SmokeTesting;

import Executor.AccessExecutor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import xpaths.PolicyBundleXpaths;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_PolicyBundle {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String Message;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final PolicyBundleXpaths PolicyBundleLocators = new PolicyBundleXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {


        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://console.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "QACarboTesting@gmail.com","Carbonetes2021!");

        WebElement Policy = driver.findElement(By.xpath(PolicyBundleLocators.PolicyBundle()));
        Policy.click();

        WebElement Create = driver.findElement(By.xpath(PolicyBundleLocators.CreateBundle()));
        Create.click();
        Thread.sleep(3000);

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("PolicyBundle");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String PolicyName = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String Description = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement elm = driver.findElement(By.xpath(PolicyBundleLocators.SavePolicy()));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

            WebElement inputName = driver.findElement(By.xpath(PolicyBundleLocators.PolicyName()));
            inputName.click();
            inputName.sendKeys(PolicyName);
            Thread.sleep(3000);

            WebElement inputDesc = driver.findElement(By.xpath(PolicyBundleLocators.PolicyDesc()));
            inputDesc.click();
            inputDesc.sendKeys(Description);
            Thread.sleep(3000);

            WebElement Savebtn = driver.findElement(By.xpath(PolicyBundleLocators.SavePolicy()));
            Savebtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Empty") || scenariotype.contains("Invalid")) {
                ErrorMessage = driver.findElement(By.xpath(PolicyBundleLocators.ErrorMessage())).getText();
                driver.findElement(By.xpath(PolicyBundleLocators.CancelPolicy())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Valid")) {
                driver.findElement(By.xpath(PolicyBundleLocators.SuccessMessage())).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath(PolicyBundleLocators.ReturnPolicy())).click();
                driver.findElement(By.xpath(PolicyBundleLocators.CreateBundle())).click();
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue("Successfully created");

            } else if (scenariotype.contains("Duplicate")) {
                Message = driver.findElement(By.xpath(PolicyBundleLocators.DuplicateMessage())).getText();
                driver.navigate().back();
                driver.findElement(By.xpath(PolicyBundleLocators.ReturnPolicy())).click();
                 Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(Message);

            }
        }//End code

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}

