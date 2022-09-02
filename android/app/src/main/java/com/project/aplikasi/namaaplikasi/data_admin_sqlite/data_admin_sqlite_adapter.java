package com.project.aplikasi.namaaplikasi.data_admin_sqlite;

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


public class data_admin_sqlite_adapter extends RecyclerView.Adapter<data_admin_sqlite_adapter.data_admin_ViewHolder> {

    Activity activity;
    private List<data_admin_sqlite_data> datalist = new ArrayList<>();
    private data_admin_sqlite_dbhandler dbHandler;
    private data_admin_sqlite_adapter adapter;


    public data_admin_sqlite_adapter(Activity activity,List<data_admin_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_admin_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_admin_tampil_v2, parent, false);
        data_admin_ViewHolder mahasiswaViewHolder = new data_admin_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_admin_ViewHolder holder, int position) {
        holder.txt_result_id_admin.setText("id_admin : " + datalist.get(position).get_id_admin());
       holder.txt_result_nama_depan.setText("Nama Depan  : " + Html.fromHtml(datalist.get(position).get_nama_depan()+ "" ));
       holder.txt_result_nama_belakang.setText("Nama Belakang  : " + Html.fromHtml(datalist.get(position).get_nama_belakang()+ "" ));
       holder.txt_result_alamat.setText("Alamat  : " + Html.fromHtml(datalist.get(position).get_alamat()+ "" ));
       holder.txt_result_email.setText("Email  : " + Html.fromHtml(datalist.get(position).get_email()+ "" ));
       holder.txt_result_no_telepon.setText("No Telepon  : " + Html.fromHtml(datalist.get(position).get_no_telepon()+ "" ));
       holder.txt_result_hak_akses.setText("Hak Akses  : " + Html.fromHtml(datalist.get(position).get_hak_akses()+ "" ));
       holder.txt_result_id_sekolah.setText("Id Sekolah  : " + Html.fromHtml(datalist.get(position).get_id_sekolah()+ "" ));
       holder.txt_result_status_pekerjaan.setText("Status Pekerjaan  : " + Html.fromHtml(datalist.get(position).get_status_pekerjaan()+ "" ));
       holder.txt_result_foto.setText("Foto  : " + Html.fromHtml(datalist.get(position).get_foto()+ "" ));
       holder.txt_result_username.setText("Username  : " + Html.fromHtml(datalist.get(position).get_username()+ "" ));
       holder.txt_result_password.setText("Password  : " + Html.fromHtml(datalist.get(position).get_password()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_admin_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_admin;
       TextView txt_result_nama_depan;
       TextView txt_result_nama_belakang;
       TextView txt_result_alamat;
       TextView txt_result_email;
       TextView txt_result_no_telepon;
       TextView txt_result_hak_akses;
       TextView txt_result_id_sekolah;
       TextView txt_result_status_pekerjaan;
       TextView txt_result_foto;
       TextView txt_result_username;
       TextView txt_result_password;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_admin_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_admin_sqlite_dbhandler(activity);
            txt_result_id_admin = (TextView) itemView.findViewById(R.id.id_admin);
           txt_result_nama_depan = (TextView) itemView.findViewById(R.id.nama_depan);
           txt_result_nama_belakang = (TextView) itemView.findViewById(R.id.nama_belakang);
           txt_result_alamat = (TextView) itemView.findViewById(R.id.alamat);
           txt_result_email = (TextView) itemView.findViewById(R.id.email);
           txt_result_no_telepon = (TextView) itemView.findViewById(R.id.no_telepon);
           txt_result_hak_akses = (TextView) itemView.findViewById(R.id.hak_akses);
           txt_result_id_sekolah = (TextView) itemView.findViewById(R.id.id_sekolah);
           txt_result_status_pekerjaan = (TextView) itemView.findViewById(R.id.status_pekerjaan);
           txt_result_foto = (TextView) itemView.findViewById(R.id.foto);
           txt_result_username = (TextView) itemView.findViewById(R.id.username);
           txt_result_password = (TextView) itemView.findViewById(R.id.password);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_admin", datalist.get(getAdapterPosition()).get_id_admin());
                   bundle.putString("nama_depan", datalist.get(getAdapterPosition()).get_nama_depan());
                   bundle.putString("nama_belakang", datalist.get(getAdapterPosition()).get_nama_belakang());
                   bundle.putString("alamat", datalist.get(getAdapterPosition()).get_alamat());
                   bundle.putString("email", datalist.get(getAdapterPosition()).get_email());
                   bundle.putString("no_telepon", datalist.get(getAdapterPosition()).get_no_telepon());
                   bundle.putString("hak_akses", datalist.get(getAdapterPosition()).get_hak_akses());
                   bundle.putString("id_sekolah", datalist.get(getAdapterPosition()).get_id_sekolah());
                   bundle.putString("status_pekerjaan", datalist.get(getAdapterPosition()).get_status_pekerjaan());
                   bundle.putString("foto", datalist.get(getAdapterPosition()).get_foto());
                   bundle.putString("username", datalist.get(getAdapterPosition()).get_username());
                   bundle.putString("password", datalist.get(getAdapterPosition()).get_password());



                    Intent intent = new Intent(activity, data_admin_sqlite_edit.class);
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

                                    dbHandler.hapus_data_admin_sqlite( new data_admin_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_admin()
                                           ,datalist.get(getAdapterPosition()).get_nama_depan()
                                           ,datalist.get(getAdapterPosition()).get_nama_belakang()
                                           ,datalist.get(getAdapterPosition()).get_alamat()
                                           ,datalist.get(getAdapterPosition()).get_email()
                                           ,datalist.get(getAdapterPosition()).get_no_telepon()
                                           ,datalist.get(getAdapterPosition()).get_hak_akses()
                                           ,datalist.get(getAdapterPosition()).get_id_sekolah()
                                           ,datalist.get(getAdapterPosition()).get_status_pekerjaan()
                                           ,datalist.get(getAdapterPosition()).get_foto()
                                           ,datalist.get(getAdapterPosition()).get_username()
                                           ,datalist.get(getAdapterPosition()).get_password()

                                    ) );

                                    List<data_admin_sqlite_data> data_admin_sqliteList = dbHandler.get_semua_data_admin_sqlite();
                                    adapter = new data_admin_sqlite_adapter( activity, data_admin_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_admin_sqlite_activity)activity).fetch_data_admin_sqlite();
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







