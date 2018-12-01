package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends AbstractPage {
    @FindBy(id = "un")
    private WebElement txtbox_username;

    @FindBy(id = "pw")
    private WebElement txtbox_password;

    @FindBy(xpath = "//*[contains(@type,'submit')]")
    private WebElement btn_login;

    private String url = "https://sdlsit.appiancloud.com/suite/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void setUsername(String username) {
        txtbox_username.sendKeys(username);
    }

    public void setPassword(String password) {
        txtbox_password.sendKeys(password);
    }

    public Tasks_JT_TaskListPage clickLogin(){
        btn_login.click();
        return new Tasks_JT_TaskListPage(driver);
    }

    public boolean isInitialised() {
        return txtbox_password.isDisplayed();
    }
    public String getUrl(){
        return url;
    }


}
