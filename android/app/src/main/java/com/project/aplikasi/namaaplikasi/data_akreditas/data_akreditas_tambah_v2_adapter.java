package com.project.aplikasi.namaaplikasi.data_akreditas;

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


public class data_akreditas_tambah_v2_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_akreditas_apidata> data;
    TextView id_akreditas
    ,nama_lengkap
    ,nisn
    ,kelas
    ,tahun_lulus
    ,email
    ,status_pekerjaan
;
    Button tombol_hapus;
	data_akreditas_apiservice mAPIService;
	loading loading;

    public data_akreditas_tambah_v2_adapter(Activity activity, ArrayList<data_akreditas_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_akreditas_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_akreditas_tambah_v2_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_akreditas = (TextView) v.findViewById(R.id.id_akreditas);
            nama_lengkap = (TextView) v.findViewById(R.id.nama_lengkap);
            nisn = (TextView) v.findViewById(R.id.nisn);
            kelas = (TextView) v.findViewById(R.id.kelas);
            tahun_lulus = (TextView) v.findViewById(R.id.tahun_lulus);
            email = (TextView) v.findViewById(R.id.email);
            status_pekerjaan = (TextView) v.findViewById(R.id.status_pekerjaan);

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_akreditas_tambah_v2)activity);

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
									  data_akreditas_apiservice mAPIService =
                                            data_akreditas_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_akreditas(
                                            data.get(position).get_id_akreditas(),
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

            id_akreditas.setText(""+data.get(position).get_id_akreditas());
            nama_lengkap.setText(""+data.get(position).get_nama_lengkap());
            nisn.setText(""+data.get(position).get_nisn());
            kelas.setText(""+data.get(position).get_kelas());
            tahun_lulus.setText(""+data.get(position).get_tahun_lulus());
            email.setText(""+data.get(position).get_email());
            status_pekerjaan.setText(""+data.get(position).get_status_pekerjaan());


        }

        return v;
    }

    public void updateResults(ArrayList<data_akreditas_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
