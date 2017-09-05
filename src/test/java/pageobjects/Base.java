package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static tests.config.baseUrl;

/**
 * Created by AGova2 on 9/4/2017.
 */
public class Base
{
  private WebDriver driver;
  public Base(WebDriver driver) {
  this.driver = driver;
  }
  public void visit(String url) {
    if (url.contains("http")) {
      driver.get(url);
      } else {
      driver.get(baseUrl + url);
      }
  }
  public WebElement find(By locator) {
  return driver.findElement(locator);
  }
  public void click(By locator) {
  find(locator).click();
  }
  public void type(String inputText, By locator) {
  find(locator).sendKeys(inputText);
  }
  public Boolean isDisplayed(By locator) {
    try {
    return find(locator).isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException exception) {
    return false;
    }
  }

}
