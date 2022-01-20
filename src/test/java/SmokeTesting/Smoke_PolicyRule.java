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
import xpaths.PolicyRuleXpaths;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_PolicyRule {
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String Message;
    String SuccessMessage;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final PolicyRuleXpaths PolicyRuleLocators = new PolicyRuleXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {


        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");

        WebElement Policy = driver.findElement(By.xpath(PolicyRuleLocators.PolicyBundle()));
        Policy.click();

        WebElement EditBtn = driver.findElement(By.xpath(PolicyRuleLocators.EditBTN()));
        EditBtn.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("PolicyRule");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String Name = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String Description = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement Addbtn = driver.findElement(By.xpath(PolicyRuleLocators.AddPolicyRule()));
            Addbtn.click();

            WebElement inputName = driver.findElement(By.xpath(PolicyRuleLocators.PolicyRuleName()));
            inputName.click();
            inputName.sendKeys(Name);
            Thread.sleep(3000);

            WebElement inputDesc = driver.findElement(By.xpath(PolicyRuleLocators.PolicyRuleDescription()));
            inputDesc.click();
            inputDesc.sendKeys(Description);
            Thread.sleep(3000);

            WebElement Savebtn = driver.findElement(By.xpath(PolicyRuleLocators.SavePolicyRule()));
            Savebtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Empty") || scenariotype.contains("Invalid")) {
                ErrorMessage = driver.findElement(By.xpath(PolicyRuleLocators.ErrorMessage())).getText();
                driver.findElement(By.xpath(PolicyRuleLocators.CancelPolicyRule())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Valid")) {
                SuccessMessage = driver.findElement(By.xpath(PolicyRuleLocators.SuccessMessage())).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(SuccessMessage);

            } else if (scenariotype.contains("Duplicate")) {
                Message = driver.findElement(By.xpath(PolicyRuleLocators.DuplicateMessage())).getText();
                driver.findElement(By.xpath(PolicyRuleLocators.CancelPolicyRule())).click();
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
