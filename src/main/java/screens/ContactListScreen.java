package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    @FindBy()
    AndroidElement plusBtn;

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
        plusBtn.click();
        return new AddNewContactScreen(driver);
    }
}
