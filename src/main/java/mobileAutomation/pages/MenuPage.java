package mobileAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileAutomation.pageObjects.MenuPageObjects;
import mobileAutomation.utility.AppiumUtility;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends AppiumUtility {
    private MenuPageObjects menuPageObjects;

    public MenuPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        menuPageObjects= new MenuPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),menuPageObjects);
    }

    private MenuPage tapOnCategoryButton(){
        waitForElementToBeClickable(menuPageObjects.catgoriesButton).click();
        return this;
    }

    private MenuPage tapOnAccountsButton(){
        waitForElementToBeClickable(menuPageObjects.accountsButton).click();
        return this;
    }

    private MenuPage tapOnCurrencyButton(){
        waitForElementToBeClickable(menuPageObjects.currencyButton).click();
        return this;
    }

    private MenuPage tapOnSettingsButton(){
        waitForElementToBeClickable(menuPageObjects.settingsButton).click();
        return this;
    }

}
