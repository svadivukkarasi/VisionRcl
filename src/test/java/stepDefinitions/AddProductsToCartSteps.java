package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddProductsPage;
import utils.CommonFunctions;

public class AddProductsToCartSteps extends CommonFunctions {
    AddProductsPage addProductsPage =new AddProductsPage(driver);
   @Given ("user is in the Products page")
    public void landedInProducts(){
addProductsPage. verifyProductsPage();
   }
       @When("the user clicks on a {string}")
       public void userClicksProduct(String productName) {
addProductsPage.clicksTheProduct(productName);
       }
  @Then("the user clicks add to cart button")
       public void userClicksBtn(){
       addProductsPage.clickAddToCartBtn();
       }
       @Then("the product is added to cart")
       public void userAddedProduct () {
addProductsPage.addToCart();
       }
       @Then("the cart is updated")
       public void cartIsUpdated() {
addProductsPage.verifyUpdatedCart();
       }


    @When("the user clicks on  {string}")
    public void theUserClicksOn(String product1) {
       addProductsPage.clicksTheProduct(product1);
    }
}

