package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    private static final By CART_ICON = By.cssSelector(".shopping_cart_link");
    private static final By CART_ITEM = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.findElement(CART_ICON).click();
    }

    public void validateNumOfAddedProducts(int amount) {
        Assert.assertEquals(driver.findElements(CART_ITEM).size(), amount, "Amount of elements is wrong");
    }
}
