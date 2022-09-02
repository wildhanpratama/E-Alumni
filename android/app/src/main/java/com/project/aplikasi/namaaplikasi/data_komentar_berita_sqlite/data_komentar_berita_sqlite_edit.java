package com.project.aplikasi.namaaplikasi.data_komentar_berita_sqlite;

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


public class data_komentar_berita_sqlite_edit extends AppCompatActivity {

    String validasi;
    private EditText id_komentar_berita;
    private EditText id_berita;
    private EditText id_alumni;
    private EditText tanggal;
    private EditText komentar;

    
    private Button button_editdata;

    private data_komentar_berita_sqlite_dbhandler dbHandler;
    private data_komentar_berita_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_komentar_berita_edit );
        dbHandler = new data_komentar_berita_sqlite_dbhandler(this);

        button_editdata = (Button) findViewById(R.id.tombol_update);
        id_komentar_berita = (EditText) findViewById(R.id.id_komentar_berita);
        id_berita = (EditText) findViewById(R.id.id_berita);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        tanggal = (EditText) findViewById(R.id.tanggal);
        komentar = (EditText) findViewById(R.id.komentar);


        Bundle bundle = getIntent().getExtras();
        id_komentar_berita.setText(bundle.getString("id_komentar_berita"));
        id_berita.setText(bundle.getString("id_berita"));
        id_alumni.setText(bundle.getString("id_alumni"));
        tanggal.setText(bundle.getString("tanggal"));
        komentar.setText(bundle.getString("komentar"));


		config_global.init_inputTypes();



        button_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();

                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_komentar_berita_sqlite_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.update_data_komentar_berita_sqlite( new data_komentar_berita_sqlite_data(
                            id_komentar_berita.getText().toString()
                            ,id_berita.getText().toString()
                            ,id_alumni.getText().toString()
                            ,tanggal.getText().toString()
                            ,komentar.getText().toString()

                    ) );

                    List<data_komentar_berita_sqlite_data> data_komentar_berita_sqliteList = dbHandler.get_semua_data_komentar_berita_sqlite();
                    adapter = new data_komentar_berita_sqlite_adapter( data_komentar_berita_sqlite_edit.this, data_komentar_berita_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_komentar_berita_sqlite_edit.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_komentar_berita.requestFocus();
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






