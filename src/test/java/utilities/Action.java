package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.PseudoColumnUsage;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;




public class Action {

    public static final int seconds = 20;
        public static void scrollUntilVisible(By xpath) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            scrollIntoView(element);
        }

        public static void scrollIntoView(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'})", element);
        }

    public static void back(){
        Driver.getDriver().navigate().back();
    }

    public static void clickElement(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.click();
    }

    public static void sendKeysElement(By xpath, String key){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.sendKeys(key);
    }

    public static String getTextElement(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        return element.getText();
    }
    public static List<String> getTextElements(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

        List<WebElement> elements = Driver.getDriver().findElements(xpath);
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        return texts;
    }

    public static void pressEnter(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        element.sendKeys(Keys.ENTER);

    }

    public static void  checkElementText(By xpath, String text){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getText(),text);
    }

    public static void elementPresent(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
    }
    public static void elementNotPresent(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
    }

    public static void  checkElementValue(By xpath, String text){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getAttribute("value"),text);
    }

    public static void clearText(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        element.clear();
    }
}
