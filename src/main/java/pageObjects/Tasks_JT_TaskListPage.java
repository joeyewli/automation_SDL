package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//*[@id="report-body"]/div/main/div/div/div/div/div/div[3]/div/div/div/div/div/div[1]/div[1]/div/div[2]/div/p/a/text()
public class Tasks_JT_TaskListPage extends TasksPage {
    @FindBy(xpath ="/html/body/div[6]/div[2]/div/div[1]/div[2]/div/ol/li[4]/a/span[1]")
    //@FindBy(xpath = "//*[contains{text(),'ADVANCE JOB SEARCH')]")
    private WebElement linkAdvanceJobSearch;

    //@FindBy(xpath ="/html/body/div[6]/div[1]/div/div[2]/div[1]/a/span")
    @FindBy(xpath = "/html/body/div[6]/div[1]/div/div[2]/div[1]/a/span")
    private WebElement profileIcon;

    @FindBy(xpath ="/html/body/div[6]/div[1]/div/div[2]/div[1]/ul/li[3]/a")
    private WebElement logout;

    private String url = "https://sdlsit.appiancloud.com/suite/tempo/tasks/l_BqtQ";
    public Tasks_JT_TaskListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialised() {
        return profileIcon.isDisplayed();
    }

    public void clickProfileIcon(){
        profileIcon.click();
    }

    public void clickLogout(){
        logout.click();
    }

    public String getUrl(){
        return url;
    }
}
