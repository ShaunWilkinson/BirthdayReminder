package com.sysadmin_central.birthdayreminder.contacts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface InterfaceContacts {
    @Insert
    void insertSingleContact(EntityContacts contacts);

    @Insert
    void insertMultipleContacts(List<EntityContacts> contactsList);

    @Query("SELECT * FROM EntityContacts WHERE id = :id")
    EntityContacts fetchContactById(int id);

    @Query("SELECT * FROM EntityContacts WHERE name = :name")
    EntityContacts fetchContactByName(String name);

    @Query("SELECT * FROM EntityContacts")
    List<EntityContacts> fetchContacts();

    @Update
    void updateContact(EntityContacts contact);

    @Delete
    void deleteContact(EntityContacts contact);

    @Query("DELETE FROM EntityContacts")
    void deleteAll();
}
