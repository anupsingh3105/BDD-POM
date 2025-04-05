package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverUtil {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
//          System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//            WebDriverManager.edgedriver().setup();
            WebDriverManager.chromedriver().setup();
            // Initialize ChromeDriver with options
             driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}