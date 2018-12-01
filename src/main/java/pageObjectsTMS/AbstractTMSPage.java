package pageObjectsTMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;

public class AbstractTMSPage {

    protected static WebDriver driver;

    public AbstractTMSPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage navigateToHomepage(){
        driver.navigate().to("https://devtms.sdlproducts.com/login/");
        return new LoginPage(driver);
    }

}
