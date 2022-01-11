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
import xpaths.ManageLicensesXpaths;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_ManageLicenses {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String SuccessMessage;
    String Message;
    String InvalidMessage;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final ManageLicensesXpaths ManageLicenseLocators = new ManageLicensesXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {


        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");

        WebElement elm = driver.findElement(By.xpath(ManageLicenseLocators.Policybundle()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

        WebElement elm1 = driver.findElement(By.xpath(ManageLicenseLocators.Settings()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm1);

        WebElement ManageLicenses = driver.findElement(By.xpath(ManageLicenseLocators.ManageLicenses()));
        ManageLicenses.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Manage Licenses");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String LicenseId = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String LicenseName = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String LicenseLink = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(3);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement AddLicenses = driver.findElement(By.xpath(ManageLicenseLocators.AddLicense()));
            AddLicenses.click();

            WebElement inputID = driver.findElement(By.xpath(ManageLicenseLocators.LicenseID()));
            inputID.click();
            inputID.sendKeys(LicenseId);
            Thread.sleep(3000);

            WebElement inputName = driver.findElement(By.xpath(ManageLicenseLocators.LicenseName()));
            inputName.click();
            inputName.sendKeys(LicenseName);
            Thread.sleep(3000);

            WebElement inputLink = driver.findElement(By.xpath(ManageLicenseLocators.LicenseLink()));
            inputLink.click();
            inputLink.sendKeys(LicenseLink);
            Thread.sleep(3000);

            WebElement Savebtn = driver.findElement(By.xpath(ManageLicenseLocators.SaveLicense()));
            Savebtn.click();
            Thread.sleep(3000);
            if (scenariotype.contains("Empty")) {
                ErrorMessage = driver.findElement(By.xpath(ManageLicenseLocators.EmptyMessage())).getText();
                driver.findElement(By.xpath(ManageLicenseLocators.CancelLicense())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(4).setCellValue(resultmessage);
                sheet.getRow(i).createCell(5).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Invalid")) {
                InvalidMessage = driver.findElement(By.xpath("ManageLicenseLocators.EmptyMessage()" +"/" + "ManageLicenseLocators.InvalidMessage()")).getText();
                driver.findElement(By.xpath(ManageLicenseLocators.CancelLicense())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(4).setCellValue(resultmessage);
                sheet.getRow(i).createCell(5).setCellValue("ErrorMessage" + "/" + "InvalidMessage");

           /* } else if (scenariotype.contains("Valid")) {
                SuccessMessage = driver.findElement(By.xpath("//div[@class='jq-toast-single jq-has-icon jq-icon-success']")).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(4).setCellValue(resultmessage);
                sheet.getRow(i).createCell(5).setCellValue(SuccessMessage);

            } else if (scenariotype.contains("Duplicate")) {
                Message = driver.findElement(By.xpath("//div[contains(text(),'The Environment Name is Already Used')]")).getText();
                driver.findElement(By.xpath(ManageLicenseLocators.CancelLicense())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(4).setCellValue(resultmessage);
                sheet.getRow(i).createCell(5).setCellValue(Message);
*/
            }
        }//End code

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}
