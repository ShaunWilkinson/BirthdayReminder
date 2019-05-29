package com.sysadmin_central.birthdayreminder.contacts;

import android.util.Log;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
import java.util.List;

//TODO finish all fields

@TypeConverters({ConverterDate.class, ConverterList.class})
@Entity
public class EntityContacts {
    private static String TAG = "EntityContacts";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private List<String> giftIdeas; //Perhaps better as a JSON array?
    private String source;

    public EntityContacts() {
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGiftIdeas() {
        return giftIdeas;
    }

    public void setGiftIdeas(List<String> giftIdeas) {
        this.giftIdeas = giftIdeas;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        if(source != null) {
            switch (source) {
                case "local":
                case "phone":
                case "facebook":
                    this.source = source.toLowerCase();
                    break;
                default:
                    Log.w(TAG, "Source should be local, phone, or facebook");
                    this.source = "";
                    break;
            }
        }
    }
}
