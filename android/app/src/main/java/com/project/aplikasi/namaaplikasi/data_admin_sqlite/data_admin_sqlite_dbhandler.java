package com.project.aplikasi.namaaplikasi.data_admin_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_admin_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_admin";
    private static final String kolom_id_admin = "id_admin";
    private static final String kolom_nama_depan = "nama_depan";
    private static final String kolom_nama_belakang = "nama_belakang";
    private static final String kolom_alamat = "alamat";
    private static final String kolom_email = "email";
    private static final String kolom_no_telepon = "no_telepon";
    private static final String kolom_hak_akses = "hak_akses";
    private static final String kolom_id_sekolah = "id_sekolah";
    private static final String kolom_status_pekerjaan = "status_pekerjaan";
    private static final String kolom_foto = "foto";
    private static final String kolom_username = "username";
    private static final String kolom_password = "password";


    public data_admin_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_admin + " TEXT " +
				"," + kolom_nama_depan + " TEXT" +
				"," + kolom_nama_belakang + " TEXT" +
				"," + kolom_alamat + " TEXT" +
				"," + kolom_email + " TEXT" +
				"," + kolom_no_telepon + " TEXT" +
				"," + kolom_hak_akses + " TEXT" +
				"," + kolom_id_sekolah + " TEXT" +
				"," + kolom_status_pekerjaan + " TEXT" +
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
    public int get_data_admin_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_admin_sqlite_data>  get_data_admin_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_admin_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_admin_sqlite_data data_admin = new data_admin_sqlite_data(
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

				);
                datalist.add(data_admin);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_admin_sqlite_data> get_semua_data_admin_sqlite(){
        List<data_admin_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_admin_sqlite_data data_admin = new data_admin_sqlite_data(
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

				);
                datalist.add(data_admin);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_admin_sqlite(data_admin_sqlite_data data_admin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_admin, data_admin.get_id_admin());
        values.put( kolom_nama_depan, data_admin.get_nama_depan());
        values.put( kolom_nama_belakang, data_admin.get_nama_belakang());
        values.put( kolom_alamat, data_admin.get_alamat());
        values.put( kolom_email, data_admin.get_email());
        values.put( kolom_no_telepon, data_admin.get_no_telepon());
        values.put( kolom_hak_akses, data_admin.get_hak_akses());
        values.put( kolom_id_sekolah, data_admin.get_id_sekolah());
        values.put( kolom_status_pekerjaan, data_admin.get_status_pekerjaan());
        values.put( kolom_foto, data_admin.get_foto());
        values.put( kolom_username, data_admin.get_username());
        values.put( kolom_password, data_admin.get_password());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_admin_sqlite(data_admin_sqlite_data data_admin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama_depan, data_admin.get_nama_depan());
        values.put( kolom_nama_belakang, data_admin.get_nama_belakang());
        values.put( kolom_alamat, data_admin.get_alamat());
        values.put( kolom_email, data_admin.get_email());
        values.put( kolom_no_telepon, data_admin.get_no_telepon());
        values.put( kolom_hak_akses, data_admin.get_hak_akses());
        values.put( kolom_id_sekolah, data_admin.get_id_sekolah());
        values.put( kolom_status_pekerjaan, data_admin.get_status_pekerjaan());
        values.put( kolom_foto, data_admin.get_foto());
        values.put( kolom_username, data_admin.get_username());
        values.put( kolom_password, data_admin.get_password());

        return db.update( nama_tabel, values, kolom_id_admin + " = ?",
                new String[]{String.valueOf(data_admin.get_id_admin())});
    }

    // HAPUS DATA
    public void hapus_data_admin_sqlite(data_admin_sqlite_data data_admin) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_admin + " = ?",
                new String[]{String.valueOf(data_admin.get_id_admin())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_admin_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




