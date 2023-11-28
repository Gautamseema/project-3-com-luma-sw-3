package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.time.Duration;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter(){
    // Women------> Tops and click on jacket
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
         select.selectByVisibleText("Product Name");
    // Verify the product name display in alphabetical order
        List<WebElement> element1 = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        String expectedText = "12 Items";
        String actualText = driver.findElement(By.xpath("(//div[@class='toolbar toolbar-products']//p[@id='toolbar-amount'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheSortByPriceFilter(){
    // Women------> Tops---->jacket and click
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price") ;
        //Verify the products price display in Low to High
        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < List2.size(); i++) {
            System.out.println(List2.get(i).getText());
            String exp = List2.get(i).getText();
            String actual = List2.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High  ", exp, actual);
}


    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
