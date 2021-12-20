package SmokeTesting;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import xpaths.LoginXpaths;

public class Smoke_Signin {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataformatter = new DataFormatter();
    String ErrorMessage;
    String filepath = "D:\\Automation\\Documents\\Carbonetes\\CarbonetesAutomatedSmokeTesting.xlsx";

    private static final LoginXpaths SigninLocators = new LoginXpaths();


    @Test

    public void initialization() throws InterruptedException, IOException {


        //Go to website
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        driver.navigate().to("https://tconsole.carbonetes.com/signin");
        driver.manage().window().maximize();

        //Get data from excel
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("SIGNIN");

        //Calling and Storing of data
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            cell = sheet.getRow(i).getCell(0);
            String username = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(1);
            String password = dataformatter.formatCellValue(cell);

            cell = sheet.getRow(i).getCell(2);
            String scenariotype = dataformatter.formatCellValue(cell);

            //Start code
            WebElement inputUname = driver.findElement(By.xpath(SigninLocators.UsernameField()));
            inputUname.click();
            inputUname.sendKeys(username);
            Thread.sleep(3000);

            WebElement inputPassword = driver.findElement(By.xpath(SigninLocators.PasswordField()));
            inputPassword.click();
            inputPassword.sendKeys(password);
            Thread.sleep(3000);

            WebElement Siginbtn = driver.findElement(By.xpath(SigninLocators.SignInBtn()));
            Siginbtn.click();
            Thread.sleep(3000);

            if (scenariotype.contains("Invalid")) {
                ErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]")).getText();
                System.out.println(ErrorMessage);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue(ErrorMessage);

            } else if (scenariotype.contains("Valid")) {
                driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).click();
                Thread.sleep(3000);
                String resultmessage = "Passed";
                sheet.getRow(i).createCell(3).setCellValue(resultmessage);
                sheet.getRow(i).createCell(4).setCellValue("Successfully login");

            }//End code
        }

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}

