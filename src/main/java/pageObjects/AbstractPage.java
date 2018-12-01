package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected static WebDriver driver;
    //private String url = "https://sdlsit.appiancloud.com/suite/";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage navigateToHomepage(){
            driver.navigate().to("https://sdlsit.appiancloud.com/suite/");
            return new LoginPage(driver);
    }

//    public String getUrl(){
//        return url;
//    }
}
