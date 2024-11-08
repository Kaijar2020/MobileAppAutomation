package pages;


import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utilites.DriverSetup;

import java.time.Duration;

public class BaseMethods extends DriverSetup{

    public WebElement getElement(By locators){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(locators);
    }

    public void text_assert(By locators,String expected_text){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actual_text = getElement(locators).getText();
        SoftAssert as = new SoftAssert();
        as.assertEquals(actual_text,expected_text);
        as.assertAll();
    }

    public void scroll_into_view(By locator){
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        WebElement ele =  getElement(locator);
        jsExe.executeScript("argument[0].scrollIntoView();",ele);
    }

    public void long_press(By locators){
        AndroidTouchAction _touch = new AndroidTouchAction(driver);
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element((WebElement)getElement(locators)));

        _touch.longPress(longPressOptions).release().perform();
    }

    public void deagDrop(){

    }
}
