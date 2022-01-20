package xpaths;

public class Dashboard_SecurityRisksXpaths {

    public String SecurityRisksElements;

    public String SecurityRisksLabel(){
        return this.SecurityRisksElements = "//h5[normalize-space()='Threats by Type']";
    }
    public String DateRangeThisMonthFilter(){
        return this.SecurityRisksElements = "//div[@class='v-list__tile__title'][normalize-space()='This Month']";
    }
    public String DateRangeThisWeekFilter(){
        return this.SecurityRisksElements = "//div[contains(text(),'This Week')]";
    }
    public String DateRangeTodayFilter(){
        return this.SecurityRisksElements = "//div[@class='v-list__tile__title'][normalize-space()='Today']";
    }
    public String DateRangeFilterDropdown(){
        return this.SecurityRisksElements = "//div[@class=\"v-input date-range-selection box-shadow-none v-text-field v-text-field--single-line v-text-field--solo v-text-field--enclosed v-select v-input--is-label-active v-input--is-dirty theme--light\"]";
    }
    public String VulnerabilitiesCriticalResult(){
        return this.SecurityRisksElements = "//div[@class='card-body']/div[1]/h5[1]";
    }
    public String VulnerbilitiesHighResult(){
        return this.SecurityRisksElements = "//div[@class='card-body']/div[2]/div[@class='mt-3 mb-3']/h5[1]";
    }
    public String VulnerabilitiesMediumResult(){
        return this.SecurityRisksElements = "//div[@class='card-body']/div[3]/div[@class='mt-3 mb-3']/h5[1]";
    }
    public String ShowUser(){
        return this.SecurityRisksElements = ".v-icon.fas.fa-user.theme--light.grey--text";
    }
    public String ShowTeams(){
        return this.SecurityRisksElements = "//div[@class='v-toolbar__items']/button[3]/div[1]/a[1]/i[1]";
    }
    public String ShowCompany(){
        return this.SecurityRisksElements = "//div[@class=\"v-toolbar__items\"]/button[4]/div[1]/a[1]/i[1]";
    }
    public String SecurityRisksUsersLabel(){
        return this.SecurityRisksElements = "//div[@class='col-sm-6 card-title']";
    }
}
