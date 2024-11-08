package pages;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

public class ApiDemosLocators{

    //Keeping all the Locators.

    public By VIEWS = AppiumBy.accessibilityId("Views");
    public By EXPANDABLE_LIST = AppiumBy.accessibilityId("Expandable Lists");
    public By CUSTOM_ADAPTER = AppiumBy.accessibilityId("1. Custom Adapter");
    public By NAMES = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]");
    public By SAMPLE_MENU = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout/android.widget.TextView");
    public By DRAGandDROP = AppiumBy.accessibilityId("Drag and Drop");
    public By DRAG_CIRCLE1 = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
    public By DRAG_CIRCLE2 = AppiumBy.id("io.appium.android.apis:id/drag_dot_2");
    public By DROPED_text = AppiumBy.id("io.appium.android.apis:id/drag_result_text");


}
