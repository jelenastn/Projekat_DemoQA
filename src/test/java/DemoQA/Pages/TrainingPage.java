package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class TrainingPage extends BaseTest {
    public TrainingPage(){
        PageFactory.initElements(driver, this);
    }
}
