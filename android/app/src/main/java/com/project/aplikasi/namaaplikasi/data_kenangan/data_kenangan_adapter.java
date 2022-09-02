package com.project.aplikasi.namaaplikasi.data_kenangan;

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


public class data_kenangan_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_kenangan_apidata> data;
    TextView id_kenangan
                 ,caption
                 ,tanggal
                 ,foto
                 ,id_alumni
                 ,jumlah_like
                 ,jumlah_komen

            ;
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_kenangan_adapter(Activity activity, ArrayList<data_kenangan_apidata> data) {
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
            v = vi.inflate( R.layout.data_kenangan_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_kenangan = (TextView) v.findViewById(R.id.id_kenangan);
            caption = (TextView) v.findViewById(R.id.caption);
            tanggal = (TextView) v.findViewById(R.id.tanggal);
            foto = (TextView) v.findViewById(R.id.foto);
            id_alumni = (TextView) v.findViewById(R.id.id_alumni);
            jumlah_like = (TextView) v.findViewById(R.id.jumlah_like);
            jumlah_komen = (TextView) v.findViewById(R.id.jumlah_komen);


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_kenangan());
                    bundle.putString("caption", data.get(position).get_caption());
                    bundle.putString("tanggal", data.get(position).get_tanggal());
                    bundle.putString("foto", data.get(position).get_foto());
                    bundle.putString("id_alumni", data.get(position).get_id_alumni());
                    bundle.putString("jumlah_like", data.get(position).get_jumlah_like());
                    bundle.putString("jumlah_komen", data.get(position).get_jumlah_komen());

                    
                    Intent intent = new Intent(activity, data_kenangan_edit.class);
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
									data_kenangan_apiservice mAPIService = 
									data_kenangan_apiutils.getAPIService();
									mAPIService.proses_hapus_data_kenangan(
											data.get(position).get_id_kenangan(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_kenangan_activity)activity).fetch_data_kenangan();
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

            id_kenangan.setText("id_kenangan "+data.get(position).get_id_kenangan());
            caption.setText("caption "+data.get(position).get_caption());
            tanggal.setText("tanggal "+data.get(position).get_tanggal());
            foto.setText("foto "+data.get(position).get_foto());
            id_alumni.setText("id_alumni "+data.get(position).get_id_alumni());
            jumlah_like.setText("jumlah_like "+data.get(position).get_jumlah_like());
            jumlah_komen.setText("jumlah_komen "+data.get(position).get_jumlah_komen());


        }

        return v;
    }

    public void updateResults(ArrayList<data_kenangan_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
