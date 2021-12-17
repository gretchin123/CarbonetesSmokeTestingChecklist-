package xpaths;

public class EnvironmentsXpaths {

    public String Environments;

    public String Policybundle() {
        return this.Environments = "//span[contains(text(),'Policy Bundle')]";
    }
    public String Environments() { return this.Environments = "//span[contains(text(),'Environments')]" ; }
    public String AddEnvironment() { return this.Environments = "//span[contains(text(),'Add Environment')]"; }
    public String NameEnvironment() { return this.Environments = "/html/body/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div[2]/div/div[1]/div[2]/form/div[2]/div[1]/div/div/div[1]/div/input"; }
    public String DescriptionEnvi() { return this.Environments = "/html/body/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div[2]/div/div[1]/div[2]/form/div[2]/div[2]/div/div/div[1]/div/input"; }
    public String SaveEnvironment() { return this.Environments = "//button[contains(text(),'Save')]"; }
    public String CancelEnvironment() { return this.Environments = "//a[contains(text(),'Cancel')]"; }

}
