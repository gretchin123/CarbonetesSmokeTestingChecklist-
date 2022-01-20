package xpaths;

public class Dashboard_ComplianceGovernanceXpaths {

    public String ComplianceGovernanceElements;

    public String ComplianceGovernance(){
        return this.ComplianceGovernanceElements = "//h5[contains(text(),'Compliance')]";
    }
    public String PolicyBundleNameSort(){
        return this.ComplianceGovernanceElements = "//div[@class='card-body']/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/i[1]";
    }
    public String StatusSort(){
        return this.ComplianceGovernanceElements = "//div[@class='card-body']/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]/i[1]";
    }
    public String PolicyRulesSort(){
        return this.ComplianceGovernanceElements = "//div[@class='card-body']/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]/i[1]";
    }
    public String WhitelistCountSort(){
        return this.ComplianceGovernanceElements = "//div[@class='card-body']/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[4]/i[1]";
    }
    public String BlacklistCountSort(){
        return this.ComplianceGovernanceElements = "//div[@class='card-body']/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[5]/i[1]";
    }
    public String EvaluationsSort(){
        return this.ComplianceGovernanceElements = "//div[@class='card-body']/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[6]/i[1]";
    }
    public String Download(){
        return this.ComplianceGovernanceElements = "//button[contains(text(),'Download')]";
    }
    public String PolicyBundleName(){
        return this.ComplianceGovernanceElements = "//a[contains(text(),'Basic Bundle')]";
    }
    public String PolicyBundleLabel(){
        return this.ComplianceGovernanceElements = "//h3[contains(text(),'Policy Bundle')]";
    }
    public String GovernanceNoneFilter(){
        return this.ComplianceGovernanceElements = "//label[contains(text(),'None')]";
    }
    public String GovernanceUserFilter(){
        return this.ComplianceGovernanceElements = "//label[contains(text(),'User')]";
    }
    public String GovernancePolicyBundleFilter(){
        return this.ComplianceGovernanceElements = "//label[contains(text(),'Policy Bundle')]";
    }
    public String GovernancePolicyBundleNameFilterDropdown(){
        return this.ComplianceGovernanceElements = "//div[@class='v-select__slot']/div[1]/div[1]/i[1]";
    }
    public String GovernanceMonthSelectDropdown(){
        return this.ComplianceGovernanceElements = "//div[@class='col-sm-2']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/i[1]";
    }
    public String GovernanceSelectMonth(){
        return this.ComplianceGovernanceElements = "//div[@class='v-list__tile__title'][normalize-space()='February']";
    }
}
