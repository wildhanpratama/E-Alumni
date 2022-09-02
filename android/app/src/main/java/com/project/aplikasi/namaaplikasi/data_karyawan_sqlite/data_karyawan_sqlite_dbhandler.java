package com.project.aplikasi.namaaplikasi.data_karyawan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_karyawan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_karyawan";
    private static final String kolom_id_karyawan = "id_karyawan";
    private static final String kolom_nama_depan = "nama_depan";
    private static final String kolom_nama_belakang = "nama_belakang";
    private static final String kolom_alamat = "alamat";
    private static final String kolom_email = "email";
    private static final String kolom_no_telepon = "no_telepon";
    private static final String kolom_kategori = "kategori";
    private static final String kolom_kota = "kota";
    private static final String kolom_tahun_masuk = "tahun_masuk";
    private static final String kolom_tahun_keluar = "tahun_keluar";
    private static final String kolom_bidang_keahlian = "bidang_keahlian";
    private static final String kolom_id_sekolah = "id_sekolah";
    private static final String kolom_linkedin = "linkedin";
    private static final String kolom_instagram = "instagram";
    private static final String kolom_facebook = "facebook";
    private static final String kolom_foto = "foto";
    private static final String kolom_username = "username";
    private static final String kolom_password = "password";


    public data_karyawan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_karyawan + " TEXT " +
				"," + kolom_nama_depan + " TEXT" +
				"," + kolom_nama_belakang + " TEXT" +
				"," + kolom_alamat + " TEXT" +
				"," + kolom_email + " TEXT" +
				"," + kolom_no_telepon + " TEXT" +
				"," + kolom_kategori + " TEXT" +
				"," + kolom_kota + " TEXT" +
				"," + kolom_tahun_masuk + " TEXT" +
				"," + kolom_tahun_keluar + " TEXT" +
				"," + kolom_bidang_keahlian + " TEXT" +
				"," + kolom_id_sekolah + " TEXT" +
				"," + kolom_linkedin + " TEXT" +
				"," + kolom_instagram + " TEXT" +
				"," + kolom_facebook + " TEXT" +
				"," + kolom_foto + " TEXT" +
				"," + kolom_username + " TEXT" +
				"," + kolom_password + " TEXT" +

                ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // CEK DATA
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + nama_tabel );
        onCreate(db);
    }

    // HITUNG DATA
    public int get_data_karyawan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_karyawan_sqlite_data>  get_data_karyawan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_karyawan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_karyawan_sqlite_data data_karyawan = new data_karyawan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)
				,cursor.getString(7)
				,cursor.getString(8)
				,cursor.getString(9)
				,cursor.getString(10)
				,cursor.getString(11)
				,cursor.getString(12)
				,cursor.getString(13)
				,cursor.getString(14)
				,cursor.getString(15)
				,cursor.getString(16)
				,cursor.getString(17)

				);
                datalist.add(data_karyawan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_karyawan_sqlite_data> get_semua_data_karyawan_sqlite(){
        List<data_karyawan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_karyawan_sqlite_data data_karyawan = new data_karyawan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)
				,cursor.getString(7)
				,cursor.getString(8)
				,cursor.getString(9)
				,cursor.getString(10)
				,cursor.getString(11)
				,cursor.getString(12)
				,cursor.getString(13)
				,cursor.getString(14)
				,cursor.getString(15)
				,cursor.getString(16)
				,cursor.getString(17)

				);
                datalist.add(data_karyawan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_karyawan_sqlite(data_karyawan_sqlite_data data_karyawan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_karyawan, data_karyawan.get_id_karyawan());
        values.put( kolom_nama_depan, data_karyawan.get_nama_depan());
        values.put( kolom_nama_belakang, data_karyawan.get_nama_belakang());
        values.put( kolom_alamat, data_karyawan.get_alamat());
        values.put( kolom_email, data_karyawan.get_email());
        values.put( kolom_no_telepon, data_karyawan.get_no_telepon());
        values.put( kolom_kategori, data_karyawan.get_kategori());
        values.put( kolom_kota, data_karyawan.get_kota());
        values.put( kolom_tahun_masuk, data_karyawan.get_tahun_masuk());
        values.put( kolom_tahun_keluar, data_karyawan.get_tahun_keluar());
        values.put( kolom_bidang_keahlian, data_karyawan.get_bidang_keahlian());
        values.put( kolom_id_sekolah, data_karyawan.get_id_sekolah());
        values.put( kolom_linkedin, data_karyawan.get_linkedin());
        values.put( kolom_instagram, data_karyawan.get_instagram());
        values.put( kolom_facebook, data_karyawan.get_facebook());
        values.put( kolom_foto, data_karyawan.get_foto());
        values.put( kolom_username, data_karyawan.get_username());
        values.put( kolom_password, data_karyawan.get_password());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_karyawan_sqlite(data_karyawan_sqlite_data data_karyawan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama_depan, data_karyawan.get_nama_depan());
        values.put( kolom_nama_belakang, data_karyawan.get_nama_belakang());
        values.put( kolom_alamat, data_karyawan.get_alamat());
        values.put( kolom_email, data_karyawan.get_email());
        values.put( kolom_no_telepon, data_karyawan.get_no_telepon());
        values.put( kolom_kategori, data_karyawan.get_kategori());
        values.put( kolom_kota, data_karyawan.get_kota());
        values.put( kolom_tahun_masuk, data_karyawan.get_tahun_masuk());
        values.put( kolom_tahun_keluar, data_karyawan.get_tahun_keluar());
        values.put( kolom_bidang_keahlian, data_karyawan.get_bidang_keahlian());
        values.put( kolom_id_sekolah, data_karyawan.get_id_sekolah());
        values.put( kolom_linkedin, data_karyawan.get_linkedin());
        values.put( kolom_instagram, data_karyawan.get_instagram());
        values.put( kolom_facebook, data_karyawan.get_facebook());
        values.put( kolom_foto, data_karyawan.get_foto());
        values.put( kolom_username, data_karyawan.get_username());
        values.put( kolom_password, data_karyawan.get_password());

        return db.update( nama_tabel, values, kolom_id_karyawan + " = ?",
                new String[]{String.valueOf(data_karyawan.get_id_karyawan())});
    }

    // HAPUS DATA
    public void hapus_data_karyawan_sqlite(data_karyawan_sqlite_data data_karyawan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_karyawan + " = ?",
                new String[]{String.valueOf(data_karyawan.get_id_karyawan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_karyawan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




