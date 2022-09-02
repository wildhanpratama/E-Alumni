package com.project.aplikasi.namaaplikasi.data_akreditas_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import com.project.aplikasi.namaaplikasi.R;

import java.util.ArrayList;
import java.util.List;


public class data_akreditas_sqlite_adapter extends RecyclerView.Adapter<data_akreditas_sqlite_adapter.data_akreditas_ViewHolder> {

    Activity activity;
    private List<data_akreditas_sqlite_data> datalist = new ArrayList<>();
    private data_akreditas_sqlite_dbhandler dbHandler;
    private data_akreditas_sqlite_adapter adapter;


    public data_akreditas_sqlite_adapter(Activity activity,List<data_akreditas_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_akreditas_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_akreditas_tampil_v2, parent, false);
        data_akreditas_ViewHolder mahasiswaViewHolder = new data_akreditas_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_akreditas_ViewHolder holder, int position) {
        holder.txt_result_id_akreditas.setText("id_akreditas : " + datalist.get(position).get_id_akreditas());
       holder.txt_result_nama_lengkap.setText("Nama Lengkap  : " + Html.fromHtml(datalist.get(position).get_nama_lengkap()+ "" ));
       holder.txt_result_nisn.setText("Nisn  : " + Html.fromHtml(datalist.get(position).get_nisn()+ "" ));
       holder.txt_result_kelas.setText("Kelas  : " + Html.fromHtml(datalist.get(position).get_kelas()+ "" ));
       holder.txt_result_tahun_lulus.setText("Tahun Lulus  : " + Html.fromHtml(datalist.get(position).get_tahun_lulus()+ "" ));
       holder.txt_result_email.setText("Email  : " + Html.fromHtml(datalist.get(position).get_email()+ "" ));
       holder.txt_result_status_pekerjaan.setText("Status Pekerjaan  : " + Html.fromHtml(datalist.get(position).get_status_pekerjaan()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_akreditas_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_akreditas;
       TextView txt_result_nama_lengkap;
       TextView txt_result_nisn;
       TextView txt_result_kelas;
       TextView txt_result_tahun_lulus;
       TextView txt_result_email;
       TextView txt_result_status_pekerjaan;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_akreditas_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_akreditas_sqlite_dbhandler(activity);
            txt_result_id_akreditas = (TextView) itemView.findViewById(R.id.id_akreditas);
           txt_result_nama_lengkap = (TextView) itemView.findViewById(R.id.nama_lengkap);
           txt_result_nisn = (TextView) itemView.findViewById(R.id.nisn);
           txt_result_kelas = (TextView) itemView.findViewById(R.id.kelas);
           txt_result_tahun_lulus = (TextView) itemView.findViewById(R.id.tahun_lulus);
           txt_result_email = (TextView) itemView.findViewById(R.id.email);
           txt_result_status_pekerjaan = (TextView) itemView.findViewById(R.id.status_pekerjaan);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_akreditas", datalist.get(getAdapterPosition()).get_id_akreditas());
                   bundle.putString("nama_lengkap", datalist.get(getAdapterPosition()).get_nama_lengkap());
                   bundle.putString("nisn", datalist.get(getAdapterPosition()).get_nisn());
                   bundle.putString("kelas", datalist.get(getAdapterPosition()).get_kelas());
                   bundle.putString("tahun_lulus", datalist.get(getAdapterPosition()).get_tahun_lulus());
                   bundle.putString("email", datalist.get(getAdapterPosition()).get_email());
                   bundle.putString("status_pekerjaan", datalist.get(getAdapterPosition()).get_status_pekerjaan());



                    Intent intent = new Intent(activity, data_akreditas_sqlite_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);

                }
            });


            linearHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(activity);
                    BackAlertDialog.setTitle("Proses Hapus");
                    BackAlertDialog.setMessage("Apakah Anda ingin Menghapus Data?");
                    BackAlertDialog.setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Proses Hapus

                                    dbHandler.hapus_data_akreditas_sqlite( new data_akreditas_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_akreditas()
                                           ,datalist.get(getAdapterPosition()).get_nama_lengkap()
                                           ,datalist.get(getAdapterPosition()).get_nisn()
                                           ,datalist.get(getAdapterPosition()).get_kelas()
                                           ,datalist.get(getAdapterPosition()).get_tahun_lulus()
                                           ,datalist.get(getAdapterPosition()).get_email()
                                           ,datalist.get(getAdapterPosition()).get_status_pekerjaan()

                                    ) );

                                    List<data_akreditas_sqlite_data> data_akreditas_sqliteList = dbHandler.get_semua_data_akreditas_sqlite();
                                    adapter = new data_akreditas_sqlite_adapter( activity, data_akreditas_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_akreditas_sqlite_activity)activity).fetch_data_akreditas_sqlite();
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



        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}







