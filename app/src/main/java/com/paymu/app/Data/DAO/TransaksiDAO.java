package com.paymu.app.Data.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.paymu.app.Data.Model.DataTransaksi;

import java.util.List;
@Dao
public interface TransaksiDAO {

    @Query("SELECT * FROM Transaksi")
    public List<DataTransaksi> getData();

}
