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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xpaths.Dashboard_ActivitiesActionItemsXpaths;
import xpaths.LoginXpaths;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Smoke_Dashboard_ActivitiesActionItems {
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataFormatter = new DataFormatter();
    String AutomationResultPassed = "Passed";
    String AutomationResultFailed = "Failed";

    private static final Dashboard_ActivitiesActionItemsXpaths ActivitiesActionItemsLocators = new Dashboard_ActivitiesActionItemsXpaths();
    private static final LoginXpaths LoginLocators = new LoginXpaths();

    @BeforeTest
    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gretchin\\Desktop\\Automation Stuffs" +
                "\\CARBONETES\\chromedriver_win32_96\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tconsole.carbonetes.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void Registration() throws IOException, InterruptedException {
        File src = new File("C:\\Users\\Gretchin\\Desktop\\Automation Stuffs\\CARBONETES" +
                "\\DataDriven\\CarbonetesAutomatedSmokeTesting.xlsx");
        FileInputStream fis = new FileInputStream(src);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Dashboard");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            //Import data for Username
            cell = sheet.getRow(i).getCell(0);
            String Username = dataFormatter.formatCellValue(cell);

            //Import data for Password
            cell = sheet.getRow(i).getCell(1);
            String Password = dataFormatter.formatCellValue(cell);

            //Import data for Dashboard Tab Selected
            cell = sheet.getRow(i).getCell(2);
            String DashboardTabSelected = dataFormatter.formatCellValue(cell);

            //Set Date
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            System.out.println(currentDate);

            //Start flow of the code

            //Sign In
            WebElement inputUsername = driver.findElement(By.xpath(LoginLocators.UsernameField()));
            inputUsername.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputUsername.sendKeys(Username);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            WebElement inputPassword = driver.findElement(By.xpath(LoginLocators.PasswordField()));
            inputPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputPassword.sendKeys(Password);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Click Sign In
            WebElement SignInBtn = driver.findElement(By.xpath(LoginLocators.SignInBtn()));
            SignInBtn.click();
            Thread.sleep(4000);

            if (DashboardTabSelected.contains("Activities & Action Items") || DashboardTabSelected.contains("Security Risks") || DashboardTabSelected.contains("Compliance & Governance") || DashboardTabSelected.contains("Asset Management")) {
                //Go to Activities & Action Items tab
            }

        }
    }
}