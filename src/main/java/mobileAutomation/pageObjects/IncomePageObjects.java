package mobileAutomation.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.MobileElement;

public class IncomePageObjects {

    @AndroidFindBy(id="com.monefy.app.lite:id/amount_text")
    public MobileElement amount;

    @AndroidFindBy(id="com.monefy.app.lite:id/textViewNote")
    public MobileElement note;

    @AndroidFindBy(id="com.monefy.app.lite:id/textViewChooseCategory")
    public MobileElement chooseCategory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Salary']")
    public MobileElement category;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Cash']")
    public MobileElement cash;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Payment card']")
    public MobileElement card;

    @AndroidFindBy(id="com.monefy.app.lite:id/currency_name")
    public MobileElement incomeType;

}

