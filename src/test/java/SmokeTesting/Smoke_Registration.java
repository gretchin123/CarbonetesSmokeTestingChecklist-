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
import xpaths.RegistrationXpaths;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Smoke_Registration {
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataFormatter = new DataFormatter();
    String AutomationResultPassed = "Passed";
    String AutomationResultFailed = "Failed";

    private static final RegistrationXpaths RegistrationLocators = new RegistrationXpaths();

    @BeforeTest
    public void initialization(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gretchin\\Desktop\\Automation Stuffs" +
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
        sheet = workbook.getSheet("Registration");

        //Click on here from Sign In Page
        WebElement HereLink = driver.findElement(By.xpath(RegistrationLocators.hereLink()));
        HereLink.click();

        for (int i=1; i<=sheet.getLastRowNum(); i++) {

            //Import data for scenario
            cell = sheet.getRow(i).getCell(0);
            String ScenarioType = dataFormatter.formatCellValue(cell);

            //Import data for First Name.
            cell = sheet.getRow(i).getCell(1);
            String Fname = dataFormatter.formatCellValue(cell);

            //Import data for Last Name
            cell = sheet.getRow(i).getCell(2);
            String Lname = dataFormatter.formatCellValue(cell);

            //Import data for Email
            cell = sheet.getRow(i).getCell(3);
            String Email = dataFormatter.formatCellValue(cell);

            //Import data for Password
            cell = sheet.getRow(i).getCell(4);
            String Pword = dataFormatter.formatCellValue(cell);

            //Import data for Confirm Password
            cell = sheet.getRow(i).getCell(5);
            String ConPassword = dataFormatter.formatCellValue(cell);

            //Import data for Company Name
            cell = sheet.getRow(i).getCell(6);
            String Company = dataFormatter.formatCellValue(cell);

            //Import data for Phone Number
            cell = sheet.getRow(i).getCell(7);
            String PhoneNumber = dataFormatter.formatCellValue(cell);

            //Set Date
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            System.out.println(currentDate);

            //Start flow of the code

            //Input First Name
            WebElement inputFname = driver.findElement(By.xpath(RegistrationLocators.FirstNameTextField()));
            inputFname.clear();
            inputFname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputFname.sendKeys(Fname);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Input Last Name
            WebElement inputLname = driver.findElement(By.xpath(RegistrationLocators.LastNameTextField()));
            inputLname.clear();
            inputLname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputLname.sendKeys(Lname);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Input Email
            WebElement inputEmail = driver.findElement(By.xpath(RegistrationLocators.EmailTextField()));
            inputEmail.clear();
            inputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputEmail.sendKeys(Email);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Input Password
            WebElement inputPassword = driver.findElement(By.xpath(RegistrationLocators.PasswordTextField()));
            inputPassword.clear();
            inputPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputPassword.sendKeys(Pword);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Input Confirm Password
            WebElement inputConPassword = driver.findElement(By.xpath(RegistrationLocators.ConfirmPasswordTextField()));
            inputConPassword.clear();
            inputConPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputConPassword.sendKeys(ConPassword);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Input Company Name
            WebElement inputCompany = driver.findElement(By.xpath(RegistrationLocators.CompanyTextField()));
            inputCompany.clear();
            inputCompany.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputCompany.sendKeys(Company);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Input Phone Number
            WebElement inputPhoneNumber = driver.findElement(By.xpath(RegistrationLocators.PhoneNumberTextField()));
            inputPhoneNumber.clear();
            inputPhoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            inputPhoneNumber.sendKeys(Company);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

            //Click Register
            WebElement RegisterBtn = driver.findElement(By.xpath(RegistrationLocators.RegisterButton()));

            if (ScenarioType.contains("Empty")) {
                //Condition if scenario is empty

                //Click LogIn button
                RegisterBtn.click();
                Thread.sleep(1000);
                driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                //Saving to Excel
                FileOutputStream fos = new FileOutputStream(src);
                String actualMessage = driver.findElement(By.xpath(RegistrationLocators.RequiredFieldErrorMessage())).getText();

                sheet.getRow(i).createCell(8).setCellValue(AutomationResultPassed);
                sheet.getRow(i).createCell(9).setCellValue(actualMessage);
                sheet.getRow(i).createCell(10).setCellValue(currentDate);
                workbook.write(fos);
                fos.close();
            }
            else if(ScenarioType.contains("Invalid")){
                //Condition if Scenario is Invalid details

                //Click LogIn button
                RegisterBtn.click();
                Thread.sleep(1000);
                driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                //Saving to Excel
                FileOutputStream fos = new FileOutputStream(src);
                String actualMessage = driver.findElement(By.xpath(RegistrationLocators.InvalidEmailErrorMessage())).getText();

                sheet.getRow(i).createCell(8).setCellValue(AutomationResultPassed);
                sheet.getRow(i).createCell(9).setCellValue(actualMessage);
                sheet.getRow(i).createCell(10).setCellValue(currentDate);
                workbook.write(fos);
                fos.close();
            }
            else if(ScenarioType.contains("Valid")){
                //Condition if Scenario is Valid details

                //Click LogIn button
                RegisterBtn.click();
                Thread.sleep(1000);
                driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                //Saving to Excel
                FileOutputStream fos = new FileOutputStream(src);
                String actualMessage = driver.findElement(By.xpath(RegistrationLocators.RegistrationSuccessMessage())).getText();

                sheet.getRow(i).createCell(8).setCellValue(AutomationResultPassed);
                sheet.getRow(i).createCell(9).setCellValue(actualMessage);
                sheet.getRow(i).createCell(10).setCellValue(currentDate);
                workbook.write(fos);
                fos.close();
            }
        }
        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
