package xpaths;

public class ForgotPasswordXpaths {

    public String ForgotPassword;

    public String ForgotBtn() { return this.ForgotPassword = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[3]/div[1]/a[1]"; }
    public String EmailTextField() { return this.ForgotPassword = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[3]/div[3]/form[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]"; }
    public String ResetBtn() { return this.ForgotPassword = "//span[contains(text(),'Reset')]"; }

}
