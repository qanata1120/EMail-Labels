import model.CreateLabelPage;
import model.LabelsPage;
import model.LearnMorePage;
import model.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LabelsTest extends BaseTest {

    public void signInProcedure() {

        WebDriver driver = getDriver();
        driver.get("https://beta.protonmail.com/u/0/settings/labels");

        final String username = "QAtest01122021@protonmail.com";
        final String password = "Test1!";

        WebElement loginElement = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//input[@data-cy-login='username']")));
        loginElement.sendKeys(username);
        WebElement pasElement = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//input[@data-cy-login='password']")));
        pasElement.sendKeys(password);
        WebElement signInButton = driver.findElement(By.xpath("//button[@data-cy-login='submit']"));
        signInButton.click();
    }

    @Test
    public void createNewRecordTest() {

        signInProcedure();

        final String labelName = "Important";

        WebElement addLabelButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[text()='Add label']")));
        addLabelButton.click();
        WebElement labelNameField = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//input[@placeholder='Label name']")));
        labelNameField.sendKeys(labelName);
        WebElement colorButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@class='flex-item-noshrink pm-button']")));
        colorButton.click();
        WebElement cherryColor = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//input[@aria-labelledby='Color #cf5858']")));
        cherryColor.click();
        WebElement saveButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[text()='Save']")));
        saveButton.click();

        final By rows = By.xpath("//tbody/tr");
        WebElement firstLabelRow = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//tbody/tr[1]")));
        List<WebElement> records = getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(rows));

        Assert.assertEquals(records.size(), 1);
    }

    @Test
    public void checkLearnMoreLink() {

        signInProcedure();

        WebElement learnMore = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//section[@data-target-id='labellist']//a")));
        learnMore.click();

        Assert.assertTrue(getDriver().equals("https://protonmail.com/support/knowledge-base/creating-folders/"));
    }

    @Test
    public void editLabel() {

        final String labelName = "Edited Label";

        signInProcedure();

        WebElement editButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[text()='Edit']")));
        editButton.click();
        WebElement labelNameField = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//input[@placeholder='Label name']")));
        labelNameField.clear();
        labelNameField.sendKeys(labelName);
        WebElement colorButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@class='flex-item-noshrink pm-button']")));
        colorButton.click();
        WebElement greenColor = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//input[@aria-labelledby='Color #e6c04c']")));
        greenColor.click();
        WebElement saveButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[text()='Save']")));
        saveButton.click();

        WebElement editedLabelName = getDriver().findElement(By.xpath("//span[@title='Edited']"));

        Assert.assertEquals(editedLabelName.getTagName(), "Edited Label");
    }

    @Test
    public void deleteLabel() throws InterruptedException {

        signInProcedure();

        WebElement dropDownMenu = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@title='Open actions dropdown]")));
        dropDownMenu.click();
        WebElement deleteButton = getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[text()='Delete']")));
        deleteButton.click();
        deleteButton.click();

        final By rows = By.xpath("//tbody/tr");
        WebElement record = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(rows));

        boolean emptyField = getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]/div[1]/button[1]")).size() < 1;
        Assert.assertTrue(emptyField);
    }
}