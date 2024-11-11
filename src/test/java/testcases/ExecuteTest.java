package testcases;

import org.testng.annotations.Test;
import pages.ApiDemosLocators;
import pages.BaseMethods;

public class ExecuteTest extends BaseMethods {


    private ApiDemosLocators _locators;

    public ExecuteTest(){
         _locators = new ApiDemosLocators();
    }

    @Test(priority = 1)
    public void navigate_to_view(){
        //Verify the Views option.
        text_assert(_locators.VIEWS,"Views");

        //Click on the Views option.
        getElement(_locators.VIEWS).click();

        //Scroll into Expandable Lists and select it if visible.
        if(getElement(_locators.EXPANDABLE_LIST).isDisplayed()){
            getElement(_locators.EXPANDABLE_LIST).click();
        }

        //Select Customer Adapter.
        getElement(_locators.CUSTOM_ADAPTER).click();

        //Validate People Names and Long Press on it.
        text_assert(_locators.NAMES, "People Names");

        //Click on Person Name
        try {
            long_Press(_locators.NAMES);
            text_assert(_locators.SAMPLE_MENU, "Sample menu");
            //Verified text is visible.
            getElement(_locators.SAMPLE_MENU).isDisplayed();
            driver.navigate().back();
        }
        catch (Exception e){
            throw e;
        }

        //Redirect to the back screen for catching Drag and Drop.
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test(priority = 2,dependsOnMethods = "navigate_to_view")
    public void drag_and_drop(){

        //Click on element.
        getElement(_locators.DRAGandDROP).click();

        //Perform the Drag and Drop operation.
        DragAndDrop(_locators.DRAG_CIRCLE1, _locators.DRAG_CIRCLE2);
        text_assert(_locators.DROPED_text, "Dropped!");
    }
}
