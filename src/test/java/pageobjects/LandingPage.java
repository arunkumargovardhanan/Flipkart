package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by AGova2 on 9/4/2017.
 */
public class LandingPage extends Base
{
  By loginFormLocator = By.id("login");
  By usernameLocator = By.id("username");
  By passwordLocator = By.id("password");
  By submitButton = By.cssSelector("button");
  By successMessageLocator = By.cssSelector(".flash.success");
  By failureMessageLocator = By.cssSelector(".flash.error");
  By searchInput = By.name("q");
  By searchSubmit = By.cssSelector(".vh79eN");
  By searchList = By.cssSelector("._2SxMvQ");
  By firstProductList = By.cssSelector("div._3yI_5w:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)");


  public LandingPage(WebDriver driver) {
  super(driver);
  /*visit("/login");
  assertTrue("The login form is not present",
  isDisplayed(loginFormLocator));*/
  visit("");
    driver.manage().window().maximize();
    try {
      Thread.sleep(5000);
      } catch (InterruptedException e) {
      e.printStackTrace();
      }
    ((JavascriptExecutor) driver).executeScript("return window.stop");
  assertTrue("The Search Field is available for Product Search", isDisplayed(searchInput));
  }
  public void with(String searchKey) {
  type(searchKey, searchInput);
  click(searchSubmit);
  try {
  Thread.sleep(6000);
  } catch (InterruptedException e) {
  e.printStackTrace();
  }
  }
  public Boolean successMessagePresent() {
  return isDisplayed(successMessageLocator);
  }
  public Boolean failureMessagePresent() {
  return isDisplayed(failureMessageLocator);
  }
  public Boolean searchGridwallPresent() {
    return isDisplayed(searchList);
    }
    public void navigateToPdp(){
    click(firstProductList);
      try {
            Thread.sleep(5000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
    }


}
