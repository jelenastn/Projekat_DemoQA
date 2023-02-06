package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class AlertFrameWindowsPage extends BaseTest {

    public AlertFrameWindowsPage() {
        PageFactory.initElements(driver, this);}

    @FindBy(className = "main-header")
    public
    WebElement BrowserHeader;
    @FindBy(className = "main-header")
    public
    WebElement AlertsHeader;
    @FindBy(id = "item-0")
    List<WebElement> browserWindows;

    @FindBy(id="item-1")
    List<WebElement>alerts;
    @FindBy(id="item-2")
    List<WebElement>frames;
    @FindBy(id="item-3")
    List<WebElement>nestedFrames;
    @FindBy(id="item-4")
    public
    List<WebElement>modalDialogs;
    @FindBy(className = "main-header")
    public
    WebElement FramesHeader;
    @FindBy(className = "main-header")
    public
    WebElement NestedFramesHeader;
    @FindBy(className = "main-header")
    public
    WebElement ModalDialogHeader;

    //------------------------------------------------------

    public void clickOnBrowserWindows(){
        browserWindows.get(2).click();
    }
    public void clickOnAlerts(){
        alerts.get(1).click();
    }
    public void clickOnFrames(){
        frames.get(1).click();
    }
    public void clickOnNestedFrames(){
        nestedFrames.get(1).click();
    }
    public void clickOnModalDialogs(){
        modalDialogs.get(1).click();
    }
}
