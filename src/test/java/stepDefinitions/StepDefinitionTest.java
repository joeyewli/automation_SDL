package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.Tasks_JT_TaskListPage;

public class StepDefinitionTest extends AbstractTest {
    LoginPage loginpage;
    Tasks_JT_TaskListPage jt_taskListPage;
    private WebDriver driver = getDriver();
    @Before
    public void setUp(){
        jt_taskListPage = new Tasks_JT_TaskListPage(driver);
    }

    @When("^I logout$")
    public void i_logout() throws Exception {
        jt_taskListPage.clickProfileIcon();
        jt_taskListPage.clickLogout();
    }

}
