package xpaths;

public class ManageLicensesXpaths {

    public String ManageLicense;

    public String Policybundle() {
        return this.ManageLicense = "//span[contains(text(),'Policy Bundle')]";
    }
    public String Settings() { return this.ManageLicense = "//span[contains(text(),'Settings')]"; }
    public String ManageLicenses() { return this.ManageLicense = "//span[normalize-space()='Manage Licenses']" ;}
    public String AddLicense() { return this.ManageLicense = "//button[@class=' btn btn-info waves-effect waves-light']" ;}
    public String LicenseID() { return this.ManageLicense = "//input[@aria-label='License Id']" ;}
    public String LicenseName() { return this.ManageLicense = "//input[@aria-label='License Name']" ;}
    public String LicenseLink() { return this.ManageLicense = "//input[@placeholder='http://opensource.org/licenses/mit-license,http://opensource.org/license']" ;}
    public String SaveLicense() { return this.ManageLicense = "//button[@title='Save']" ;}
    public String CancelLicense() { return this.ManageLicense = "//a[@title='Cancel']" ;}

    //For messages
    public String EmptyMessage() { return this.ManageLicense = "//div[@class='v-messages__message']" ;}
    public String InvalidMessage() { return this.ManageLicense = "//div[@class='v-messages__message message-transition-enter-to']" ;}

}
