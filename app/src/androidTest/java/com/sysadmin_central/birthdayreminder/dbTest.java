package com.sysadmin_central.birthdayreminder;

import androidx.room.Room;
import android.content.Context;

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
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class dbTest {
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

        // Create a new contact and insert into DB
        EntityContacts contact = new EntityContacts();
        contact.setName("Test");
        contactDao.insertSingleContact(contact);

        // Read from DB and ensure name is the same
        EntityContacts contactReturned = contactDao.fetchContactByName("Test");
        assertThat(contactReturned.getName(), equalTo(contact.getName()));
    }
}
