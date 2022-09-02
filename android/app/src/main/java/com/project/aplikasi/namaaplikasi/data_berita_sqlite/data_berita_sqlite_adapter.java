package com.project.aplikasi.namaaplikasi.data_berita_sqlite;

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


public class data_berita_sqlite_adapter extends RecyclerView.Adapter<data_berita_sqlite_adapter.data_berita_ViewHolder> {

    Activity activity;
    private List<data_berita_sqlite_data> datalist = new ArrayList<>();
    private data_berita_sqlite_dbhandler dbHandler;
    private data_berita_sqlite_adapter adapter;


    public data_berita_sqlite_adapter(Activity activity,List<data_berita_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_berita_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_berita_tampil_v2, parent, false);
        data_berita_ViewHolder mahasiswaViewHolder = new data_berita_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_berita_ViewHolder holder, int position) {
        holder.txt_result_id_berita.setText("id_berita : " + datalist.get(position).get_id_berita());
       holder.txt_result_caption.setText("Caption  : " + Html.fromHtml(datalist.get(position).get_caption()+ "" ));
       holder.txt_result_tanggal.setText("Tanggal  : " + Html.fromHtml(datalist.get(position).get_tanggal()+ "" ));
       holder.txt_result_foto.setText("Foto  : " + Html.fromHtml(datalist.get(position).get_foto()+ "" ));
       holder.txt_result_id_alumni.setText("Id Alumni  : " + Html.fromHtml(datalist.get(position).get_id_alumni()+ "" ));
       holder.txt_result_jumlah_like.setText("Jumlah Like  : " + Html.fromHtml(datalist.get(position).get_jumlah_like()+ "" ));
       holder.txt_result_jumlah_komen.setText("Jumlah Komen  : " + Html.fromHtml(datalist.get(position).get_jumlah_komen()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_berita_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_berita;
       TextView txt_result_caption;
       TextView txt_result_tanggal;
       TextView txt_result_foto;
       TextView txt_result_id_alumni;
       TextView txt_result_jumlah_like;
       TextView txt_result_jumlah_komen;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_berita_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_berita_sqlite_dbhandler(activity);
            txt_result_id_berita = (TextView) itemView.findViewById(R.id.id_berita);
           txt_result_caption = (TextView) itemView.findViewById(R.id.caption);
           txt_result_tanggal = (TextView) itemView.findViewById(R.id.tanggal);
           txt_result_foto = (TextView) itemView.findViewById(R.id.foto);
           txt_result_id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);
           txt_result_jumlah_like = (TextView) itemView.findViewById(R.id.jumlah_like);
           txt_result_jumlah_komen = (TextView) itemView.findViewById(R.id.jumlah_komen);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_berita", datalist.get(getAdapterPosition()).get_id_berita());
                   bundle.putString("caption", datalist.get(getAdapterPosition()).get_caption());
                   bundle.putString("tanggal", datalist.get(getAdapterPosition()).get_tanggal());
                   bundle.putString("foto", datalist.get(getAdapterPosition()).get_foto());
                   bundle.putString("id_alumni", datalist.get(getAdapterPosition()).get_id_alumni());
                   bundle.putString("jumlah_like", datalist.get(getAdapterPosition()).get_jumlah_like());
                   bundle.putString("jumlah_komen", datalist.get(getAdapterPosition()).get_jumlah_komen());



                    Intent intent = new Intent(activity, data_berita_sqlite_edit.class);
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

                                    dbHandler.hapus_data_berita_sqlite( new data_berita_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_berita()
                                           ,datalist.get(getAdapterPosition()).get_caption()
                                           ,datalist.get(getAdapterPosition()).get_tanggal()
                                           ,datalist.get(getAdapterPosition()).get_foto()
                                           ,datalist.get(getAdapterPosition()).get_id_alumni()
                                           ,datalist.get(getAdapterPosition()).get_jumlah_like()
                                           ,datalist.get(getAdapterPosition()).get_jumlah_komen()

                                    ) );

                                    List<data_berita_sqlite_data> data_berita_sqliteList = dbHandler.get_semua_data_berita_sqlite();
                                    adapter = new data_berita_sqlite_adapter( activity, data_berita_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_berita_sqlite_activity)activity).fetch_data_berita_sqlite();
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







