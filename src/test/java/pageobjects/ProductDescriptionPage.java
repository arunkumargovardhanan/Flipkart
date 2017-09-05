package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by AGova2 on 9/4/2017.
 */
public class ProductDescriptionPage extends Base
{
  By sizeSelector = By.cssSelector("#swatch-1-size > a:nth-child(1)");
  By addToCart = By.cssSelector("._2MWPVK");

  public ProductDescriptionPage(WebDriver driver)
  {
    super(driver);
    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    ((JavascriptExecutor) driver).executeScript("return window.stop");
    assertTrue("The Search Field is available for Product Search", isDisplayed(addToCart));
  }

  public String selectShoeSize(){
        String size ="";
        if (isDisplayed(sizeSelector)){
          click(sizeSelector);
          try {
                      Thread.sleep(5000);
                      } catch (InterruptedException e) {
                      e.printStackTrace();
                      }
          size = find(sizeSelector).getText();
      }
        return size;
    }

    public void addToCart(){
      click(addToCart);
      try {
                          Thread.sleep(5000);
                          } catch (InterruptedException e) {
                          e.printStackTrace();
                          }
    }
}
