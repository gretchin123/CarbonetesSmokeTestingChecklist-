package xpaths;

public class DeduplicationSettingsXpaths {

    public String DeduplicationSettings;

    public String Policybundle() {
        return this.DeduplicationSettings = "//span[contains(text(),'Policy Bundle')]";
    }
    public String Settings() { return this.DeduplicationSettings = "//span[contains(text(),'Settings')]"; }
    public String Engine() { return this.DeduplicationSettings = "//label[contains(text(),'Engine T')]" ;}
    public String DropDown() { return this.DeduplicationSettings = "//div[@class='v-select__selections']" ;}
    public String ImageToTest() { return this.DeduplicationSettings = "//div[contains(text(),'jaegertracing/allinone:1.14.0')]" ;}
    public String SaveResult() { return this.DeduplicationSettings = "//button[normalize-space()='Save and show result']" ;}
    public String YesBTN() { return this.DeduplicationSettings = "//button[normalize-space()='Yes']" ;}

}
