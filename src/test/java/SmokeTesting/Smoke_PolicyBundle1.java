package SmokeTesting;

import Executor.AccessExecutor;
import net.bytebuddy.ByteBuddy;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import xpaths.PolicyBundleXpaths;

import javax.sound.midi.Track;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_PolicyBundle1 {

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
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");

        WebElement Policy = driver.findElement(By.xpath(PolicyBundleLocators.PolicyBundle()));
        Policy.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("SearchPolicy");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String Search = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String Name = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            if (scenariotype.contains("Updated")) {

                WebElement Searchtxt = driver.findElement(By.xpath(PolicyBundleLocators.Search()));
                Searchtxt.click();
                Searchtxt.sendKeys(Search);
                Thread.sleep(3000);

                WebElement Searchbtn = driver.findElement(By.xpath(PolicyBundleLocators.Searchbtn()));
                Searchbtn.click();
                Thread.sleep(3000);

                WebElement EditBtn = driver.findElement(By.xpath(PolicyBundleLocators.Edit()));
                EditBtn.click();
                Thread.sleep(3000);

                WebElement EditBundle = driver.findElement(By.xpath(PolicyBundleLocators.EditBundle()));
                EditBundle.click();
                Thread.sleep(3000);

                WebElement inputName = driver.findElement(By.xpath(PolicyBundleLocators.BundleName()));
                inputName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                inputName.sendKeys(Name);
                inputName.click();
                Thread.sleep(3000);

                WebElement Savebtn = driver.findElement(By.xpath(PolicyBundleLocators.SavePolicy()));
                Savebtn.click();
                Thread.sleep(3000);

                Message = driver.findElement(By.xpath(PolicyBundleLocators.UpdatedMessage())).getText();
                driver.findElement(By.xpath(PolicyBundleLocators.ReturnPolicy())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(Message);

            } else if (scenariotype.contains("Cloned")) {

                WebElement Searchtxt1 = driver.findElement(By.xpath(PolicyBundleLocators.Search()));
                Searchtxt1.click();
                Searchtxt1.sendKeys(Search);
                Thread.sleep(3000);

                WebElement Searchbtn1 = driver.findElement(By.xpath(PolicyBundleLocators.Searchbtn()));
                Searchbtn1.click();
                Thread.sleep(3000);

                WebElement Cloned = driver.findElement(By.xpath(PolicyBundleLocators.ClonedBundle()));
                Cloned.click();
                Thread.sleep(3000);

                WebElement inputCloneName = driver.findElement(By.xpath(PolicyBundleLocators.CloneName()));
                inputCloneName.click();
                inputCloneName.sendKeys(Name);
                Thread.sleep(3000);

                WebElement SaveClone = driver.findElement(By.xpath(PolicyBundleLocators.SaveClone()));
                SaveClone.click();
                Thread.sleep(3000);

                Message = driver.findElement(By.xpath(PolicyBundleLocators.ClonedMessage())).getText();
                Searchtxt1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(Message);

            } else if (scenariotype.contains("Deleted")) {

                WebElement Searchtxt2 = driver.findElement(By.xpath(PolicyBundleLocators.Search()));
                Searchtxt2.click();
                Searchtxt2.sendKeys(Search);
                Thread.sleep(3000);

                WebElement Searchbtn2 = driver.findElement(By.xpath(PolicyBundleLocators.Searchbtn()));
                Searchbtn2.click();
                Thread.sleep(3000);

                WebElement DeleteBtn = driver.findElement(By.xpath(PolicyBundleLocators.DeleteBtn()));
                DeleteBtn.click();
                Thread.sleep(3000);

                WebElement DeleteClone = driver.findElement(By.xpath(PolicyBundleLocators.DeleteClone()));
                DeleteClone.click();
                Thread.sleep(3000);

                Message = driver.findElement(By.xpath(PolicyBundleLocators.DeleteMessage())).getText();
                Thread.sleep(3000);
                Searchtxt2.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
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