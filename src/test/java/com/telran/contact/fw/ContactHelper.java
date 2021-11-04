package com.telran.contact.fw;

import com.telran.contact.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void addNewContact(Contact contact) {

        click(By.cssSelector("a:nth-child(5)"));
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSurName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
        clickWithActions(By.cssSelector(".add_form__2rsm2 button"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.xpath("//h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            driver.findElement(By.xpath("//button[text()='Remove']")).click();
        }
    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public int sizeOfContacts() {
        if (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;

    }
}
