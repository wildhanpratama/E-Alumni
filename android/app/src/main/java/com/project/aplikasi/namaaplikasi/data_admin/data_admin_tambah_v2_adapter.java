package com.project.aplikasi.namaaplikasi.data_admin;

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


public class data_admin_tambah_v2_adapter extends BaseAdapter {

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
    Button tombol_hapus;
	data_admin_apiservice mAPIService;
	loading loading;

    public data_admin_tambah_v2_adapter(Activity activity, ArrayList<data_admin_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_admin_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_admin_tambah_v2_tampil, null);
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

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_admin_tambah_v2)activity);

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
									  data_admin_apiservice mAPIService =
                                            data_admin_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_admin(
                                            data.get(position).get_id_admin(),
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

            id_admin.setText(""+data.get(position).get_id_admin());
            nama_depan.setText(""+data.get(position).get_nama_depan());
            nama_belakang.setText(""+data.get(position).get_nama_belakang());
            alamat.setText(""+data.get(position).get_alamat());
            email.setText(""+data.get(position).get_email());
            no_telepon.setText(""+data.get(position).get_no_telepon());
            hak_akses.setText(""+data.get(position).get_hak_akses());
            id_sekolah.setText(""+data.get(position).get_id_sekolah());
            status_pekerjaan.setText(""+data.get(position).get_status_pekerjaan());
            foto.setText(""+data.get(position).get_foto());
            username.setText(""+data.get(position).get_username());
            password.setText(""+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_admin_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
