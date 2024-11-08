package testcases;

import org.testng.annotations.Test;
import pages.ApiDemosLocators;
import pages.BaseMethods;




public class ExecuteTest extends BaseMethods {


    private ApiDemosLocators _locators;

    public ExecuteTest(){
         _locators = new ApiDemosLocators();
    }

    @Test
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
        //long_press(_locators.NAMES);
        System.out.println(getElement(_locators.SAMPLE_MENU).isDisplayed());
    }

    @Test
    public void drag_and_drop(){
        getElement(_locators.VIEWS).click();

        text_assert(_locators.DROPED_text, "Dropped!");
    }
}
