package xpaths;

public class LoginXpaths {

    public String LoginLocators;

    public String UsernameField(){
        return this.LoginLocators = "//input[@id='username']";
    }
    public String PasswordField(){
        return this.LoginLocators = "//input[@id='password']";
    }
    public String SignInBtn(){
        return this.LoginLocators = "//button[normalize-space()='Sign In']";
    }

    //For Messages
    public String ErrorMessage() { return this.LoginLocators = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]"; }
    public String SuccessMessage() { return this.LoginLocators = "//span[contains(text(),'Dashboard')]"; }

}
