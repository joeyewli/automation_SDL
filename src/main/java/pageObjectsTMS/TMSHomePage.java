package pageObjectsTMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TMSHomePage extends AbstractTMSPage {
    @FindBy(xpath = "/html/body/div[7]/div[2]/div/ul/li/ul")
    private WebElement droplist;
    @FindBy(xpath = "//*[contains(@id,'create_job')]")
    private WebElement btnCreateJob;

    public TMSHomePage(WebDriver driver) {
        super(driver);
    }

    public CreateTMSJobPage clickCreateJob() {

//        Select list = new Select(droplist);
//        list.selectByVisibleText("Create Job");
        driver.navigate().to("https://devtms.sdlproducts.com/interface/portal/default.asp");
        return new CreateTMSJobPage(driver);
    }


}
