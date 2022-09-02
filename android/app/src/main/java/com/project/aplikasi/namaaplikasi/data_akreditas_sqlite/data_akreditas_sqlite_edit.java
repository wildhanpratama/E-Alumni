package com.project.aplikasi.namaaplikasi.data_akreditas_sqlite;

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


public class data_akreditas_sqlite_edit extends AppCompatActivity {

    String validasi;
    private EditText id_akreditas;
    private EditText nama_lengkap;
    private EditText nisn;
    private EditText kelas;
    private EditText tahun_lulus;
    private EditText email;
    private EditText status_pekerjaan;

    
    private Button button_editdata;

    private data_akreditas_sqlite_dbhandler dbHandler;
    private data_akreditas_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_akreditas_edit );
        dbHandler = new data_akreditas_sqlite_dbhandler(this);

        button_editdata = (Button) findViewById(R.id.tombol_update);
        id_akreditas = (EditText) findViewById(R.id.id_akreditas);
        nama_lengkap = (EditText) findViewById(R.id.nama_lengkap);
        nisn = (EditText) findViewById(R.id.nisn);
        kelas = (EditText) findViewById(R.id.kelas);
        tahun_lulus = (EditText) findViewById(R.id.tahun_lulus);
        email = (EditText) findViewById(R.id.email);
        status_pekerjaan = (EditText) findViewById(R.id.status_pekerjaan);


        Bundle bundle = getIntent().getExtras();
        id_akreditas.setText(bundle.getString("id_akreditas"));
        nama_lengkap.setText(bundle.getString("nama_lengkap"));
        nisn.setText(bundle.getString("nisn"));
        kelas.setText(bundle.getString("kelas"));
        tahun_lulus.setText(bundle.getString("tahun_lulus"));
        email.setText(bundle.getString("email"));
        status_pekerjaan.setText(bundle.getString("status_pekerjaan"));


		config_global.init_inputTypes();



        button_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();

                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_akreditas_sqlite_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.update_data_akreditas_sqlite( new data_akreditas_sqlite_data(
                            id_akreditas.getText().toString()
                            ,nama_lengkap.getText().toString()
                            ,nisn.getText().toString()
                            ,kelas.getText().toString()
                            ,tahun_lulus.getText().toString()
                            ,email.getText().toString()
                            ,status_pekerjaan.getText().toString()

                    ) );

                    List<data_akreditas_sqlite_data> data_akreditas_sqliteList = dbHandler.get_semua_data_akreditas_sqlite();
                    adapter = new data_akreditas_sqlite_adapter( data_akreditas_sqlite_edit.this, data_akreditas_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_akreditas_sqlite_edit.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_akreditas.requestFocus();
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






