package xpaths;

public class ForgotPasswordXpaths {

    public String ForgotPassword;

    public String ForgotBtn() { return this.ForgotPassword = "(//a[normalize-space()='Forgot password?'])[1]"; }
    public String EmailTextField() { return this.ForgotPassword = "(//input[@aria-label='Email'])[2]"; }
    public String ResetBtn() { return this.ForgotPassword = "//span[contains(text(),'Reset')]"; }

    //For Messages
    public String ErrorMessage() { return this.ForgotPassword = "//div[contains(text(),'Username/E-mail must be valid')]"; }
    public String SuccessMessage() { return this.ForgotPassword = "//body/div[7]/div[1]"; }

}
