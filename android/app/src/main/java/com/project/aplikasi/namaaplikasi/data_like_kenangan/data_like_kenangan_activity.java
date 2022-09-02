package com.project.aplikasi.namaaplikasi.data_like_kenangan;

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

public class data_like_kenangan_activity extends AppCompatActivity {

    ArrayList<data_like_kenangan_apidata> result = new ArrayList<>();
    data_like_kenangan_adapter adapter;
    ListView data_like_kenangan_tampil;
    data_like_kenangan_apiservice mAPIService;
    Button tombol_tambah,tombol_refresh ;
    protected int REQUEST_CODE_TAMBAH = 3543;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_like_kenangan_activity );

        data_like_kenangan_tampil = (ListView) findViewById(R.id.data_like_kenangan_tampil);
        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
		tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
		loading = new loading(this);

        adapter = new data_like_kenangan_adapter(this, result);
        data_like_kenangan_tampil.setAdapter(adapter);
        data_like_kenangan_tampil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mAPIService = data_like_kenangan_apiutils.getAPIService();
        fetch_data_like_kenangan();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( data_like_kenangan_activity.this, data_like_kenangan_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });
		
		tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch_data_like_kenangan();
				 Toast.makeText(data_like_kenangan_activity.this, "Data Berhasil Diperbarui",
                            Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_like_kenangan();
            }
        }

    }

    public void fetch_data_like_kenangan(){
		loading.showDialog(1,"Please Wait","Loading Data..");
		String token = new config_global().ambil(this);
        mAPIService.tampil_data_like_kenangan("", "", "","","","", "Bearer "+token
        ).enqueue(new Callback<data_like_kenangan_api>() {
            @Override
            public void onResponse(Call<data_like_kenangan_api> call, Response<data_like_kenangan_api> response) {
				loading.hideDialog();
                data_like_kenangan_api response_data = response.body();
                Log.d("data", response_data.toString());
                adapter.updateResults(response_data.get_data_like_kenangan());
            }

            @Override
            public void onFailure(Call<data_like_kenangan_api> call, Throwable t) {
				loading.hideDialog();
            }
        });
    }
}
