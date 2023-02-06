package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.LocalFileDetector;

import java.io.File;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ElementsPageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        formsPage = new FormsPage();
        alertFrameWindowsPage = new AlertFrameWindowsPage();
        widgetPage = new WidgetPage();
        interactionsPage = new InteractionsPage();
        bookStorePage = new BookStorePage();
        js =  (JavascriptExecutor) driver;



    }
    @Test
    public void userCanClickOnTextBox() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage. clickOnTextBox();
        String expectedURL1 = excelReader.getStringData("URL", 4, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String textBoxTitle = "Text Box";
        Assert.assertEquals(elementsPage.TextBoxHeader.getText(), textBoxTitle);

    }
    @Test
    public void userCanInsertAllDataInTextBox() throws InterruptedException {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnTextBox();
        String name = "Matija";
        String validEmail = "matijastn@gmail.com";
        String validCurrentAddress = "Gandijeva 122";
        String validPermanentAddress = "Vuka Karadzica 2";
        elementsPage.insertFullName(name);
        elementsPage.insertEmail(validEmail);
        elementsPage.insertCurrentAdress(validCurrentAddress);
        elementsPage.insertPermanentAdress(validPermanentAddress);
        elementsPage.clickOnSubmit();
        Assert.assertEquals(elementsPage.enteredName.getText(), "Name:"+name);
        Assert.assertEquals(elementsPage.enteredMail.getText() ,"Email:"+validEmail);
        Assert.assertEquals(elementsPage.enteredCurrentAddress.getText(), "Current Address :"+validCurrentAddress);
        Assert.assertEquals(elementsPage.enteredPermanentAddress.getText(), "Permananet Address :"+validPermanentAddress);
    }
    @Test
    public void userCanInsertPartialDataInTextBox() throws InterruptedException {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnTextBox();
        String name = "Iva";
        String noEmail = "";
        String noCurrentAddress = "";
        String noPermanentAddress = "";
        elementsPage.insertFullName(name);
        elementsPage.insertEmail(noEmail);
        elementsPage.insertCurrentAdress(noCurrentAddress);
        elementsPage.insertPermanentAdress(noPermanentAddress);
        elementsPage.clickOnSubmit();
        Assert.assertEquals(elementsPage.enteredName.getText(), "Name:"+name);
        String expectedURL1 = excelReader.getStringData("URL", 4, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);

    }
    @Test
    public void userCanInsertNothingInTextBox() {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnTextBox();
        String noName = "";
        String noEmail = "";
        String noCurrentAddress = "";
        String noPermanentAddress = "";
        elementsPage.insertFullName(noName);
        elementsPage.insertEmail(noEmail);
        elementsPage.insertCurrentAdress(noCurrentAddress);
        elementsPage.insertPermanentAdress(noPermanentAddress);
        elementsPage.clickOnSubmit();
        String expectedURL1 = excelReader.getStringData("URL", 4, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL1);
        String textBoxTitle = "Text Box";
        Assert.assertEquals(elementsPage.TextBoxHeader.getText(), textBoxTitle);

    }

    @Test
    public void clickOnCheckBox() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage. clickOnCheckBox();
        String expectedURL2 = excelReader.getStringData("URL", 4, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
        String checkBoxTitle = "Check Box";
        Assert.assertEquals(elementsPage.CheckBoxHeader.getText(), checkBoxTitle);
    }
    @Test
    public void userCanClickOnCheckBoxIcon() {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnCheckBox();
        elementsPage.clickOnCheckBoxIcon();
        String expectedURL2 = excelReader.getStringData("URL", 4, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
        String notification = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(elementsPage.ResultText.getText(), notification);

    }

    @Test
    public void clickOnRadioButton() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage. clickOnRadioButton();
        String expectedURL3 = excelReader.getStringData("URL", 4, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
        String radioButtonTitle = "Radio Button";
        Assert.assertEquals(elementsPage.RadioButtonHeader.getText(), radioButtonTitle);

    }
    @Test
    public void userCanClickOnRadioButtonYes()  {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnRadioButton();
        elementsPage.clickOnRadioButtonYes();
        Assert.assertEquals(elementsPage.YesNotification.getText(), "Yes");
        String expectedURL3 = excelReader.getStringData("URL", 4, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
    }
    @Test
    public void userCanClickOnRadioButtonImpressive() {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnRadioButton();
        elementsPage.clickOnRadioButtonImpressive();
        Assert.assertEquals(elementsPage.YesNotification.getText(), "Impressive");
        String expectedURL3 = excelReader.getStringData("URL", 4, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
    }
    @Test
    public void userCanClickOnRadioButtonDisabled() {
        homePage.clickOnCard("Elements");
        elementsPage. clickOnRadioButton();
        elementsPage.clickOnRadioButtonNo();
        String radioButtonTitle = "Radio Button";
        Assert.assertEquals(elementsPage.RadioButtonHeader.getText(), radioButtonTitle);
        String expectedURL3 = excelReader.getStringData("URL", 4, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL3);
    }
    @Test
    public void clickOnWebTables() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage. clickOnWebTables();
        String expectedURL4 = excelReader.getStringData("URL", 4, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL4);
        String webTablesTitle = "Web Tables";
        Assert.assertEquals(elementsPage.WebTablesHeader.getText(), webTablesTitle);
    }

    @Test
    public void userCanInsertDataInWebTables() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnWebTables();
        elementsPage.clickOnAdd();
        String validName = "Iva";
        elementsPage.insertFirstName(validName);
        String validLastName = "Stanic";
        elementsPage.insertLastName(validLastName);
        String validEmail = "ivastanic@gmail.com";
        elementsPage.insertUserEmail(validEmail);
        String validAge = "20";
        elementsPage.insertUserAge(validAge);
        String validSalary = "150000";
        elementsPage.insertUserSalary(validSalary);
        String validDepartment = "Health";
        elementsPage.insertUserDepartment(validDepartment);
        elementsPage.clickOnSubmitButton();
        Assert.assertEquals(elementsPage.userFields.get(21).getText(), validName);
        Assert.assertEquals(elementsPage.userFields.get(22).getText(), validLastName);
        Assert.assertEquals(elementsPage.userFields.get(23).getText(), validAge);
        Assert.assertEquals(elementsPage.userFields.get(24).getText(), validEmail);
        Assert.assertEquals(elementsPage.userFields.get(25).getText(), validSalary);
        Assert.assertEquals(elementsPage.userFields.get(26).getText(), validDepartment);
    }
    @Test
    public void userCanDeletDataInWebTables()  {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnWebTables();
        elementsPage.clickOnAdd();
        String validName = "Matija";
        elementsPage.insertFirstName(validName);
        String validLastName = "Stanic";
        elementsPage.insertLastName(validLastName);
        String validEmail = "matijastnc@gmail.com";
        elementsPage.insertUserEmail(validEmail);
        String validAge = "24";
        elementsPage.insertUserAge(validAge);
        String validSalary = "250000";
        elementsPage.insertUserSalary(validSalary);
        String validDepartment = "IT";
        elementsPage.insertUserDepartment(validDepartment);
        elementsPage.clickOnSubmitButton();
        Assert.assertEquals(elementsPage.userFields.get(21).getText(), validName);
        Assert.assertEquals(elementsPage.userFields.get(22).getText(), validLastName);
        Assert.assertEquals(elementsPage.userFields.get(23).getText(), validAge);
        Assert.assertEquals(elementsPage.userFields.get(24).getText(), validEmail);
        Assert.assertEquals(elementsPage.userFields.get(25).getText(), validSalary);
        Assert.assertEquals(elementsPage.userFields.get(26).getText(), validDepartment);
        elementsPage.clickOnDeleteIcon();
        Assert.assertNotEquals(elementsPage.userFields.get(21).getText(), validName);
        Assert.assertNotEquals(elementsPage.userFields.get(22).getText(), validLastName);
        Assert.assertNotEquals(elementsPage.userFields.get(23).getText(), validAge);
        Assert.assertNotEquals(elementsPage.userFields.get(24).getText(), validEmail);
        Assert.assertNotEquals(elementsPage.userFields.get(25).getText(), validSalary);
        Assert.assertNotEquals(elementsPage.userFields.get(26).getText(), validDepartment);
    }
    @Test
    public void userCanEditDataInWebTables() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnWebTables();
        elementsPage.clickOnAdd();
        String validName = "Masa";
        elementsPage.insertFirstName(validName);
        String validLastName = "Stanic";
        elementsPage.insertLastName(validLastName);
        String validEmail = "masastnc25@gmail.com";
        elementsPage.insertUserEmail(validEmail);
        String validAge = "10";
        elementsPage.insertUserAge(validAge);
        String validSalary = "100000";
        elementsPage.insertUserSalary(validSalary);
        String validDepartment = "Tourism";
        elementsPage.insertUserDepartment(validDepartment);
        elementsPage.clickOnSubmitButton();
        Assert.assertEquals(elementsPage.userFields.get(21).getText(), validName);
        Assert.assertEquals(elementsPage.userFields.get(22).getText(), validLastName);
        Assert.assertEquals(elementsPage.userFields.get(23).getText(), validAge);
        Assert.assertEquals(elementsPage.userFields.get(24).getText(), validEmail);
        Assert.assertEquals(elementsPage.userFields.get(25).getText(), validSalary);
        Assert.assertEquals(elementsPage.userFields.get(26).getText(), validDepartment);
        elementsPage.clickOnEditIcon();
        String newSalary = "350000";
        elementsPage.UserSalary.clear();
        elementsPage.insertUserSalary(newSalary);
        elementsPage.clickOnSubmitButton();
        Assert.assertEquals(elementsPage.userFields.get(25).getText(), newSalary);

    }
    @Test
    public void clickOnButtons() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage.clickOnButtons();
        String expectedURL5 = excelReader.getStringData("URL", 4, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL5);
        String buttonsTitle = "Buttons";
        Assert.assertEquals(elementsPage.ButtonsHeader.getText(), buttonsTitle);
    }
    @Test
    public void clickOnDoubleClickButton() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnButtons();
        Actions act = new Actions(driver);
        act.doubleClick(elementsPage.DoubleClick).perform();
        Assert.assertTrue(isDisplayed(elementsPage.DoubleClickMessage));
        String expectedURL5 = excelReader.getStringData("URL", 4, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL5);

    }
    @Test
    public void clickOnRightClickButton() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnButtons();
        Actions act = new Actions(driver);
        act.contextClick(elementsPage.RightClickButton).perform();
        Assert.assertTrue(isDisplayed(elementsPage.RightClickMessage));
        String expectedURL5 = excelReader.getStringData("URL", 4, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL5);

    }

    @Test
    public void clickOnLeftClickButton() throws InterruptedException {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnButtons();
        Thread.sleep(2000);
        elementsPage.clickOnLeftClickButton();
        Assert.assertTrue(isDisplayed(elementsPage.LeftClickMessage));
        String expectedURL5 = excelReader.getStringData("URL", 4, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL5);

    }
    @Test
    public void clickOnLinks() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage.clickOnLinks();
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);
        String linksTitle = "Links";
        Assert.assertEquals(elementsPage.LinksHeader.getText(), linksTitle);
    }

    @Test
    public void clickOnStaticHomeLink() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        String originalWindow = driver.getWindowHandle();
        elementsPage.clickOnHomeSimpleLink();
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);
        wdwait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);


    }
    @Test
    public void clickOnDynamicHomeLink() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        String originalWindow = driver.getWindowHandle();
        elementsPage.clickOnHomeDynamicLink();
       // String newWindow = driver.getWindowHandle();
      //  System.out.println(originalWindow);
      //  System.out.println(newWindow);
      String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);
       wdwait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);


    }

    @Test
    public void clickOnCreatedAPI() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnHomeCreatedAPILink();
        String message = "Link has responded with staus 201 and status text Created";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnNoContentAPI() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnNoContentLink();
        String message1 = "Link has responded with staus 204 and status text No Content";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message1);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnMovedAPI() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnMovedLink();
        String message2 = "Link has responded with staus 301 and status text Moved Permanently";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message2);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnBadRequestAPI() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnBadRequestLink();
        String message2 = "Link has responded with staus 400 and status text Bad Request";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message2);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnUnauthorizedAPI() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnUnauthorizedLink();
        String message2 = "Link has responded with staus 401 and status text Unauthorized";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message2);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnForbiddenAPI() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnForbiddenLink();
        String message2 = "Link has responded with staus 403 and status text Forbidden";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message2);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnNotFound() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinks();
        elementsPage.clickOnNotFoundLink();
        String message2 = "Link has responded with staus 404 and status text Not Found";
        waitForVisibility(elementsPage.ApiResponse);
        Assert.assertEquals(elementsPage.ApiResponse.getText(), message2);
        String expectedURL6 = excelReader.getStringData("URL", 4, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL6);


    }
    @Test
    public void clickOnBrokenLinks() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        elementsPage.clickOnBrokenLinks();
        String expectedURL7 = excelReader.getStringData("URL", 4, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL7);
        String brokenLinksTitle = "Broken Links - Images";
        Assert.assertEquals(elementsPage.BrokenLinksHeader.getText(), brokenLinksTitle);
    }
    @Test
    public void clickOnValidLink() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnBrokenLinks();
        elementsPage.clickOnValidLink();
        Assert.assertFalse(isDisplayed(elementsPage.BrokenLinksHeader) );
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);

    }
    @Test
    public void clickOnBrokenLink() {
        homePage.clickOnCard("Elements");
        elementsPage.clickOnBrokenLinks();
        elementsPage.clickOnBrokenLink();
        Assert.assertFalse(isDisplayed(elementsPage.BrokenLinksHeader) );
        String statusCode500 = "http://the-internet.herokuapp.com/status_codes/500";
        Assert.assertEquals(driver.getCurrentUrl(), statusCode500);

    }
    @Test
    public void clickOnUploadAndDownload() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnUploadDownload();
        String expectedURL8 = excelReader.getStringData("URL", 4, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL8);
        String uploadDownloadTitle = "Upload and Download";
        Assert.assertEquals(elementsPage.UploadDownloadHeader.getText(), uploadDownloadTitle);
    }
    @Test
    public void clickOnUploadButton()  {
        homePage.clickOnCard("Elements");
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnUploadDownload();
        waitForVisibility(elementsPage.UploadButton);
        String filePath = "C:\\Users\\HP\\Desktop\\upload\\sampleFile.jpeg";
        elementsPage.clickOnUploadButton(filePath);
        waitForVisibility(elementsPage.UploadedNotification);
        Assert.assertTrue(isDisplayed(elementsPage.UploadedNotification));
        String path = "C:\\fakepath\\sampleFile.jpeg";
        Assert.assertEquals(elementsPage.UploadedNotification.getText(), path );

    }

    @Test
    public void clickOnDownloadButton() throws InterruptedException {
        homePage.clickOnCard("Elements");
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnUploadDownload();
        elementsPage.clickOnDownloadButton();
        Thread.sleep(3000);
        String downloadPath = "C:\\Users\\HP\\Downloads";
        File getLatestFile = elementsPage.getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        Assert.assertTrue(fileName.equals("sampleFile.jpeg"));
        String expectedURL8 = excelReader.getStringData("URL", 4, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL8);

    }
    @Test
    public void clickOnDynamicProperties() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        js.executeScript("window.scrollBy(0,550)", "");
        elementsPage.clickOnDynamicProperties();
        String expectedURL9 = excelReader.getStringData("URL", 4, 8);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL9);
        String dynamicPropertiesTitle = "Dynamic Properties";
        Assert.assertEquals(elementsPage.DynamicPropertiesHeader.getText(), dynamicPropertiesTitle);
    }
    @Test
    public void clickOnDynamicChanges() throws InterruptedException {
        homePage.clickOnCard("Elements");
        js.executeScript("window.scrollBy(0,550)", "");
        elementsPage.clickOnDynamicProperties();
        waitForVisibility(elementsPage.EnableAfter);
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(elementsPage.VisibleAfter));
        Assert.assertTrue(isDisplayed(elementsPage.RedColorText));

    }

  @Test
  public void clickOnPractiseFormOnElementPage() {
      homePage.clickOnCard("Elements");
      String expectedURL = excelReader.getStringData("URL", 1, 2);
      Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
      wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.TextBox));
      //js.executeScript("window.scrollBy(0,550)", "");
      elementsPage.clickOnClose();
      wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.bookStore.get(5)));
      elementsPage.clickOnFormsSubmenu();
    //  js.executeScript("window.scrollBy(0,750)", "");
      elementsPage.clickOnPractiseform();
      String expectedURL10 = excelReader.getStringData("URL", 7, 0);
      Assert.assertEquals(driver.getCurrentUrl(), expectedURL10);
      String practise = "Practice Form";
      Assert.assertEquals(formsPage.PractiseFormsHeader.getText(), practise);
  }
    @Test
    public void clickOnModalDialogOnElementPage() {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.TextBox));
        //js.executeScript("window.scrollBy(0,550)", "");
        elementsPage.clickOnClose();
       //wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.bookStore.get(5)));
        elementsPage.clickOnAlertsSubmenu();
        js.executeScript("window.scrollBy(0,450)", "");
        wdwait.until(ExpectedConditions.elementToBeClickable(alertFrameWindowsPage.modalDialogs.get(1)));
        elementsPage.clickOnModalDialog();
        String expectedURL10 = excelReader.getStringData("URL", 10, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL10);
        String modalDialogTitle = "Modal Dialogs";
        Assert.assertEquals(alertFrameWindowsPage.ModalDialogHeader.getText(), modalDialogTitle);
    }


    @Test
    public void clickOnSelectMenuOnElementPage() throws InterruptedException {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.TextBox));
        elementsPage.clickOnClose();
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.widget.get(3)));
        elementsPage.clickOnWidgetSubmenu();
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.select.get(1)));
        scrollToElement(elementsPage.select.get(1));
     //  wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.select.get(1)));
        elementsPage.clickOnSelectMenu();
        String expectedURL10 = excelReader.getStringData("URL", 13, 8);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL10);
        String selectMenuTitle = "Select Menu";
        Assert.assertEquals(widgetPage.SelectMenuHeader.getText(), selectMenuTitle);
    }

    @Test
    public void clickOnDraggableOnElementPage() throws InterruptedException {
        homePage.clickOnCard("Elements");
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.TextBox));
        elementsPage.clickOnClose();
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.interaction.get(4)));
        elementsPage.clickOnInteractionsSubmenu();
        wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.draggable.get(3)));
       scrollToElement(elementsPage.draggable.get(3));
        //  wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.select.get(1)));
        elementsPage.clickOnDraggable();
        String expectedURL10 = excelReader.getStringData("URL", 16, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL10);
        String draggableTitle = "Dragabble";
        Assert.assertEquals(interactionsPage.DraggableHeader.getText(), draggableTitle);
    }



    /*Bug na ovoj strani(https://demoqa.com/elements), ali i na stranama: https://demoqa.com/forms , https://demoqa.com/alertsWindows ,
     https://demoqa.com/widgets , https://demoqa.com/interaction - za korisnika je potpuno nemoguće da skroluje do poslednjeg buttona
    Book Store API(postavljen je fixedban preko njega)*/

  @Test
  public void clickOnBookStoreApiOnElementPage() {
      homePage.clickOnCard("Elements");
      String expectedURL = excelReader.getStringData("URL", 1, 2);
      Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
      wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.TextBox));
      //js.executeScript("window.scrollBy(0,550)", "");
      elementsPage.clickOnClose();
      wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.bookStore.get(5)));
      elementsPage.clickOnBookStore();
      // js.executeScript("window.scrollBy(0,750)", "");
      wdwait.until(ExpectedConditions.elementToBeClickable(elementsPage.bookstoreApi.get(4)));
      scrollToElement(elementsPage.bookstoreApi.get(4));
      elementsPage.clickOnBookStoreApi();
      String expectedURL10 = excelReader.getStringData("URL", 19, 3);
      Assert.assertEquals(driver.getCurrentUrl(), expectedURL10);

  }

    @AfterMethod
    public void driverClose()   {

        driver.quit();
    }

}
