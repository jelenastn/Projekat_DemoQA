package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static DemoQA.Base.BaseTest.driver;

public class FormsPage extends BaseTest {
    public FormsPage() {
        PageFactory.initElements(driver, this);}

    @FindBy(id = "item-0")
    List<WebElement> practiseForm;
    @FindBy(className = "main-header")
    public
    WebElement FormsHeader;
    @FindBy(className = "main-header")
    public
    WebElement PractiseFormsHeader;

//----------------------------------------------------------
    public void clickOnPractiseForm(){
        practiseForm.get(1).click();
    }

}
