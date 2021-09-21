package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @DataProvider
    public Object[][] dataForCheckoutForm() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", "Fizzle", "220108", "Error: First Name is required"},
                {"Nastya", "", "220108", "Error: Last Name is required"},
                {"Nastya", "Fizzle", "", "Error: Postal Code is required"},
        };
    }

    @Test(description = "Check submitting the checkout form with valid values", groups = {"Smoke"})
    public void validSubmitOfCheckoutForm() {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openByClickingOnCartButton();
        cartPage.checkout();
        assertTrue(checkoutPage.isPageOpened());
        checkoutPage.submit("Nastya", "Fizzle", "220108");
        assertTrue(checkoutOverviewPage.isPageOpened());
    }

    @Test(description = "Check submitting the checkout form with invalid values", dataProvider = "dataForCheckoutForm")
    public void invalidSubmitOfCheckoutForm(String firstName, String lastName, String zipCode, String errorText) {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openByClickingOnCartButton();
        cartPage.checkout();
        assertTrue(checkoutPage.isPageOpened());
        checkoutPage.submit(firstName, lastName, zipCode);
        assertEquals(checkoutPage.getError(), errorText);
    }
}
