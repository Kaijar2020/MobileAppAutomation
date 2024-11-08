package utilites;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String url_appium = "http://127.0.0.1:4723";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:app",System.getProperty("user.dir")+"\\app\\ApiDemos-debug.apk");

        URL url = new URL(url_appium);
        driver = new AndroidDriver(url, desiredCapabilities);
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}