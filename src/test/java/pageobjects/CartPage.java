package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by AGova2 on 9/4/2017.
 */
public class CartPage extends Base
{
  By sizeDescription = By.cssSelector(".v7-Wbf");
  By placeOrder = By.cssSelector("button._2AkmmA:nth-child(2) > span:nth-child(1)");

  public CartPage(WebDriver driver)
    {
      super(driver);
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      ((JavascriptExecutor) driver).executeScript("return window.stop");
      assertTrue("The Search Field is available for Product Search", isDisplayed(placeOrder));
    }

  public String getShoeSize(){
         String size ="";
         if (isDisplayed(sizeDescription)){
           size = find(sizeDescription).getText();
       }
         return size;
     }
}
