package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.AlertFrameWindowsPage;
import DemoQA.Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertFrameWindowsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        alertFrameWindowsPage = new AlertFrameWindowsPage();
        js =  (JavascriptExecutor) driver;

    }

    @Test
    public void userCanClickOnBrowserWindows() {
        homePage.clickOnCard("Alerts, Frame & Windows");
        String expectedURL = excelReader.getStringData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        alertFrameWindowsPage.clickOnBrowserWindows();
        String expectedURL1 = excelReader.getStringData("URL", 10, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String browserTitle = "Browser Windows";
        Assert.assertEquals(alertFrameWindowsPage.BrowserHeader.getText(), browserTitle);

    }
    @Test
    public void userCanClickOnAlerts() {
        homePage.clickOnCard("Alerts, Frame & Windows");
        String expectedURL = excelReader.getStringData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        alertFrameWindowsPage.clickOnAlerts();
        String expectedURL1 = excelReader.getStringData("URL", 10, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String alertsTitle = "Alerts";
        Assert.assertEquals(alertFrameWindowsPage.AlertsHeader.getText(), alertsTitle);
    }
    @Test
    public void UserCanClickOnFrames() {
        homePage.clickOnCard("Alerts, Frame & Windows");
        String expectedURL = excelReader.getStringData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        alertFrameWindowsPage.clickOnFrames();
        String expectedURL1 = excelReader.getStringData("URL", 10, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String framesTitle = "Frames";
        Assert.assertEquals(alertFrameWindowsPage.FramesHeader.getText(), framesTitle);

    }
    @Test
    public void userCanClickOnNestedFrames() {
        homePage.clickOnCard("Alerts, Frame & Windows");
        String expectedURL = excelReader.getStringData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        alertFrameWindowsPage.clickOnNestedFrames();
        String expectedURL1 = excelReader.getStringData("URL", 10, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String nestedFramesTitle = "Nested Frames";
        Assert.assertEquals(alertFrameWindowsPage.NestedFramesHeader.getText(), nestedFramesTitle);
    }
    @Test
    public void userCanClickModalDialog() {
        homePage.clickOnCard("Alerts, Frame & Windows");
        String expectedURL = excelReader.getStringData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,350)", "");
        alertFrameWindowsPage.clickOnModalDialogs();
        String expectedURL1 = excelReader.getStringData("URL", 10, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String modalDialogTitle = "Modal Dialogs";
        Assert.assertEquals(alertFrameWindowsPage.ModalDialogHeader.getText(), modalDialogTitle);
    }
    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }

}
