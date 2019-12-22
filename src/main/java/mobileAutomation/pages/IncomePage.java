package mobileAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileAutomation.pageObjects.IncomePageObjects;
import mobileAutomation.utility.AppiumUtility;
import org.openqa.selenium.support.PageFactory;

public class IncomePage extends AppiumUtility {
    private IncomePageObjects incomePageObjects;

    public IncomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        incomePageObjects=new IncomePageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),incomePageObjects);
    }

    public KeyBoardPage enterAmount(){
        waitForElementToBeClickable(incomePageObjects.amount).click();
        return new KeyBoardPage(driver);
    }

    public IncomePage enterNote(String note){
        waitForElementToBeClickable(incomePageObjects.note).sendKeys(note);
        return this;
    }

    public IncomePage chooseCategory(){
        waitForElementToBeClickable(incomePageObjects.chooseCategory).click();
        return this;
    }

    public IncomePage selectCategory(){
        waitForElementToBeClickable(incomePageObjects.category).click();
        return this;
    }

    public IncomePage selectCashIncome(){
        changeIncomeType();
        waitForElementToBeClickable(incomePageObjects.cash).click();
        return this;
    }

    public IncomePage selectCardIncome(){
        changeIncomeType();
        waitForElementToBeClickable(incomePageObjects.card).click();
        return this;
    }

    public IncomePage changeIncomeType(){
        waitForElementToBeClickable(incomePageObjects.incomeType).click();
        return this;
    }
}
