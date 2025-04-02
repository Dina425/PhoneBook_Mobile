package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactsTests extends AppiumConfig {
   @BeforeClass
   public void preCondition(){
       new AuthenticationScreen(driver).fillLoginRegistrationForm(Auth.builder().email("sonicboom@gmail.com")
                       .password("Snow123456!").build())
               .submitLogin();
   }


    @Test
    public void createNewContactSuccess(){
       int i=new Random().nextInt(1000)+1000;
        Contact contact= Contact.builder()
                .name("Sims")
                .lastname("Koshak"+i)
                .phone("24234234234"+i)
                .email("Kot"+i+"@gmail.com")
                .address("Lindt")
                .description("Best of the Best")
                .build();

        new ContactListScreen(driver).openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastname());

    }
    @Test
    public void createNewContactSuccessReq(){
        int i=new Random().nextInt(1000)+1000;
        Contact contact= Contact.builder()
                .name("Sims")
                .lastname("Koshak"+i)
                .phone("24234234234"+i)
                .email("Kot"+i+"@gmail.com")
                .address("Lindt")
                .build();

        new ContactListScreen(driver).openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastname());

    }
    @Test
    public void createContactWithEmptyName(){
        Contact contact= Contact.builder()
                .name("")
                .lastname("Koshak")
                .phone("2423423423423")
                .email("Kot@gmail.com")
                .address("Lindt")
                .build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageHasText("name=must not be blank");
        driver.navigate().back();
    }
    @AfterClass
    public void postCondition(){
       new ContactListScreen(driver).logout();
    }

}
