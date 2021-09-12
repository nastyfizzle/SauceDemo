package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        actions = new Actions(driver);
    }

    public void waitForNumberOfElementsToAppear(By locator, int numberOfElements){
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, numberOfElements));
        } catch (TimeoutException ex){
            ex.printStackTrace();
            Assert.fail("Num of elements doesn't correspond to expected:" + numberOfElements);
        }
    }

    public void waitForCartBadgeAmountToAppear(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex){
            ex.printStackTrace();
            Assert.fail("Not such element found");
        }
    }
}
