package xpaths;

public class PublicImageXpaths {

    public String PulicImage;

    public String ImageTextField() { return this.PulicImage = "//input[@aria-label='Image']"; }
    public String AnalyzeBtn() { return this.PulicImage = "//button[contains(text(),'Analyze')]"; }

    //For Messages
    public String SuccessMessage() { return this.PulicImage = "//form[@class='v-form analysis-result-container']"; }
    public String ErrorMessage() { return this.PulicImage = " //p[@class='text-danger']"; }

}
