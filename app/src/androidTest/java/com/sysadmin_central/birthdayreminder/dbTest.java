package com.sysadmin_central.birthdayreminder;

import androidx.room.Room;
import android.content.Context;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;

import com.sysadmin_central.birthdayreminder.contacts.DatabaseContacts;
import com.sysadmin_central.birthdayreminder.contacts.EntityContacts;
import com.sysadmin_central.birthdayreminder.contacts.InterfaceContacts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class dbTest {
    private static String TAG = "dbTest";
    private InterfaceContacts contactDao;
    private DatabaseContacts db;

    @Before
    public void createDB() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DatabaseContacts.class).build();
        contactDao = db.interfaceContacts();
        db.interfaceContacts().deleteAll();
    }

    @After
    public void closeDB() throws IOException {
        db.close();
    }

    @Test
    public void writeContactAndReadInList() throws Exception {
        // Ensure no records in database
        assertThat(0, equalTo(contactDao.fetchContacts().size()));

        List<String> giftIdeas = new ArrayList<>();
        giftIdeas.add("Birthday Card");
        giftIdeas.add("Party");

        // Create a new contact and insert into DB
        EntityContacts contact = new EntityContacts();
        contact.setName("Test");
        contact.setBirthday(new Date(817171200000L));
        contact.setEmail("test@gmail.com");
        contact.setGiftIdeas(giftIdeas);
        contact.setPhoneNumber("+44 0000 0000");
        contact.setSource("local");
        contactDao.insertSingleContact(contact);

        // Read from DB and ensure name is the same
        EntityContacts contactReturned = contactDao.fetchContactByName("Test");
        assertThat(contactReturned.getName(), equalTo(contact.getName()));

        contactDao.deleteAll();
    }
}
