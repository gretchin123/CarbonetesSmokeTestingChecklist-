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


}
