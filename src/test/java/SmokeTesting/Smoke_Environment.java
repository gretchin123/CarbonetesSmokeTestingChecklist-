package SmokeTesting;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import xpaths.EnvironmentsXpaths;
import java.util.concurrent.TimeUnit;
import Executor.AccessExecutor;


public class Smoke_Environment {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String SuccessMessage;
    String Message;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\Carbo.xlsx";

    private static final EnvironmentsXpaths EnvironmentsLocators = new EnvironmentsXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {


        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com","!Carbonetes99");

        WebElement elm = driver.findElement(By.xpath(EnvironmentsLocators.Policybundle()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

        WebElement Envi = driver.findElement(By.xpath(EnvironmentsLocators.Environments()));
        Envi.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Environments");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String Name = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String Description = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement Addbtn = driver.findElement(By.xpath(EnvironmentsLocators.AddEnvironment()));
            Addbtn.click();

            WebElement inputName = driver.findElement(By.xpath(EnvironmentsLocators.NameEnvironment()));
            inputName.click();
            inputName.sendKeys(Name);
            Thread.sleep(3000);

            WebElement inputDesc = driver.findElement(By.xpath(EnvironmentsLocators.DescriptionEnvi()));
            inputDesc.click();
            inputDesc.sendKeys(Description);
            Thread.sleep(3000);

            WebElement Savebtn = driver.findElement(By.xpath(EnvironmentsLocators.SaveEnvironment()));
            Savebtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Empty") || scenariotype.contains("Invalid")) {
                ErrorMessage = driver.findElement(By.xpath("//body[1]/div[7]/div[1]")).getText();
                driver.findElement(By.xpath(EnvironmentsLocators.CancelEnvironment())).click();
                Thread.sleep(3000);
                System.out.println(ErrorMessage);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Valid")) {
                SuccessMessage = driver.findElement(By.xpath("//body/div[7]/div[1]")).getText();
                Thread.sleep(3000);
                System.out.println(SuccessMessage);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(SuccessMessage);

            } else if (scenariotype.contains("Duplicate")) {
                Message = driver.findElement(By.xpath("//div[contains(text(),'The Environment Name is Already Used')]")).getText();
                driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
                Thread.sleep(3000);
                System.out.println(Message);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(Message);

            }
        }

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}
