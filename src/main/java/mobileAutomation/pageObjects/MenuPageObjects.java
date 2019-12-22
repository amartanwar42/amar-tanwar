package mobileAutomation.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPageObjects {

    @AndroidFindBy(id="com.monefy.app.lite:id/categories_button")
    public MobileElement catgoriesButton;

    @AndroidFindBy(id="com.monefy.app.lite:id/accounts_panel")
    public MobileElement accountsButton;

    @AndroidFindBy(id="com.monefy.app.lite:id/currency_panel")
    public MobileElement currencyButton;

    @AndroidFindBy(id="com.monefy.app.lite:id/settings_panel")
    public MobileElement settingsButton;


}
