package SmokeTesting;

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
import xpaths.ForgotPasswordXpaths;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Smoke_ForgotPassword {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String SuccessMessage;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\Carbo.xlsx";

    private static final ForgotPasswordXpaths ForgotPasswordLocators = new ForgotPasswordXpaths();

    @Test

    public void initialization() throws InterruptedException, IOException {

        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        driver.navigate().to("https://tconsole.carbonetes.com/signin");
        driver.manage().window().maximize();

        WebElement Forgotbtn = driver.findElement(By.xpath(ForgotPasswordLocators.ForgotBtn()));
        Forgotbtn.click();
        Thread.sleep(3000);

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Forgot");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String email = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement inputEmail = driver.findElement(By.xpath(ForgotPasswordLocators.EmailTextField()));
            inputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputEmail.sendKeys(email);
            inputEmail.click();
            Thread.sleep(3000);

            WebElement Resetbtn = driver.findElement(By.xpath(ForgotPasswordLocators.ResetBtn()));
            Resetbtn.click();
            Thread.sleep(3000);


            if (scenariotype.contains("Invalid")) {
                ErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'Username/E-mail must be valid')]")).getText();
                System.out.println(ErrorMessage);
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Valid")) {
                SuccessMessage = driver.findElement(By.xpath("//body/div[7]/div[1]")).getText();
                System.out.println(SuccessMessage);
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(2).setCellValue(resultmessage);
                sheet.getRow(i).createCell(3).setCellValue(SuccessMessage);

            }
        }

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}
