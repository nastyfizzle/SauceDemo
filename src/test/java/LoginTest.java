import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void login() {
        driver.get("https://www.saucedemo.com/");
    }
}
