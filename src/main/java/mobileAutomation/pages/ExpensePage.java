package mobileAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileAutomation.pageObjects.ExpensePageObjects;
import mobileAutomation.utility.AppiumUtility;
import org.openqa.selenium.support.PageFactory;

public class ExpensePage extends AppiumUtility {
    private ExpensePageObjects expensePageObjects;

    public ExpensePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        expensePageObjects=new ExpensePageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),expensePageObjects);
    }

    public KeyBoardPage enterAmount(){
        waitForElementToBeClickable(expensePageObjects.amountText).click();
        return new KeyBoardPage(driver);
    }

    public ExpensePage addNote(String note){
        waitForElementToBeClickable(expensePageObjects.addNote).sendKeys(note);
        return this;
    }

    public ExpensePage chooseCategory(){
        waitForElementToBeClickable(expensePageObjects.chooseCategory).click();
        return this;
    }

    public ExpensePage selectCategory(){
        waitForElementToBeClickable(expensePageObjects.category).click();
        return this;
    }

    public ExpensePage selectCashIncome(){
        changeExpenseFrom();
        waitForElementToBeClickable(expensePageObjects.cash).click();
        return this;
    }

    public ExpensePage selectCardIncome(){
        changeExpenseFrom();
        waitForElementToBeClickable(expensePageObjects.card).click();
        return this;
    }

    public ExpensePage changeExpenseFrom(){
        waitForElementToBeClickable(expensePageObjects.expenseType).click();
        return this;
    }

}
