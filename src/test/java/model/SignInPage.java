package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@data-cy-login='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@data-cy-login='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-cy-login='submit']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage getWait() {
        return new SignInPage(getDriver());
    }

    @Override
    public CreateLabelPage sendKeys(String string) {
        return null;
    }


    public SignInPage sendKeys(String username, String password) {
        usernameField.sendKeys();
        passwordField.sendKeys();
        return new SignInPage(getDriver());
    }

    @Override
    public CreateLabelPage clickColorMenuButton() {
        return null;
    }

    @Override
    public CreateLabelPage clickSaveButton() {
        return null;
    }

    public LabelsPage clickSignInButton() {
        signInButton.click();
        return getLabelsPage();
    }

}
