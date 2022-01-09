package com.paymu.app.Data.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Model.UserEntity;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
}
