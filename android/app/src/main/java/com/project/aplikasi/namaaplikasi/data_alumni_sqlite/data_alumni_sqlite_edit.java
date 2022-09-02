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


public class data_alumni_sqlite_edit extends AppCompatActivity {

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

    
    private Button button_editdata;

    private data_alumni_sqlite_dbhandler dbHandler;
    private data_alumni_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_alumni_edit );
        dbHandler = new data_alumni_sqlite_dbhandler(this);

        button_editdata = (Button) findViewById(R.id.tombol_update);
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


        Bundle bundle = getIntent().getExtras();
        id_alumni.setText(bundle.getString("id_alumni"));
        nama_depan.setText(bundle.getString("nama_depan"));
        nama_belakang.setText(bundle.getString("nama_belakang"));
        alamat.setText(bundle.getString("alamat"));
        email.setText(bundle.getString("email"));
        no_telepon.setText(bundle.getString("no_telepon"));
        nisn.setText(bundle.getString("nisn"));
        id_sekolah.setText(bundle.getString("id_sekolah"));
        jurusan.setText(bundle.getString("jurusan"));
        tahun_masuk.setText(bundle.getString("tahun_masuk"));
        tahun_keluar.setText(bundle.getString("tahun_keluar"));
        jalur_penerimaan.setText(bundle.getString("jalur_penerimaan"));
        jenjang.setText(bundle.getString("jenjang"));
        linkedin.setText(bundle.getString("linkedin"));
        instagram.setText(bundle.getString("instagram"));
        facebook.setText(bundle.getString("facebook"));
        tempat_kerja.setText(bundle.getString("tempat_kerja"));
        jabatan_kerja.setText(bundle.getString("jabatan_kerja"));
        alamat_kerja.setText(bundle.getString("alamat_kerja"));
        tahun_masuk_kerja.setText(bundle.getString("tahun_masuk_kerja"));
        tahun_resign.setText(bundle.getString("tahun_resign"));
        foto.setText(bundle.getString("foto"));
        username.setText(bundle.getString("username"));
        password.setText(bundle.getString("password"));


		config_global.init_inputTypes();



        button_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();

                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_alumni_sqlite_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.update_data_alumni_sqlite( new data_alumni_sqlite_data(
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
                    adapter = new data_alumni_sqlite_adapter( data_alumni_sqlite_edit.this, data_alumni_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_alumni_sqlite_edit.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_alumni.requestFocus();
                    hideLoading();
                    finish();
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
                .setMessage("Mengupdate Data ...")
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






