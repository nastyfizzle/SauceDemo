package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); //check version of current Chrome -> download webdriver -> install
        //WebDriverManager.chromedriver().browserVersion("93").setup(); specific version of browser
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true) //close browser anyway, not depending on passed/failed test
    public void closeDriver() {
        driver.quit();
    }
}
