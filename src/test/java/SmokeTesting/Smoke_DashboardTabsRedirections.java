package SmokeTesting;

import Executor.AccessExecutor;
import org.apache.bcel.generic.Select;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xpaths.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Smoke_DashboardTabsRedirections {

    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    DataFormatter dataFormatter = new DataFormatter();
    String AutomationResultPassed = "Passed";
    String AutomationResultFailed = "Failed";
    String Filepath = "C:\\Users\\Gretchin\\Desktop\\Automation Stuffs\\CARBONETES\\DataDriven\\CarbonetesAutomatedSmokeTesting.xlsx";


    private static final DashboardTabsXpaths DashboardTabsLocators = new DashboardTabsXpaths();
    private static final Dashboard_ActivitiesActionItemsXpaths ActivitiesActionItemsLocators = new Dashboard_ActivitiesActionItemsXpaths();
    private static final Dashboard_SecurityRisksXpaths SecurityRisksLocators = new Dashboard_SecurityRisksXpaths();
    private static final Dashboard_ComplianceGovernanceXpaths ComplianceGovernanceLocators = new Dashboard_ComplianceGovernanceXpaths();


    @BeforeTest
    public void initialization() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gretchin\\Desktop\\Automation Stuffs" +
                "\\CARBONETES\\chromedriver_win32_96\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://tconsole.carbonetes.com/signin";
        driver.manage().window().maximize();
        new AccessExecutor().SigninExecute(driver, url, "admin@hoolisoftware.com", "!Carbonetes99");
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void DashboardSmokeTesting() throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(Filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Dashboard");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Go to Dashboard page
        WebElement DashboardPage = driver.findElement(By.xpath(DashboardTabsLocators.DashboardPage()));
        DashboardPage.click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            //Import data for Dashboard Tab Selected
            cell = sheet.getRow(i).getCell(0);
            String DashboardTabSelected = dataFormatter.formatCellValue(cell);

            //Set Date
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            System.out.println(currentDate);

            //Start flow of the code

            if (DashboardTabSelected.contains("Activities & Action Items") || DashboardTabSelected.contains("Security Risks") || DashboardTabSelected.contains("Compliance & Governance") || DashboardTabSelected.contains("Asset Management")) {

                if (DashboardTabSelected.contains("Activities & Action Items")) {
                    //Go to Activities & Action Items
                    WebElement DashboardActivitiesActionItems = driver.findElement(By.xpath(DashboardTabsLocators.ActivitiesActionItemsTab()));
                    DashboardActivitiesActionItems.click();
                    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                    // Saving details
                    String DashboardActionableItemsLabel = driver.findElement(By.xpath(ActivitiesActionItemsLocators.ActionableItemsLabel())).getText();
                    System.out.println(DashboardActionableItemsLabel);
                    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                    Thread.sleep(1000);

                    sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                    sheet.getRow(i).createCell(2).setCellValue(DashboardActionableItemsLabel);
                    sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    if (DashboardTabSelected.contains("Activities & Action Items: Date Range - This Month")) {
                        //To expand the Date Range Filter
                        WebElement ActivitiesActionItemsDateRange = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeFilterDropdown()));
                        ActivitiesActionItemsDateRange.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        //To select a filter "This Month"
                        WebElement DateRangeMonth = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeThisMonthFilter()));
                        DateRangeMonth.click();
                        String ThisMonthPolicyResultLabel = driver.findElement(By.xpath(ActivitiesActionItemsLocators.PolicyResultThisMonth())).getText();
                        System.out.println(ThisMonthPolicyResultLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ThisMonthPolicyResultLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Date Range - This Week")) {
                        //To expand the Date Range Filter
                        WebElement ActivitiesActionItemsDateRange = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeFilterDropdown()));
                        ActivitiesActionItemsDateRange.click();

                        //To select a filter "This Week"
                        WebElement DateRangeWeek = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeThisWeekFilter()));
                        DateRangeWeek.click();
                        String ThisWeekPolicyResultLabel = driver.findElement(By.xpath(ActivitiesActionItemsLocators.PolicyResultThisWeek())).getText();
                        System.out.println(ThisWeekPolicyResultLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ThisWeekPolicyResultLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Date Range - Today")) {
                        //To expand the Date Range Filter
                        WebElement ActivitiesActionItemsDateRange = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeFilterDropdown()));
                        ActivitiesActionItemsDateRange.click();

                        //To select a filter "Today"
                        WebElement DateRangeToday = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeTodayFilter()));
                        DateRangeToday.click();
                        String TodayPolicyResultLabel = driver.findElement(By.xpath(ActivitiesActionItemsLocators.PolicyResultToday())).getText();
                        System.out.println(TodayPolicyResultLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(TodayPolicyResultLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Show User")) {
                        //To click "Show User" filter
                        WebElement FilterShowUser = driver.findElement(By.cssSelector(ActivitiesActionItemsLocators.ShowUser()));
                        FilterShowUser.click();

                        //To get the actionable item displayed
                        String ActionableItemDisplayedShowUser = driver.findElement(By.xpath(ActivitiesActionItemsLocators.GetActionableItem())).getText();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ActionableItemDisplayedShowUser);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Show Teams")) {
                        //To click "Show Teams" filter
                        WebElement FilterShowTeams = driver.findElement(By.xpath(ActivitiesActionItemsLocators.ShowTeams()));
                        FilterShowTeams.click();

                        //To get the actionable item displayed
                        String ActionableItemDisplayedShowTeams = driver.findElement(By.xpath(ActivitiesActionItemsLocators.GetActionableItem())).getText();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ActionableItemDisplayedShowTeams);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Show Company")) {
                        //To click "Show Company" filter
                        WebElement FilterShowCompany = driver.findElement(By.xpath(ActivitiesActionItemsLocators.ShowCompany()));
                        FilterShowCompany.click();

                        //To get the actionable item displayed
                        String ActionableItemDisplayedShowCompany = driver.findElement(By.xpath(ActivitiesActionItemsLocators.GetActionableItem())).getText();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ActionableItemDisplayedShowCompany);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Analyze Image")) {
                        //To analyze the image displayed in the actionable item
                        WebElement AnalyzeImage = driver.findElement(By.xpath(ActivitiesActionItemsLocators.AnalyzeImage()));
                        AnalyzeImage.click();

                        //To get the Success Message for Complete Analyze
                        String CompleteAnalyzeMessage = driver.findElement(By.xpath(ActivitiesActionItemsLocators.CompleteAnalyzeToaster())).getText();
                        System.out.println(CompleteAnalyzeMessage);
                        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                        Thread.sleep(3500);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(CompleteAnalyzeMessage);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Show Results")) {
                        //View the result of the selected item
                        WebElement ShowResults = driver.findElement(By.xpath(ActivitiesActionItemsLocators.ShowResults()));
                        ShowResults.click();

                        //To get the Image Overview Label
                        String ImageOverviewLabel = driver.findElement(By.xpath(ActivitiesActionItemsLocators.ImageOverviewLabel())).getText();
                        System.out.println(ImageOverviewLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ImageOverviewLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                        driver.navigate().back();

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Modify JIRA Ticket")) {
                        //Modify JIRA ticket under Date Range: Month
                        //To expand the Date Range Filter
                        WebElement ActivitiesActionItemsDateRange = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeFilterDropdown()));
                        ActivitiesActionItemsDateRange.click();

                        //To select a filter "This Month"
                        WebElement DateRangeMonth = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeThisMonthFilter()));
                        DateRangeMonth.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        //To navigate in Company
                        WebElement JiraCompany = driver.findElement(By.xpath(ActivitiesActionItemsLocators.JiraCompany()));
                        JiraCompany.click();

                        //to perform Scroll down on application using Selenium
                        js.executeScript("window.scrollBy(0,350)", "JiraCompany");

                        //To click the Edit icon of Jira Ticket
                        WebElement EditJiraTicket = driver.findElement(By.xpath(ActivitiesActionItemsLocators.EditJiraTicketIcon()));
                        EditJiraTicket.click();

                        //To update the summary of Jira Ticket
                        WebElement inputSummary = driver.findElement(By.xpath(ActivitiesActionItemsLocators.UpdateJiraSummary()));
                        inputSummary.clear();
                        inputSummary.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                        inputSummary.sendKeys("Test CVE 12121");
                        inputSummary.sendKeys(Keys.RETURN);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                        //Save the updated Jira Ticket
                        WebElement clickSave = driver.findElement(By.xpath(ActivitiesActionItemsLocators.SaveJiraUpdate()));
                        clickSave.click();

                        String JiraUpdateSuccessMessage = driver.findElement(By.xpath(ActivitiesActionItemsLocators.JiraUpdateSuccessMessageToaster())).getText();
                        System.out.println(JiraUpdateSuccessMessage);
                        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                        Thread.sleep(3500);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(JiraUpdateSuccessMessage);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                        //to perform Scroll up on application using Selenium
                        js.executeScript("window.scrollBy(0,-350)", "JiraCompany");

                    } else if (DashboardTabSelected.contains("Activities & Action Items: Validate JIRA Ticket redirection")) {
                        // Validate JIRA Ticket redirection
                        //To expand the Date Range Filter
                        WebElement ActivitiesActionItemsDateRange = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeFilterDropdown()));
                        ActivitiesActionItemsDateRange.click();

                        //To select a filter "This Month"
                        WebElement DateRangeMonth = driver.findElement(By.xpath(ActivitiesActionItemsLocators.DateRangeThisMonthFilter()));
                        DateRangeMonth.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        //To navigate in Company
                        WebElement JiraCompany = driver.findElement(By.xpath(ActivitiesActionItemsLocators.JiraCompany()));
                        JiraCompany.click();

                        //To click Jira Ticket
                        WebElement JiraTicket = driver.findElement(By.xpath(ActivitiesActionItemsLocators.JiraTicketRedirection()));
                        JiraTicket.click();

                        // hold all window handles in array list
                        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
                        Set<String> set = driver.getWindowHandles();

                        //switch to new tab
                        driver.switchTo().window(newTb.get(1));
                        String pageTitle = driver.getTitle();
                        System.out.println("Page title of new tab: " + driver.getTitle());

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(pageTitle);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(2000);

                        //To close the new tab
                        set.remove(newTb);
                        driver.close();

                        //switch to parent window
                        driver.switchTo().window(newTb.get(0));
                        System.out.println("Page title of parent window: " + driver.getTitle());
                    }
                }
                if (DashboardTabSelected.contains("Security Risks")) {
                    //Go to Security Risks tab
                    WebElement DashboardSecurityRisksTab = driver.findElement(By.xpath(DashboardTabsLocators.SecurityRisksTab()));
                    DashboardSecurityRisksTab.click();
                    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                    // Saving details
                    String DashboardSecurityRisksLabel = driver.findElement(By.xpath(SecurityRisksLocators.SecurityRisksLabel())).getText();
                    System.out.println(DashboardSecurityRisksLabel);
                    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                    Thread.sleep(1000);

                    sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                    sheet.getRow(i).createCell(2).setCellValue(DashboardSecurityRisksLabel);
                    sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    if (DashboardTabSelected.contains("Security Risks: Date Range - This Month")) {
                        //To expand the Date Range Filter
                        WebElement SecurityRisksDateRange = driver.findElement(By.xpath(SecurityRisksLocators.DateRangeFilterDropdown()));
                        SecurityRisksDateRange.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        //To select a filter "This Month"
                        WebElement DateRangeMonth = driver.findElement(By.xpath(SecurityRisksLocators.DateRangeThisMonthFilter()));
                        DateRangeMonth.click();
                        String ThisMonthVulnCriticalResultLabel = driver.findElement(By.xpath(SecurityRisksLocators.VulnerabilitiesCriticalResult())).getText();
                        System.out.println(ThisMonthVulnCriticalResultLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ThisMonthVulnCriticalResultLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Security Risks: Date Range -  This Week")) {
                        //To expand the Date Range Filter
                        WebElement SecurityRisksDateRange = driver.findElement(By.xpath(SecurityRisksLocators.DateRangeFilterDropdown()));
                        SecurityRisksDateRange.click();

                        //To select a filter "This Week"
                        WebElement DateRangeWeek = driver.findElement(By.xpath(SecurityRisksLocators.DateRangeThisWeekFilter()));
                        DateRangeWeek.click();
                        String ThisWeekVulnHighResultLabel = driver.findElement(By.xpath(SecurityRisksLocators.VulnerbilitiesHighResult())).getText();
                        System.out.println(ThisWeekVulnHighResultLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ThisWeekVulnHighResultLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Security Risks: Date Range - Today")) {
                        //To expand the Date Range Filter
                        WebElement SecurityRisksDateRange = driver.findElement(By.xpath(SecurityRisksLocators.DateRangeFilterDropdown()));
                        SecurityRisksDateRange.click();

                        //To select a filter "Today"
                        WebElement DateRangeToday = driver.findElement(By.xpath(SecurityRisksLocators.DateRangeTodayFilter()));
                        DateRangeToday.click();
                        String ThisWeekVulnMediumResultLabel = driver.findElement(By.xpath(SecurityRisksLocators.VulnerabilitiesMediumResult())).getText();
                        System.out.println(ThisWeekVulnMediumResultLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(ThisWeekVulnMediumResultLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Security Risks: Show User")) {
                        //To click "Show User" filter
                        WebElement FilterShowUser = driver.findElement(By.cssSelector(SecurityRisksLocators.ShowUser()));
                        FilterShowUser.click();

                        //To get the Users displayed
                        String SecurityRisksDisplayedUserLabel = driver.findElement(By.xpath(SecurityRisksLocators.SecurityRisksUsersLabel())).getText();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(SecurityRisksDisplayedUserLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Security Risks: Show Teams")) {
                        //To click "Show Teams" filter
                        WebElement FilterShowTeams = driver.findElement(By.xpath(SecurityRisksLocators.ShowTeams()));
                        FilterShowTeams.click();

                        //To get the Users displayed
                        String SecurityRisksDisplayedUserLabel = driver.findElement(By.xpath(SecurityRisksLocators.SecurityRisksUsersLabel())).getText();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(SecurityRisksDisplayedUserLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    } else if (DashboardTabSelected.contains("Security Risks: Show Company")) {
                        //To click "Show Company" filter
                        WebElement FilterShowCompany = driver.findElement(By.xpath(SecurityRisksLocators.ShowCompany()));
                        FilterShowCompany.click();

                        //To get the Users displayed
                        String SecurityRisksDisplayedUserLabel = driver.findElement(By.xpath(SecurityRisksLocators.SecurityRisksUsersLabel())).getText();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(SecurityRisksDisplayedUserLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);
                    }
                }
                if (DashboardTabSelected.contains("Compliance & Governance")) {
                    //Go to Compliance & Governance tab
                    WebElement DashboardComplianceGovernanceTab = driver.findElement(By.xpath(DashboardTabsLocators.ComplianceGovernanceTab()));
                    DashboardComplianceGovernanceTab.click();
                    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

                    // Saving details
                    String DashboardComplianceGovernanceLabel = driver.findElement(By.xpath(ComplianceGovernanceLocators.ComplianceGovernance())).getText();
                    System.out.println(DashboardComplianceGovernanceLabel);
                    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                    Thread.sleep(1000);

                    sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                    sheet.getRow(i).createCell(2).setCellValue(DashboardComplianceGovernanceLabel);
                    sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    if (DashboardTabSelected.contains("Compliance & Governance: Compliance - Validate Policy Bundle Name redirection")) {
                        //To redirect to a policy bundle
                        WebElement PolicyBundleNameSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.PolicyBundleNameSort()));
                        PolicyBundleNameSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement clickPolicyBundleName = driver.findElement(By.xpath(ComplianceGovernanceLocators.PolicyBundleName()));
                        clickPolicyBundleName.click();

                        //To get the Policy Bundle Label
                        String PolicyBundleLabel = driver.findElement(By.xpath(ComplianceGovernanceLocators.PolicyBundleLabel())).getText();
                        System.out.println(PolicyBundleLabel);
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        //Save details of the test execution
                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(2).setCellValue(PolicyBundleLabel);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                        driver.navigate().back();
                    }
                    else if (DashboardTabSelected.contains("Compliance & Governance: Compliance - Validate Sort and Governance Filters")) {
                        //To click sort icons in the compliance table
                        WebElement PolicyBundleNameSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.PolicyBundleNameSort()));
                        PolicyBundleNameSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement StatusSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.StatusSort()));
                        StatusSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement PolicyRulesSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.PolicyRulesSort()));
                        PolicyRulesSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement WhitelistCountSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.WhitelistCountSort()));
                        WhitelistCountSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement BlacklistCountSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.BlacklistCountSort()));
                        BlacklistCountSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement EvaluationsSort = driver.findElement(By.xpath(ComplianceGovernanceLocators.EvaluationsSort()));
                        EvaluationsSort.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement GovernanceNoneFilter = driver.findElement(By.xpath(ComplianceGovernanceLocators.GovernanceNoneFilter()));
                        GovernanceNoneFilter.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        //to perform Scroll down on application using Selenium
                        js.executeScript("window.scrollBy(0,350)", "GovernanceNoneFilter");

                        WebElement GovernanceUserFilter = driver.findElement(By.xpath(ComplianceGovernanceLocators.GovernanceUserFilter()));
                        GovernanceUserFilter.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);

                        WebElement GovernancePolicyBundleFilter = driver.findElement(By.xpath(ComplianceGovernanceLocators.GovernancePolicyBundleFilter()));
                        GovernancePolicyBundleFilter.click();
                        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
                        Thread.sleep(1000);



                        //To save details if the test execution passed.
                        sheet.getRow(i).createCell(1).setCellValue(AutomationResultPassed);
                        sheet.getRow(i).createCell(3).setCellValue(currentDate);

                    }
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(Filepath);
        workbook.write(fos);
        fos.close();
        driver.close();
    }
}
