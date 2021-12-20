package Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import xpaths.LoginXpaths;

public class AccessExecutor {

    private static final LoginXpaths SigninLocators = new LoginXpaths();

    public AccessExecutor() {
    }

    public void SigninExecute(WebDriver driver, String url, String username, String password) throws InterruptedException {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), "Carbonetes");
        Thread.sleep(2000L);
        driver.findElement(By.xpath(SigninLocators.UsernameField())).sendKeys(new CharSequence[]{username});
        driver.findElement(By.xpath(SigninLocators.PasswordField())).sendKeys(new CharSequence[]{password});
        Thread.sleep(2000L);
        driver.findElement(By.xpath(SigninLocators.SignInBtn())).click();
        Thread.sleep(2000L);
    }
}



