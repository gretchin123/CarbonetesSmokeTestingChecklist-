package xpaths;

public class PolicyBundleXpaths {

    public String PolicyBundle;

    public String PolicyBundle() {
        return this.PolicyBundle = "//span[contains(text(),'Policy Bundle')]";
    }
    public String CreateBundle() { return this.PolicyBundle = "//span[normalize-space()='Create New Bundle']"; }
    public String PolicyName() { return this.PolicyBundle = "//input[@aria-label='Policy Bundle Name']"; }
    public String PolicyDesc() { return this.PolicyBundle = "//textarea[@aria-label='Description']"; }
    public String SavePolicy() { return this.PolicyBundle = "//button[contains(text(),'Save')]"; }
    public String CancelPolicy() { return this.PolicyBundle = "//button[contains(text(),'Cancel')]"; }
    public String ReturnPolicy() { return this.PolicyBundle = "//a[normalize-space()='Policy Bundles']";}

    //For Messages
    public String ErrorMessage() { return this.PolicyBundle = "//div[contains(text(),'Policy Bundle Name is required')]"; }
    public String DuplicateMessage() { return this.PolicyBundle = "//div[contains(text(),'Policy bundle name already exists.')]"; }
    public String SuccessMessage() { return this.PolicyBundle = "//span[@class='hidden-xs-down'][contains(text(),'Policy')]"; }

    //PolicyBundle1

    public String Search() { return this.PolicyBundle = "//input[@aria-label='Search']"; }
    public String Searchbtn() { return this.PolicyBundle = "//i[normalize-space()='search']" ;}
    public String Edit() { return this.PolicyBundle = "//i[@class='fas fa-edit']" ;}
    public String BundleName() { return this.PolicyBundle = "//input[@placeholder='Bundle Name']" ;}
    public String EditBundle() { return this.PolicyBundle = "//form[@class='v-form']//button[1]" ;}
    public String ClonedBundle() { return this.PolicyBundle = "(//i[@class='fas fa-clone'])[1]" ;}
    public String CloneName() { return this.PolicyBundle = "//input[@aria-label='Policy Bundle Name']" ;}
    public String SaveClone() { return this.PolicyBundle = "//button[@class='btn btn-info']" ;}
    public String DeleteBtn() { return this.PolicyBundle = "//i[@class='fas fa-trash']" ;}
    public String DeleteClone() { return this.PolicyBundle = "//button[normalize-space()='Yes']" ;}

    //PolicyBundle1 Messages
    public String UpdatedMessage() { return this.PolicyBundle = "//body/div[7]/div[1]" ;}
    public String ClonedMessage() { return this.PolicyBundle = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']" ;}
    public String DeleteMessage() { return this.PolicyBundle = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']" ;}


}
