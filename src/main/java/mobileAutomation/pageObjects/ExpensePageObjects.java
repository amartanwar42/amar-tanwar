package mobileAutomation.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpensePageObjects {

    @AndroidFindBy (id="com.monefy.app.lite:id/amount_text")
    public MobileElement amountText;

    @AndroidFindBy(id="com.monefy.app.lite:id/textViewNote")
    public MobileElement addNote;

    @AndroidFindBy(id="com.monefy.app.lite:id/textViewChooseCategory")
    public MobileElement chooseCategory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='Bills']")
    public MobileElement category;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Cash]")
    public MobileElement cash;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Payment card']")
    public MobileElement card;

    @AndroidFindBy(id="com.monefy.app.lite:id/currency_name")
    public MobileElement expenseType;

}
