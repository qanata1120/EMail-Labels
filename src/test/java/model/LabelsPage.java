package model;

import com.beust.jcommander.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class LabelsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add label']")
    private WebElement addLabelButton;

    @FindBy(linkText = "https://protonmail.com/support/knowledge-base/creating-folders/")
    private static WebElement learnMore;

    @FindBy(xpath = "//table[contains(@class, 'orderableTable ')]/tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//section[@data-target-id='labellist']")
    private WebElement table;

    public LabelsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage getWait() {
        return null;
    }

    @Override
    public CreateLabelPage sendKeys(String important) {
        return null;
    }

    @Override
    public SignInPage sendKeys(String username, String password) {
        return null;
    }

    @Override
    public CreateLabelPage clickColorMenuButton() {
        return null;
    }

    @Override
    public CreateLabelPage clickSaveButton() {
        return null;
    }

    @Override
    protected WebDriverWait getWebDriverWait() {
        return super.getWebDriverWait();
    }

    public LabelsPage clickAddLabelButton() throws InterruptedException {
        addLabelButton.wait(10);
        addLabelButton.click();
        return new LabelsPage(getDriver());
    }

    public int getRowCount() {
        if (Strings.isStringEmpty(table.getText())) {
            return 0;
        } else {
            return tableRows.size();
        }
    }

    public List<String> getRow(int rowNumber) {
        return tableRows.get(rowNumber).findElements(By.xpath("//td/a/div")).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public LearnMorePage openLearnMore() throws InterruptedException {
        learnMore.wait(10);
        learnMore.click();
        return new LearnMorePage(getDriver());
    }
}

