package mobileAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileAutomation.pageObjects.AccountPageObjects;
import mobileAutomation.utility.AppiumUtility;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AppiumUtility {

    private AccountPageObjects accountPageObjects;

    public AccountPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        accountPageObjects=new AccountPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageObjects);
    }

    public AccountPage selectAccountType(){
        waitForElementToBeClickable(accountPageObjects.accountType).click();
        return this;
    }

    public AccountPage selectAllAccounts(){
        waitForElementToBeClickable(accountPageObjects.allAccounts).click();
        return this;
    }

    public AccountPage selectCash(){
        selectAccountType();
        waitForElementToBeClickable(accountPageObjects.cash).click();
        return this;
    }

    public AccountPage selectCard(){
        selectAccountType();
        waitForElementToBeClickable(accountPageObjects.card).click();
        return this;
    }

}
