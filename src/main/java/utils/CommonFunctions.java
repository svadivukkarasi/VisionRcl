package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class CommonFunctions {
    public static WebDriver driver;

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

   public void closeBrowser() {
       driver.quit();
   }

    public static void waitForTime(Duration duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration.getSeconds()));
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitForElementToClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void type(WebElement element, String data) {
        element.sendKeys(data);

    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void selectOptionsByText(WebElement element, String data) {
        new Select(element).selectByVisibleText(data);
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public static void assertEquals(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    public static void  isElementDisplayed (WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public static void takeScreenShot(String filename) throws IOException {


        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destPath = new File("src/main/resources/"+filename).getAbsolutePath();
        File dest = new File(destPath);
        FileUtils.copyFile(source, dest);


    }


    public static void switchToWindow(){
        String windowHandle=driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
    }
    public static void executeJS(String script,WebElement element){
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript(script,element);

    }
    public static void clickElementJS(WebElement element){
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("argument[0].click();",element);

    }
    //Selenium can't scroll use JS
    public static void scrollToElement(WebElement element){
        executeJS("argument[0].scrollIntoView(true);",element);
    }
    public static void scroll(){
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(200,400);");

    }
    public static void mouseOver(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();

    }
    public static void rightClick(WebElement element){
        Actions actions=new Actions(driver);
        actions.contextClick(element).perform();
    }
    public static void doubleClick(WebElement element){
        Actions actions=new Actions(driver);
        actions.doubleClick(element).perform();
    }
    public static void dragAndDrop (WebElement source,WebElement target){
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target);
    }
    public static void applyKey(Keys key){
        Actions actions=new Actions(driver);
        actions.sendKeys(key).perform();
    }
    public static void compositeActions(WebElement element,String data){
        Actions actions=new Actions(driver);
       actions .moveToElement(element)
        .contextClick()
        .sendKeys(data)
        .click()
        .perform();
    }

}
