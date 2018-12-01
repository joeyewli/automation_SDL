package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.Tasks_JT_TaskListPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends AbstractTest {
    LoginPage loginpage;
    Tasks_JT_TaskListPage jt_taskListPage;
    private WebDriver driver = getDriver();
    @After("@login")
    public void clearUp(){
        jt_taskListPage.clickProfileIcon();
        jt_taskListPage.clickLogout();
    }

    @Given("^I am on SDL login page$")
    public void i_am_on_SDL_login_page() throws Exception {
//        System.setProperty("webdriver.gecko.driver", "D:\\Desktop\\automation_SDL\\geckodriver.exe");
//        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
//        driver = new FirefoxDriver();
        loginpage = new LoginPage(driver);
        loginpage.navigateToHomepage();
        assertTrue(loginpage.isInitialised());
    }

    @When("^I enter my username - (.*) in SDL$")
    public void i_enter_my_username(String username)   {
        loginpage.setUsername(username);
    }

    @When("^I enter my password - (.*) in SDL$")
    public void i_enter_my_password(String password)   {
        loginpage.setPassword(password);
    }

    @When("^I click login in SDL$")
    public void i_click_login()  {
        jt_taskListPage = loginpage.clickLogin();
        jt_taskListPage.isInitialised();
    }

    @Then("^I will enter SDL homepage$")
    public void i_will_enter_SDL_homepage()   {
        jt_taskListPage.isInitialised();
        assertEquals(jt_taskListPage.getUrl(),driver.getCurrentUrl());
    }

    @Given("^I am logged in as a PM$")
    public void i_am_logged_in_as_a_PM() throws Exception {
        System.out.println("TESSSSST");
//    loginpage.navigateToHomepage()
//            .setUsername("JoeLi.PM@sdl.com")
//            .setPassword("Appian2018")
//            .clickLogin();
//
    i_am_on_SDL_login_page();
    loginpage.setUsername("JoeLi.PM@sdl.com");
    loginpage.setPassword("Appian2018");
    i_click_login();

    }

    @Then("^I return to the login page$")
    public void i_return_to_the_login_page() throws Exception {
        assertEquals(loginpage.getUrl(),driver.getCurrentUrl());
    }

}
