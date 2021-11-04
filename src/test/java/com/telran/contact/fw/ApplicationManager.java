package com.telran.contact.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HomeHelper home;

    NoNameHelper noName;

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomeHelper getHome() {
        return home;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomeHelper(driver);
        noName = new NoNameHelper(driver);
    }

    public NoNameHelper getNoName() {
        return noName;
    }

    public void stop() {
        driver.quit();
    }

}