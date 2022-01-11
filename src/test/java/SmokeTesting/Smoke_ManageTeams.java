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
import xpaths.ManageTeamsXpaths;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_ManageTeams {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String Message;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final ManageTeamsXpaths ManageTeamsLocators = new ManageTeamsXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {

        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");

        WebElement elm = driver.findElement(By.xpath(ManageTeamsLocators.Policybundle()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

        WebElement elm1 = driver.findElement(By.xpath(ManageTeamsLocators.Settings()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm1);

        WebElement ManageTeams = driver.findElement(By.xpath(ManageTeamsLocators.ManageTeams()));
        ManageTeams.click();

        WebElement AddTeam = driver.findElement(By.xpath(ManageTeamsLocators.AddTeam()));
        AddTeam.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("ManageTeams");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String TeamName = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String Description = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String TeamTag = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(3);
            String SearchName = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(4);
            String scenariotype = dataformatter.formatCellValue(cell);


            //Start code
            WebElement inputName = driver.findElement(By.xpath(ManageTeamsLocators.TeamName()));
            inputName.click();
            inputName.sendKeys(TeamName);
            Thread.sleep(3000);

            WebElement inputDescription = driver.findElement(By.xpath(ManageTeamsLocators.Description()));
            inputDescription.click();
            inputDescription.sendKeys(Description);
            Thread.sleep(3000);

            WebElement inputTeamTag = driver.findElement(By.xpath(ManageTeamsLocators.TeamTag()));
            inputTeamTag.click();
            inputTeamTag.sendKeys(TeamTag);
            Thread.sleep(3000);

            WebElement inputSearchName= driver.findElement(By.xpath(ManageTeamsLocators.SearchName()));
            inputSearchName.click();
            inputSearchName.sendKeys(SearchName);
            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@aria-label='John Black']")).click();
        }
    }
}