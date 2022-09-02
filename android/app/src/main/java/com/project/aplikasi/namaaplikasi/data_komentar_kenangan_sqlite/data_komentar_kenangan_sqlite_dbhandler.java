package com.project.aplikasi.namaaplikasi.data_komentar_kenangan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_komentar_kenangan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_komentar_kenangan";
    private static final String kolom_id_komentar_kenangan = "id_komentar_kenangan";
    private static final String kolom_id_kenangan = "id_kenangan";
    private static final String kolom_id_alumni = "id_alumni";
    private static final String kolom_tanggal = "tanggal";
    private static final String kolom_komentar = "komentar";


    public data_komentar_kenangan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_komentar_kenangan + " TEXT " +
				"," + kolom_id_kenangan + " TEXT" +
				"," + kolom_id_alumni + " TEXT" +
				"," + kolom_tanggal + " TEXT" +
				"," + kolom_komentar + " TEXT" +

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
    public int get_data_komentar_kenangan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_komentar_kenangan_sqlite_data>  get_data_komentar_kenangan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_komentar_kenangan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_komentar_kenangan_sqlite_data data_komentar_kenangan = new data_komentar_kenangan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)

				);
                datalist.add(data_komentar_kenangan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_komentar_kenangan_sqlite_data> get_semua_data_komentar_kenangan_sqlite(){
        List<data_komentar_kenangan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_komentar_kenangan_sqlite_data data_komentar_kenangan = new data_komentar_kenangan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)

				);
                datalist.add(data_komentar_kenangan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_komentar_kenangan_sqlite(data_komentar_kenangan_sqlite_data data_komentar_kenangan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_komentar_kenangan, data_komentar_kenangan.get_id_komentar_kenangan());
        values.put( kolom_id_kenangan, data_komentar_kenangan.get_id_kenangan());
        values.put( kolom_id_alumni, data_komentar_kenangan.get_id_alumni());
        values.put( kolom_tanggal, data_komentar_kenangan.get_tanggal());
        values.put( kolom_komentar, data_komentar_kenangan.get_komentar());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_komentar_kenangan_sqlite(data_komentar_kenangan_sqlite_data data_komentar_kenangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_kenangan, data_komentar_kenangan.get_id_kenangan());
        values.put( kolom_id_alumni, data_komentar_kenangan.get_id_alumni());
        values.put( kolom_tanggal, data_komentar_kenangan.get_tanggal());
        values.put( kolom_komentar, data_komentar_kenangan.get_komentar());

        return db.update( nama_tabel, values, kolom_id_komentar_kenangan + " = ?",
                new String[]{String.valueOf(data_komentar_kenangan.get_id_komentar_kenangan())});
    }

    // HAPUS DATA
    public void hapus_data_komentar_kenangan_sqlite(data_komentar_kenangan_sqlite_data data_komentar_kenangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_komentar_kenangan + " = ?",
                new String[]{String.valueOf(data_komentar_kenangan.get_id_komentar_kenangan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_komentar_kenangan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




