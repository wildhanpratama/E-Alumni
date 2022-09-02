package com.project.aplikasi.namaaplikasi.data_sekolah_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_sekolah_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_sekolah";
    private static final String kolom_id_sekolah = "id_sekolah";
    private static final String kolom_nama_sekolah = "nama_sekolah";
    private static final String kolom_alamat = "alamat";
    private static final String kolom_email = "email";
    private static final String kolom_no_telepon = "no_telepon";
    private static final String kolom_kota = "kota";
    private static final String kolom_deskripsi = "deskripsi";


    public data_sekolah_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_sekolah + " TEXT " +
				"," + kolom_nama_sekolah + " TEXT" +
				"," + kolom_alamat + " TEXT" +
				"," + kolom_email + " TEXT" +
				"," + kolom_no_telepon + " TEXT" +
				"," + kolom_kota + " TEXT" +
				"," + kolom_deskripsi + " TEXT" +

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
    public int get_data_sekolah_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_sekolah_sqlite_data>  get_data_sekolah_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_sekolah_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_sekolah_sqlite_data data_sekolah = new data_sekolah_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_sekolah);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_sekolah_sqlite_data> get_semua_data_sekolah_sqlite(){
        List<data_sekolah_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_sekolah_sqlite_data data_sekolah = new data_sekolah_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_sekolah);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_sekolah_sqlite(data_sekolah_sqlite_data data_sekolah){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_sekolah, data_sekolah.get_id_sekolah());
        values.put( kolom_nama_sekolah, data_sekolah.get_nama_sekolah());
        values.put( kolom_alamat, data_sekolah.get_alamat());
        values.put( kolom_email, data_sekolah.get_email());
        values.put( kolom_no_telepon, data_sekolah.get_no_telepon());
        values.put( kolom_kota, data_sekolah.get_kota());
        values.put( kolom_deskripsi, data_sekolah.get_deskripsi());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_sekolah_sqlite(data_sekolah_sqlite_data data_sekolah) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama_sekolah, data_sekolah.get_nama_sekolah());
        values.put( kolom_alamat, data_sekolah.get_alamat());
        values.put( kolom_email, data_sekolah.get_email());
        values.put( kolom_no_telepon, data_sekolah.get_no_telepon());
        values.put( kolom_kota, data_sekolah.get_kota());
        values.put( kolom_deskripsi, data_sekolah.get_deskripsi());

        return db.update( nama_tabel, values, kolom_id_sekolah + " = ?",
                new String[]{String.valueOf(data_sekolah.get_id_sekolah())});
    }

    // HAPUS DATA
    public void hapus_data_sekolah_sqlite(data_sekolah_sqlite_data data_sekolah) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_sekolah + " = ?",
                new String[]{String.valueOf(data_sekolah.get_id_sekolah())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_sekolah_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




