package com.project.aplikasi.namaaplikasi.data_like_kenangan_sqlite;

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


public class data_like_kenangan_sqlite_adapter extends RecyclerView.Adapter<data_like_kenangan_sqlite_adapter.data_like_kenangan_ViewHolder> {

    Activity activity;
    private List<data_like_kenangan_sqlite_data> datalist = new ArrayList<>();
    private data_like_kenangan_sqlite_dbhandler dbHandler;
    private data_like_kenangan_sqlite_adapter adapter;


    public data_like_kenangan_sqlite_adapter(Activity activity,List<data_like_kenangan_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_like_kenangan_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_like_kenangan_tampil_v2, parent, false);
        data_like_kenangan_ViewHolder mahasiswaViewHolder = new data_like_kenangan_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_like_kenangan_ViewHolder holder, int position) {
        holder.txt_result_id_like_kenangan.setText("id_like_kenangan : " + datalist.get(position).get_id_like_kenangan());
       holder.txt_result_tanggal.setText("Tanggal  : " + Html.fromHtml(datalist.get(position).get_tanggal()+ "" ));
       holder.txt_result_id_kenangan.setText("Id Kenangan  : " + Html.fromHtml(datalist.get(position).get_id_kenangan()+ "" ));
       holder.txt_result_id_alumni.setText("Id Alumni  : " + Html.fromHtml(datalist.get(position).get_id_alumni()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_like_kenangan_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_like_kenangan;
       TextView txt_result_tanggal;
       TextView txt_result_id_kenangan;
       TextView txt_result_id_alumni;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_like_kenangan_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_like_kenangan_sqlite_dbhandler(activity);
            txt_result_id_like_kenangan = (TextView) itemView.findViewById(R.id.id_like_kenangan);
           txt_result_tanggal = (TextView) itemView.findViewById(R.id.tanggal);
           txt_result_id_kenangan = (TextView) itemView.findViewById(R.id.id_kenangan);
           txt_result_id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_like_kenangan", datalist.get(getAdapterPosition()).get_id_like_kenangan());
                   bundle.putString("tanggal", datalist.get(getAdapterPosition()).get_tanggal());
                   bundle.putString("id_kenangan", datalist.get(getAdapterPosition()).get_id_kenangan());
                   bundle.putString("id_alumni", datalist.get(getAdapterPosition()).get_id_alumni());



                    Intent intent = new Intent(activity, data_like_kenangan_sqlite_edit.class);
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

                                    dbHandler.hapus_data_like_kenangan_sqlite( new data_like_kenangan_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_like_kenangan()
                                           ,datalist.get(getAdapterPosition()).get_tanggal()
                                           ,datalist.get(getAdapterPosition()).get_id_kenangan()
                                           ,datalist.get(getAdapterPosition()).get_id_alumni()

                                    ) );

                                    List<data_like_kenangan_sqlite_data> data_like_kenangan_sqliteList = dbHandler.get_semua_data_like_kenangan_sqlite();
                                    adapter = new data_like_kenangan_sqlite_adapter( activity, data_like_kenangan_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_like_kenangan_sqlite_activity)activity).fetch_data_like_kenangan_sqlite();
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







