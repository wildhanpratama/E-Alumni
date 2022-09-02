package com.project.aplikasi.namaaplikasi.data_sekolah_sqlite;

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


public class data_sekolah_sqlite_adapter extends RecyclerView.Adapter<data_sekolah_sqlite_adapter.data_sekolah_ViewHolder> {

    Activity activity;
    private List<data_sekolah_sqlite_data> datalist = new ArrayList<>();
    private data_sekolah_sqlite_dbhandler dbHandler;
    private data_sekolah_sqlite_adapter adapter;


    public data_sekolah_sqlite_adapter(Activity activity,List<data_sekolah_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_sekolah_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_sekolah_tampil_v2, parent, false);
        data_sekolah_ViewHolder mahasiswaViewHolder = new data_sekolah_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_sekolah_ViewHolder holder, int position) {
        holder.txt_result_id_sekolah.setText("id_sekolah : " + datalist.get(position).get_id_sekolah());
       holder.txt_result_nama_sekolah.setText("Nama Sekolah  : " + Html.fromHtml(datalist.get(position).get_nama_sekolah()+ "" ));
       holder.txt_result_alamat.setText("Alamat  : " + Html.fromHtml(datalist.get(position).get_alamat()+ "" ));
       holder.txt_result_email.setText("Email  : " + Html.fromHtml(datalist.get(position).get_email()+ "" ));
       holder.txt_result_no_telepon.setText("No Telepon  : " + Html.fromHtml(datalist.get(position).get_no_telepon()+ "" ));
       holder.txt_result_kota.setText("Kota  : " + Html.fromHtml(datalist.get(position).get_kota()+ "" ));
       holder.txt_result_deskripsi.setText("Deskripsi  : " + Html.fromHtml(datalist.get(position).get_deskripsi()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_sekolah_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_sekolah;
       TextView txt_result_nama_sekolah;
       TextView txt_result_alamat;
       TextView txt_result_email;
       TextView txt_result_no_telepon;
       TextView txt_result_kota;
       TextView txt_result_deskripsi;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_sekolah_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_sekolah_sqlite_dbhandler(activity);
            txt_result_id_sekolah = (TextView) itemView.findViewById(R.id.id_sekolah);
           txt_result_nama_sekolah = (TextView) itemView.findViewById(R.id.nama_sekolah);
           txt_result_alamat = (TextView) itemView.findViewById(R.id.alamat);
           txt_result_email = (TextView) itemView.findViewById(R.id.email);
           txt_result_no_telepon = (TextView) itemView.findViewById(R.id.no_telepon);
           txt_result_kota = (TextView) itemView.findViewById(R.id.kota);
           txt_result_deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_sekolah", datalist.get(getAdapterPosition()).get_id_sekolah());
                   bundle.putString("nama_sekolah", datalist.get(getAdapterPosition()).get_nama_sekolah());
                   bundle.putString("alamat", datalist.get(getAdapterPosition()).get_alamat());
                   bundle.putString("email", datalist.get(getAdapterPosition()).get_email());
                   bundle.putString("no_telepon", datalist.get(getAdapterPosition()).get_no_telepon());
                   bundle.putString("kota", datalist.get(getAdapterPosition()).get_kota());
                   bundle.putString("deskripsi", datalist.get(getAdapterPosition()).get_deskripsi());



                    Intent intent = new Intent(activity, data_sekolah_sqlite_edit.class);
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

                                    dbHandler.hapus_data_sekolah_sqlite( new data_sekolah_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_sekolah()
                                           ,datalist.get(getAdapterPosition()).get_nama_sekolah()
                                           ,datalist.get(getAdapterPosition()).get_alamat()
                                           ,datalist.get(getAdapterPosition()).get_email()
                                           ,datalist.get(getAdapterPosition()).get_no_telepon()
                                           ,datalist.get(getAdapterPosition()).get_kota()
                                           ,datalist.get(getAdapterPosition()).get_deskripsi()

                                    ) );

                                    List<data_sekolah_sqlite_data> data_sekolah_sqliteList = dbHandler.get_semua_data_sekolah_sqlite();
                                    adapter = new data_sekolah_sqlite_adapter( activity, data_sekolah_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_sekolah_sqlite_activity)activity).fetch_data_sekolah_sqlite();
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







