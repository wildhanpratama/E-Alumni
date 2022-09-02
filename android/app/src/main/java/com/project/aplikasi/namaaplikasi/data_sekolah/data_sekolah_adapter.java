package com.project.aplikasi.namaaplikasi.data_sekolah;

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


public class data_sekolah_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_sekolah_apidata> data;
    TextView id_sekolah
                 ,nama_sekolah
                 ,alamat
                 ,email
                 ,no_telepon
                 ,kota
                 ,deskripsi

            ;
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_sekolah_adapter(Activity activity, ArrayList<data_sekolah_apidata> data) {
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
            v = vi.inflate( R.layout.data_sekolah_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_sekolah = (TextView) v.findViewById(R.id.id_sekolah);
            nama_sekolah = (TextView) v.findViewById(R.id.nama_sekolah);
            alamat = (TextView) v.findViewById(R.id.alamat);
            email = (TextView) v.findViewById(R.id.email);
            no_telepon = (TextView) v.findViewById(R.id.no_telepon);
            kota = (TextView) v.findViewById(R.id.kota);
            deskripsi = (TextView) v.findViewById(R.id.deskripsi);


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_sekolah());
                    bundle.putString("nama_sekolah", data.get(position).get_nama_sekolah());
                    bundle.putString("alamat", data.get(position).get_alamat());
                    bundle.putString("email", data.get(position).get_email());
                    bundle.putString("no_telepon", data.get(position).get_no_telepon());
                    bundle.putString("kota", data.get(position).get_kota());
                    bundle.putString("deskripsi", data.get(position).get_deskripsi());

                    
                    Intent intent = new Intent(activity, data_sekolah_edit.class);
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
									data_sekolah_apiservice mAPIService = 
									data_sekolah_apiutils.getAPIService();
									mAPIService.proses_hapus_data_sekolah(
											data.get(position).get_id_sekolah(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_sekolah_activity)activity).fetch_data_sekolah();
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

            id_sekolah.setText("id_sekolah "+data.get(position).get_id_sekolah());
            nama_sekolah.setText("nama_sekolah "+data.get(position).get_nama_sekolah());
            alamat.setText("alamat "+data.get(position).get_alamat());
            email.setText("email "+data.get(position).get_email());
            no_telepon.setText("no_telepon "+data.get(position).get_no_telepon());
            kota.setText("kota "+data.get(position).get_kota());
            deskripsi.setText("deskripsi "+data.get(position).get_deskripsi());


        }

        return v;
    }

    public void updateResults(ArrayList<data_sekolah_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
