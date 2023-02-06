package DemoQA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static DemoQA.Base.BaseTest.driver;

public class ElementsPage {
    public ElementsPage() {
        PageFactory.initElements(driver, this);

    }

  /* @FindBy(className = "menu-list")
    public List<WebElement> meni;*/
    @FindBy(id = "item-0")
    public
  WebElement TextBox;
    @FindBy(id = "item-1")
    WebElement CheckBox;
    @FindBy(id = "item-2")
    WebElement RadioButton;
    @FindBy(id = "item-3")
    WebElement WebTables;
    @FindBy(id = "item-4")
    WebElement Buttons;
    @FindBy(id = "item-5")
    WebElement Links;
    @FindBy(id = "item-6")
    WebElement BrokenLinks;
    @FindBy(id = "item-7")
    WebElement Upload;
    @FindBy(id = "item-8")
    WebElement DynamicProperties;

    @FindBy(className = "main-header")
    public
    WebElement ElementsHeader;
    @FindBy(className = "main-header")
    public
    WebElement TextBoxHeader;
    @FindBy(className = "main-header")
    public
    WebElement CheckBoxHeader;
    @FindBy(className = "main-header")
    public
    WebElement RadioButtonHeader;
  @FindBy(className = "main-header")
  public
  WebElement WebTablesHeader;
  @FindBy(className = "main-header")
  public
  WebElement ButtonsHeader;
  @FindBy(className = "main-header")
  public
  WebElement LinksHeader;
  @FindBy(className = "main-header")
  public
  WebElement BrokenLinksHeader;
  @FindBy(className = "main-header")
  public
  WebElement UploadDownloadHeader;
  @FindBy(className = "main-header")
  public
  WebElement DynamicPropertiesHeader;

    @FindBy(id = "element-group")
    List<WebElement> forms;

    @FindBy(className = "header-right")
    public
    List<WebElement> iconClose;
    @FindBy(className = "element-group")
    public
    List<WebElement> bookStore;
    @FindBy(id = "item-4")
    public
    List<WebElement> bookstoreApi;
    @FindBy(className = "element-group")
    public
    List<WebElement>formssubmeni;

    @FindBy(id = "item-0")
    public
    List<WebElement>practise;
    @FindBy(className = "element-group")
    public
    List<WebElement>alert;
    @FindBy(id = "item-4")
    public
    List<WebElement>modal;
    @FindBy(className = "element-group")
    public
    List<WebElement>widget;
    @FindBy(id = "item-8")
    public
    List<WebElement>select;
    @FindBy(className = "header-text")
    public
    List<WebElement>interaction;
    @FindBy(id = "item-4")
    public
    List<WebElement>draggable;
  @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input")
  public
  WebElement fullName;
  @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input")
  WebElement email2;

@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/textarea")
WebElement cadress;
  @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[2]/textarea")
 WebElement padress;
  @FindBy(id="submit")
  WebElement SubmitButton;

  @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[1]")
  public
  WebElement enteredName;
  @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[2]")
  public
  WebElement enteredMail;
  @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")
  public
  WebElement enteredCurrentAddress;
    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")
    public
    WebElement enteredPermanentAddress;
    @FindBy(className = "rct-checkbox")
    WebElement CheckboxIcon;
    @FindBy(id = "result")
    public
    WebElement ResultText;
    @FindBy(className = "custom-control-label")
    public
   List <WebElement> RadioButtons;

    @FindBy(className = "text-success")
    public
    WebElement YesNotification;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/button")
    public
    WebElement AddUser;
    @FindBy (id="firstName")
    WebElement firstName;

    @FindBy (id="lastName")
    WebElement lastName;
    @FindBy (id="userEmail")
    WebElement UserEmail;
    @FindBy (id="age")
    WebElement UserAge;
    @FindBy (id="salary")
    public
    WebElement UserSalary;
    @FindBy (id="department")
    WebElement UserDepartment;
    @FindBy (id="submit")
    WebElement ButtonSubmit;
    @FindBy (className =  "rt-td")
    public
    List <WebElement> userFields;
    @FindBy (id="edit-record-4")
    WebElement EditIcon;
    @FindBy(id = "delete-record-4")
    WebElement DeleteIcon;
    @FindBy(id = "doubleClickBtn")
    public
    WebElement DoubleClick;
    @FindBy(id="doubleClickMessage")
    public
    WebElement DoubleClickMessage;
    @FindBy(id="rightClickBtn")
    public
    WebElement RightClickButton;
    @FindBy(id="rightClickMessage")
    public
    WebElement RightClickMessage;
    @FindBy (css=".btn.btn-primary")
    public
    List<WebElement> clickButton;
    @FindBy(id="dynamicClickMessage")
    public
    WebElement LeftClickMessage;
    @FindBy(linkText = "Click Here for Valid Link")
    public
    WebElement ValidLink;
    @FindBy(linkText = "Click Here for Broken Link")
    public
    WebElement BrokenLink;
    @FindBy(id="simpleLink")
    WebElement HomeSimpleLink;
    @FindBy(id ="dynamicLink")
    WebElement HomeDynamicLink;
    @FindBy(id ="created")
    public
    WebElement APICreated;
    @FindBy(id = "linkResponse")
    public
    WebElement ApiResponse;
    @FindBy(id ="no-content")
    public
    WebElement APINoContent;
    @FindBy(id ="moved")
    public
    WebElement APIMoved;
    @FindBy(id ="bad-request")
    public
    WebElement APIBadRequest;
    @FindBy(id ="unauthorized")
    public
    WebElement APIUnauthorized;
    @FindBy(id ="forbidden")
    public
    WebElement APIForbidden;
    @FindBy(id ="invalid-url")
    public
    WebElement APINotFound;
    @FindBy(id ="enableAfter")
    public
    WebElement EnableAfter;
    @FindBy(id ="visibleAfter")
    public
    WebElement VisibleAfter;
    @FindBy(css =".mt-4.text-danger.btn.btn-primary")
    public
    WebElement RedColorText;
    @FindBy(id ="downloadButton")
    public
    WebElement DownloadButton;
    @FindBy(id= "uploadFile")
    public
    WebElement UploadButton;
    @FindBy(id="uploadedFilePath")
    public
    WebElement UploadedNotification;

