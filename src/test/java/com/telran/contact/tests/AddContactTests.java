package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSignOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("kroos@gm.com")
                    .setPassword("Kroos12345~"));
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        app.getContact().addNewContact(new Contact().setName("Karl").setSurName("Adam")
                .setPhone("1234534876" + i).setEmail("adam" + i + "@gm.com")
                .setAddress("Koblenz").setDescription("torwart"));
        //   click(By.cssSelector(".add_form__2rsm2 button"));
        //Assert contact created
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));

    }
}