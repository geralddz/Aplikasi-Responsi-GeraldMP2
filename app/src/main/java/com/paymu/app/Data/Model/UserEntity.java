package com.paymu.app.Data.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @ColumnInfo(name = "Email")
    private String email = "";

    @ColumnInfo(name = "Password")
    private String password= "";

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

