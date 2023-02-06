package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookStorePage extends BaseTest {
    public BookStorePage() {
        PageFactory.initElements(driver, this);}

    @FindBy(id = "item-0")
    public
    List<WebElement> login;
    @FindBy(id = "item-2")
    List<WebElement> bookStore;
    @FindBy(id = "item-3")
    public
    List<WebElement> profile;
    @FindBy(id = "item-4")
    public
    List<WebElement> bookStoreApi;
    @FindBy(id = "userName")
    WebElement username1;
    @FindBy(id = "password")
    WebElement password1;

    @FindBy(id="login")
    public
    WebElement loginButton;
    @FindBy(id="submit")
    public
    WebElement logoutButton;
    @FindBy(id="see-book-Learning JavaScript Design Patterns")
    public
    WebElement book1;
    @FindBy(id="see-book-Speaking JavaScript")
    public
    WebElement book2;
    @FindBy(id = "addNewRecordButton")
    public
    List<WebElement>  addButton;
    @FindBy(id="gotoStore")
    public
    WebElement GoToStore;
    @FindBy(id = "submit")

    List<WebElement> deleteAllBooks;
    @FindBy(id="closeSmallModal-ok")
    public
    WebElement ok;
    @FindBy(id = "submit")

    List<WebElement> deleteAccount;
    @FindBy(id="addNewRecordButton")
    List<WebElement>backToBook;
    @FindBy(id="delete-record-undefined")
    WebElement Bin;
    @FindBy(css = ".pattern-backgound.playgound-header")
    public
    WebElement BookStoreHeader;
    @FindBy(className = "main-header")
    public
    WebElement BookStoreProfileHeader;
    @FindBy(className = "title")
    public
    WebElement BookStoreAPIHeader;
    //-------------------------------------------------------------------------
    public void clickOnLogin(){
        login.get(5).click();
    }
    public void clickOnBookStore(){
        bookStore.get(4).click();
    }
    public void clickOnProfile(){
        profile.get(4).click();
    }
    public void clickOnBookStoreAPI(){
        bookStoreApi.get(4).click();
    }
    public void insertUsername(String username){
        username1.sendKeys(username);
    }
    public void insertPassword(String password){
        password1.sendKeys(password);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public void clickOnLogOutButton(){
        logoutButton.click();
    }
    public void goToBookStoreButton(){
        GoToStore.click();
    }
    public void clickOnBook1(){
        book1.click();
    }
    public void clickOnBook2(){
        book2.click();
    }

    public void clickOnAddToYourCollection(){
        addButton.get(1).click();
    }
    public void deleteBook(){
     deleteAllBooks.get(2).click();
    }
    public void clickOnOK(){
        ok.click();
    }
    public void clickOnDeleteAccount(){
        deleteAccount.get(1).click();
    }
    public void clickOnBackToBookStore(){
        backToBook.get(0).click();
    }
    public void clickOnBinToDeleteBook(){
        Bin.click();
    }
}
