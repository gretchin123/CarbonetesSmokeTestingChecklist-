package xpaths;

public class EnvironmentsXpaths {

    public String Environments;

    public String Policybundle() {
        return this.Environments = "//span[contains(text(),'Policy Bundle')]";
    }
    public String Environments() { return this.Environments = "//span[contains(text(),'Environments')]" ; }
    public String AddEnvironment() { return this.Environments = "//span[contains(text(),'Add Environment')]"; }
    public String NameEnvironment() { return this.Environments = "//input[@placeholder='Ex. Local Development']"; }
    public String DescriptionEnvi() { return this.Environments = "//input[@aria-label='Description']"; }
    public String SaveEnvironment() { return this.Environments = "//button[contains(text(),'Save')]"; }
    public String CancelEnvironment() { return this.Environments = "//a[contains(text(),'Cancel')]"; }

    //Environments1

    public String SearchText() { return this.Environments = "//input[@aria-label='Search']"; }
    public String SearchBtn() { return this.Environments = "//i[contains(text(),'search')]"; }
    public String DeleteBtn() { return this.Environments = "(//i[@class='fas fa-trash'])[1]"; }
    public String YesBtn() { return this.Environments = "//button[contains(text(),'Yes')]"; }


}
