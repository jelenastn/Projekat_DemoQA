package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WidgetPage extends BaseTest {

    public WidgetPage() {
        PageFactory.initElements(driver, this);}

    @FindBy(id = "item-0")
    List<WebElement> accordian;

    @FindBy(id = "item-1")
    List<WebElement> autoComplete;

    @FindBy(id = "item-2")
    List<WebElement> datePicker;
    @FindBy(id = "item-3")
    List<WebElement> slider;

    @FindBy(id = "item-4")
    List<WebElement> progressBar;
    @FindBy(id = "item-5")
    List<WebElement> tabs;
    @FindBy(id = "item-6")
    List<WebElement> toolTips;
    @FindBy(id = "item-7")
    List<WebElement> menu;
    @FindBy(id = "item-8")
    List<WebElement> selectMenu;
    @FindBy(className = "main-header")
    public
    WebElement WidgetsHeader;
    @FindBy(className = "main-header")
    public
    WebElement SelectMenuHeader;
    @FindBy(className = "main-header")
    public
    WebElement MenuHeader;
    @FindBy(className = "main-header")
    public
    WebElement ToolTipsHeader;
    @FindBy(className = "main-header")
    public
    WebElement TabsHeader;
    @FindBy(className = "main-header")
    public
    WebElement ProgressBarHeader;
    @FindBy(className = "main-header")
    public
    WebElement SliderHeader;
    @FindBy(className = "main-header")
    public
    WebElement DatePickerHeader;
    @FindBy(className = "main-header")
    public
    WebElement AutocompleteHeader;
    @FindBy(className = "main-header")
    public
    WebElement AccordianHeader;

 //-------------------------------------------
    public void clickOnAccordian(){
        accordian.get(3).click();    }
    public void clickOnAutoComplete(){
        autoComplete.get(2).click();    }
    public void clickOnDatePicker(){
        datePicker.get(2).click();    }
    public void clickOnSlider(){
        slider.get(2).click();    }
    public void clickOnProgressBar(){
        progressBar.get(2).click();    }
    public void clickOnTabs(){
        tabs.get(1).click();    }
    public void clickOnToolTips(){
        toolTips.get(1).click();    }
    public void clickOnMenu(){
        menu.get(1).click();    }
    public void clickOnSelectMenu(){
        selectMenu.get(1).click();    }

}
