package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginSecondTests extends AppiumConfig {
@Test
    public void loginSuccess(){
    new AuthenticationScreen(driver)
            .fillEmail("sonicboom@gmail.com")
            .fillPassword("Snow123456!")
            .submitLogin()
            .isAccountOpened()
            .logout();
}
    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("sonicboom@gmail.com").password("Snow123456!").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("sonicboomgmail.com").password("Snow123456!").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");

    }

}
