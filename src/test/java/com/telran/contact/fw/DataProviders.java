package com.telran.contact.fw;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newContact() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "98765432987", "kan@gm.co", "Dresden", "goalkeeper"});
        list.add(new Object[]{"Oliver", "Kan", "98765432983", "kan+1@gm.co", "Dresden", "goalkeeper"});
        list.add(new Object[]{"Oliver", "Kan", "98765432975", "kan+2@gm.co", "Dresden", "goalkeeper"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contacts.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setSurName(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUserFromCSV () throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/NegativeRegistrationUsers.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

}