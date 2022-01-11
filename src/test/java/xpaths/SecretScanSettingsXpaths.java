package xpaths;

public class SecretScanSettingsXpaths {

    public String SecretScanSettings;

    public String Policybundle() {
        return this.SecretScanSettings = "//span[contains(text(),'Policy Bundle')]";
    }
    public String Settings() { return this.SecretScanSettings = "//span[contains(text(),'Settings')]"; }
    public String SecretScan() { return this.SecretScanSettings = "//a[@href='#secretScan']" ;}
    public String AddContextRegex() { return this.SecretScanSettings = "//span[normalize-space()='Add Content Regex Name']" ;}
    public String ContentRegex() { return this.SecretScanSettings = "//input[@aria-label='Content Regex Name']" ;}
    public String SaveRegex() { return this.SecretScanSettings = "//button[@title='Save']" ;}
    public String SaveConfig() { return this.SecretScanSettings = "//span[normalize-space()='Save Config']" ;}
    public String TobeUpdated() { return this.SecretScanSettings = "//td[normalize-space()='PRIV_KEY']" ;}
    public String Scroll() { return this.SecretScanSettings = "//span[contains(text(),'Add Content Regex Name')]" ;}
    public String EditNameBtn() { return this.SecretScanSettings = "(//i[@class='fas fa-edit'])[6]" ;}
    public String CancelName() {return this.SecretScanSettings = "//a[@title='Cancel']" ;}
    public String TobeDelete() { return this.SecretScanSettings = "//td[normalize-space()='PRIVATE_KEY']" ;}
    public String DeleteRegex() { return this.SecretScanSettings = "(//i[@class='fas fa-trash'])[7]" ;}
    public String Yesbtn() { return this.SecretScanSettings = "//button[normalize-space()='Yes']" ;}

    //For Messages
    public String ValidMessage() { return this.SecretScanSettings = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']" ;}
    public String DuplicateMessage() { return this.SecretScanSettings = "//div[@class='jq-toast-single jq-has-icon jq-icon-warning']" ;}

}
