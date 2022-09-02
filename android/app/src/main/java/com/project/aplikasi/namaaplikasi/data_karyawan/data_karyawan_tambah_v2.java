package com.project.aplikasi.namaaplikasi.data_karyawan;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.activity.loading;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.project.aplikasi.namaaplikasi.config.config_global.inputTypes;

public class data_karyawan_tambah_v2 extends AppCompatActivity {

	String validasi;
    Button tombol_simpan, tombol_tambah;
    data_karyawan_apiservice mAPIService;
    EditText id_karyawan
    ,nama_depan
    ,nama_belakang
    ,alamat
    ,email
    ,no_telepon
    ,kategori
    ,kota
    ,tahun_masuk
    ,tahun_keluar
    ,bidang_keahlian
    ,id_sekolah
    ,linkedin
    ,instagram
    ,facebook
    ,foto
    ,username
    ,password
;

    data_karyawan_tambah_v2_adapter adapter;
    ListView data_karyawan_tampil;
	loading loading;

    ArrayList<data_karyawan_apidata> result = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_karyawan_tambah_v2 );
        tombol_simpan = (Button) findViewById(R.id.tombol_simpan);
        tombol_tambah = (Button) findViewById(R.id.btnTambah);
		loading = new loading(this);
		
        id_karyawan = (EditText) findViewById(R.id.id_karyawan);
        nama_depan = (EditText) findViewById(R.id.nama_depan);
        nama_belakang = (EditText) findViewById(R.id.nama_belakang);
        alamat = (EditText) findViewById(R.id.alamat);
        email = (EditText) findViewById(R.id.email);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        kategori = (EditText) findViewById(R.id.kategori);
        kota = (EditText) findViewById(R.id.kota);
        tahun_masuk = (EditText) findViewById(R.id.tahun_masuk);
        tahun_keluar = (EditText) findViewById(R.id.tahun_keluar);
        bidang_keahlian = (EditText) findViewById(R.id.bidang_keahlian);
        id_sekolah = (EditText) findViewById(R.id.id_sekolah);
        linkedin = (EditText) findViewById(R.id.linkedin);
        instagram = (EditText) findViewById(R.id.instagram);
        facebook = (EditText) findViewById(R.id.facebook);
        foto = (EditText) findViewById(R.id.foto);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


		id_karyawan.setText( config_global.generate_id(this,"data_karyawan") );
		
        data_karyawan_tampil = (ListView) findViewById(R.id.cvdata_karyawan);

        adapter = new data_karyawan_tambah_v2_adapter(this, result);
        data_karyawan_tampil.setAdapter(adapter);

        mAPIService = data_karyawan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Simpan Data..");
				id_karyawan.setText( config_global.generate_id(data_karyawan_tambah_v2.this,"data_karyawan") );
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_karyawan_tambah_v2.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
					String token = "Bearer " + new config_global().ambil(data_karyawan_tambah_v2.this);
					mAPIService.proses_simpan_data_karyawan(id_karyawan.getText().toString()
							,nama_depan.getText().toString()
							,nama_belakang.getText().toString()
							,alamat.getText().toString()
							,email.getText().toString()
							,no_telepon.getText().toString()
							,kategori.getText().toString()
							,kota.getText().toString()
							,tahun_masuk.getText().toString()
							,tahun_keluar.getText().toString()
							,bidang_keahlian.getText().toString()
							,id_sekolah.getText().toString()
							,linkedin.getText().toString()
							,instagram.getText().toString()
							,facebook.getText().toString()
							,foto.getText().toString()
							,username.getText().toString()
							,password.getText().toString()

							,token
					).enqueue(new Callback<Object>() {
						@Override
						public void onResponse(Call<Object> call, Response<Object> response) {
							Toast.makeText( data_karyawan_tambah_v2.this, "Berhasil Disimpan",
									Toast.LENGTH_LONG).show();
							result.add(new data_karyawan_apidata(
									id_karyawan.getText().toString()
									,nama_depan.getText().toString()
									,nama_belakang.getText().toString()
									,alamat.getText().toString()
									,email.getText().toString()
									,no_telepon.getText().toString()
									,kategori.getText().toString()
									,kota.getText().toString()
									,tahun_masuk.getText().toString()
									,tahun_keluar.getText().toString()
									,bidang_keahlian.getText().toString()
									,id_sekolah.getText().toString()
									,linkedin.getText().toString()
									,instagram.getText().toString()
									,facebook.getText().toString()
									,foto.getText().toString()
									,username.getText().toString()
									,password.getText().toString()

							));
							adapter.updateResults(result);
							clearForm((ViewGroup) findViewById(R.id.group));
							id_karyawan.requestFocus();
							loading.hideDialog();
						}
	
						@Override
						public void onFailure(Call<Object> call, Throwable t) {
							Toast.makeText( data_karyawan_tambah_v2.this, "Gagal Disimpan",
									Toast.LENGTH_LONG).show();
									loading.hideDialog();
						}
					});
				}
            }
        });


        tombol_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);
                finish();



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
	
	
	
}
