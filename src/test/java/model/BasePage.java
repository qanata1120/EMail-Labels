package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private final WebDriver driver;
    private WebDriverWait webDriverWait;


    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, 10);
        }

        return webDriverWait;
    }

    protected LabelsPage getLabelsPage() {
        //       WebDriver driver = getDriver();
        //        driver.get("https://beta.protonmail.com/u/0/settings/labels");
        driver.get("https://beta.protonmail.com/u/0/settings/labels");
        return new LabelsPage(getDriver());
    }

    public abstract BasePage getWait();

    public abstract CreateLabelPage sendKeys(String string);

    public abstract SignInPage sendKeys(String username, String password);

    public abstract CreateLabelPage clickColorMenuButton();

    public abstract CreateLabelPage clickSaveButton();
}
