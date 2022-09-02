package com.project.aplikasi.namaaplikasi.data_alumni_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_alumni_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_alumni";
    private static final String kolom_id_alumni = "id_alumni";
    private static final String kolom_nama_depan = "nama_depan";
    private static final String kolom_nama_belakang = "nama_belakang";
    private static final String kolom_alamat = "alamat";
    private static final String kolom_email = "email";
    private static final String kolom_no_telepon = "no_telepon";
    private static final String kolom_nisn = "nisn";
    private static final String kolom_id_sekolah = "id_sekolah";
    private static final String kolom_jurusan = "jurusan";
    private static final String kolom_tahun_masuk = "tahun_masuk";
    private static final String kolom_tahun_keluar = "tahun_keluar";
    private static final String kolom_jalur_penerimaan = "jalur_penerimaan";
    private static final String kolom_jenjang = "jenjang";
    private static final String kolom_linkedin = "linkedin";
    private static final String kolom_instagram = "instagram";
    private static final String kolom_facebook = "facebook";
    private static final String kolom_tempat_kerja = "tempat_kerja";
    private static final String kolom_jabatan_kerja = "jabatan_kerja";
    private static final String kolom_alamat_kerja = "alamat_kerja";
    private static final String kolom_tahun_masuk_kerja = "tahun_masuk_kerja";
    private static final String kolom_tahun_resign = "tahun_resign";
    private static final String kolom_foto = "foto";
    private static final String kolom_username = "username";
    private static final String kolom_password = "password";


    public data_alumni_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_alumni + " TEXT " +
				"," + kolom_nama_depan + " TEXT" +
				"," + kolom_nama_belakang + " TEXT" +
				"," + kolom_alamat + " TEXT" +
				"," + kolom_email + " TEXT" +
				"," + kolom_no_telepon + " TEXT" +
				"," + kolom_nisn + " TEXT" +
				"," + kolom_id_sekolah + " TEXT" +
				"," + kolom_jurusan + " TEXT" +
				"," + kolom_tahun_masuk + " TEXT" +
				"," + kolom_tahun_keluar + " TEXT" +
				"," + kolom_jalur_penerimaan + " TEXT" +
				"," + kolom_jenjang + " TEXT" +
				"," + kolom_linkedin + " TEXT" +
				"," + kolom_instagram + " TEXT" +
				"," + kolom_facebook + " TEXT" +
				"," + kolom_tempat_kerja + " TEXT" +
				"," + kolom_jabatan_kerja + " TEXT" +
				"," + kolom_alamat_kerja + " TEXT" +
				"," + kolom_tahun_masuk_kerja + " TEXT" +
				"," + kolom_tahun_resign + " TEXT" +
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
    public int get_data_alumni_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_alumni_sqlite_data>  get_data_alumni_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_alumni_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_alumni_sqlite_data data_alumni = new data_alumni_sqlite_data(
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
				,cursor.getString(18)
				,cursor.getString(19)
				,cursor.getString(20)
				,cursor.getString(21)
				,cursor.getString(22)
				,cursor.getString(23)

				);
                datalist.add(data_alumni);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_alumni_sqlite_data> get_semua_data_alumni_sqlite(){
        List<data_alumni_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_alumni_sqlite_data data_alumni = new data_alumni_sqlite_data(
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
				,cursor.getString(18)
				,cursor.getString(19)
				,cursor.getString(20)
				,cursor.getString(21)
				,cursor.getString(22)
				,cursor.getString(23)

				);
                datalist.add(data_alumni);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_alumni_sqlite(data_alumni_sqlite_data data_alumni){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_alumni, data_alumni.get_id_alumni());
        values.put( kolom_nama_depan, data_alumni.get_nama_depan());
        values.put( kolom_nama_belakang, data_alumni.get_nama_belakang());
        values.put( kolom_alamat, data_alumni.get_alamat());
        values.put( kolom_email, data_alumni.get_email());
        values.put( kolom_no_telepon, data_alumni.get_no_telepon());
        values.put( kolom_nisn, data_alumni.get_nisn());
        values.put( kolom_id_sekolah, data_alumni.get_id_sekolah());
        values.put( kolom_jurusan, data_alumni.get_jurusan());
        values.put( kolom_tahun_masuk, data_alumni.get_tahun_masuk());
        values.put( kolom_tahun_keluar, data_alumni.get_tahun_keluar());
        values.put( kolom_jalur_penerimaan, data_alumni.get_jalur_penerimaan());
        values.put( kolom_jenjang, data_alumni.get_jenjang());
        values.put( kolom_linkedin, data_alumni.get_linkedin());
        values.put( kolom_instagram, data_alumni.get_instagram());
        values.put( kolom_facebook, data_alumni.get_facebook());
        values.put( kolom_tempat_kerja, data_alumni.get_tempat_kerja());
        values.put( kolom_jabatan_kerja, data_alumni.get_jabatan_kerja());
        values.put( kolom_alamat_kerja, data_alumni.get_alamat_kerja());
        values.put( kolom_tahun_masuk_kerja, data_alumni.get_tahun_masuk_kerja());
        values.put( kolom_tahun_resign, data_alumni.get_tahun_resign());
        values.put( kolom_foto, data_alumni.get_foto());
        values.put( kolom_username, data_alumni.get_username());
        values.put( kolom_password, data_alumni.get_password());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_alumni_sqlite(data_alumni_sqlite_data data_alumni) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama_depan, data_alumni.get_nama_depan());
        values.put( kolom_nama_belakang, data_alumni.get_nama_belakang());
        values.put( kolom_alamat, data_alumni.get_alamat());
        values.put( kolom_email, data_alumni.get_email());
        values.put( kolom_no_telepon, data_alumni.get_no_telepon());
        values.put( kolom_nisn, data_alumni.get_nisn());
        values.put( kolom_id_sekolah, data_alumni.get_id_sekolah());
        values.put( kolom_jurusan, data_alumni.get_jurusan());
        values.put( kolom_tahun_masuk, data_alumni.get_tahun_masuk());
        values.put( kolom_tahun_keluar, data_alumni.get_tahun_keluar());
        values.put( kolom_jalur_penerimaan, data_alumni.get_jalur_penerimaan());
        values.put( kolom_jenjang, data_alumni.get_jenjang());
        values.put( kolom_linkedin, data_alumni.get_linkedin());
        values.put( kolom_instagram, data_alumni.get_instagram());
        values.put( kolom_facebook, data_alumni.get_facebook());
        values.put( kolom_tempat_kerja, data_alumni.get_tempat_kerja());
        values.put( kolom_jabatan_kerja, data_alumni.get_jabatan_kerja());
        values.put( kolom_alamat_kerja, data_alumni.get_alamat_kerja());
        values.put( kolom_tahun_masuk_kerja, data_alumni.get_tahun_masuk_kerja());
        values.put( kolom_tahun_resign, data_alumni.get_tahun_resign());
        values.put( kolom_foto, data_alumni.get_foto());
        values.put( kolom_username, data_alumni.get_username());
        values.put( kolom_password, data_alumni.get_password());

        return db.update( nama_tabel, values, kolom_id_alumni + " = ?",
                new String[]{String.valueOf(data_alumni.get_id_alumni())});
    }

    // HAPUS DATA
    public void hapus_data_alumni_sqlite(data_alumni_sqlite_data data_alumni) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_alumni + " = ?",
                new String[]{String.valueOf(data_alumni.get_id_alumni())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_alumni_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




