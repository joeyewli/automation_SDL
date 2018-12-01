package stepDefinitionsTMS;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import pageObjectsTMS.CreateTMSJobPage;
import pageObjectsTMS.LoginTMSPage;
import pageObjectsTMS.TMSHomePage;
import stepDefinitions.AbstractTest;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class LoginTestTMS extends AbstractTest {
    LoginTMSPage loginpage;
    TMSHomePage homePage;
    CreateTMSJobPage createJobPage;
    private WebDriver driver = getDriver();

    @Given("^I am on dev TMS login page$")
    public void i_am_on_dev_TMS_login_page()  {
        loginpage = new LoginTMSPage(driver);
        loginpage.navigateToHomepage();
        assertTrue(loginpage.isInitialised());
    }

    @When("^I enter my username - (.*) in TMS$")
    public void i_enter_my_username(String username)   {
        loginpage.setUsername(username);
    }

    @When("^I enter my password - (.*) in TMS$")
    public void i_enter_my_password(String password)   {
        loginpage.setPassword(password);
    }

    @When("^I click login in TMS$")
    public void i_click_login()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage = loginpage.clickLogin();
//        jt_taskListPage = loginpage.clickLogin();
//        jt_taskListPage.isInitialised();
    }

    @Given("^I am logged in as PJM authorise in TMS$")
    public void i_am_logged_in_as_PJM_authorise_in_TMS()   {
        i_am_on_dev_TMS_login_page();
        i_enter_my_username("stewilson@sdl.com");
        i_enter_my_password("P@ssw0rd123");
        i_click_login();

    }

    @When("^I select Create Job$")
    public void i_select_Create_Job()   {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       createJobPage =  homePage.clickCreateJob();
        createJobPage.switchToContentsFrame();
       // showAllTags();
        createJobPage.setTab_JobDetails("a","b","c","d");

        try {
            createJobPage.setFiles();
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void showAllTags(){
        List<WebElement> eee = driver.findElements(By.xpath("//*"));
        for (WebElement d: eee){
            System.out.println(d.getText());
        }

    }
}
