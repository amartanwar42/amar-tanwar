package mobileAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileAutomation.pageObjects.HomePageObjects;
import mobileAutomation.utility.AppiumUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends AppiumUtility {
    private HomePageObjects homePageObjects;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        homePageObjects=new HomePageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),homePageObjects);
    }

    public ExpensePage tapOnExpenseButton(){
        waitForElementToBeClickable(homePageObjects.expenseButton).click();
        return new ExpensePage(driver);
    }

    public IncomePage tapOnIncomeButton(){
        waitForElementToBeClickable(homePageObjects.incomeButton).click();
        return new IncomePage(driver);
    }

    public HomePage tapOnMenuButton(){
        waitForElementToBeClickable(homePageObjects.menu).click();
        return this;
    }

    public String balanceAmount(){
       return waitForElementToBeClickable(homePageObjects.balanceAmount).getText();
    }

    public String incomeAmount(){
        return waitForElementToBeClickable(homePageObjects.incomeAmount).getText();
    }

    public String expenseAmount(){
        return waitForElementToBeClickable(homePageObjects.expenseAmount).getText();
    }

    public AccountPage tabOnNavigation(){
        waitForElementToBeClickable(homePageObjects.navigation).click();
        return new AccountPage(driver);
    }

    public HomePage selectCategory(){
        waitForElementToBeClickable(homePageObjects.category).click();
        return this;
    }

    public HomePage assertIncome(String expectedIncome){
        String actualIncome=incomeAmount();
        Assert.assertTrue(actualIncome.contains(expectedIncome));
        return this;
    }

    public HomePage assertBalance(String expectedBalance){
        String actualIncome=balanceAmount();
        Assert.assertTrue(actualIncome.contains(expectedBalance));
        return this;
    }

    public HomePage assertExpense(String expectedExpense){
        String actualIncome=expenseAmount();
        Assert.assertTrue(actualIncome.contains(expectedExpense));
        return this;
    }

    public HomePage showHistory(){
        swipeByElements(homePageObjects.balanceAmount,homePageObjects.menu);
        return this;
    }

    public HomePage assertHistory(){
        waitForElementToBeVisible(homePageObjects.billsHistory);
        waitForElementToBeVisible(homePageObjects.incomeHistory);
        return this;
    }
}
