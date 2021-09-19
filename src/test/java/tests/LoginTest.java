package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test
    public void loginWihtoutCredentials() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWihtoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWihtoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required");
    }

    @Test
    public void invalidLogin() {
        loginPage.open();
        loginPage.login("45", "45");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockeOutUserTest() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
