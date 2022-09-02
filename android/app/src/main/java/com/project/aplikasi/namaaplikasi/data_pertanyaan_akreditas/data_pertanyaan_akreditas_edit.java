package com.project.aplikasi.namaaplikasi.data_pertanyaan_akreditas;
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

public class data_pertanyaan_akreditas_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
    EditText id_pertanyaan_akreditas
    ,id_sekolah
    ,pertanyaan

            ;
    data_pertanyaan_akreditas_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_pertanyaan_akreditas_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
		loading = new loading(this);
		
        id_pertanyaan_akreditas = (EditText) findViewById(R.id.id_pertanyaan_akreditas);
        id_sekolah = (EditText) findViewById(R.id.id_sekolah);
        pertanyaan = (EditText) findViewById(R.id.pertanyaan);


        Bundle bundle = getIntent().getExtras();

        id_pertanyaan_akreditas.setText(bundle.getString("id_pertanyaan_akreditas"));
        id_sekolah.setText(bundle.getString("id_sekolah"));
        pertanyaan.setText(bundle.getString("pertanyaan"));


        mAPIService = data_pertanyaan_akreditas_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_pertanyaan_akreditas_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_pertanyaan_akreditas_edit.this);
                mAPIService.proses_update_data_pertanyaan_akreditas(id_pertanyaan_akreditas.getText().toString()
				,id_sekolah.getText().toString()
				,pertanyaan.getText().toString()

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_pertanyaan_akreditas_edit.this, "Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_pertanyaan_akreditas_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
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
