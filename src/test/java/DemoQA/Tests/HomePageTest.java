package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        trainingPage = new TrainingPage();
        elementsPage = new ElementsPage();
        formsPage = new FormsPage();
        alertFrameWindowsPage = new AlertFrameWindowsPage();
        widgetPage = new WidgetPage();
        interactionsPage = new InteractionsPage();
        bookStorePage = new BookStorePage();
        js =  (JavascriptExecutor) driver;

    }


    @Test
    public void userCanClickOnBannerImage() {
        HomePage.clickOnImageLink();
        String expectedURL = excelReader.getStringData("URL", 1, 1);
        String a = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(a)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertFalse(isDisplayed(HomePage.ImageLink));

    }

    @Test
    public void userCanClickOnCardElements() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String validHeader1 = "Elements";
        Assert.assertEquals(elementsPage.ElementsHeader.getText(), validHeader1);
    }

    @Test
    public void userCanClickOncardForms() {
        homePage.clickOnCard("Forms");
        String expectedURL = excelReader.getStringData("URL", 1, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String validHeader2 = "Forms";
        Assert.assertEquals(formsPage.FormsHeader.getText(), validHeader2);

    }

    @Test
    public void userCanClickOncardAlertsFrameWindows() {
        homePage.clickOnCard("Alerts, Frame & Windows");
        String expectedURL = excelReader.getStringData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String validHeader3 = "Alerts, Frame & Windows";
        Assert.assertEquals(alertFrameWindowsPage.AlertsHeader.getText(), validHeader3);

    }
    @Test
    public void userCanClickOncardWidgets() {
        homePage.clickOnCard("Widgets");
        String expectedURL = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String validHeader4 = "Widgets";
        Assert.assertEquals(widgetPage.WidgetsHeader.getText(), validHeader4);

    }

    @Test
    public void userCanClickOnCardInteractions() {
        homePage.clickOnCard("Interactions");
        String expectedURL = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String validHeader5 = "Interactions";
        wdwait.until(ExpectedConditions.elementToBeClickable(interactionsPage.InteractionsHeader));
        Assert.assertEquals(interactionsPage.InteractionsHeader.getText(), validHeader5);

    }

    @Test
    public void userCanClickOnCardBookStore() {
        js.executeScript("window.scrollBy(0,550)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.loginButton));
        Assert.assertTrue(isDisplayed(bookStorePage.loginButton));

    }
    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }

}