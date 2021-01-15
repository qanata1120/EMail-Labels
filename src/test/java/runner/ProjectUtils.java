package runner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ProjectUtils {

    public static void scroll(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void sendKeys(WebElement element, String keys) {
        for (int i = 0; i < keys.length(); i++) {
            element.sendKeys(keys.substring(i, i + 1));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {
            }
        }
    }
}


