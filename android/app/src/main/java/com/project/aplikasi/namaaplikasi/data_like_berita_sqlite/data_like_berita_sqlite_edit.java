package com.project.aplikasi.namaaplikasi.data_like_berita_sqlite;

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


public class data_like_berita_sqlite_edit extends AppCompatActivity {

    String validasi;
    private EditText id_like_berita;
    private EditText tanggal;
    private EditText id_berita;
    private EditText id_alumni;

    
    private Button button_editdata;

    private data_like_berita_sqlite_dbhandler dbHandler;
    private data_like_berita_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_like_berita_edit );
        dbHandler = new data_like_berita_sqlite_dbhandler(this);

        button_editdata = (Button) findViewById(R.id.tombol_update);
        id_like_berita = (EditText) findViewById(R.id.id_like_berita);
        tanggal = (EditText) findViewById(R.id.tanggal);
        id_berita = (EditText) findViewById(R.id.id_berita);
        id_alumni = (EditText) findViewById(R.id.id_alumni);


        Bundle bundle = getIntent().getExtras();
        id_like_berita.setText(bundle.getString("id_like_berita"));
        tanggal.setText(bundle.getString("tanggal"));
        id_berita.setText(bundle.getString("id_berita"));
        id_alumni.setText(bundle.getString("id_alumni"));


		config_global.init_inputTypes();



        button_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();

                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_like_berita_sqlite_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.update_data_like_berita_sqlite( new data_like_berita_sqlite_data(
                            id_like_berita.getText().toString()
                            ,tanggal.getText().toString()
                            ,id_berita.getText().toString()
                            ,id_alumni.getText().toString()

                    ) );

                    List<data_like_berita_sqlite_data> data_like_berita_sqliteList = dbHandler.get_semua_data_like_berita_sqlite();
                    adapter = new data_like_berita_sqlite_adapter( data_like_berita_sqlite_edit.this, data_like_berita_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_like_berita_sqlite_edit.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_like_berita.requestFocus();
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






