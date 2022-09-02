package com.project.aplikasi.namaaplikasi.data_sekolah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

import android.app.SearchManager;							 
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;				 
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.activity.loading;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class data_sekolah_activity extends AppCompatActivity {

    ArrayList<data_sekolah_apidata> result = new ArrayList<>();
    data_sekolah_adapter adapter;
    ListView data_sekolah_tampil;
    data_sekolah_apiservice mAPIService;
    Button tombol_tambah,tombol_refresh ;
    protected int REQUEST_CODE_TAMBAH = 3543;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_sekolah_activity );

        data_sekolah_tampil = (ListView) findViewById(R.id.data_sekolah_tampil);
        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
		tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
		loading = new loading(this);

        adapter = new data_sekolah_adapter(this, result);
        data_sekolah_tampil.setAdapter(adapter);
        data_sekolah_tampil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mAPIService = data_sekolah_apiutils.getAPIService();
        fetch_data_sekolah();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( data_sekolah_activity.this, data_sekolah_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });
		
		tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch_data_sekolah();
				 Toast.makeText(data_sekolah_activity.this, "Data Berhasil Diperbarui",
                            Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_sekolah();
            }
        }

    }

    public void fetch_data_sekolah(){
		loading.showDialog(1,"Please Wait","Loading Data..");
		String token = new config_global().ambil(this);
        mAPIService.tampil_data_sekolah("", "", "","","","", "Bearer "+token
        ).enqueue(new Callback<data_sekolah_api>() {
            @Override
            public void onResponse(Call<data_sekolah_api> call, Response<data_sekolah_api> response) {
				loading.hideDialog();
                data_sekolah_api response_data = response.body();
                Log.d("data", response_data.toString());
                adapter.updateResults(response_data.get_data_sekolah());
            }

            @Override
            public void onFailure(Call<data_sekolah_api> call, Throwable t) {
				loading.hideDialog();
            }
        });
    }
}
