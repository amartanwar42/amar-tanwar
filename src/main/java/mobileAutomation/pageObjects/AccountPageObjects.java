package mobileAutomation.pageObjects;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class AccountPageObjects {

    @AndroidFindBy(id="com.monefy.app.lite:id/currency_name")
    public MobileElement accountType;

    @AndroidFindBy(id="//android.widget.TextView[@text ='All accounts']")
    public MobileElement allAccounts;

    @AndroidFindBy(xpath="//android.widget.TextView[@text ='Cash']")
    public MobileElement cash;

    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Payment card']")
    public MobileElement card;

}
