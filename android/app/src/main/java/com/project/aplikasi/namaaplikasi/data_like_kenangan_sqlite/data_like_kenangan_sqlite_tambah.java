package com.project.aplikasi.namaaplikasi.data_like_kenangan_sqlite;

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


public class data_like_kenangan_sqlite_tambah extends AppCompatActivity {

    String validasi;
    private EditText id_like_kenangan;
    private EditText tanggal;
    private EditText id_kenangan;
    private EditText id_alumni;

    
    private Button button_tambahdata;

    private data_like_kenangan_sqlite_dbhandler dbHandler;
    private data_like_kenangan_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_like_kenangan_tambah );
        dbHandler = new data_like_kenangan_sqlite_dbhandler(this);

        button_tambahdata = (Button) findViewById(R.id.tombol_simpan);
        id_like_kenangan = (EditText) findViewById(R.id.id_like_kenangan);
        tanggal = (EditText) findViewById(R.id.tanggal);
        id_kenangan = (EditText) findViewById(R.id.id_kenangan);
        id_alumni = (EditText) findViewById(R.id.id_alumni);


        id_like_kenangan.setText( config_global.generate_id( data_like_kenangan_sqlite_tambah.this,"data_like_kenangan") );
		
		config_global.init_inputTypes();


        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                id_like_kenangan.setText( config_global.generate_id( data_like_kenangan_sqlite_tambah.this,"data_like_kenangan") );
                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_like_kenangan_sqlite_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.tambah_data_like_kenangan_sqlite( new data_like_kenangan_sqlite_data(
                            id_like_kenangan.getText().toString()
                            ,tanggal.getText().toString()
                            ,id_kenangan.getText().toString()
                            ,id_alumni.getText().toString()

                    ) );

                    List<data_like_kenangan_sqlite_data> data_like_kenangan_sqliteList = dbHandler.get_semua_data_like_kenangan_sqlite();
                    adapter = new data_like_kenangan_sqlite_adapter( data_like_kenangan_sqlite_tambah.this, data_like_kenangan_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_like_kenangan_sqlite_tambah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_like_kenangan.requestFocus();
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






