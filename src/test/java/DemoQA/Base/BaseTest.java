package DemoQA.Base;

import DemoQA.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public static ExcelReader excelReader;
    public String homeURL;
    public HomePage homePage;
    public TrainingPage trainingPage;
    public ElementsPage elementsPage;
    public FormsPage formsPage;
    public AlertFrameWindowsPage alertFrameWindowsPage;
    public WidgetPage widgetPage;
    public InteractionsPage interactionsPage;
    public BookStorePage bookStorePage;
    public JavascriptExecutor js;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("src/test/java/DemoQA/TestData.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
    }
    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

   public void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

    @AfterClass
    public void tearDown() {

    }

}
