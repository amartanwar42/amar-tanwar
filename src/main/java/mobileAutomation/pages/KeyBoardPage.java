package mobileAutomation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileAutomation.pageObjects.KeyBoardObjects;
import mobileAutomation.utility.AppiumUtility;
import org.openqa.selenium.support.PageFactory;

public class KeyBoardPage extends AppiumUtility {

    private KeyBoardObjects keyBoardObjects;

    public KeyBoardPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        keyBoardObjects= new KeyBoardObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),keyBoardObjects);
    }

    public KeyBoardPage selectOne(){
        waitForElementToBeClickable(keyBoardObjects.one).click();
        return this;
    }

    public KeyBoardPage selectTwo(){
        waitForElementToBeClickable(keyBoardObjects.two).click();
        return this;
    }

    public KeyBoardPage selectThree(){
        waitForElementToBeClickable(keyBoardObjects.three).click();
        return this;
    }

    public KeyBoardPage selectFour(){
        waitForElementToBeClickable(keyBoardObjects.four).click();
        return this;
    }

    public KeyBoardPage selectFive(){
        waitForElementToBeClickable(keyBoardObjects.five).click();
        return this;
    }

    public KeyBoardPage selectSix(){
        waitForElementToBeClickable(keyBoardObjects.six).click();
        return this;
    }

    public KeyBoardPage selectSeven(){
        waitForElementToBeClickable(keyBoardObjects.seven).click();
        return this;
    }

    public KeyBoardPage selectEight(){
        waitForElementToBeClickable(keyBoardObjects.eight).click();
        return this;
    }

    public KeyBoardPage selectNine(){
        waitForElementToBeClickable(keyBoardObjects.nine).click();
        return this;
    }

    public KeyBoardPage selectZero(){
        waitForElementToBeClickable(keyBoardObjects.zero).click();
        return this;
    }

}
