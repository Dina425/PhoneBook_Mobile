package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextView;
    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement menuOption;
    @FindBy(xpath = "//*[@text='Logout']")
    AndroidElement logoutButton;
    @FindBy(id="com.sheygam.contactapp:id/add_contact_btn")
    AndroidElement plusBtn;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<AndroidElement> contactNameList;
    @FindBy(xpath = "")
    List<AndroidElement> contactList;

    public boolean isActivityTitle(String text){
        //return activityTextView.getText().contains("Contact list");
        return isShouldHave(activityTextView,text,10);

    }
    public  AuthenticationScreen logout(){
        if(activityTextView.getText().equals("Contact list")){
        menuOption.click();
        logoutButton.click();
        }
        return new AuthenticationScreen(driver);
    }

    public ContactListScreen isAccountOpened() {
        Assert.assertTrue(isActivityTitle("Contact list"));
        return this;
    }
    public AddNewContactScreen openContactForm(){
        //if (activityTextView.getText().equals("Contact list")) {

            plusBtn.click();

        return new AddNewContactScreen(driver);
    }

    public ContactListScreen isContactAddedByName(String name, String lastname) {
    isShouldHave(activityTextView,"Contact list",5);


    boolean isPresent=false;
    for (AndroidElement el:contactNameList) {
        if (el.getText().equals(name + " " + lastname)) {
            isPresent = true;
            break;
        }
    }
Assert.assertTrue(isPresent);
    return this;
    }

    public ContactListScreen deleteFirstContact(){

        AndroidElement first=contactList.get(0);
        Rectangle rectangle=first.getRect();
        int xFrom=rectangle.getX()+rectangle.getWidth()/8;
        int y=rectangle.getY()+rectangle.getHeight()/2;
        int xTo=rectangle.getWidth()-xFrom;
        //TouchAction<?> touchAction=new TouchAction<>(driver);
        //touchAction.longPress(PointOption.point(xFrom,y)).moveTo(PointOption.point(xTo,y)).release



        return this;
    }
}
