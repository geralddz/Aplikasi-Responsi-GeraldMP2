package com.paymu.app.Data.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Transaksi")
public class DataTransaksi {


        @PrimaryKey(autoGenerate = true)
        private int tid = 0;

        @ColumnInfo(name = "Tanggal")
        private String tanggal;

        @ColumnInfo(name = "Jenis")
        private String jenis;

        @ColumnInfo(name = "Status")
        private String status;

    public DataTransaksi(String tanggal, String jenis, String status) {
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.status = status;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
