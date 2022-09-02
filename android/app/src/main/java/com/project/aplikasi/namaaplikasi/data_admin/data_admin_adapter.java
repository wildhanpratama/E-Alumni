package com.project.aplikasi.namaaplikasi.data_admin;

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


public class data_admin_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_admin_apidata> data;
    TextView id_admin
                 ,nama_depan
                 ,nama_belakang
                 ,alamat
                 ,email
                 ,no_telepon
                 ,hak_akses
                 ,id_sekolah
                 ,status_pekerjaan
                 ,foto
                 ,username
                 ,password

            ;
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_admin_adapter(Activity activity, ArrayList<data_admin_apidata> data) {
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
            v = vi.inflate( R.layout.data_admin_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_admin = (TextView) v.findViewById(R.id.id_admin);
            nama_depan = (TextView) v.findViewById(R.id.nama_depan);
            nama_belakang = (TextView) v.findViewById(R.id.nama_belakang);
            alamat = (TextView) v.findViewById(R.id.alamat);
            email = (TextView) v.findViewById(R.id.email);
            no_telepon = (TextView) v.findViewById(R.id.no_telepon);
            hak_akses = (TextView) v.findViewById(R.id.hak_akses);
            id_sekolah = (TextView) v.findViewById(R.id.id_sekolah);
            status_pekerjaan = (TextView) v.findViewById(R.id.status_pekerjaan);
            foto = (TextView) v.findViewById(R.id.foto);
            username = (TextView) v.findViewById(R.id.username);
            password = (TextView) v.findViewById(R.id.password);


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_admin());
                    bundle.putString("nama_depan", data.get(position).get_nama_depan());
                    bundle.putString("nama_belakang", data.get(position).get_nama_belakang());
                    bundle.putString("alamat", data.get(position).get_alamat());
                    bundle.putString("email", data.get(position).get_email());
                    bundle.putString("no_telepon", data.get(position).get_no_telepon());
                    bundle.putString("hak_akses", data.get(position).get_hak_akses());
                    bundle.putString("id_sekolah", data.get(position).get_id_sekolah());
                    bundle.putString("status_pekerjaan", data.get(position).get_status_pekerjaan());
                    bundle.putString("foto", data.get(position).get_foto());
                    bundle.putString("username", data.get(position).get_username());
                    bundle.putString("password", data.get(position).get_password());

                    
                    Intent intent = new Intent(activity, data_admin_edit.class);
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
									data_admin_apiservice mAPIService = 
									data_admin_apiutils.getAPIService();
									mAPIService.proses_hapus_data_admin(
											data.get(position).get_id_admin(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_admin_activity)activity).fetch_data_admin();
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

            id_admin.setText("id_admin "+data.get(position).get_id_admin());
            nama_depan.setText("nama_depan "+data.get(position).get_nama_depan());
            nama_belakang.setText("nama_belakang "+data.get(position).get_nama_belakang());
            alamat.setText("alamat "+data.get(position).get_alamat());
            email.setText("email "+data.get(position).get_email());
            no_telepon.setText("no_telepon "+data.get(position).get_no_telepon());
            hak_akses.setText("hak_akses "+data.get(position).get_hak_akses());
            id_sekolah.setText("id_sekolah "+data.get(position).get_id_sekolah());
            status_pekerjaan.setText("status_pekerjaan "+data.get(position).get_status_pekerjaan());
            foto.setText("foto "+data.get(position).get_foto());
            username.setText("username "+data.get(position).get_username());
            password.setText("password "+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_admin_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
