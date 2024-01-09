package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    public Driver() {
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions chromeOptions;
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--disable-site-isolation-trials");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--headless=new");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
