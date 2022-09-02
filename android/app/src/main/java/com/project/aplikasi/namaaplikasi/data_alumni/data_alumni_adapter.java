package com.project.aplikasi.namaaplikasi.data_alumni;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class data_alumni_adapter extends BaseAdapter {

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
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_alumni_adapter(Activity activity, ArrayList<data_alumni_apidata> data) {
        this.activity = activity;
        this.data = data;
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
            v = vi.inflate( R.layout.data_alumni_tampil, null);
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


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_alumni());
                    bundle.putString("nama_depan", data.get(position).get_nama_depan());
                    bundle.putString("nama_belakang", data.get(position).get_nama_belakang());
                    bundle.putString("alamat", data.get(position).get_alamat());
                    bundle.putString("email", data.get(position).get_email());
                    bundle.putString("no_telepon", data.get(position).get_no_telepon());
                    bundle.putString("nisn", data.get(position).get_nisn());
                    bundle.putString("id_sekolah", data.get(position).get_id_sekolah());
                    bundle.putString("jurusan", data.get(position).get_jurusan());
                    bundle.putString("tahun_masuk", data.get(position).get_tahun_masuk());
                    bundle.putString("tahun_keluar", data.get(position).get_tahun_keluar());
                    bundle.putString("jalur_penerimaan", data.get(position).get_jalur_penerimaan());
                    bundle.putString("jenjang", data.get(position).get_jenjang());
                    bundle.putString("linkedin", data.get(position).get_linkedin());
                    bundle.putString("instagram", data.get(position).get_instagram());
                    bundle.putString("facebook", data.get(position).get_facebook());
                    bundle.putString("tempat_kerja", data.get(position).get_tempat_kerja());
                    bundle.putString("jabatan_kerja", data.get(position).get_jabatan_kerja());
                    bundle.putString("alamat_kerja", data.get(position).get_alamat_kerja());
                    bundle.putString("tahun_masuk_kerja", data.get(position).get_tahun_masuk_kerja());
                    bundle.putString("tahun_resign", data.get(position).get_tahun_resign());
                    bundle.putString("foto", data.get(position).get_foto());
                    bundle.putString("username", data.get(position).get_username());
                    bundle.putString("password", data.get(position).get_password());

                    
                    Intent intent = new Intent(activity, data_alumni_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

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
                                    String token = "Bearer " + new config_global().ambil(activity);
									data_alumni_apiservice mAPIService = 
									data_alumni_apiutils.getAPIService();
									mAPIService.proses_hapus_data_alumni(
											data.get(position).get_id_alumni(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_alumni_activity)activity).fetch_data_alumni();
										}
				
										@Override
										public void onFailure(Call<Object> call, Throwable t) {
											Toast.makeText(activity, "Gagal", Toast.LENGTH_LONG).show();
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

            id_alumni.setText("id_alumni "+data.get(position).get_id_alumni());
            nama_depan.setText("nama_depan "+data.get(position).get_nama_depan());
            nama_belakang.setText("nama_belakang "+data.get(position).get_nama_belakang());
            alamat.setText("alamat "+data.get(position).get_alamat());
            email.setText("email "+data.get(position).get_email());
            no_telepon.setText("no_telepon "+data.get(position).get_no_telepon());
            nisn.setText("nisn "+data.get(position).get_nisn());
            id_sekolah.setText("id_sekolah "+data.get(position).get_id_sekolah());
            jurusan.setText("jurusan "+data.get(position).get_jurusan());
            tahun_masuk.setText("tahun_masuk "+data.get(position).get_tahun_masuk());
            tahun_keluar.setText("tahun_keluar "+data.get(position).get_tahun_keluar());
            jalur_penerimaan.setText("jalur_penerimaan "+data.get(position).get_jalur_penerimaan());
            jenjang.setText("jenjang "+data.get(position).get_jenjang());
            linkedin.setText("linkedin "+data.get(position).get_linkedin());
            instagram.setText("instagram "+data.get(position).get_instagram());
            facebook.setText("facebook "+data.get(position).get_facebook());
            tempat_kerja.setText("tempat_kerja "+data.get(position).get_tempat_kerja());
            jabatan_kerja.setText("jabatan_kerja "+data.get(position).get_jabatan_kerja());
            alamat_kerja.setText("alamat_kerja "+data.get(position).get_alamat_kerja());
            tahun_masuk_kerja.setText("tahun_masuk_kerja "+data.get(position).get_tahun_masuk_kerja());
            tahun_resign.setText("tahun_resign "+data.get(position).get_tahun_resign());
            foto.setText("foto "+data.get(position).get_foto());
            username.setText("username "+data.get(position).get_username());
            password.setText("password "+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_alumni_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
