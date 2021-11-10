package com.telran.contact.tests;

import com.telran.contact.fw.DataProviders;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    public void registrationPositiveTest() throws InterruptedException {
        //click on Login
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        //fill registration form
        app.getUser().createNewAccount(new User()
                .setEmail("kroozs@gm.com")
                .setPassword("Kroozzzzs12345~"));
        //check Logout button displayed
        Thread.sleep(2000);
        Assert.assertTrue(app.getUser().isSignOutTabPresent());
        Thread.sleep(2000);
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

    @Test (dataProvider = "newUserFromCSV", dataProviderClass = DataProviders.class)

    public void registrationNegativeCSVTest(User user) throws InterruptedException {

        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        //fill registration form
        app.getUser().createNewAccount(user);
        //check Logout button displayed
        Thread.sleep(1000);
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}