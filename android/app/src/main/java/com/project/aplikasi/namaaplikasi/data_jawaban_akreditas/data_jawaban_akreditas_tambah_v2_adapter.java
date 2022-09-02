package com.project.aplikasi.namaaplikasi.data_jawaban_akreditas;

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


public class data_jawaban_akreditas_tambah_v2_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_jawaban_akreditas_apidata> data;
    TextView id_jawaban_akreditas
    ,id_pertanyaan_akreditas
    ,jawaban
    ,id_alumni
;
    Button tombol_hapus;
	data_jawaban_akreditas_apiservice mAPIService;
	loading loading;

    public data_jawaban_akreditas_tambah_v2_adapter(Activity activity, ArrayList<data_jawaban_akreditas_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_jawaban_akreditas_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_jawaban_akreditas_tambah_v2_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_jawaban_akreditas = (TextView) v.findViewById(R.id.id_jawaban_akreditas);
            id_pertanyaan_akreditas = (TextView) v.findViewById(R.id.id_pertanyaan_akreditas);
            jawaban = (TextView) v.findViewById(R.id.jawaban);
            id_alumni = (TextView) v.findViewById(R.id.id_alumni);

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_jawaban_akreditas_tambah_v2)activity);

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
									  data_jawaban_akreditas_apiservice mAPIService =
                                            data_jawaban_akreditas_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_jawaban_akreditas(
                                            data.get(position).get_id_jawaban_akreditas(),
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

            id_jawaban_akreditas.setText(""+data.get(position).get_id_jawaban_akreditas());
            id_pertanyaan_akreditas.setText(""+data.get(position).get_id_pertanyaan_akreditas());
            jawaban.setText(""+data.get(position).get_jawaban());
            id_alumni.setText(""+data.get(position).get_id_alumni());


        }

        return v;
    }

    public void updateResults(ArrayList<data_jawaban_akreditas_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
