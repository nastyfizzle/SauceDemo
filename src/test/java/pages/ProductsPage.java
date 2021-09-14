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
//    private static final By REMOVE_BUTTON_XPATH = By.xpath("//*[text() = 'Remove']/ancestor::*[@class = 'inventory_item']//button");

    public ProductsPage(WebDriver driver) { //call constructor of parent class
        super(driver);
    }

    public String getHeader() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(productButtonLocator, productName))).click();
    }

//todo: методы addToCart и removeFromCart одинаковые, на мой вщгляд для наглядности эти два метода об актуальны, но не уверена, что это правильно
    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(productButtonLocator, productName))).click();
    }
//todo: у меня не получилось реализовать метод для проверки изменения кнопки Add to cart на Remove. Нужна твоя помощь, Дима :)
//    public boolean isProductAddedToCart(String productName) {
//        return driver.findElement(REMOVE_BUTTON_XPATH).isDisplayed();
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
