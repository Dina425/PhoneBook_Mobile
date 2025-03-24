package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy()
    AndroidElement nameEditText;
    @FindBy()
    AndroidElement lastnameEditText;
    @FindBy()
    AndroidElement emailEditText;
    @FindBy()
    AndroidElement phoneEditText;
    @FindBy()
    AndroidElement addressEditText;
    @FindBy()
    AndroidElement descriptionEditText;
    @FindBy()
    AndroidElement createBtn;

    public AddNewContactScreen fillContactForm(Contact contact){
        should(nameEditText,5);
        type(nameEditText, contact.getName());
        type(lastnameEditText, contact.getLastname());
        type(emailEditText, contact.getEmail());
        type(phoneEditText, contact.getPhone());
        type(addressEditText, contact.getAddress());
        type(descriptionEditText, contact.getDescription());
        return this;
    }
    public ContactListScreen submitContactForm(){
        createBtn.click();
        return new ContactListScreen(driver);
    }
}
