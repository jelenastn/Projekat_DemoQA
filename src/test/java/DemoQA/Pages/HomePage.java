package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);

    }

    public static @FindBy(className = "banner-image")
    WebElement ImageLink;

    @FindBy(className = "card-body")
    public List<WebElement> cards;



//-------------------------------------------------------------------
public static void clickOnImageLink(){
     ImageLink.click();

    }
 public void clickOnCard(String a){
    for (int i=0; i<cards.size(); i++){
        if(cards.get(i).getText().equals(a)){
            cards.get(i).click();
            break;
        }
    }
 }

}


