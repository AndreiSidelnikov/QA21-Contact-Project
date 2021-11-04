package com.telran.contact.tests;

import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //login not present
        if (!app.getUser().isLoginTabPresent()) {
            //click on logout button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void registrationPositiveTest() {
        //click on Login
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        //fill registration form
        app.getUser().createNewAccount(new User()
                .setEmail("kroozzs@gm.com")
                .setPassword("Kroozzs12345~"));
        //check Logout button displayed
        Assert.assertTrue(app.getUser().isSignOutTabPresent());
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
        //click on Login
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        //fill registration form
        app.getUser().createNewAccount(new User()
                .setEmail("kroos@gm.com"));
        //check Logout button displayed
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}