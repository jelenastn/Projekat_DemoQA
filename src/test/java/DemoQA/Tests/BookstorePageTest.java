package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.BookStorePage;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class BookstorePageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        bookStorePage = new BookStorePage();
        js =  (JavascriptExecutor) driver;

    }
    @Test
    public void userCanLoginAndLogoutWithValidCredentials() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        for (int i = 1; i< excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", i, 0);
            String validPassword = excelReader.getStringData("Login", i, 1);
            bookStorePage.insertUsername(validUsername);
            bookStorePage.insertPassword(validPassword);
            bookStorePage.clickOnLoginButton();
            String expectedURL2 = excelReader.getStringData("URL", 19, 0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
            wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.logoutButton));
            Assert.assertTrue(isDisplayed(bookStorePage.logoutButton));
            bookStorePage.clickOnLogOutButton();
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
            Assert.assertFalse(isDisplayed(bookStorePage.logoutButton));

        }

    }
    @Test
    public void userCanNotLoginWithoutUsername() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        for (int i = 1; i< excelReader.getLastRow("Login"); i++) {
            js.executeScript("window.scrollBy(0,250)", "");
            wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.login.get(5)));
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
            String noUsername = "";
            String validPassword = excelReader.getStringData("Login", i, 1);
            bookStorePage.insertUsername(noUsername);
            bookStorePage.insertPassword(validPassword);
            bookStorePage.clickOnLoginButton();
            String expectedURL2 = excelReader.getStringData("URL", 19, 2);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL2);
            Assert.assertFalse(isDisplayed(bookStorePage.logoutButton));
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

        }

    }

    @Test
    public void userCanNotLoginWithoutPassword() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        for (int i = 1; i< excelReader.getLastRow("Login"); i++) {
            js.executeScript("window.scrollBy(0,250)", "");
            wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.login.get(5)));
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
            String validUsername = excelReader.getStringData("Login", i, 0);
            String noPassword = "";
            bookStorePage.insertUsername(validUsername);
            bookStorePage.insertPassword(noPassword);
            bookStorePage.clickOnLoginButton();
            String expectedURL2 = excelReader.getStringData("URL", 19, 2);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL2);
            Assert.assertFalse(isDisplayed(bookStorePage.logoutButton));
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

        }

    }
    @Test
    public void userCanNotLoginWithoutPasswordAndUsername() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.login.get(5)));
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String noUsername = "";
        String noPassword = "";
        bookStorePage.insertUsername(noUsername);
        bookStorePage.insertPassword(noPassword);
        bookStorePage.clickOnLoginButton();
        String expectedURL2 = excelReader.getStringData("URL", 19, 2);
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL2);
        Assert.assertFalse(isDisplayed(bookStorePage.logoutButton));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

    }
    @Test
    public void userCanNotLoginWithInvalidPassword() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        for (int i = 1; i< excelReader.getLastRow("InvalidPassword"); i++) {
            js.executeScript("window.scrollBy(0,250)", "");
            wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.login.get(5)));
            bookStorePage.clickOnLogin();
            String expectedURL1 = excelReader.getStringData("URL", 19, 0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
            String validUsername = excelReader.getStringData("InvalidPassword", i, 1);
            String invalidPassword = excelReader.getStringData("InvalidPassword", i, 0);
            bookStorePage.insertUsername(validUsername);
            bookStorePage.insertPassword(invalidPassword);
            bookStorePage.clickOnLoginButton();
            String expectedURL2 = excelReader.getStringData("URL", 19, 2);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL2);
            Assert.assertFalse(isDisplayed(bookStorePage.logoutButton));
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
            driver.navigate().back();
        }

    }


    @Test
    public void userCanClickOnBookStoreMenu() {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,350)", "");
        bookStorePage.clickOnBookStore();
        String expectedURL1 = excelReader.getStringData("URL", 19, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        Assert.assertTrue(isDisplayed(bookStorePage.loginButton));

    }

    @Test(priority = 10)
    public void userCanOrderBook() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        js.executeScript("window.scrollBy(0,250)", "");
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

            String validUsername = excelReader.getStringData("Login", 1, 0);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            bookStorePage.insertUsername(validUsername);
            bookStorePage.insertPassword(validPassword);
            bookStorePage.clickOnLoginButton();
            String expectedURL2 = excelReader.getStringData("URL", 19, 0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);

            wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.GoToStore));
           bookStorePage.goToBookStoreButton();

           wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book1));
           bookStorePage.clickOnBook1();
           wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage. addButton.get(1)));
           bookStorePage.clickOnAddToYourCollection();

           Thread.sleep(3000);
           driver.switchTo().alert().accept();

           wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.profile.get(4)));
           js.executeScript("window.scrollBy(0,550)", "");
           bookStorePage.clickOnProfile();
           String expectedURL3 = excelReader.getStringData("URL", 19, 2);
           Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
          wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book1));
           Assert.assertTrue(isDisplayed(bookStorePage.book1));

        }


    @Test(priority = 20)
    public void userCanSeeOrderedBookAfterNewLogIn(){
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        js.executeScript("window.scrollBy(0,250)", "");
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        bookStorePage.insertUsername(validUsername);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        String expectedURL2 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book1));
        Assert.assertTrue(isDisplayed(bookStorePage.book1));


    }
    @Test(priority = 30)
    public void userCanDeleteOrderedBook() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        js.executeScript("window.scrollBy(0,250)", "");
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        bookStorePage.insertUsername(validUsername);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        String expectedURL2 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book1));
        Assert.assertTrue(isDisplayed(bookStorePage.book1));
        bookStorePage.clickOnBinToDeleteBook();
       //bookStorePage.deleteBook();
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.ok));
        bookStorePage.clickOnOK();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Assert.assertFalse(isDisplayed(bookStorePage.book1));
        String expectedURL3 = excelReader.getStringData("URL", 19, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
    }


    //Registrovati usera (userForDeleting) pre svakog testiranja
    @Test
    public void userCanBeDeleted() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        js.executeScript("window.scrollBy(0,250)", "");
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

        String validUsername = excelReader.getStringData("UserForDeleting", 1, 0);
        String validPassword = excelReader.getStringData("UserForDeleting", 1, 1);
        bookStorePage.insertUsername(validUsername);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        String expectedURL2 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
        Thread.sleep(3000);
        bookStorePage.clickOnDeleteAccount();
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.ok));
        bookStorePage.clickOnOK();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Assert.assertTrue(isDisplayed(bookStorePage.loginButton));
        Assert.assertFalse(isDisplayed(bookStorePage.logoutButton));


    }
    @Test
    public void userCanOrderAndDeleteTwoBooks() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        js.executeScript("window.scrollBy(0,250)", "");
        bookStorePage.clickOnLogin();
        String expectedURL1 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

        String validUsername = excelReader.getStringData("Login", 2, 0);
        String validPassword = excelReader.getStringData("Login", 2, 1);
        bookStorePage.insertUsername(validUsername);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        String expectedURL2 = excelReader.getStringData("URL", 19, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);

        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.GoToStore));
        bookStorePage.goToBookStoreButton();

        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book1));
        bookStorePage.clickOnBook1();
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage. addButton.get(1)));
        bookStorePage.clickOnAddToYourCollection();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        bookStorePage.clickOnBackToBookStore();
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book2));
        bookStorePage.clickOnBook2();
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage. addButton.get(1)));
        bookStorePage.clickOnAddToYourCollection();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.profile.get(4)));
        js.executeScript("window.scrollBy(0,550)", "");
        bookStorePage.clickOnProfile();
        String expectedURL3 = excelReader.getStringData("URL", 19, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.book1));
        Assert.assertTrue(isDisplayed(bookStorePage.book1));
        Assert.assertTrue(isDisplayed(bookStorePage.book2));
        js.executeScript("window.scrollBy(0,550)", "");
        bookStorePage.deleteBook();
        wdwait.until(ExpectedConditions.elementToBeClickable(bookStorePage.ok));
        bookStorePage.clickOnOK();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Assert.assertFalse(isDisplayed(bookStorePage.book1));
        Assert.assertFalse(isDisplayed(bookStorePage.book2));


    }
    @Test
    public void UserCanClickOnProfile() {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        scrollToElement(bookStorePage.profile.get(4));
        waitForClickability(bookStorePage.profile.get(4));
        bookStorePage.clickOnProfile();
        String expectedURL1 = excelReader.getStringData("URL", 19, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String title = "Profile";
        Assert.assertEquals(bookStorePage.BookStoreProfileHeader.getText(), title);

    }
    @Test
    public void userCanClickOnBookStoreAPI() throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.clickOnCard("Book Store Application");
        String expectedURL = excelReader.getStringData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        scrollToElement(bookStorePage.bookStoreApi.get(4));
        waitForClickability(bookStorePage.bookStoreApi.get(4));
        bookStorePage.clickOnBookStoreAPI();
        String expectedURL1 = excelReader.getStringData("URL", 19, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        waitForVisibility(bookStorePage.BookStoreAPIHeader);
        String titleAPI = "Book Store API\n" +
                " v1 ";
        Assert.assertEquals(bookStorePage.BookStoreAPIHeader.getText(), titleAPI);

    }

    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }



}
