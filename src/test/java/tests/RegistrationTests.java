package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    int i=new Random().nextInt(1000)+1000;

    @Test
    public void RegistrationTestSuccess(){
        int i=new Random().nextInt(1000)+1000;
        boolean result = new AuthenticationScreen(driver)
                .fillEmail("sonicboom"+i+"@gmail.com")
                .fillPassword("Snow123456!")
                .submitRegistartion()
                .isActivityTitle("Contact list");
        Assert.assertTrue(result);

    }
    @Test
    public void registrationWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("sonicboomgmail.com").password("Snow123456!").build())
                .submitRegistrationNegative()
                .isErrorMessageHasText("username=must be a well-formed email address");

    }
    @Test
    public void registrationWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("sonicboom@gmail.com").password("Snow123456").build())
                .submitRegistrationNegative()
                .isErrorMessageHasText("At least 8 characters");

    }
    @AfterMethod
    public void postConditioin(){
        new ContactListScreen(driver).logout();
    }
}