    //------------------------------------------------------
  /*  public void clickOnMenu() {
      for (int i = 0; i < meni.size(); i++) {
                meni.get(i).click();
                break;

        }
    }*/

    public void clickOnTextBox(){
        TextBox.click();
    }
    public void clickOnCheckBox(){
        CheckBox.click();
    }
    public void clickOnRadioButton(){
        RadioButton.click();
    }
    public void clickOnWebTables(){
        WebTables.click();
    }
    public void clickOnButtons(){
        Buttons.click();
    }
    public void clickOnLinks(){
        Links.click();
    }
    public void clickOnBrokenLinks(){
        BrokenLinks.click();
    }
    public void clickOnUploadDownload(){
        Upload.click();
    }
    public void clickOnDynamicProperties(){
        DynamicProperties.click();
    }
    public void clickOnForms(){
        forms.get(1).click();
    }
    public void clickOnClose(){
        iconClose.get(0).click();
    }
    public void clickOnBookStore(){
        bookStore.get(5).click();
    }
    public void clickOnBookStoreApi(){
        bookstoreApi.get(4).click();
    }
    public void clickOnFormsSubmenu(){
        formssubmeni.get(1).click();
    }
    public void clickOnPractiseform(){
        practise.get(1).click();
    }
    public void clickOnAlertsSubmenu(){
        alert.get(2).click();
    }
    public void clickOnModalDialog(){
        modal.get(1).click();
    }
    public void clickOnWidgetSubmenu() {
        widget.get(3).click();
    }
        public void clickOnSelectMenu(){
            select.get(1).click();
        }
    public void clickOnInteractionsSubmenu() {
        interaction.get(4).click();
    }
    public void clickOnDraggable(){
        draggable.get(3).click();
    }

    public void insertFullName(String name){
      fullName.sendKeys(name);
    }
    public void insertEmail(String email1){
      email2.sendKeys(email1);

    }
  public void insertCurrentAdress(String cadress1){
    cadress.sendKeys(cadress1);

  }
  public void insertPermanentAdress(String padress1){
    padress.sendKeys(padress1);

  }
  public void clickOnSubmit(){
  SubmitButton.click();
  }
    public void clickOnCheckBoxIcon(){
        CheckboxIcon.click();
    }
    public void clickOnRadioButtonYes(){
        RadioButtons.get(0).click();
    }
    public void clickOnRadioButtonImpressive(){
        RadioButtons.get(1).click();
    }
    public void clickOnRadioButtonNo(){
        RadioButtons.get(2).click();
    }
    public void clickOnAdd(){
        AddUser.click();
    }
    public void insertFirstName(String firstName1){
        firstName.sendKeys(firstName1);
    }
    public void insertLastName(String lastName1){
        lastName.sendKeys(lastName1);
    }
    public void insertUserEmail(String email1){
        UserEmail.sendKeys(email1);
    }
    public void insertUserAge(String age1){
        UserAge.sendKeys(age1);
    }
    public void insertUserSalary(String salary1){
        UserSalary.sendKeys(salary1);
    }
    public void insertUserDepartment(String department1){
        UserDepartment.sendKeys(department1);
    }
    public void clickOnSubmitButton(){
        ButtonSubmit.click();
    }
    public void clickOnEditIcon(){
        EditIcon.click();
    }
    public void clickOnDeleteIcon(){
        DeleteIcon.click();
    }
    public void clickOnLeftClickButton(){
        clickButton.get(2).click();}
    public void clickOnValidLink(){
        ValidLink.click();
    }

public void clickOnBrokenLink(){
        BrokenLink.click();
}
public  void clickOnHomeSimpleLink(){
        HomeSimpleLink.click();
}
    public  void clickOnHomeDynamicLink(){
        HomeDynamicLink.click();
    }
    public  void clickOnHomeCreatedAPILink(){
        APICreated.click();
    }
    public  void clickOnNoContentLink(){
        APINoContent.click();
    }
    public  void clickOnMovedLink(){
        APIMoved.click();
    }
    public  void clickOnBadRequestLink(){
        APIBadRequest.click();
    }
    public  void clickOnUnauthorizedLink(){
        APIUnauthorized.click();
    }
    public  void clickOnForbiddenLink(){
        APIForbidden.click();
    }
    public  void clickOnNotFoundLink(){
        APINotFound.click();
    }
    public  void clickOnDownloadButton(){
        DownloadButton.click();
    }
    public  void clickOnUploadButton(String keys){
        UploadButton.sendKeys(keys);
    }
    public File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public void fileUploadUsingRobot(String filePath) {
        //try{
        Robot robot= null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        StringSelection ss = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            robot.delay(3000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);

//        }
//        catch(Exception e) {
//            log.error(e);
//        }
    }
}