package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void addTwoItems() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.validateNumOfAddedProducts(2);
    }
}
