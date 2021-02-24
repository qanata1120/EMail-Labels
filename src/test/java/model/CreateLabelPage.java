package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.ProjectUtils;

public class CreateLabelPage extends LabelsPage {


    @FindBy(xpath = "//input[@placeholder='Label name']")
    private WebElement labelNameField;

    @FindBy(xpath = "//button[@class='flex-item-noshrink pm-button']")
    private WebElement colorButton;

    @FindBy(xpath = "//input[@aria-labelledby='Color #cf5858']")
    private WebElement cherryColor;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public CreateLabelPage(WebDriver driver) {
        super(driver);
    }


    public CreateLabelPage sendKeys(String labelName) {
        ProjectUtils.sendKeys(labelNameField, labelName);
        return new CreateLabelPage(getDriver());
    }

    public CreateLabelPage clickColorMenuButton() {
        colorButton.click();
        return new CreateLabelPage(getDriver());
    }

    public CreateLabelPage clickOnCherryColor() {
        cherryColor.click();
        return new CreateLabelPage(getDriver());
    }
}
