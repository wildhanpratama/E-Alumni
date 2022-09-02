package com.project.aplikasi.namaaplikasi.data_komentar_berita;

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


public class data_komentar_berita_tambah_v2_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_komentar_berita_apidata> data;
    TextView id_komentar_berita
    ,id_berita
    ,id_alumni
    ,tanggal
    ,komentar
;
    Button tombol_hapus;
	data_komentar_berita_apiservice mAPIService;
	loading loading;

    public data_komentar_berita_tambah_v2_adapter(Activity activity, ArrayList<data_komentar_berita_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_komentar_berita_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_komentar_berita_tambah_v2_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_komentar_berita = (TextView) v.findViewById(R.id.id_komentar_berita);
            id_berita = (TextView) v.findViewById(R.id.id_berita);
            id_alumni = (TextView) v.findViewById(R.id.id_alumni);
            tanggal = (TextView) v.findViewById(R.id.tanggal);
            komentar = (TextView) v.findViewById(R.id.komentar);

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_komentar_berita_tambah_v2)activity);

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
									  data_komentar_berita_apiservice mAPIService =
                                            data_komentar_berita_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_komentar_berita(
                                            data.get(position).get_id_komentar_berita(),
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

            id_komentar_berita.setText(""+data.get(position).get_id_komentar_berita());
            id_berita.setText(""+data.get(position).get_id_berita());
            id_alumni.setText(""+data.get(position).get_id_alumni());
            tanggal.setText(""+data.get(position).get_tanggal());
            komentar.setText(""+data.get(position).get_komentar());


        }

        return v;
    }

    public void updateResults(ArrayList<data_komentar_berita_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
