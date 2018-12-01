package pageObjectsTMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.Tasks_JT_TaskListPage;

public class LoginTMSPage extends  AbstractTMSPage {
    @FindBy(id = "username")
    private WebElement txtbox_username;

    @FindBy(id = "password")
    private WebElement txtbox_password;

    @FindBy(id = "loginButton")
    private WebElement btn_login;

    private String url = "https://sdlsit.appiancloud.com/suite/";

    public LoginTMSPage(WebDriver driver) {
        super(driver);
    }
    public void setUsername(String username) {
        txtbox_username.sendKeys(username);
    }

    public void setPassword(String password) {
        txtbox_password.sendKeys(password);
    }

    public TMSHomePage clickLogin(){

        btn_login.click();
        return new TMSHomePage(driver);
    }

    public boolean isInitialised() {
        return txtbox_password.isDisplayed();
    }
    public String getUrl(){
        return url;
    }


}

