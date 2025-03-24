package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {


    @Test
    public void loginSuccess(){
        boolean result = new AuthenticationScreen(driver)
                //.checkCurrentVersion("Version 1.0.0")
                .fillEmail("sonicboom@gmail.com")
                .fillPassword("Snow123456!")
                .submitLogin()
                .isActivityTitle("Contact list");
        Assert.assertTrue(result);
    }
    @Test
public void loginSuccessModel(){
       Assert.assertTrue( new AuthenticationScreen(driver)
            //.checkCurrentVersion("Version 1.0.0")
            .fillLoginRegistrationForm(Auth.builder().email("sonicboom@gmail.com").password("Snow123456!").build())
            .submitLogin()
            .isActivityTitle("Contact list"));

    }
    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("sonicboomgmail.com").password("Snow123456!").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");

    }

    @Test
    public void loginWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("sonicboom@gmail.com").password("now123456!").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");

    }
    @AfterMethod
    public void postConditioin(){
        new ContactListScreen(driver).logout();
    }
}
