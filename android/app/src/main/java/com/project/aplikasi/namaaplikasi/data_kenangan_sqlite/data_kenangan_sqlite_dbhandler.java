package com.project.aplikasi.namaaplikasi.data_kenangan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_kenangan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_kenangan";
    private static final String kolom_id_kenangan = "id_kenangan";
    private static final String kolom_caption = "caption";
    private static final String kolom_tanggal = "tanggal";
    private static final String kolom_foto = "foto";
    private static final String kolom_id_alumni = "id_alumni";
    private static final String kolom_jumlah_like = "jumlah_like";
    private static final String kolom_jumlah_komen = "jumlah_komen";


    public data_kenangan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_kenangan + " TEXT " +
				"," + kolom_caption + " TEXT" +
				"," + kolom_tanggal + " TEXT" +
				"," + kolom_foto + " TEXT" +
				"," + kolom_id_alumni + " TEXT" +
				"," + kolom_jumlah_like + " TEXT" +
				"," + kolom_jumlah_komen + " TEXT" +

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
    public int get_data_kenangan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_kenangan_sqlite_data>  get_data_kenangan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_kenangan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_kenangan_sqlite_data data_kenangan = new data_kenangan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_kenangan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_kenangan_sqlite_data> get_semua_data_kenangan_sqlite(){
        List<data_kenangan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_kenangan_sqlite_data data_kenangan = new data_kenangan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_kenangan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_kenangan_sqlite(data_kenangan_sqlite_data data_kenangan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_kenangan, data_kenangan.get_id_kenangan());
        values.put( kolom_caption, data_kenangan.get_caption());
        values.put( kolom_tanggal, data_kenangan.get_tanggal());
        values.put( kolom_foto, data_kenangan.get_foto());
        values.put( kolom_id_alumni, data_kenangan.get_id_alumni());
        values.put( kolom_jumlah_like, data_kenangan.get_jumlah_like());
        values.put( kolom_jumlah_komen, data_kenangan.get_jumlah_komen());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_kenangan_sqlite(data_kenangan_sqlite_data data_kenangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_caption, data_kenangan.get_caption());
        values.put( kolom_tanggal, data_kenangan.get_tanggal());
        values.put( kolom_foto, data_kenangan.get_foto());
        values.put( kolom_id_alumni, data_kenangan.get_id_alumni());
        values.put( kolom_jumlah_like, data_kenangan.get_jumlah_like());
        values.put( kolom_jumlah_komen, data_kenangan.get_jumlah_komen());

        return db.update( nama_tabel, values, kolom_id_kenangan + " = ?",
                new String[]{String.valueOf(data_kenangan.get_id_kenangan())});
    }

    // HAPUS DATA
    public void hapus_data_kenangan_sqlite(data_kenangan_sqlite_data data_kenangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_kenangan + " = ?",
                new String[]{String.valueOf(data_kenangan.get_id_kenangan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_kenangan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




