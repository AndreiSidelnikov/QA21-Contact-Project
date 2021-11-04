package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSignOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("kroos@gm.com")
                    .setPassword("Kroos12345~"));
        }
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        app.getContact().addNewContact(new Contact().setName("Karl").setSurName("Adam")
                .setPhone("12345" + i).setEmail("adam" + i + "@gm.com")
                .setAddress("Koblenz").setDescription("torwart"));
    }

    @Test
    public void removeOneContactTest() throws InterruptedException {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);
        app.getContact().removeContact();
        Thread.sleep(2000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);

        Assert.assertEquals(sizeBefore - 1, sizeAfter);

    }
}