package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {
    //*************************** Action Methods ***************************************//
    //This method will use to hover mouse on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //*************************** Select Class Methods ***************************************//
    // This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {

    }

    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    //This method will get text from element

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }
    public void verifyTextFromElement(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText,actual);

    }
}