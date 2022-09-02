package com.project.aplikasi.namaaplikasi.data_komentar_kenangan;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.activity.loading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.project.aplikasi.namaaplikasi.config.config_global.inputTypes;

public class data_komentar_kenangan_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
    EditText id_komentar_kenangan
    ,id_kenangan
    ,id_alumni
    ,tanggal
    ,komentar

            ;
    data_komentar_kenangan_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_komentar_kenangan_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
		loading = new loading(this);
		
        id_komentar_kenangan = (EditText) findViewById(R.id.id_komentar_kenangan);
        id_kenangan = (EditText) findViewById(R.id.id_kenangan);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        tanggal = (EditText) findViewById(R.id.tanggal);
        komentar = (EditText) findViewById(R.id.komentar);


        Bundle bundle = getIntent().getExtras();

        id_komentar_kenangan.setText(bundle.getString("id_komentar_kenangan"));
        id_kenangan.setText(bundle.getString("id_kenangan"));
        id_alumni.setText(bundle.getString("id_alumni"));
        tanggal.setText(bundle.getString("tanggal"));
        komentar.setText(bundle.getString("komentar"));


        mAPIService = data_komentar_kenangan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_komentar_kenangan_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_komentar_kenangan_edit.this);
                mAPIService.proses_update_data_komentar_kenangan(id_komentar_kenangan.getText().toString()
				,id_kenangan.getText().toString()
				,id_alumni.getText().toString()
				,tanggal.getText().toString()
				,komentar.getText().toString()

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_komentar_kenangan_edit.this, "Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_komentar_kenangan_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
						loading.hideDialog();
                    }
                });
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
                }
			  }
                if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                    validasiForm((ViewGroup)view);
            }
    }
	
}
