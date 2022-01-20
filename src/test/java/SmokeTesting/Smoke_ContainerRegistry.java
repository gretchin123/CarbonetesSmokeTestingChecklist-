package SmokeTesting;

import Executor.AccessExecutor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import xpaths.ContainerRegistryXpaths;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_ContainerRegistry {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String SuccessMessage;
    String Message;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final ContainerRegistryXpaths ContainerRegistryLocators = new ContainerRegistryXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {

        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "jennyhunter99@gmail.com", "hannahbelle21");

        WebElement ContainerRegistries = driver.findElement(By.xpath(ContainerRegistryLocators.ContainerRegistry()));
        ContainerRegistries.click();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("ContainerRegistry");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String URI = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String RegisryName = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String AccoundID = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(3);
            String APIKey = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(4);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement AddBtn = driver.findElement(By.xpath(ContainerRegistryLocators.AddRegistry()));
            AddBtn.click();
            Thread.sleep(3000);

            WebElement SelectRegistry = driver.findElement(By.xpath(ContainerRegistryLocators.SelectRegistry()));
            SelectRegistry.click();
            Thread.sleep(3000);

            WebElement inputURI = driver.findElement(By.xpath(ContainerRegistryLocators.ContainerURI()));
            inputURI.click();
            inputURI.sendKeys(URI);
            Thread.sleep(3000);

            WebElement InputName = driver.findElement(By.xpath(ContainerRegistryLocators.RegistryName()));
            InputName.click();
            InputName.sendKeys(RegisryName);
            Thread.sleep(3000);

            WebElement inputID = driver.findElement(By.xpath(ContainerRegistryLocators.AccountID()));
            inputID.click();
            inputID.sendKeys(AccoundID);
            Thread.sleep(3000);

            WebElement inputAPIKey = driver.findElement(By.xpath(ContainerRegistryLocators.APIKey()));
            inputAPIKey.click();
            inputAPIKey.sendKeys(APIKey);
            Thread.sleep(3000);

            WebElement SaveBtn = driver.findElement(By.xpath(ContainerRegistryLocators.SaveRegistry()));
            SaveBtn.click();
            Thread.sleep(3000);

            WebElement CancelBtn = driver.findElement(By.xpath(ContainerRegistryLocators.CancelRegistry()));
            CancelBtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Invalid")) {
                ErrorMessage = driver.findElement(By.xpath(ContainerRegistryLocators.InvalidMessage())).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(5).setCellValue(resultmessage);
                sheet.getRow(i).createCell(6).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Valid")) {
                SuccessMessage = driver.findElement(By.xpath(ContainerRegistryLocators.SuccessMessage())).getText();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(5).setCellValue(resultmessage);
                sheet.getRow(i).createCell(6).setCellValue(SuccessMessage);

            } else if (scenariotype.contains("Duplicate")) {
                Message = driver.findElement(By.xpath(ContainerRegistryLocators.DuplicateMessage())).getText();
                driver.findElement(By.xpath(ContainerRegistryLocators.CancelRegistry())).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(5).setCellValue(resultmessage);
                sheet.getRow(i).createCell(6).setCellValue(Message);

            }
        }//End code

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}

