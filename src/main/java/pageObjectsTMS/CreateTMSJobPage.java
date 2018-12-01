package pageObjectsTMS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class CreateTMSJobPage extends AbstractTMSPage {
    private String url = "https://devtms.sdlproducts.com/interface/portal/default.asp";

    private WebElement iframe_content;
    @FindBy (id = "p1")
    private WebElement tab_JobDetails;
    @FindBy (id = "name")
    private WebElement txtbox_JobName;
    @FindBy (id = "description")
    private WebElement txtbox_JobDescription;
    @FindBy (id = "cfg")
    private WebElement droplist_Configuration;
    @FindBy (id = "pr")
    private WebElement droplist_Project;
    private WebElement datepicker_DueDate;

    @FindBy (id = "p2")
    private WebElement tab_Files;
//    @FindBy (className = "filepicker dropzone dz-clickable")
//    @FindBy (id = "src0")
    @FindBy (id = "dropzoneSrc")
//    @FindBy (className="dz-default dz-message")
    private WebElement chooseFile;

    @FindBy (id = "p3")
    private WebElement tab_Languages;
    private WebElement droplist_TranslateFrom;
    @FindBy (id = "tgtlang")
    private WebElement droplist_TranslateInto;
    private WebElement tab_JobCreatedSummary;

    private WebElement btn_Submit;

    public CreateTMSJobPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl(){
        return  url;
    }

    public void setTab_JobDetails(String name, String description, String configuration, String project ){
        txtbox_JobName.sendKeys("Test Job Name");
        txtbox_JobDescription.sendKeys("Test Job Description");
        setConfiguration(configuration);
    }

    public void setConfiguration(String configuration){
        Select config = new Select(droplist_Configuration);
        config.selectByVisibleText("H2_Post-translation Stages - Short 2");
    }

    public void setFiles() throws FindFailed {
        tab_Files.click();
        chooseFile.click();


        Pattern filename = new Pattern("src\\test\\Resources\\filename.PNG");
        Pattern openfile = new Pattern("src\\test\\Resources\\open.PNG");
        Screen screen = new Screen();
        screen.wait(filename);
        screen.type(filename,"C:\\Users\\joeye\\Documents\\job1.docx");
        System.out.println("clicking on:" + screen.find(openfile).text());
        screen.wait(openfile);
        screen.click(openfile);




        //chooseFile.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();",chooseFile);
//        driver.execute_script("arguments[0].click();",chooseFile);

        chooseFile.sendKeys("C:\\Users\\joeye\\Documents\\job1.docx");

    }
    public void switchToContentsFrame(){
        driver.switchTo().frame("content");
    }
}
