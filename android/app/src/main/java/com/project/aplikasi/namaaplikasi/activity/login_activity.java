package com.project.aplikasi.namaaplikasi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_sessionmanager;
import com.project.aplikasi.namaaplikasi.data_alumni.data_alumni_tambah;
import com.project.aplikasi.namaaplikasi.data_karyawan.data_karyawan_tambah;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_activity extends AppCompatActivity {
    config_sessionmanager config_sessionmanager;
    login_apiservice mAPIService;
    AutoCompleteTextView username;
    EditText password;
    loading loading;
    Spinner login_sebagai;

    static class LoginSebagai {
        public static int alumni = 0;
        public static int karyawan = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        config_sessionmanager = new config_sessionmanager(this);
        config_sessionmanager.saveSPBoolean(config_sessionmanager.SP_SUDAH_LOGIN, false);
        mAPIService = login_apiutils.getAPIService();

        username = (AutoCompleteTextView) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login_sebagai = findViewById(R.id.login_sebagai);

        // logout (delete data session manager)
        new config_sessionmanager(this).logOut();
        loading = new loading(this);
    }


    public void login(View view) {
        loading.showDialog(1, "Please Wait", "Loading..");
        mAPIService.login_pegawai(
                username.getText().toString(),
                password.getText().toString(),
                login_sebagai.getSelectedItemPosition() == LoginSebagai.alumni ? "alumni" : "karyawan"
        ).enqueue(new Callback<login_pegawai_api>() {

            @Override
            public void onResponse(Call<login_pegawai_api> call, Response<login_pegawai_api> response) {
                if (response.code() == 200) {
                    loading.hideDialog();
                    login_pegawai_api res = response.body();
                    try {
                        if (res.getStatus().equals("success")) {
                            Toast.makeText(login_activity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                            config_sessionmanager.saveSPString(config_sessionmanager.SP_TOKEN, res.getResult().get_tkn());
                            config_sessionmanager.saveSPString(config_sessionmanager.SP_JABATAN, res.getResult().get_jabatan());
                            config_sessionmanager.saveSPString(com.project.aplikasi.namaaplikasi.config.config_sessionmanager.SP_NAMA, res.getResult().get_nama_pegawai());
                            config_sessionmanager.saveSPBoolean(config_sessionmanager.SP_SUDAH_LOGIN, true);

                            Intent intent = new Intent(login_activity.this, home_activity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        } else {
                            Toast.makeText(login_activity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NullPointerException ex) {
                        Toast.makeText(login_activity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(login_activity.this, "Koneksi Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<login_pegawai_api> call, Throwable t) {
                loading.hideDialog();
                Toast.makeText(login_activity.this, "Koneksi Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void batal(View view) {
//        if (login_sebagai.getSelectedItemPosition() == LoginSebagai.alumni) {
//        } else {
//            intent = new Intent(login_activity.this, data_karyawan_tambah.class);
//        }
        Intent intent = new Intent(login_activity.this, data_alumni_tambah.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("login_sebagai", login_sebagai.getSelectedItemPosition() == LoginSebagai.alumni ? "alumni" : "guru/karyawan");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
