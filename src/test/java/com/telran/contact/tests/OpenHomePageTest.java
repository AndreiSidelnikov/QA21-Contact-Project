package com.telran.contact.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {

    @Test
    public void homePageTest() throws InterruptedException {
        System.out.println("site opened");
        Thread.sleep(1000);
        System.out.println("HomeComponent:" + app.getHome().isElementPresent2(By.cssSelector("div:nth-child(2) > div > div")));
    }
}