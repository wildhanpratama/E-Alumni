package com.project.aplikasi.namaaplikasi.data_admin_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import java.util.List;
import static com.project.aplikasi.namaaplikasi.config.config_global.inputTypes;


public class data_admin_sqlite_tambah extends AppCompatActivity {

    String validasi;
    private EditText id_admin;
    private EditText nama_depan;
    private EditText nama_belakang;
    private EditText alamat;
    private EditText email;
    private EditText no_telepon;
    private EditText hak_akses;
    private EditText id_sekolah;
    private EditText status_pekerjaan;
    private EditText foto;
    private EditText username;
    private EditText password;

    
    private Button button_tambahdata;

    private data_admin_sqlite_dbhandler dbHandler;
    private data_admin_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_admin_tambah );
        dbHandler = new data_admin_sqlite_dbhandler(this);

        button_tambahdata = (Button) findViewById(R.id.tombol_simpan);
        id_admin = (EditText) findViewById(R.id.id_admin);
        nama_depan = (EditText) findViewById(R.id.nama_depan);
        nama_belakang = (EditText) findViewById(R.id.nama_belakang);
        alamat = (EditText) findViewById(R.id.alamat);
        email = (EditText) findViewById(R.id.email);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        hak_akses = (EditText) findViewById(R.id.hak_akses);
        id_sekolah = (EditText) findViewById(R.id.id_sekolah);
        status_pekerjaan = (EditText) findViewById(R.id.status_pekerjaan);
        foto = (EditText) findViewById(R.id.foto);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        id_admin.setText( config_global.generate_id( data_admin_sqlite_tambah.this,"data_admin") );
		
		config_global.init_inputTypes();


        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                id_admin.setText( config_global.generate_id( data_admin_sqlite_tambah.this,"data_admin") );
                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_admin_sqlite_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.tambah_data_admin_sqlite( new data_admin_sqlite_data(
                            id_admin.getText().toString()
                            ,nama_depan.getText().toString()
                            ,nama_belakang.getText().toString()
                            ,alamat.getText().toString()
                            ,email.getText().toString()
                            ,no_telepon.getText().toString()
                            ,hak_akses.getText().toString()
                            ,id_sekolah.getText().toString()
                            ,status_pekerjaan.getText().toString()
                            ,foto.getText().toString()
                            ,username.getText().toString()
                            ,password.getText().toString()

                    ) );

                    List<data_admin_sqlite_data> data_admin_sqliteList = dbHandler.get_semua_data_admin_sqlite();
                    adapter = new data_admin_sqlite_adapter( data_admin_sqlite_tambah.this, data_admin_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_admin_sqlite_tambah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_admin.requestFocus();
                    hideLoading();
                }
            }
        });
    }


    public void validasiForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                if(!TextUtils.isEmpty(((EditText)view).getText().toString()))  {
                }  else  {
                    validasi = "gagal";
                    ((EditText)view).setError("Silahkan Input Terlebih Dahulu");
                    ((EditText)view).requestFocus();
                }
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                validasiForm((ViewGroup)view);
        }
    }

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }

    AlertDialog alertDialog;
    public void showLoading(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage("Menyimpan Data ...")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false);
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void hideLoading(){
        if (alertDialog != null){
            alertDialog.dismiss();
        }
    }

}






