package xpaths;

public class PolicyRuleXpaths {

    public String PolicyRule;

    public String PolicyBundle() {
        return this.PolicyRule = "//span[contains(text(),'Policy Bundle')]";
    }
    public String EditBTN() { return this.PolicyRule = "//i[@class='fas fa-edit']" ;}
    public String AddPolicyRule() { return this.PolicyRule = "//span[normalize-space()='Add New Policy']" ;}
    public String PolicyRuleName() { return this.PolicyRule = "//input[@aria-label='Name']" ;}
    public String PolicyRuleDescription() { return this.PolicyRule = "//textarea[@aria-label='Description']" ;}
    public String SavePolicyRule() { return this.PolicyRule = "(//button[normalize-space()='Save'])[1]" ;}
    public String CancelPolicyRule() { return this.PolicyRule = "(//button[normalize-space()='Cancel'])[1]" ;}

    //For Messages
    public String ErrorMessage() { return this.PolicyRule = "//div[contains(text(),'Policy Name is required')]" ;}
    public String SuccessMessage() { return this.PolicyRule = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']" ;}
    public String DuplicateMessage() { return this.PolicyRule = "//h2[@class='jq-toast-heading']" ;}

    //PolicyRule1
    public String Scroll() { return this.PolicyRule = ""}

}
