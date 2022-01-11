package SmokeTesting;

import Executor.AccessExecutor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import xpaths.EnvironmentsXpaths;

public class Smoke_Environments1 {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String SuccessMessage;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final EnvironmentsXpaths EnvironmentsLocators = new EnvironmentsXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {

        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        String url = "https://console.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "QACarboTesting@gmail.com","Carbonetes2021!");

        WebElement elm = driver.findElement(By.xpath(EnvironmentsLocators.Policybundle()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);

        WebElement Envi = driver.findElement(By.xpath(EnvironmentsLocators.Environments()));
        Envi.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("SearchEnvironment");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String Search = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement Searchtxt = driver.findElement(By.xpath(EnvironmentsLocators.SearchText()));
            Searchtxt.click();
            Searchtxt.sendKeys(Search);
            Thread.sleep(3000);

            WebElement Searchbtn = driver.findElement(By.xpath(EnvironmentsLocators.SearchBtn()));
            Searchbtn.click();
            Thread.sleep(3000);

            WebElement Deletebtn = driver.findElement(By.xpath(EnvironmentsLocators.DeleteBtn()));
            Deletebtn.click();
            Thread.sleep(3000);

            WebElement Yesbtn = driver.findElement(By.xpath(EnvironmentsLocators.YesBtn()));
            Yesbtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Valid")) {
                SuccessMessage = driver.findElement(By.xpath("//body/div[7]/div[1]")).getText();
                Searchtxt.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                Thread.sleep(3000);
                System.out.println(SuccessMessage);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(SuccessMessage);

            }
        }//End code

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}


