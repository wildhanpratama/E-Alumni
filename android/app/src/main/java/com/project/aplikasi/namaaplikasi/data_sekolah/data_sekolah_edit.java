package com.project.aplikasi.namaaplikasi.data_sekolah;
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

public class data_sekolah_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
    EditText id_sekolah
    ,nama_sekolah
    ,alamat
    ,email
    ,no_telepon
    ,kota
    ,deskripsi

            ;
    data_sekolah_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_sekolah_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
		loading = new loading(this);
		
        id_sekolah = (EditText) findViewById(R.id.id_sekolah);
        nama_sekolah = (EditText) findViewById(R.id.nama_sekolah);
        alamat = (EditText) findViewById(R.id.alamat);
        email = (EditText) findViewById(R.id.email);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        kota = (EditText) findViewById(R.id.kota);
        deskripsi = (EditText) findViewById(R.id.deskripsi);


        Bundle bundle = getIntent().getExtras();

        id_sekolah.setText(bundle.getString("id_sekolah"));
        nama_sekolah.setText(bundle.getString("nama_sekolah"));
        alamat.setText(bundle.getString("alamat"));
        email.setText(bundle.getString("email"));
        no_telepon.setText(bundle.getString("no_telepon"));
        kota.setText(bundle.getString("kota"));
        deskripsi.setText(bundle.getString("deskripsi"));


        mAPIService = data_sekolah_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_sekolah_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_sekolah_edit.this);
                mAPIService.proses_update_data_sekolah(id_sekolah.getText().toString()
				,nama_sekolah.getText().toString()
				,alamat.getText().toString()
				,email.getText().toString()
				,no_telepon.getText().toString()
				,kota.getText().toString()
				,deskripsi.getText().toString()

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_sekolah_edit.this, "Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_sekolah_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
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
