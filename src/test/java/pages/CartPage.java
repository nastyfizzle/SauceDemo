package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    public String productInTheCartButtonLocator = "//*[contains(text(), '%s')]/ancestor::*[@class='cart_item']//button";
    public static final By CONTINUE_SHOPPING = By.id("continue-shopping");
    public static final By CHECKOUT = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public void openByClickingOnCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public int getAmountOfProducts() {
        return driver.findElements(CART_ITEM).size();
    }

    public void removeItemFromCart(String productName) {
        driver.findElement(By.xpath(String.format(productInTheCartButtonLocator, productName))).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }
}
