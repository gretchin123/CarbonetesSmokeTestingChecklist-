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
    
    //Environments1
    public String SearchText() { return this.Environments = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"; }
    public String SearchBtn() { return this.Environments = "//i[contains(text(),'search')]"; }
    public String DeleteBtn() { return this.Environments = "//tbody/tr[1]/td[3]/a[2]/i[1]"; }
    public String YesBtn() { return this.Environments = "//button[contains(text(),'Yes')]"; }


    //Environments1

    public String SearchText() { return this.Environments = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"; }
    public String SearchBtn() { return this.Environments = "//i[contains(text(),'search')]"; }
    public String DeleteBtn() { return this.Environments = "//tbody/tr[1]/td[3]/a[2]/i[1]"; }
    public String YesBtn() { return this.Environments = "//button[contains(text(),'Yes')]"; }


}
