package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest{

    @Test
    public void removeProductFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.removeItemFromCart("Sauce Labs Fleece Jacket");
        assertEquals(cartPage.getAmountOfProducts(), 0, "Amount of products is wrong");
    }
}
