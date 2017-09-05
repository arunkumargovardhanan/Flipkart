package tests;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import pageobjects.CartPage;
import pageobjects.LandingPage;
import pageobjects.ProductDescriptionPage;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by AGova2 on 9/4/2017.
 */
public class TestLandingPage extends Base
{
  private LandingPage landingPage;
  private ProductDescriptionPage productDescriptionPage;
  private CartPage cartPage;
  public Logger logger;
  @Before
  public void setUp() {
  landingPage  = new LandingPage(driver);
  }

  @Test
  public void addItemToCart() {
    landingPage.with("Nike shoes");
    assertTrue("Product lists are available",
    landingPage.searchGridwallPresent());
    if (landingPage.searchGridwallPresent()){
      landingPage.navigateToPdp();
    }
    productDescriptionPage = new ProductDescriptionPage(driver);
    String selectedSize = productDescriptionPage.selectShoeSize();
    if (productDescriptionPage.selectShoeSize()!=""){
      productDescriptionPage.addToCart();
    }

    cartPage = new CartPage(driver);
    System.out.println();cartPage.getShoeSize();
    assertTrue("Product Size on cart matches with Selected Size on PDP ",cartPage.getShoeSize().contains(selectedSize));

  }

  }
