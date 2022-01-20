package xpaths;

public class ContainerRegistryXpaths {

    public String ContainerRegistry;

    public String ContainerRegistry() { return this.ContainerRegistry = "//span[normalize-space()='Container Registries']" ;}
    public String AddRegistry() { return this.ContainerRegistry = "//button[contains(text(),'Add Registry')]" ;}
    public String SelectRegistry() { return this.ContainerRegistry = "//div[normalize-space()='IBM Cloud']" ;}
    public String ContainerURI() { return this.ContainerRegistry = "//input[@aria-label='URI']" ;}
    public String RegistryName() { return this.ContainerRegistry = "//input[@aria-label='Registry Name']" ;}
    public String AccountID() { return this.ContainerRegistry = "//input[@aria-label='Account Id']" ;}
    public String APIKey() { return this.ContainerRegistry = "//input[@aria-label='API Key']" ;}
    public String SaveRegistry() { return this.ContainerRegistry = "//button[contains(text(),'Save')]" ;}
    public String CancelRegistry() { return this.ContainerRegistry = "//button[contains(text(),'Cancel')]" ;}

    //For Message
    public String InvalidMessage() { return this.ContainerRegistry = "//div[@class='v-messages__message'][normalize-space()='Failed validation. Valid registry uri includes icr.io, us.icr.io, etc.']" ;}
    public String DuplicateMessage() { return this.ContainerRegistry = "//div[@class='container']//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]" ;}
    public String SuccessMessage() { return this.ContainerRegistry = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']" ;}

}
