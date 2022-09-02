package com.project.aplikasi.namaaplikasi.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.project.aplikasi.namaaplikasi.R;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;

public class home_activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.home_activity );
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_kiri1, R.id.nav_kiri2
                ,R.id.nav_kiri3
                ,R.id.nav_kiri4
                ,R.id.nav_kiri5
				,R.id.nav_data_admin
				,R.id.nav_data_akreditas
				,R.id.nav_data_alumni
				,R.id.nav_data_berita
				,R.id.nav_data_jawaban_akreditas
				,R.id.nav_data_karyawan
				,R.id.nav_data_kenangan
				,R.id.nav_data_komentar_berita
				,R.id.nav_data_komentar_kenangan
				,R.id.nav_data_like_berita
				,R.id.nav_data_like_kenangan
				,R.id.nav_data_pertanyaan_akreditas
				,R.id.nav_data_sekolah

        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
	
	 public void open_webview(String url, String judul, String deskripsi)
    {
        Intent intent = new Intent(home_activity.this, com.project.aplikasi.namaaplikasi.activity.home_activity.class);
        intent.putExtra("url", url);
        intent.putExtra("judul", judul);
        intent.putExtra("deskripsi", deskripsi);
        startActivity(intent);
    }

    public void id_tombol_1(View view) {
		
    }

    public void id_tombol_2(View view) {
	
    }

    public void id_tombol_3(View view) {

    }

    public void id_tombol_4(View view) {

    }

    public void id_tombol_5(View view) {

    }

    public void id_tombol_6(View view) {

    }

    public void id_tombol_profil(View view) {

    }


}
