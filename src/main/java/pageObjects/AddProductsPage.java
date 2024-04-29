package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.List;

public class AddProductsPage extends CommonFunctions

{
    public AddProductsPage(WebDriver driver)
{
    PageFactory.initElements(driver,this);
}
    @FindBy(className ="title")
    public WebElement productsPageHeading;

    @FindBy(className ="inventory_item_name")
    public List<WebElement> productNames;

   @FindBy(xpath ="//div[text()='Sauce Labs Backpack']")
    public WebElement productName;
   @FindBy(id ="add-to-cart-sauce-labs-backpack")
   public WebElement addToCartBtn;
   @FindBy(className ="shopping_cart_link")
   public WebElement productAdded;
   @FindBy(className="shopping_cart_badge")
   public WebElement updatedCart;

   public void verifyProductsPage()
   {
       CommonFunctions.isElementDisplayed(productsPageHeading);
   }



public void clicksTheProduct(String product1){
       CommonFunctions.clickElement(productName);
}
public void clickAddToCartBtn(){
       CommonFunctions.clickElement(addToCartBtn);
}
public void addToCart(){
       CommonFunctions.isElementDisplayed(productAdded);
}
public void verifyUpdatedCart(){
       CommonFunctions.isElementDisplayed(updatedCart);
}
}
