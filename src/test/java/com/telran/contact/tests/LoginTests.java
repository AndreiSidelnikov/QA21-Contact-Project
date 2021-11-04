package com.telran.contact.tests;

import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //login not present
        if (!app.getUser().isLoginTabPresent()) {
            //click on logout button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 2)
    public void loginRegisteredUserPositiveTest() {
        //click on Login tab
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        //fill Login form
        app.getUser().login(new User()
                .setEmail("kroos@gm.com")
                .setPassword("Kroos12345~"));
        //Assert user loggedIn
        Assert.assertTrue(app.getUser().isSignOutTabPresent());
    }

    @Test(priority = 1)
    public void loginRegisteredUserNegativeWithWrongPasswordTest() {
        //click on Login tab
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        //fill Login form
        app.getUser().login(new User()
                .setEmail("kroos@gm.com")
                .setPassword("Kroos12345"));
        //Assert user loggedIn
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}