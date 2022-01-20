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
import xpaths.DeduplicationSettingsXpaths;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_DeduplicationSettings {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String SuccessMessage;
    String Message;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final DeduplicationSettingsXpaths DeduplicationSettingsLocators = new DeduplicationSettingsXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {

        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");

        WebElement elm = driver.findElement(By.xpath(DeduplicationSettingsLocators.Policybundle()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

        WebElement Settings = driver.findElement(By.xpath(DeduplicationSettingsLocators.Settings()));
        Settings.click();

        WebElement Engine = driver.findElement(By.xpath(DeduplicationSettingsLocators.Engine()));
        Engine.click();
        Thread.sleep(3000);

        WebElement DropDown = driver.findElement(By.xpath(DeduplicationSettingsLocators.DropDown()));
        DropDown.click();
        Thread.sleep(3000);

        WebElement ImageToTest = driver.findElement(By.xpath(DeduplicationSettingsLocators.ImageToTest()));
        ImageToTest.click();
        Thread.sleep(3000);

        WebElement ShowResult = driver.findElement(By.xpath(DeduplicationSettingsLocators.SaveResult()));
        ShowResult.click();
        Thread.sleep(3000);

        WebElement YesBtn = driver.findElement(By.xpath(DeduplicationSettingsLocators.YesBTN()));
        YesBtn.click();
        Thread.sleep(3000);
    }
}