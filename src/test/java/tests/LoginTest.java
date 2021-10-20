package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Feature("Blabla feature")
public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] dataForLogin() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"45", "45", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("number of test case TMS-1")
    @Issue("number of bug report TMS-123")
    @Link("https://tut.by")
    @Test(description = "Check successful authorization with valid credentials", groups = {"Smoke"})
    @Description("Use credentials displayed in the 'Login' page")
    public void validLogin() {
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test(description = "Check not successful authorization with invalid credentials", dataProvider = "dataForLogin")
    public void invalidLogin(String username, String password, String errorText) {
        loginPage.isPageOpened();
        loginPage.login(username, password);
        assertEquals(loginPage.getError(), errorText);

    }
}
