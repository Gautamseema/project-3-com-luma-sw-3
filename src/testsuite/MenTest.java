package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        WebElement Men = driver.findElement(By.id("ui-id-5"));
       WebElement Bottoms = driver.findElement(By.id("ui-id-18"));
        WebElement Pants = driver.findElement(By.id("ui-id-23"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Men).moveToElement(Bottoms).moveToElement(Pants).click().build().perform();

        WebElement dropDown = driver.findElement(By.id("sorter") );
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");
    // click on item
     clickOnElement(By.xpath("//img[@alt='Cronus Yoga Pant ']") );
    //click on item size
      clickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']") );
     // click on item by color
        clickOnElement(By.id("option-label-color-93-item-49") );
    // click on add to cart
        clickOnElement(By.id("product-addtocart-button") );

    // Find the actual text element and get the text from element
       String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
       String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")) ;
       Assert.assertEquals(expectedText , actualText );
    // click on shopping cart link
        clickOnElement(By.xpath( "//body[@class='page-product-configurable catalog-product-view product-cronus-yoga-pant page-layout-1column']"));

        String expectedText1 = "Cronus Yoga Pant";
        verifyTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");
      //  Verify the product size ‘32’
        verifyTextFromElement(By.xpath("//dd[contains(text(),'32 ')]"),"32");
      // Verify the product colour ‘Black’
        verifyTextFromElement(By.xpath("//dd[contains(text(),'Black ')]"),"Black");



    }
   @After
   public void tearDown() {
        closeBrowser();
    }

}