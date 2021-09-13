package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage{
    private String ADD_TO_CART_LOCATOR = "//*[text() = '%s']/ancestor::*[@class = 'inventory_item']//button";
    private static final String ADD_TO_CART_BUTTON = ".btn_inventory";
    private String REMOVE_FROM_CART_PRODUCTS_PAGE = "//*[text() = '%s']/ancestor::*[@class = 'inventory_item']//button";
    private static final By CART_BADGE = By.xpath("//*[contains(@class, 'shopping_cart_badge')]");
    private static final By DROPDOWN = By.xpath("//select[@class='product_sort_container']");
    private static final String PRODUCT_TITLE = ".inventory_item_name";

    public ProductsPage(WebDriver driver) { //call constructor of parent class
        super(driver);
    }

    public ProductsPage addToCart(String productName) {
        waitForNumberOfElementsToAppear(By.cssSelector(ADD_TO_CART_BUTTON), 6);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_LOCATOR, productName))).click();
        return this;
    }

    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PRODUCTS_PAGE, productName))).click();
    }

    //todo: cannot be performed, the reason in console is locator
    public void validateNumOfProducts(int amount) {
        waitForCartBadgeAmountToAppear(By.xpath(String.valueOf(CART_BADGE)));
        Assert.assertEquals(driver.findElements(CART_BADGE).size(), amount, "Amount is wrong");
    }

    public void sortDescOrderName(){
        Select dropdown = new Select(driver.findElement(DROPDOWN));
        dropdown.selectByVisibleText("Name (Z to A)");
    }

    public void sortAscOrderName(){
        Select dropdown = new Select(driver.findElement(DROPDOWN));
        dropdown.selectByVisibleText("Name (A to Z)");
    }

    public void sortAscOrderPrice(){
        Select dropdown = new Select(driver.findElement(DROPDOWN));
        dropdown.selectByVisibleText("Price (low to high)");
    }

    public void sortDescOrderPrice(){
        Select dropdown = new Select(driver.findElement(DROPDOWN));
        dropdown.selectByVisibleText("Price (high to low)");
    }

    public List<String> getProductNames(){
        List<String> stringNames = new ArrayList<>();
        List<WebElement> names = driver.findElements(By.cssSelector(PRODUCT_TITLE));
        for(WebElement element : names){
            stringNames.add(element.getText());
        }
        return stringNames;
    }
}
