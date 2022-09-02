package com.project.aplikasi.namaaplikasi.config;

import android.content.Context;
import android.content.SharedPreferences;

public class config_sessionmanager {

    public static final String SP_APP = "app";
    public static final String SP_NAMA = "nama";
    public static final String SP_TOKEN = "email";
    public static final String SP_ID = "id_pegawai";

    public static final String SP_SUDAH_LOGIN = "sudahlogin";
    public static final String SP_JABATAN = "jabatan";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public config_sessionmanager(Context context) {
        sp = context.getSharedPreferences(SP_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value) {
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value) {
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama() {
        return sp.getString(SP_NAMA, "");
    }

    public String getSPToken() {
        return sp.getString(SP_TOKEN, "");
    }

    public Boolean getSPSudahLogin() {
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public String getSPId(){
        return sp.getString(SP_ID, "");
    }

    public void logOut(){
        saveSPString(SP_NAMA, "");
        saveSPString(SP_TOKEN, "");
        saveSPString(SP_ID, "");
        saveSPString(SP_JABATAN, "");
        saveSPBoolean(SP_SUDAH_LOGIN, false);
    }

    public String getSPJabatan() {
        return sp.getString(SP_JABATAN, "");
    }
}