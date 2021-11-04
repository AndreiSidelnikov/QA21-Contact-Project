package com.telran.contact.tests;

import com.telran.contact.fw.DataProviders;
import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSignOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("kroozzs@gm.com")
                    .setPassword("Kroozzs12345~"));
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        app.getContact().addNewContact(new Contact().setName("Karl").setSurName("Adam")
                .setPhone("1234534876" + i).setEmail("adam" + i + "@gm.com")
                .setAddress("Koblenz").setDescription("torwart"));
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));

    }

    @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String sName, String ph, String email, String add, String des) {

        app.getContact().addNewContact(new Contact().setName(name).setSurName(sName)
                .setPhone(ph).setEmail(email)
                .setAddress(add).setDescription(des));
        app.getContact().removeContact();
    }

    @Test(dataProvider = "newContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromCSVTest(Contact contact) throws InterruptedException {

        app.getContact().addNewContact(contact);
        app.getContact().removeContact();
        Thread.sleep(5000);
    }

}