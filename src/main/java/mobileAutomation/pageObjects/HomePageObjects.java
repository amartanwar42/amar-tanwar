package mobileAutomation.pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import sun.management.snmp.util.MibLogger;

public class HomePageObjects {

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button_title")
    public MobileElement expenseButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button_title")
    public MobileElement incomeButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/overflow")
    public AndroidElement menu;

    @AndroidFindBy(id="com.monefy.app.lite:id/balance_amount")
    public AndroidElement balanceAmount;

    @AndroidFindBy(id="com.monefy.app.lite:id/income_amount_text")
    public MobileElement incomeAmount;

    @AndroidFindBy(id="com.monefy.app.lite:id/expense_amount_text")
    public MobileElement expenseAmount;

    @AndroidFindBy(accessibility = "Open navigation")
    public MobileElement navigation;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[1]")
    public MobileElement category;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$900.00']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$800.00']")
    public MobileElement incomeHistory;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$800.00']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$500.00']")
    public MobileElement billsHistory;
}
