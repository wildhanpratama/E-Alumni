package com.project.aplikasi.namaaplikasi.data_kenangan_sqlite;

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


public class data_kenangan_sqlite_tambah extends AppCompatActivity {

    String validasi;
    private EditText id_kenangan;
    private EditText caption;
    private EditText tanggal;
    private EditText foto;
    private EditText id_alumni;
    private EditText jumlah_like;
    private EditText jumlah_komen;

    
    private Button button_tambahdata;

    private data_kenangan_sqlite_dbhandler dbHandler;
    private data_kenangan_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_kenangan_tambah );
        dbHandler = new data_kenangan_sqlite_dbhandler(this);

        button_tambahdata = (Button) findViewById(R.id.tombol_simpan);
        id_kenangan = (EditText) findViewById(R.id.id_kenangan);
        caption = (EditText) findViewById(R.id.caption);
        tanggal = (EditText) findViewById(R.id.tanggal);
        foto = (EditText) findViewById(R.id.foto);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        jumlah_like = (EditText) findViewById(R.id.jumlah_like);
        jumlah_komen = (EditText) findViewById(R.id.jumlah_komen);


        id_kenangan.setText( config_global.generate_id( data_kenangan_sqlite_tambah.this,"data_kenangan") );
		
		config_global.init_inputTypes();


        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                id_kenangan.setText( config_global.generate_id( data_kenangan_sqlite_tambah.this,"data_kenangan") );
                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_kenangan_sqlite_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.tambah_data_kenangan_sqlite( new data_kenangan_sqlite_data(
                            id_kenangan.getText().toString()
                            ,caption.getText().toString()
                            ,tanggal.getText().toString()
                            ,foto.getText().toString()
                            ,id_alumni.getText().toString()
                            ,jumlah_like.getText().toString()
                            ,jumlah_komen.getText().toString()

                    ) );

                    List<data_kenangan_sqlite_data> data_kenangan_sqliteList = dbHandler.get_semua_data_kenangan_sqlite();
                    adapter = new data_kenangan_sqlite_adapter( data_kenangan_sqlite_tambah.this, data_kenangan_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_kenangan_sqlite_tambah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_kenangan.requestFocus();
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






