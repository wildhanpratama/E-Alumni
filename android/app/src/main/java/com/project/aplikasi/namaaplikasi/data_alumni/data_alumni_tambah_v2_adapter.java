package com.project.aplikasi.namaaplikasi.data_alumni;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.activity.loading;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class data_alumni_tambah_v2_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_alumni_apidata> data;
    TextView id_alumni
    ,nama_depan
    ,nama_belakang
    ,alamat
    ,email
    ,no_telepon
    ,nisn
    ,id_sekolah
    ,jurusan
    ,tahun_masuk
    ,tahun_keluar
    ,jalur_penerimaan
    ,jenjang
    ,linkedin
    ,instagram
    ,facebook
    ,tempat_kerja
    ,jabatan_kerja
    ,alamat_kerja
    ,tahun_masuk_kerja
    ,tahun_resign
    ,foto
    ,username
    ,password
;
    Button tombol_hapus;
	data_alumni_apiservice mAPIService;
	loading loading;

    public data_alumni_tambah_v2_adapter(Activity activity, ArrayList<data_alumni_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_alumni_apiutils.getAPIService();
    }

    @Override
    public int getCount() {
        if (data == null){
            return 0;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(activity);
            v = vi.inflate( R.layout.data_alumni_tambah_v2_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_alumni = (TextView) v.findViewById(R.id.id_alumni);
            nama_depan = (TextView) v.findViewById(R.id.nama_depan);
            nama_belakang = (TextView) v.findViewById(R.id.nama_belakang);
            alamat = (TextView) v.findViewById(R.id.alamat);
            email = (TextView) v.findViewById(R.id.email);
            no_telepon = (TextView) v.findViewById(R.id.no_telepon);
            nisn = (TextView) v.findViewById(R.id.nisn);
            id_sekolah = (TextView) v.findViewById(R.id.id_sekolah);
            jurusan = (TextView) v.findViewById(R.id.jurusan);
            tahun_masuk = (TextView) v.findViewById(R.id.tahun_masuk);
            tahun_keluar = (TextView) v.findViewById(R.id.tahun_keluar);
            jalur_penerimaan = (TextView) v.findViewById(R.id.jalur_penerimaan);
            jenjang = (TextView) v.findViewById(R.id.jenjang);
            linkedin = (TextView) v.findViewById(R.id.linkedin);
            instagram = (TextView) v.findViewById(R.id.instagram);
            facebook = (TextView) v.findViewById(R.id.facebook);
            tempat_kerja = (TextView) v.findViewById(R.id.tempat_kerja);
            jabatan_kerja = (TextView) v.findViewById(R.id.jabatan_kerja);
            alamat_kerja = (TextView) v.findViewById(R.id.alamat_kerja);
            tahun_masuk_kerja = (TextView) v.findViewById(R.id.tahun_masuk_kerja);
            tahun_resign = (TextView) v.findViewById(R.id.tahun_resign);
            foto = (TextView) v.findViewById(R.id.foto);
            username = (TextView) v.findViewById(R.id.username);
            password = (TextView) v.findViewById(R.id.password);

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_alumni_tambah_v2)activity);

            tombol_hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(activity);
                    BackAlertDialog.setTitle("Proses Hapus");
                    BackAlertDialog.setMessage("Apakah Anda ingin Menghapus Data?");
                    BackAlertDialog.setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Proses Hapus
									loading.showDialog(1,"Please Wait","Proses Hapus Data..");
									  data_alumni_apiservice mAPIService =
                                            data_alumni_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_alumni(
                                            data.get(position).get_id_alumni(),
                                            token
                                    ).enqueue(new Callback<Object>() {
                                        @Override
                                        public void onResponse(Call<Object> call, Response<Object> response) {
                                            if (new config_global().checkTokenOlineIsValid(activity,
                                                    response.code())){
                                                data.remove(position);
                                                 notifyDataSetChanged();
                                            }
                                            loading.hideDialog();
                                        }

                                        @Override
                                        public void onFailure(Call<Object> call, Throwable t) {
                                            loading.hideDialog();
                                        }
                                    });
                                }
                            });

                    BackAlertDialog.setNegativeButton("Tidak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Batal Hapus
                                    dialog.cancel();
                                }
                            });
                    BackAlertDialog.show();



                }
            });

            id_alumni.setText(""+data.get(position).get_id_alumni());
            nama_depan.setText(""+data.get(position).get_nama_depan());
            nama_belakang.setText(""+data.get(position).get_nama_belakang());
            alamat.setText(""+data.get(position).get_alamat());
            email.setText(""+data.get(position).get_email());
            no_telepon.setText(""+data.get(position).get_no_telepon());
            nisn.setText(""+data.get(position).get_nisn());
            id_sekolah.setText(""+data.get(position).get_id_sekolah());
            jurusan.setText(""+data.get(position).get_jurusan());
            tahun_masuk.setText(""+data.get(position).get_tahun_masuk());
            tahun_keluar.setText(""+data.get(position).get_tahun_keluar());
            jalur_penerimaan.setText(""+data.get(position).get_jalur_penerimaan());
            jenjang.setText(""+data.get(position).get_jenjang());
            linkedin.setText(""+data.get(position).get_linkedin());
            instagram.setText(""+data.get(position).get_instagram());
            facebook.setText(""+data.get(position).get_facebook());
            tempat_kerja.setText(""+data.get(position).get_tempat_kerja());
            jabatan_kerja.setText(""+data.get(position).get_jabatan_kerja());
            alamat_kerja.setText(""+data.get(position).get_alamat_kerja());
            tahun_masuk_kerja.setText(""+data.get(position).get_tahun_masuk_kerja());
            tahun_resign.setText(""+data.get(position).get_tahun_resign());
            foto.setText(""+data.get(position).get_foto());
            username.setText(""+data.get(position).get_username());
            password.setText(""+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_alumni_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
