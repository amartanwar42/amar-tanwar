package mobileTest;

import mobileAutomation.pages.ExpensePage;
import mobileAutomation.pages.HomePage;
import org.testng.annotations.Test;

public class MobileTests extends BaseTest {

    @Test(groups = {"MOBILE"},priority = 3)
    public void addCardIncome_addExpense_checkHistory(){

        HomePage homePage=addCardIncome();
        homePage.assertBalance("900");
        homePage.assertIncome("900");

        homePage.tapOnExpenseButton()
                .enterAmount()
                .selectEight()
                .selectZero()
                .selectZero();

        new ExpensePage(driver)
                .chooseCategory()
                .selectCategory();

        homePage.assertExpense("800")
                .assertBalance("100")
                .showHistory()
                .assertHistory();
    }

    @Test(groups = {"MOBILE"},priority = 2)
    public void addCashIncome_addExpense_checkHistory(){
        HomePage homePage = addCashIncome();

        homePage.assertBalance("800");
        homePage.assertIncome("800");

        homePage.tapOnExpenseButton()
                .enterAmount()
                .selectFive()
                .selectZero()
                .selectZero();

        new ExpensePage(driver)
                .chooseCategory()
                .selectCategory();

        homePage.assertExpense("500")
                .assertBalance("300")
                .showHistory()
                .assertHistory();
    }

    @Test(groups = {"MOBILE"},priority = 1,description = "Adding salary from both cash and card and checking the balance when All Accounts are Selected and Cash is Selected and Card is selected")
    public void AddExpenseFromBoth_CashAndCard(){
        addCardIncome();
        addCashIncome();

        //Asserting Income and Balance when All Account is selected
        HomePage homePage=new HomePage(driver);
        homePage.assertBalance("1,700")
                .assertIncome("1,700");

        //Asserting Income and Balance when Card is selected
        homePage.tabOnNavigation()
                .selectCard();
        homePage.assertBalance("900")
                .assertIncome("900");

        //Asserting Income and Balance when cash is selected
        homePage.tabOnNavigation()
                .selectCash();
        homePage.assertBalance("800")
                .assertIncome("800");

    }
}
