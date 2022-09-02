package com.project.aplikasi.namaaplikasi.data_alumni_sqlite;

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


public class data_alumni_sqlite_adapter extends RecyclerView.Adapter<data_alumni_sqlite_adapter.data_alumni_ViewHolder> {

    Activity activity;
    private List<data_alumni_sqlite_data> datalist = new ArrayList<>();
    private data_alumni_sqlite_dbhandler dbHandler;
    private data_alumni_sqlite_adapter adapter;


    public data_alumni_sqlite_adapter(Activity activity,List<data_alumni_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_alumni_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_alumni_tampil_v2, parent, false);
        data_alumni_ViewHolder mahasiswaViewHolder = new data_alumni_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_alumni_ViewHolder holder, int position) {
        holder.txt_result_id_alumni.setText("id_alumni : " + datalist.get(position).get_id_alumni());
       holder.txt_result_nama_depan.setText("Nama Depan  : " + Html.fromHtml(datalist.get(position).get_nama_depan()+ "" ));
       holder.txt_result_nama_belakang.setText("Nama Belakang  : " + Html.fromHtml(datalist.get(position).get_nama_belakang()+ "" ));
       holder.txt_result_alamat.setText("Alamat  : " + Html.fromHtml(datalist.get(position).get_alamat()+ "" ));
       holder.txt_result_email.setText("Email  : " + Html.fromHtml(datalist.get(position).get_email()+ "" ));
       holder.txt_result_no_telepon.setText("No Telepon  : " + Html.fromHtml(datalist.get(position).get_no_telepon()+ "" ));
       holder.txt_result_nisn.setText("Nisn  : " + Html.fromHtml(datalist.get(position).get_nisn()+ "" ));
       holder.txt_result_id_sekolah.setText("Id Sekolah  : " + Html.fromHtml(datalist.get(position).get_id_sekolah()+ "" ));
       holder.txt_result_jurusan.setText("Jurusan  : " + Html.fromHtml(datalist.get(position).get_jurusan()+ "" ));
       holder.txt_result_tahun_masuk.setText("Tahun Masuk  : " + Html.fromHtml(datalist.get(position).get_tahun_masuk()+ "" ));
       holder.txt_result_tahun_keluar.setText("Tahun Keluar  : " + Html.fromHtml(datalist.get(position).get_tahun_keluar()+ "" ));
       holder.txt_result_jalur_penerimaan.setText("Jalur Penerimaan  : " + Html.fromHtml(datalist.get(position).get_jalur_penerimaan()+ "" ));
       holder.txt_result_jenjang.setText("Jenjang  : " + Html.fromHtml(datalist.get(position).get_jenjang()+ "" ));
       holder.txt_result_linkedin.setText("Linkedin  : " + Html.fromHtml(datalist.get(position).get_linkedin()+ "" ));
       holder.txt_result_instagram.setText("Instagram  : " + Html.fromHtml(datalist.get(position).get_instagram()+ "" ));
       holder.txt_result_facebook.setText("Facebook  : " + Html.fromHtml(datalist.get(position).get_facebook()+ "" ));
       holder.txt_result_tempat_kerja.setText("Tempat Kerja  : " + Html.fromHtml(datalist.get(position).get_tempat_kerja()+ "" ));
       holder.txt_result_jabatan_kerja.setText("Jabatan Kerja  : " + Html.fromHtml(datalist.get(position).get_jabatan_kerja()+ "" ));
       holder.txt_result_alamat_kerja.setText("Alamat Kerja  : " + Html.fromHtml(datalist.get(position).get_alamat_kerja()+ "" ));
       holder.txt_result_tahun_masuk_kerja.setText("Tahun Masuk Kerja  : " + Html.fromHtml(datalist.get(position).get_tahun_masuk_kerja()+ "" ));
       holder.txt_result_tahun_resign.setText("Tahun Resign  : " + Html.fromHtml(datalist.get(position).get_tahun_resign()+ "" ));
       holder.txt_result_foto.setText("Foto  : " + Html.fromHtml(datalist.get(position).get_foto()+ "" ));
       holder.txt_result_username.setText("Username  : " + Html.fromHtml(datalist.get(position).get_username()+ "" ));
       holder.txt_result_password.setText("Password  : " + Html.fromHtml(datalist.get(position).get_password()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_alumni_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_alumni;
       TextView txt_result_nama_depan;
       TextView txt_result_nama_belakang;
       TextView txt_result_alamat;
       TextView txt_result_email;
       TextView txt_result_no_telepon;
       TextView txt_result_nisn;
       TextView txt_result_id_sekolah;
       TextView txt_result_jurusan;
       TextView txt_result_tahun_masuk;
       TextView txt_result_tahun_keluar;
       TextView txt_result_jalur_penerimaan;
       TextView txt_result_jenjang;
       TextView txt_result_linkedin;
       TextView txt_result_instagram;
       TextView txt_result_facebook;
       TextView txt_result_tempat_kerja;
       TextView txt_result_jabatan_kerja;
       TextView txt_result_alamat_kerja;
       TextView txt_result_tahun_masuk_kerja;
       TextView txt_result_tahun_resign;
       TextView txt_result_foto;
       TextView txt_result_username;
       TextView txt_result_password;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_alumni_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_alumni_sqlite_dbhandler(activity);
            txt_result_id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);
           txt_result_nama_depan = (TextView) itemView.findViewById(R.id.nama_depan);
           txt_result_nama_belakang = (TextView) itemView.findViewById(R.id.nama_belakang);
           txt_result_alamat = (TextView) itemView.findViewById(R.id.alamat);
           txt_result_email = (TextView) itemView.findViewById(R.id.email);
           txt_result_no_telepon = (TextView) itemView.findViewById(R.id.no_telepon);
           txt_result_nisn = (TextView) itemView.findViewById(R.id.nisn);
           txt_result_id_sekolah = (TextView) itemView.findViewById(R.id.id_sekolah);
           txt_result_jurusan = (TextView) itemView.findViewById(R.id.jurusan);
           txt_result_tahun_masuk = (TextView) itemView.findViewById(R.id.tahun_masuk);
           txt_result_tahun_keluar = (TextView) itemView.findViewById(R.id.tahun_keluar);
           txt_result_jalur_penerimaan = (TextView) itemView.findViewById(R.id.jalur_penerimaan);
           txt_result_jenjang = (TextView) itemView.findViewById(R.id.jenjang);
           txt_result_linkedin = (TextView) itemView.findViewById(R.id.linkedin);
           txt_result_instagram = (TextView) itemView.findViewById(R.id.instagram);
           txt_result_facebook = (TextView) itemView.findViewById(R.id.facebook);
           txt_result_tempat_kerja = (TextView) itemView.findViewById(R.id.tempat_kerja);
           txt_result_jabatan_kerja = (TextView) itemView.findViewById(R.id.jabatan_kerja);
           txt_result_alamat_kerja = (TextView) itemView.findViewById(R.id.alamat_kerja);
           txt_result_tahun_masuk_kerja = (TextView) itemView.findViewById(R.id.tahun_masuk_kerja);
           txt_result_tahun_resign = (TextView) itemView.findViewById(R.id.tahun_resign);
           txt_result_foto = (TextView) itemView.findViewById(R.id.foto);
           txt_result_username = (TextView) itemView.findViewById(R.id.username);
           txt_result_password = (TextView) itemView.findViewById(R.id.password);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_alumni", datalist.get(getAdapterPosition()).get_id_alumni());
                   bundle.putString("nama_depan", datalist.get(getAdapterPosition()).get_nama_depan());
                   bundle.putString("nama_belakang", datalist.get(getAdapterPosition()).get_nama_belakang());
                   bundle.putString("alamat", datalist.get(getAdapterPosition()).get_alamat());
                   bundle.putString("email", datalist.get(getAdapterPosition()).get_email());
                   bundle.putString("no_telepon", datalist.get(getAdapterPosition()).get_no_telepon());
                   bundle.putString("nisn", datalist.get(getAdapterPosition()).get_nisn());
                   bundle.putString("id_sekolah", datalist.get(getAdapterPosition()).get_id_sekolah());
                   bundle.putString("jurusan", datalist.get(getAdapterPosition()).get_jurusan());
                   bundle.putString("tahun_masuk", datalist.get(getAdapterPosition()).get_tahun_masuk());
                   bundle.putString("tahun_keluar", datalist.get(getAdapterPosition()).get_tahun_keluar());
                   bundle.putString("jalur_penerimaan", datalist.get(getAdapterPosition()).get_jalur_penerimaan());
                   bundle.putString("jenjang", datalist.get(getAdapterPosition()).get_jenjang());
                   bundle.putString("linkedin", datalist.get(getAdapterPosition()).get_linkedin());
                   bundle.putString("instagram", datalist.get(getAdapterPosition()).get_instagram());
                   bundle.putString("facebook", datalist.get(getAdapterPosition()).get_facebook());
                   bundle.putString("tempat_kerja", datalist.get(getAdapterPosition()).get_tempat_kerja());
                   bundle.putString("jabatan_kerja", datalist.get(getAdapterPosition()).get_jabatan_kerja());
                   bundle.putString("alamat_kerja", datalist.get(getAdapterPosition()).get_alamat_kerja());
                   bundle.putString("tahun_masuk_kerja", datalist.get(getAdapterPosition()).get_tahun_masuk_kerja());
                   bundle.putString("tahun_resign", datalist.get(getAdapterPosition()).get_tahun_resign());
                   bundle.putString("foto", datalist.get(getAdapterPosition()).get_foto());
                   bundle.putString("username", datalist.get(getAdapterPosition()).get_username());
                   bundle.putString("password", datalist.get(getAdapterPosition()).get_password());



                    Intent intent = new Intent(activity, data_alumni_sqlite_edit.class);
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

                                    dbHandler.hapus_data_alumni_sqlite( new data_alumni_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_alumni()
                                           ,datalist.get(getAdapterPosition()).get_nama_depan()
                                           ,datalist.get(getAdapterPosition()).get_nama_belakang()
                                           ,datalist.get(getAdapterPosition()).get_alamat()
                                           ,datalist.get(getAdapterPosition()).get_email()
                                           ,datalist.get(getAdapterPosition()).get_no_telepon()
                                           ,datalist.get(getAdapterPosition()).get_nisn()
                                           ,datalist.get(getAdapterPosition()).get_id_sekolah()
                                           ,datalist.get(getAdapterPosition()).get_jurusan()
                                           ,datalist.get(getAdapterPosition()).get_tahun_masuk()
                                           ,datalist.get(getAdapterPosition()).get_tahun_keluar()
                                           ,datalist.get(getAdapterPosition()).get_jalur_penerimaan()
                                           ,datalist.get(getAdapterPosition()).get_jenjang()
                                           ,datalist.get(getAdapterPosition()).get_linkedin()
                                           ,datalist.get(getAdapterPosition()).get_instagram()
                                           ,datalist.get(getAdapterPosition()).get_facebook()
                                           ,datalist.get(getAdapterPosition()).get_tempat_kerja()
                                           ,datalist.get(getAdapterPosition()).get_jabatan_kerja()
                                           ,datalist.get(getAdapterPosition()).get_alamat_kerja()
                                           ,datalist.get(getAdapterPosition()).get_tahun_masuk_kerja()
                                           ,datalist.get(getAdapterPosition()).get_tahun_resign()
                                           ,datalist.get(getAdapterPosition()).get_foto()
                                           ,datalist.get(getAdapterPosition()).get_username()
                                           ,datalist.get(getAdapterPosition()).get_password()

                                    ) );

                                    List<data_alumni_sqlite_data> data_alumni_sqliteList = dbHandler.get_semua_data_alumni_sqlite();
                                    adapter = new data_alumni_sqlite_adapter( activity, data_alumni_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_alumni_sqlite_activity)activity).fetch_data_alumni_sqlite();
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







