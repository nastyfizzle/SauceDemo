package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.cssSelector(".title");
    private String productButtonLocator = "//*[text() = '%s']/ancestor::*[@class = 'inventory_item']//button";
    private static final By DROPDOWN = By.xpath("//select[@class='product_sort_container']");
    private static final String PRODUCT_TITLE = ".inventory_item_name";

    private static final String ADD_TO_CART_CSS = ".btn_inventory";

    private static final By CART_BADGE = By.xpath("//*[contains(@class, 'shopping_cart_badge')]");



    public ProductsPage(WebDriver driver) { //call constructor of parent class
        super(driver);
    }

    public String getHeader() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(productButtonLocator, productName))).click();
    }

    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(productButtonLocator, productName))).click();
    }

//    public String getTextOfButton(String buttonName) {
//        return driver.findElement(By.xpath(String.format(productButtonLocator, buttonName))).getText();
//    }

    //todo: cannot be performed, the reason in console is locator
//    public void validateNumOfProducts(int amount) {
//        waitForCartBadgeAmountToAppear(By.xpath(String.valueOf(CART_BADGE)));
//        Assert.assertEquals(driver.findElements(CART_BADGE).size(), amount, "Amount is wrong");
//    }

    public void selectOption(String value) {
        WebElement selectElement = driver.findElement(DROPDOWN);
        Select option = new Select(selectElement);
        option.selectByVisibleText(value);
    }

    public List<String> getProductNames() {
        List<String> stringNames = new ArrayList<>();
        List<WebElement> names = driver.findElements(By.cssSelector(PRODUCT_TITLE));
        for (WebElement element : names) {
            stringNames.add(element.getText());
        }
        return stringNames;
    }
}
