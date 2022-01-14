package com.paymu.app.Data.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.paymu.app.Data.DAO.TransaksiDAO;
import com.paymu.app.Data.Model.DataTransaksi;

@Database(entities = {DataTransaksi.class},version = 1)
public abstract class TransaksiDatabase extends RoomDatabase {

    public abstract TransaksiDAO transaksiDAO();

}
