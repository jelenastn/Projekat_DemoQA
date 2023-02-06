package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.HomePage;
import DemoQA.Pages.TrainingPage;
import DemoQA.Pages.WidgetPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WidgetTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        widgetPage = new WidgetPage();
        js =  (JavascriptExecutor) driver;
    }

@Test
public void userCanClickOnAccordian() {
    homePage.clickOnCard("Widgets");
    String expectedURL = excelReader.getStringData("URL", 1, 5);
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    widgetPage.clickOnAccordian();
    String expectedURL1 = excelReader.getStringData("URL", 13, 0);
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
    String accordianTitle = "Accordian";
    Assert.assertEquals(widgetPage.AccordianHeader.getText(), accordianTitle);
}
    @Test
    public void userCanClickOnAutoComplete() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        widgetPage.clickOnAutoComplete();
        String expectedURL1 = excelReader.getStringData("URL", 13, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String autocompleteTitle = "Auto Complete";
        Assert.assertEquals(widgetPage.AutocompleteHeader.getText(), autocompleteTitle);

    }
    @Test
    public void userCanClickOnDatePicker() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        widgetPage.clickOnDatePicker();
        String expectedURL1 = excelReader.getStringData("URL", 13, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String datePickerTitle = "Date Picker";
        Assert.assertEquals(widgetPage.DatePickerHeader.getText(), datePickerTitle);
    }
    @Test
    public void userCanClickOnSlider() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,350)", "");
        widgetPage.clickOnSlider();
        String expectedURL1 = excelReader.getStringData("URL", 13, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String sliderTitle = "Slider";
        Assert.assertEquals(widgetPage.SliderHeader.getText(), sliderTitle);
    }
    @Test
    public void userCanClickOnProgressBar() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,450)", "");
        widgetPage.clickOnProgressBar();
        String expectedURL1 = excelReader.getStringData("URL", 13, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String progressBarTitle = "Progress Bar";
        Assert.assertEquals(widgetPage.ProgressBarHeader.getText(), progressBarTitle);
    }
    @Test
    public void userCanClickOnTabs() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,550)", "");
        widgetPage.clickOnTabs();
        String expectedURL1 = excelReader.getStringData("URL", 13, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String tabsTitle = "Tabs";
        Assert.assertEquals(widgetPage.TabsHeader.getText(), tabsTitle);

    }
    @Test
    public void userCanClickOnToolTips() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,650)", "");
        widgetPage.clickOnToolTips();
        String expectedURL1 = excelReader.getStringData("URL", 13, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String toolTipsTitle = "Tool Tips";
        Assert.assertEquals(widgetPage.ToolTipsHeader.getText(), toolTipsTitle);

    }
    @Test
    public void userCanClickOnMenu() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,750)", "");
        widgetPage.clickOnMenu();
        String expectedURL1 = excelReader.getStringData("URL", 13, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String menuTitle = "Menu";
        Assert.assertEquals(widgetPage.MenuHeader.getText(), menuTitle);
    }
    @Test
    public void userCanClickOnSelectMenu() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,750)", "");
        widgetPage.clickOnSelectMenu();
        String expectedURL1 = excelReader.getStringData("URL", 13, 8);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String selectMenuTitle = "Select Menu";
        Assert.assertEquals(widgetPage.SelectMenuHeader.getText(), selectMenuTitle);

    }
    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }

}
