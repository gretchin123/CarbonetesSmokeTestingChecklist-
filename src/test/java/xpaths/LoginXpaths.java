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
}
