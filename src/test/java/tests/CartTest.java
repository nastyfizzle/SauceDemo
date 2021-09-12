package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void addTwoItems() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.validateNumOfAddedProducts(2);
    }
}
