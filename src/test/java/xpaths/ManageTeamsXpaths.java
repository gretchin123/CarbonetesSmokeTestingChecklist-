package xpaths;

public class ManageTeamsXpaths {

    public String ManageTeams;

    public String Policybundle() {
        return this.ManageTeams = "//span[contains(text(),'Policy Bundle')]";
    }
    public String Settings() { return this.ManageTeams = "//span[contains(text(),'Settings')]"; }
    public String ManageTeams() { return this.ManageTeams = "//span[normalize-space()='Manage Teams']" ;}
    public String AddTeam() { return this.ManageTeams = "//span[contains(text(),'Add New Team')]" ;}
    public String TeamName() { return this.ManageTeams = "//input[@aria-label='Team Name']" ;}
    public String Description() { return this.ManageTeams = "//textarea[@aria-label='Description']" ;}
    public String TeamTag() { return this.ManageTeams = "//input[@aria-label='Team Tag']" ;}
    public String SearchName() { return this.ManageTeams = "//input[@aria-label='Search name']" ;}


}
