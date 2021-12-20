package xpaths;

public class DashboardTabsXpaths {

    public String DashboardTabsElements;

    public String DashboardPage(){
        return this.DashboardTabsElements = "//a[@class='dashboard-tab active']";
    }
    public String ActivitiesActionItemsTab(){
        return this.DashboardTabsElements = "//a[contains(text(),'Activities & Action Items')]";
    }
    public String SecurityRisksTab(){
        return this.DashboardTabsElements = "//a[normalize-space()='Security Risks']";
    }
    public String ComplianceGovernanceTab(){
        return this.DashboardTabsElements = "//a[normalize-space()='Compliance & Governance']";
    }
    public String AssetManagementTab(){
        return this.DashboardTabsElements = "//a[normalize-space()='Asset Management']";
    }

}
