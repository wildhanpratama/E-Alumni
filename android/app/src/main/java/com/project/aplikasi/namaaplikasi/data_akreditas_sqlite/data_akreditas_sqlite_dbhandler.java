package com.project.aplikasi.namaaplikasi.data_akreditas_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_akreditas_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_akreditas";
    private static final String kolom_id_akreditas = "id_akreditas";
    private static final String kolom_nama_lengkap = "nama_lengkap";
    private static final String kolom_nisn = "nisn";
    private static final String kolom_kelas = "kelas";
    private static final String kolom_tahun_lulus = "tahun_lulus";
    private static final String kolom_email = "email";
    private static final String kolom_status_pekerjaan = "status_pekerjaan";


    public data_akreditas_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_akreditas + " TEXT " +
				"," + kolom_nama_lengkap + " TEXT" +
				"," + kolom_nisn + " TEXT" +
				"," + kolom_kelas + " TEXT" +
				"," + kolom_tahun_lulus + " TEXT" +
				"," + kolom_email + " TEXT" +
				"," + kolom_status_pekerjaan + " TEXT" +

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
    public int get_data_akreditas_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_akreditas_sqlite_data>  get_data_akreditas_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_akreditas_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_akreditas_sqlite_data data_akreditas = new data_akreditas_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_akreditas);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_akreditas_sqlite_data> get_semua_data_akreditas_sqlite(){
        List<data_akreditas_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_akreditas_sqlite_data data_akreditas = new data_akreditas_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_akreditas);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_akreditas_sqlite(data_akreditas_sqlite_data data_akreditas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_akreditas, data_akreditas.get_id_akreditas());
        values.put( kolom_nama_lengkap, data_akreditas.get_nama_lengkap());
        values.put( kolom_nisn, data_akreditas.get_nisn());
        values.put( kolom_kelas, data_akreditas.get_kelas());
        values.put( kolom_tahun_lulus, data_akreditas.get_tahun_lulus());
        values.put( kolom_email, data_akreditas.get_email());
        values.put( kolom_status_pekerjaan, data_akreditas.get_status_pekerjaan());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_akreditas_sqlite(data_akreditas_sqlite_data data_akreditas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama_lengkap, data_akreditas.get_nama_lengkap());
        values.put( kolom_nisn, data_akreditas.get_nisn());
        values.put( kolom_kelas, data_akreditas.get_kelas());
        values.put( kolom_tahun_lulus, data_akreditas.get_tahun_lulus());
        values.put( kolom_email, data_akreditas.get_email());
        values.put( kolom_status_pekerjaan, data_akreditas.get_status_pekerjaan());

        return db.update( nama_tabel, values, kolom_id_akreditas + " = ?",
                new String[]{String.valueOf(data_akreditas.get_id_akreditas())});
    }

    // HAPUS DATA
    public void hapus_data_akreditas_sqlite(data_akreditas_sqlite_data data_akreditas) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_akreditas + " = ?",
                new String[]{String.valueOf(data_akreditas.get_id_akreditas())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_akreditas_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




