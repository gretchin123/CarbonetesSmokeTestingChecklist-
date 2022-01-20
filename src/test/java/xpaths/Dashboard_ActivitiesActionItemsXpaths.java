package xpaths;

public class Dashboard_ActivitiesActionItemsXpaths {

    public String ActivitiesActionItemsElements;

    public String ActionableItemsLabel(){
        return this.ActivitiesActionItemsElements = "//h5[normalize-space()='Actionable Items']";
    }
    public String DateRangeThisMonthFilter(){
        return this.ActivitiesActionItemsElements = "//div[@class='v-list__tile__title'][normalize-space()='This Month']";
    }
    public String DateRangeThisWeekFilter(){
        return this.ActivitiesActionItemsElements = "//div[contains(text(),'This Week')]";
    }
    public String DateRangeTodayFilter(){
        return this.ActivitiesActionItemsElements = "//div[@class='v-list__tile__title'][normalize-space()='Today']";
    }
    public String DateRangeFilterDropdown(){
        return this.ActivitiesActionItemsElements = "//div[@class=\"v-input date-range-selection box-shadow-none v-text-field v-text-field--single-line v-text-field--solo v-text-field--enclosed v-select v-input--is-label-active v-input--is-dirty theme--light\"]";
    }
    public String PolicyResultThisMonth(){
        return this.ActivitiesActionItemsElements = "//small[@class='font-weight-bold rate text-success']";
    }
    public String PolicyResultThisWeek(){
        return this.ActivitiesActionItemsElements = "//div[@class=\"col-7\"]/div[1]/h5[1]/small[3]";
    }
    public String PolicyResultToday(){
        return this.ActivitiesActionItemsElements = "//small[@class='font-weight-bold rate text-success']";
    }
    public String ShowUser(){
        return this.ActivitiesActionItemsElements = ".v-icon.fas.fa-user.theme--light.grey--text";
    }
    public String ShowTeams(){
        return this.ActivitiesActionItemsElements = "//i[@class='v-icon fas fa-users theme--light grey--text']";
    }
    public String ShowCompany(){
        return this.ActivitiesActionItemsElements = "//div[@class=\"v-toolbar__items\"]/button[4]/div[1]/a[1]/i[1]";
    }
    public String GetActionableItem(){
        return this.ActivitiesActionItemsElements = "//tbody/tr[1]/td[1]/span[1]";
    }
    public String AnalyzeImage(){
        return this.ActivitiesActionItemsElements = "(//i[@class='fas fa-crosshairs'])[1]";
    }
    public String CompleteAnalyzeToaster(){
        return this.ActivitiesActionItemsElements = "//div[@class='jq-toast-wrap top-right']";
    }
    public String ShowResults(){
        return this.ActivitiesActionItemsElements = "(//i[@class='fas fa-check-circle'])[1]";
    }
    public String ImageOverviewLabel(){
        return this.ActivitiesActionItemsElements = "//h3[normalize-space()='Image Overview']";
    }
    public String EditJiraTicketIcon(){
        return this.ActivitiesActionItemsElements = "//div[@class='overflow']//div[1]//div[1]//span[1]//a[1]//i[1]";
    }
    public String UpdateJiraSummary(){
        return this.ActivitiesActionItemsElements = "//input[@aria-label='Jira Ticket Summary']";
    }
    public String SaveJiraUpdate(){
        return this.ActivitiesActionItemsElements = "//button[normalize-space()='Save']";
    }
    public String JiraUpdateSuccessMessageToaster(){
        return this.ActivitiesActionItemsElements = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']";
    }
    public String JiraCompany(){
        return this.ActivitiesActionItemsElements = "//span[normalize-space()='Company']";
    }
    public String JiraTicketRedirection(){
        return this.ActivitiesActionItemsElements = "//div[@class='overflow']//div[1]//div[1]//a[1]//h5[1]";
    }


}
