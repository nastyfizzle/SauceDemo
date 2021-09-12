package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void loginWihtoutCredentials() {
        loginPage.openPage();
        loginPage.login("", "");
        loginPage.handleError("Epic sadface: Username is required");
    }

    @Test
    public void loginWihtoutUsername() {
        loginPage.openPage();
        loginPage.login("", "secret_sauce");
        loginPage.handleError("Epic sadface: Username is required");
    }

    @Test
    public void loginWihtoutPassword() {
        loginPage.openPage();
        loginPage.login("standard_user", "");
        loginPage.handleError("Epic sadface: Password is required");
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.login("45", "45");
        loginPage.handleError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockeOutUserTest() {
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.handleError("Epic sadface: Sorry, this user has been locked out.");
    }
}
