package com.project.aplikasi.namaaplikasi.data_jawaban_akreditas_sqlite;

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


public class data_jawaban_akreditas_sqlite_adapter extends RecyclerView.Adapter<data_jawaban_akreditas_sqlite_adapter.data_jawaban_akreditas_ViewHolder> {

    Activity activity;
    private List<data_jawaban_akreditas_sqlite_data> datalist = new ArrayList<>();
    private data_jawaban_akreditas_sqlite_dbhandler dbHandler;
    private data_jawaban_akreditas_sqlite_adapter adapter;


    public data_jawaban_akreditas_sqlite_adapter(Activity activity,List<data_jawaban_akreditas_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_jawaban_akreditas_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_jawaban_akreditas_tampil_v2, parent, false);
        data_jawaban_akreditas_ViewHolder mahasiswaViewHolder = new data_jawaban_akreditas_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_jawaban_akreditas_ViewHolder holder, int position) {
        holder.txt_result_id_jawaban_akreditas.setText("id_jawaban_akreditas : " + datalist.get(position).get_id_jawaban_akreditas());
       holder.txt_result_id_pertanyaan_akreditas.setText("Id Pertanyaan Akreditas  : " + Html.fromHtml(datalist.get(position).get_id_pertanyaan_akreditas()+ "" ));
       holder.txt_result_jawaban.setText("Jawaban  : " + Html.fromHtml(datalist.get(position).get_jawaban()+ "" ));
       holder.txt_result_id_alumni.setText("Id Alumni  : " + Html.fromHtml(datalist.get(position).get_id_alumni()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_jawaban_akreditas_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_jawaban_akreditas;
       TextView txt_result_id_pertanyaan_akreditas;
       TextView txt_result_jawaban;
       TextView txt_result_id_alumni;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_jawaban_akreditas_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_jawaban_akreditas_sqlite_dbhandler(activity);
            txt_result_id_jawaban_akreditas = (TextView) itemView.findViewById(R.id.id_jawaban_akreditas);
           txt_result_id_pertanyaan_akreditas = (TextView) itemView.findViewById(R.id.id_pertanyaan_akreditas);
           txt_result_jawaban = (TextView) itemView.findViewById(R.id.jawaban);
           txt_result_id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_jawaban_akreditas", datalist.get(getAdapterPosition()).get_id_jawaban_akreditas());
                   bundle.putString("id_pertanyaan_akreditas", datalist.get(getAdapterPosition()).get_id_pertanyaan_akreditas());
                   bundle.putString("jawaban", datalist.get(getAdapterPosition()).get_jawaban());
                   bundle.putString("id_alumni", datalist.get(getAdapterPosition()).get_id_alumni());



                    Intent intent = new Intent(activity, data_jawaban_akreditas_sqlite_edit.class);
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

                                    dbHandler.hapus_data_jawaban_akreditas_sqlite( new data_jawaban_akreditas_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_jawaban_akreditas()
                                           ,datalist.get(getAdapterPosition()).get_id_pertanyaan_akreditas()
                                           ,datalist.get(getAdapterPosition()).get_jawaban()
                                           ,datalist.get(getAdapterPosition()).get_id_alumni()

                                    ) );

                                    List<data_jawaban_akreditas_sqlite_data> data_jawaban_akreditas_sqliteList = dbHandler.get_semua_data_jawaban_akreditas_sqlite();
                                    adapter = new data_jawaban_akreditas_sqlite_adapter( activity, data_jawaban_akreditas_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_jawaban_akreditas_sqlite_activity)activity).fetch_data_jawaban_akreditas_sqlite();
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







