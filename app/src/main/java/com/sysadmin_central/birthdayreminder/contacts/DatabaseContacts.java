package com.sysadmin_central.birthdayreminder.contacts;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {EntityContacts.class}, version = 1, exportSchema = false)
public abstract class DatabaseContacts extends RoomDatabase {
    public abstract InterfaceContacts interfaceContacts();
}
