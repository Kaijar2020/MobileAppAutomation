package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.asserts.SoftAssert;
import utilites.DriverSetup;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class BaseMethods extends DriverSetup{

    // Create a new pointer input for touch on element.
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");


    //To find element
    public WebElement getElement(By locators){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(locators);
    }

    //To assert Text.
    public void text_assert(By locators,String expected_text){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actual_text = getElement(locators).getText();
        SoftAssert as = new SoftAssert();
        as.assertEquals(actual_text,expected_text);
        as.assertAll();
    }

    //To Scroll
    public void scroll_into_view(By locator){
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        WebElement ele =  getElement(locator);
        jsExe.executeScript("argument[0].scrollIntoView();",ele);
    }

    //To Drag and Drop.
    public void DragAndDrop(By target, By destination) {
        //Convert into web-element.
        WebElement circle1 = getElement(target);
        WebElement circle2 = getElement(destination);

        Sequence dragAndDrop = new Sequence(finger, 1);

        // Select circle1
        dragAndDrop.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), circle1.getLocation().getX(), circle1.getLocation().getY()));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        //Drop in circle2
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofSeconds(3), PointerInput.Origin.viewport(), circle2.getLocation().getX(), circle2.getLocation().getY()));
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the action
        driver.perform(Arrays.asList(dragAndDrop));
    }

    public void long_Press(By locators) {
        //Convert into web-element.
        WebElement elem = driver.findElement(locators);

        Sequence longPress = new Sequence(finger, 1);

        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), elem.getLocation().getX(), elem.getLocation().getY()));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(finger.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), elem.getLocation().getX(), elem.getLocation().getY()));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(longPress));
    }
}
