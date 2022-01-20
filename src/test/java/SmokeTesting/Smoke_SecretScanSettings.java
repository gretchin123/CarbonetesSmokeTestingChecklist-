package SmokeTesting;

import Executor.AccessExecutor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import xpaths.SecretScanSettingsXpaths;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_SecretScanSettings {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String SuccessMessage;
    String Message;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final SecretScanSettingsXpaths SecretScanSettingsLocators = new SecretScanSettingsXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {

        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");

        WebElement elm = driver.findElement(By.xpath(SecretScanSettingsLocators.Policybundle()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

        WebElement Settings = driver.findElement(By.xpath(SecretScanSettingsLocators.Settings()));
        Settings.click();

        WebElement SecretScan = driver.findElement(By.xpath(SecretScanSettingsLocators.SecretScan()));
        SecretScan.click();

        WebElement elm1 = driver.findElement(By.xpath(SecretScanSettingsLocators.Scroll()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm1);

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("SecretScan");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String ContentRegexName = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            if (scenariotype.contains("Valid")) {

                WebElement AddBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.AddContextRegex()));
                AddBtn.click();
                Thread.sleep(3000);

                WebElement inputName = driver.findElement(By.xpath(SecretScanSettingsLocators.ContentRegex()));
                inputName.click();
                inputName.sendKeys(ContentRegexName);
                Thread.sleep(3000);

                WebElement SaveBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.SaveRegex()));
                SaveBtn.click();
                Thread.sleep(3000);

                WebElement SaveConfig = driver.findElement(By.xpath(SecretScanSettingsLocators.SaveConfig()));
                SaveConfig.click();
                Thread.sleep(3000);

                SuccessMessage = driver.findElement(By.xpath(SecretScanSettingsLocators.ValidMessage())).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(SuccessMessage);

            } else if (scenariotype.contains("Updated")) {

                WebElement ToBeUpdate = driver.findElement(By.xpath(SecretScanSettingsLocators.TobeUpdated()));
                ToBeUpdate.click();
                Thread.sleep(3000);

                WebElement EditBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.EditNameBtn()));
                EditBtn.click();
                Thread.sleep(3000);

                WebElement inputUpdateName = driver.findElement(By.xpath(SecretScanSettingsLocators.ContentRegex()));
                inputUpdateName.click();
                inputUpdateName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                inputUpdateName.sendKeys(ContentRegexName);
                Thread.sleep(3000);

                WebElement SaveBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.SaveRegex()));
                SaveBtn.click();
                Thread.sleep(3000);

                WebElement SaveConfig = driver.findElement(By.xpath(SecretScanSettingsLocators.SaveConfig()));
                SaveConfig.click();
                Thread.sleep(3000);

                Message = driver.findElement(By.xpath(SecretScanSettingsLocators.ValidMessage())).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(Message);

            } else if (scenariotype.contains("Duplicate")) {

                WebElement AddBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.AddContextRegex()));
                AddBtn.click();
                Thread.sleep(3000);

                WebElement inputName = driver.findElement(By.xpath(SecretScanSettingsLocators.ContentRegex()));
                inputName.click();
                inputName.sendKeys(ContentRegexName);
                Thread.sleep(3000);

                WebElement SaveBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.SaveRegex()));
                SaveBtn.click();
                Thread.sleep(3000);

                Message = driver.findElement(By.xpath(SecretScanSettingsLocators.DuplicateMessage())).getText();
                driver.findElement(By.xpath(SecretScanSettingsLocators.CancelName())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(Message);

            } else if (scenariotype.contains("Deleted")) {

                WebElement DeleteRegex = driver.findElement(By.xpath(SecretScanSettingsLocators.TobeDelete()));
                DeleteRegex.click();
                Thread.sleep(3000);

                WebElement DeleteBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.DeleteRegex()));
                DeleteBtn.click();
                Thread.sleep(3000);

                WebElement YesBtn = driver.findElement(By.xpath(SecretScanSettingsLocators.Yesbtn()));
                YesBtn.click();
                Thread.sleep(3000);

                WebElement SaveConfig = driver.findElement(By.xpath(SecretScanSettingsLocators.SaveConfig()));
                SaveConfig.click();
                Thread.sleep(3000);

                Message = driver.findElement(By.xpath(SecretScanSettingsLocators.ValidMessage())).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(Message);
            }
        }//End code

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}
