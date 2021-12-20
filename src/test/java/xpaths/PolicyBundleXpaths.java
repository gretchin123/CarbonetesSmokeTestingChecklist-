package xpaths;

public class PolicyBundleXpaths {

    public String PolicyBundle;

    public String PolicyBundle() {
        return this.PolicyBundle = "//span[contains(text(),'Policy Bundle')]";
    }
    public String CreateBundle() { return this.PolicyBundle = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/ul[1]/li[2]/a[1]/span[2]"; }
    public String PolicyName() { return this.PolicyBundle = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"; }
    public String PolicyDesc() { return this.PolicyBundle = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[1]"; }
    public String SavePolicy() { return this.PolicyBundle = "//button[contains(text(),'Save')]"; }
    public String CancelPolicy() { return this.PolicyBundle = "//button[contains(text(),'Cancel')]"; }

    //For Messages
    public String ErrorMessage() { return this.PolicyBundle = "//div[contains(text(),'Policy Bundle Name is required')]"; }

}
