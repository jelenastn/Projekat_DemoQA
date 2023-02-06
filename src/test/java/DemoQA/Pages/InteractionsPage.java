package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InteractionsPage extends BaseTest {
    public InteractionsPage() {
        PageFactory.initElements(driver, this);}

    @FindBy(id = "item-0")
    List<WebElement> sortable;
    @FindBy(id = "item-1")
    List<WebElement> selectable;
    @FindBy(id = "item-2")
    List<WebElement> resizable;
    @FindBy(id = "item-3")
    List<WebElement> droppable;
    @FindBy(id = "item-4")
    List<WebElement> draggable;
    @FindBy(className = "main-header")
    public
    WebElement InteractionsHeader;
    @FindBy(className = "main-header")
    public
    WebElement DraggableHeader;
    @FindBy(className = "main-header")
    public
    WebElement DroppableHeader;
    @FindBy(className = "main-header")
    public
    WebElement ResizableHeader;
    @FindBy(className = "main-header")
    public
    WebElement SelectableHeader;
    @FindBy(className = "main-header")
    public
    WebElement SortableHeader;

    //-----------------------------------------------

    public void clickOnSortable(){
        sortable.get(4).click();
    }
    public void clickOnSelectable(){
        selectable.get(3).click();
    }
    public void clickOnResizeble(){
        resizable.get(3).click();
    }
    public void clickOnDroppable(){
        droppable.get(3).click();
    }
    public void clickOnDraggable(){
        draggable.get(3).click();
    }

}
