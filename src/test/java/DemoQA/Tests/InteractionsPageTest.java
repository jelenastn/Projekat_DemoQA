package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.HomePage;
import DemoQA.Pages.InteractionsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InteractionsPageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        interactionsPage = new InteractionsPage();
        js =  (JavascriptExecutor) driver;

    }


    @Test
    public void userCanClickOnSortable() {
        homePage.clickOnCard("Interactions");
        String expectedURL = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        interactionsPage. clickOnSortable();
        String expectedURL1 = excelReader.getStringData("URL", 16, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String sortableTitle = "Sortable";
        Assert.assertEquals(interactionsPage.SortableHeader.getText(), sortableTitle);
    }
    @Test
    public void userCanClickOnSelectable() throws InterruptedException {
        homePage.clickOnCard("Interactions");
        String expectedURL = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        interactionsPage. clickOnSelectable();
        Thread.sleep(1000);
        String expectedURL1 = excelReader.getStringData("URL", 16, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String selectableTitle = "Selectable";
        Assert.assertEquals(interactionsPage.SelectableHeader.getText(), selectableTitle);

    }
    @Test
    public void userCanClickOnResizable() {
        homePage.clickOnCard("Interactions");
        String expectedURL = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        interactionsPage. clickOnResizeble();
        String expectedURL1 = excelReader.getStringData("URL", 16, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String resizableTitle = "Resizable";
        Assert.assertEquals(interactionsPage.ResizableHeader.getText(), resizableTitle);
    }
    @Test
    public void userCanClickOnDroppable() {
        homePage.clickOnCard("Interactions");
        String expectedURL = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        interactionsPage. clickOnDroppable();
        String expectedURL1 = excelReader.getStringData("URL", 16, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String droppableTitle = "Droppable";
        Assert.assertEquals(interactionsPage.DroppableHeader.getText(), droppableTitle);

    }
    @Test
    public void userCanClickOnDraggable() {
        homePage.clickOnCard("Interactions");
        String expectedURL = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,350)", "");
        interactionsPage. clickOnDraggable();
        String expectedURL1 = excelReader.getStringData("URL", 16, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String draggableTitle = "Dragabble";
        Assert.assertEquals(interactionsPage.DraggableHeader.getText(), draggableTitle);
    }
    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }
}
