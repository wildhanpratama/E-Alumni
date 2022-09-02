package com.project.aplikasi.namaaplikasi.data_karyawan;

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


public class data_karyawan_tambah_v2_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_karyawan_apidata> data;
    TextView id_karyawan
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
    Button tombol_hapus;
	data_karyawan_apiservice mAPIService;
	loading loading;

    public data_karyawan_tambah_v2_adapter(Activity activity, ArrayList<data_karyawan_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_karyawan_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_karyawan_tambah_v2_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_karyawan = (TextView) v.findViewById(R.id.id_karyawan);
            nama_depan = (TextView) v.findViewById(R.id.nama_depan);
            nama_belakang = (TextView) v.findViewById(R.id.nama_belakang);
            alamat = (TextView) v.findViewById(R.id.alamat);
            email = (TextView) v.findViewById(R.id.email);
            no_telepon = (TextView) v.findViewById(R.id.no_telepon);
            kategori = (TextView) v.findViewById(R.id.kategori);
            kota = (TextView) v.findViewById(R.id.kota);
            tahun_masuk = (TextView) v.findViewById(R.id.tahun_masuk);
            tahun_keluar = (TextView) v.findViewById(R.id.tahun_keluar);
            bidang_keahlian = (TextView) v.findViewById(R.id.bidang_keahlian);
            id_sekolah = (TextView) v.findViewById(R.id.id_sekolah);
            linkedin = (TextView) v.findViewById(R.id.linkedin);
            instagram = (TextView) v.findViewById(R.id.instagram);
            facebook = (TextView) v.findViewById(R.id.facebook);
            foto = (TextView) v.findViewById(R.id.foto);
            username = (TextView) v.findViewById(R.id.username);
            password = (TextView) v.findViewById(R.id.password);

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_karyawan_tambah_v2)activity);

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
									  data_karyawan_apiservice mAPIService =
                                            data_karyawan_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_karyawan(
                                            data.get(position).get_id_karyawan(),
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

            id_karyawan.setText(""+data.get(position).get_id_karyawan());
            nama_depan.setText(""+data.get(position).get_nama_depan());
            nama_belakang.setText(""+data.get(position).get_nama_belakang());
            alamat.setText(""+data.get(position).get_alamat());
            email.setText(""+data.get(position).get_email());
            no_telepon.setText(""+data.get(position).get_no_telepon());
            kategori.setText(""+data.get(position).get_kategori());
            kota.setText(""+data.get(position).get_kota());
            tahun_masuk.setText(""+data.get(position).get_tahun_masuk());
            tahun_keluar.setText(""+data.get(position).get_tahun_keluar());
            bidang_keahlian.setText(""+data.get(position).get_bidang_keahlian());
            id_sekolah.setText(""+data.get(position).get_id_sekolah());
            linkedin.setText(""+data.get(position).get_linkedin());
            instagram.setText(""+data.get(position).get_instagram());
            facebook.setText(""+data.get(position).get_facebook());
            foto.setText(""+data.get(position).get_foto());
            username.setText(""+data.get(position).get_username());
            password.setText(""+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_karyawan_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
