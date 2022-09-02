package com.project.aplikasi.namaaplikasi.data_alumni_sqlite;

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


public class data_alumni_sqlite_tambah extends AppCompatActivity {

    String validasi;
    private EditText id_alumni;
    private EditText nama_depan;
    private EditText nama_belakang;
    private EditText alamat;
    private EditText email;
    private EditText no_telepon;
    private EditText nisn;
    private EditText id_sekolah;
    private EditText jurusan;
    private EditText tahun_masuk;
    private EditText tahun_keluar;
    private EditText jalur_penerimaan;
    private EditText jenjang;
    private EditText linkedin;
    private EditText instagram;
    private EditText facebook;
    private EditText tempat_kerja;
    private EditText jabatan_kerja;
    private EditText alamat_kerja;
    private EditText tahun_masuk_kerja;
    private EditText tahun_resign;
    private EditText foto;
    private EditText username;
    private EditText password;

    
    private Button button_tambahdata;

    private data_alumni_sqlite_dbhandler dbHandler;
    private data_alumni_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_alumni_tambah );
        dbHandler = new data_alumni_sqlite_dbhandler(this);

        button_tambahdata = (Button) findViewById(R.id.tombol_simpan);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        nama_depan = (EditText) findViewById(R.id.nama_depan);
        nama_belakang = (EditText) findViewById(R.id.nama_belakang);
        alamat = (EditText) findViewById(R.id.alamat);
        email = (EditText) findViewById(R.id.email);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        nisn = (EditText) findViewById(R.id.nisn);
        id_sekolah = (EditText) findViewById(R.id.id_sekolah);
        jurusan = (EditText) findViewById(R.id.jurusan);
        tahun_masuk = (EditText) findViewById(R.id.tahun_masuk);
        tahun_keluar = (EditText) findViewById(R.id.tahun_keluar);
        jalur_penerimaan = (EditText) findViewById(R.id.jalur_penerimaan);
        jenjang = (EditText) findViewById(R.id.jenjang);
        linkedin = (EditText) findViewById(R.id.linkedin);
        instagram = (EditText) findViewById(R.id.instagram);
        facebook = (EditText) findViewById(R.id.facebook);
        tempat_kerja = (EditText) findViewById(R.id.tempat_kerja);
        jabatan_kerja = (EditText) findViewById(R.id.jabatan_kerja);
        alamat_kerja = (EditText) findViewById(R.id.alamat_kerja);
        tahun_masuk_kerja = (EditText) findViewById(R.id.tahun_masuk_kerja);
        tahun_resign = (EditText) findViewById(R.id.tahun_resign);
        foto = (EditText) findViewById(R.id.foto);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        id_alumni.setText( config_global.generate_id( data_alumni_sqlite_tambah.this,"data_alumni") );
		
		config_global.init_inputTypes();


        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                id_alumni.setText( config_global.generate_id( data_alumni_sqlite_tambah.this,"data_alumni") );
                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_alumni_sqlite_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.tambah_data_alumni_sqlite( new data_alumni_sqlite_data(
                            id_alumni.getText().toString()
                            ,nama_depan.getText().toString()
                            ,nama_belakang.getText().toString()
                            ,alamat.getText().toString()
                            ,email.getText().toString()
                            ,no_telepon.getText().toString()
                            ,nisn.getText().toString()
                            ,id_sekolah.getText().toString()
                            ,jurusan.getText().toString()
                            ,tahun_masuk.getText().toString()
                            ,tahun_keluar.getText().toString()
                            ,jalur_penerimaan.getText().toString()
                            ,jenjang.getText().toString()
                            ,linkedin.getText().toString()
                            ,instagram.getText().toString()
                            ,facebook.getText().toString()
                            ,tempat_kerja.getText().toString()
                            ,jabatan_kerja.getText().toString()
                            ,alamat_kerja.getText().toString()
                            ,tahun_masuk_kerja.getText().toString()
                            ,tahun_resign.getText().toString()
                            ,foto.getText().toString()
                            ,username.getText().toString()
                            ,password.getText().toString()

                    ) );

                    List<data_alumni_sqlite_data> data_alumni_sqliteList = dbHandler.get_semua_data_alumni_sqlite();
                    adapter = new data_alumni_sqlite_adapter( data_alumni_sqlite_tambah.this, data_alumni_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_alumni_sqlite_tambah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_alumni.requestFocus();
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






