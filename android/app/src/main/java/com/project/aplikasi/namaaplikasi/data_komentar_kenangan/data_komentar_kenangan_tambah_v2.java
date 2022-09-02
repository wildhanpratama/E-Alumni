package com.project.aplikasi.namaaplikasi.data_komentar_kenangan;
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

public class data_komentar_kenangan_tambah_v2 extends AppCompatActivity {

	String validasi;
    Button tombol_simpan, tombol_tambah;
    data_komentar_kenangan_apiservice mAPIService;
    EditText id_komentar_kenangan
    ,id_kenangan
    ,id_alumni
    ,tanggal
    ,komentar
;

    data_komentar_kenangan_tambah_v2_adapter adapter;
    ListView data_komentar_kenangan_tampil;
	loading loading;

    ArrayList<data_komentar_kenangan_apidata> result = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_komentar_kenangan_tambah_v2 );
        tombol_simpan = (Button) findViewById(R.id.tombol_simpan);
        tombol_tambah = (Button) findViewById(R.id.btnTambah);
		loading = new loading(this);
		
        id_komentar_kenangan = (EditText) findViewById(R.id.id_komentar_kenangan);
        id_kenangan = (EditText) findViewById(R.id.id_kenangan);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        tanggal = (EditText) findViewById(R.id.tanggal);
        komentar = (EditText) findViewById(R.id.komentar);


		id_komentar_kenangan.setText( config_global.generate_id(this,"data_komentar_kenangan") );
		
        data_komentar_kenangan_tampil = (ListView) findViewById(R.id.cvdata_komentar_kenangan);

        adapter = new data_komentar_kenangan_tambah_v2_adapter(this, result);
        data_komentar_kenangan_tampil.setAdapter(adapter);

        mAPIService = data_komentar_kenangan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Simpan Data..");
				id_komentar_kenangan.setText( config_global.generate_id(data_komentar_kenangan_tambah_v2.this,"data_komentar_kenangan") );
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_komentar_kenangan_tambah_v2.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
					String token = "Bearer " + new config_global().ambil(data_komentar_kenangan_tambah_v2.this);
					mAPIService.proses_simpan_data_komentar_kenangan(id_komentar_kenangan.getText().toString()
							,id_kenangan.getText().toString()
							,id_alumni.getText().toString()
							,tanggal.getText().toString()
							,komentar.getText().toString()

							,token
					).enqueue(new Callback<Object>() {
						@Override
						public void onResponse(Call<Object> call, Response<Object> response) {
							Toast.makeText( data_komentar_kenangan_tambah_v2.this, "Berhasil Disimpan",
									Toast.LENGTH_LONG).show();
							result.add(new data_komentar_kenangan_apidata(
									id_komentar_kenangan.getText().toString()
									,id_kenangan.getText().toString()
									,id_alumni.getText().toString()
									,tanggal.getText().toString()
									,komentar.getText().toString()

							));
							adapter.updateResults(result);
							clearForm((ViewGroup) findViewById(R.id.group));
							id_komentar_kenangan.requestFocus();
							loading.hideDialog();
						}
	
						@Override
						public void onFailure(Call<Object> call, Throwable t) {
							Toast.makeText( data_komentar_kenangan_tambah_v2.this, "Gagal Disimpan",
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
