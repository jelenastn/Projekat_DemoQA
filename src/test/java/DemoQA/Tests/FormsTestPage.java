package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.FormsPage;
import DemoQA.Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormsTestPage extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        formsPage = new FormsPage();
        js =  (JavascriptExecutor) driver;

    }
    @Test
    public void userCanClickOnPractiseForms() {
        homePage.clickOnCard("Forms");
        String expectedURL = excelReader.getStringData("URL", 1, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        formsPage.clickOnPractiseForm();
        String expectedURL1 = excelReader.getStringData("URL", 7, 0);
        String practise = "Practice Form";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        Assert.assertEquals(formsPage.PractiseFormsHeader.getText(), practise);

    }
    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }
}
