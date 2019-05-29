package com.sysadmin_central.birthdayreminder.contacts;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//TODO finish all fields

@Entity
public class EntityContacts {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public EntityContacts() {}

    public int getId() {
        return id;
    }

    public void setId(int contactID) {
        this.id = contactID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
