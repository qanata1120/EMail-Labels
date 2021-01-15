package model;

import org.openqa.selenium.WebDriver;

public class LearnMorePage  extends LabelsPage{

    public LearnMorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage getWait() {
        return null;
    }

}
