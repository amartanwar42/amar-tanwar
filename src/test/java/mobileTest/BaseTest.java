package mobileTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import mobileAutomation.pages.HomePage;
import mobileAutomation.pages.IncomePage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private AppiumDriverLocalService service;
    protected AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        startServer();
        setAndroidCaps();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    private void setAndroidCaps() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "test");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.monefy.activities.main.MainActivity_");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.monefy.app.lite");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.APP,
                new File("./app/monefy.apk").getAbsolutePath());

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            ((AndroidDriver) driver).setSetting(Setting.NORMALIZE_TAG_NAMES, true);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public HomePage addCashIncome(){
        HomePage homePage = new HomePage(driver);

        homePage.tapOnIncomeButton()
                .selectCashIncome()
                .enterAmount()
                .selectEight()
                .selectZero()
                .selectZero();
        new IncomePage(driver).enterNote("adding cash salary")
                .chooseCategory()
                .selectCategory();

        return homePage;
    }

    public HomePage addCardIncome(){
        HomePage homePage = new HomePage(driver);

        homePage.tapOnIncomeButton()
                .selectCardIncome()
                .enterAmount()
                .selectNine()
                .selectZero()
                .selectZero();
        new IncomePage(driver).enterNote("adding cash salary")
                .chooseCategory()
                .selectCategory();

        return homePage;
    }
}
