//package tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//public class DriverFactory {
//
//    public static WebDriver getDriver(String driver) {
//        String browser;
//        if (driver.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            return new ChromeDriver();
//        } else if (driver.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            return new EdgeDriver();
//        }
//        return null;
//    }
//}
