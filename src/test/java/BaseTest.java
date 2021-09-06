import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup(); //check version of current Chrome -> download webdriver -> install
        //WebDriverManager.chromedriver().browserVersion("93").setup(); specific version of browser
        driver = new ChromeDriver();
    }


    @AfterMethod(alwaysRun = true) //always close browser
    public void tearDown(){
        driver.quit();
    }
}
