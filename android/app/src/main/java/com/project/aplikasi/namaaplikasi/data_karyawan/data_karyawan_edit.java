package com.project.aplikasi.namaaplikasi.data_karyawan;
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

public class data_karyawan_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
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
    data_karyawan_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_karyawan_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
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


        Bundle bundle = getIntent().getExtras();

        id_karyawan.setText(bundle.getString("id_karyawan"));
        nama_depan.setText(bundle.getString("nama_depan"));
        nama_belakang.setText(bundle.getString("nama_belakang"));
        alamat.setText(bundle.getString("alamat"));
        email.setText(bundle.getString("email"));
        no_telepon.setText(bundle.getString("no_telepon"));
        kategori.setText(bundle.getString("kategori"));
        kota.setText(bundle.getString("kota"));
        tahun_masuk.setText(bundle.getString("tahun_masuk"));
        tahun_keluar.setText(bundle.getString("tahun_keluar"));
        bidang_keahlian.setText(bundle.getString("bidang_keahlian"));
        id_sekolah.setText(bundle.getString("id_sekolah"));
        linkedin.setText(bundle.getString("linkedin"));
        instagram.setText(bundle.getString("instagram"));
        facebook.setText(bundle.getString("facebook"));
        foto.setText(bundle.getString("foto"));
        username.setText(bundle.getString("username"));
        password.setText(bundle.getString("password"));


        mAPIService = data_karyawan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_karyawan_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_karyawan_edit.this);
                mAPIService.proses_update_data_karyawan(id_karyawan.getText().toString()
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

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_karyawan_edit.this, "Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_karyawan_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
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
