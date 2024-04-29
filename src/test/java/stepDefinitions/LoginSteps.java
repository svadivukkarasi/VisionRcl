package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;
import utils.CommonFunctions;

import java.io.IOException;


public class LoginSteps extends CommonFunctions {
    LoginPage loginPage=new LoginPage(driver);

    @Given("User is on the homepage {string}")
    public void openHomePage(String url) {
CommonFunctions.navigateToUrl(url);

    }
    @When("the user enters username {string}")
    public void  entersUsername(String username)
    {loginPage.enterUserName(username);
    }
    @When("the user enters password {string}")
    public void entersPassword(String password) {
loginPage.enterPassword(password);
    }
    @When("the user clicks login button")
    public void clicksLoginButton() {
loginPage.clickButton();
    }
    @Then("the user should see the {string} page")
    public void userIsInProductsPage(String expectedPageHeading) {
        loginPage.landedProductPage();

    }
@Then ("the user should see the error message {string}")

public void inValidLogin(String string)throws IOException
{
        loginPage.verifyInvalidLogin();
}




}
