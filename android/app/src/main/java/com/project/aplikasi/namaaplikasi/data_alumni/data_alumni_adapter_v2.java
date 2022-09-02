package com.project.aplikasi.namaaplikasi.data_alumni;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.data_admin.data_admin_activity_v2;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_alumni_adapter_v2 extends RecyclerView.Adapter<data_alumni_adapter_v2.data_alumni_adapter_v2_view_holder> {
    private ArrayList<data_alumni_apidata> dataList;
    private Activity activity;

    public data_alumni_adapter_v2(ArrayList<data_alumni_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_alumni_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_alumni_tampil_v2, parent, false);
        return new data_alumni_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_alumni_adapter_v2_view_holder holder, int position) {

        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_alumni.setText("" + dataList.get(position).get_id_alumni());
        holder.id_alumni.setVisibility(View.GONE);
        holder.nama_depan.setText(Html.fromHtml("Nama Depan  : " + dataList.get(position).get_nama_depan() + ""));
        holder.nama_belakang.setText(Html.fromHtml("Nama Belakang  : " + dataList.get(position).get_nama_belakang() + ""));
        holder.alamat.setText(Html.fromHtml("Alamat  : " + dataList.get(position).get_alamat() + ""));
        holder.email.setText(Html.fromHtml("Email  : " + dataList.get(position).get_email() + ""));
        holder.no_telepon.setText(Html.fromHtml("No Telepon  : " + dataList.get(position).get_no_telepon() + ""));
        holder.nisn.setText(Html.fromHtml("Nisn  : " + dataList.get(position).get_nisn() + ""));
        holder.id_sekolah.setText(Html.fromHtml("Id Sekolah  : " + dataList.get(position).get_id_sekolah() + ""));
        holder.jurusan.setText(Html.fromHtml("Jurusan  : " + dataList.get(position).get_jurusan() + ""));
        holder.tahun_masuk.setText(Html.fromHtml("Tahun Masuk  : " + dataList.get(position).get_tahun_masuk() + ""));
        holder.tahun_keluar.setText(Html.fromHtml("Tahun Keluar  : " + dataList.get(position).get_tahun_keluar() + ""));
        holder.jalur_penerimaan.setText(Html.fromHtml("Jalur Penerimaan  : " + dataList.get(position).get_jalur_penerimaan() + ""));
        holder.jenjang.setText(Html.fromHtml("Jenjang  : " + dataList.get(position).get_jenjang() + ""));
        holder.linkedin.setText(Html.fromHtml("Linkedin  : " + dataList.get(position).get_linkedin() + ""));
        holder.instagram.setText(Html.fromHtml("Instagram  : " + dataList.get(position).get_instagram() + ""));
        holder.facebook.setText(Html.fromHtml("Facebook  : " + dataList.get(position).get_facebook() + ""));
        holder.tempat_kerja.setText(Html.fromHtml("Tempat Kerja  : " + dataList.get(position).get_tempat_kerja() + ""));
        holder.jabatan_kerja.setText(Html.fromHtml("Jabatan Kerja  : " + dataList.get(position).get_jabatan_kerja() + ""));
        holder.alamat_kerja.setText(Html.fromHtml("Alamat Kerja  : " + dataList.get(position).get_alamat_kerja() + ""));
        holder.tahun_masuk_kerja.setText(Html.fromHtml("Tahun Masuk Kerja  : " + dataList.get(position).get_tahun_masuk_kerja() + ""));
        holder.tahun_resign.setText(Html.fromHtml("Tahun Resign  : " + dataList.get(position).get_tahun_resign() + ""));
        holder.foto.setText(Html.fromHtml("Foto  : " + dataList.get(position).get_foto() + ""));
        holder.username.setText(Html.fromHtml("Username  : " + dataList.get(position).get_username() + ""));
        holder.password.setText(Html.fromHtml("Password  : " + dataList.get(position).get_password() + ""));


        thumb(holder, BASE_URL + "admin/upload/" + dataList.get(position).get_foto(), true);
        edit(holder, "Edit", false);
        hapus(holder, "Hapus", false);
    }

    private void thumb(data_alumni_adapter_v2_view_holder holder, String url_gambar, Boolean visible) {
        if (visible == true) {
            holder.image.setVisibility(View.VISIBLE);
            Picasso.get().load(url_gambar).into(holder.image);
        } else {
            holder.image.setVisibility(View.GONE);
        }
    }

    private void edit(data_alumni_adapter_v2_view_holder holder, String nama_tombol, Boolean visible) {
        holder.tombol_edit.setText(nama_tombol);
        if (visible == true) {
            holder.linearEdit.setVisibility(View.VISIBLE);
        } else {
            holder.linearEdit.setVisibility(View.GONE);
        }
    }

    private void hapus(data_alumni_adapter_v2_view_holder holder, String nama_tombol, Boolean visible) {
        holder.tombol_hapus.setText(nama_tombol);
        if (visible == true) {
            holder.linearHapus.setVisibility(View.VISIBLE);
        } else {
            holder.linearHapus.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class data_alumni_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_alumni, nama_depan, nama_belakang, alamat, email, no_telepon, nisn, id_sekolah, jurusan, tahun_masuk, tahun_keluar, jalur_penerimaan, jenjang, linkedin, instagram, facebook, tempat_kerja, jabatan_kerja, alamat_kerja, tahun_masuk_kerja, tahun_resign, foto, username, password, nomor;
        TextView tombol_edit, tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus, linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_alumni_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);
            nama_depan = (TextView) itemView.findViewById(R.id.nama_depan);
            nama_belakang = (TextView) itemView.findViewById(R.id.nama_belakang);
            alamat = (TextView) itemView.findViewById(R.id.alamat);
            email = (TextView) itemView.findViewById(R.id.email);
            no_telepon = (TextView) itemView.findViewById(R.id.no_telepon);
            nisn = (TextView) itemView.findViewById(R.id.nisn);
            id_sekolah = (TextView) itemView.findViewById(R.id.id_sekolah);
            jurusan = (TextView) itemView.findViewById(R.id.jurusan);
            tahun_masuk = (TextView) itemView.findViewById(R.id.tahun_masuk);
            tahun_keluar = (TextView) itemView.findViewById(R.id.tahun_keluar);
            jalur_penerimaan = (TextView) itemView.findViewById(R.id.jalur_penerimaan);
            jenjang = (TextView) itemView.findViewById(R.id.jenjang);
            linkedin = (TextView) itemView.findViewById(R.id.linkedin);
            instagram = (TextView) itemView.findViewById(R.id.instagram);
            facebook = (TextView) itemView.findViewById(R.id.facebook);
            tempat_kerja = (TextView) itemView.findViewById(R.id.tempat_kerja);
            jabatan_kerja = (TextView) itemView.findViewById(R.id.jabatan_kerja);
            alamat_kerja = (TextView) itemView.findViewById(R.id.alamat_kerja);
            tahun_masuk_kerja = (TextView) itemView.findViewById(R.id.tahun_masuk_kerja);
            tahun_resign = (TextView) itemView.findViewById(R.id.tahun_resign);
            foto = (TextView) itemView.findViewById(R.id.foto);
            username = (TextView) itemView.findViewById(R.id.username);
            password = (TextView) itemView.findViewById(R.id.password);

            username.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            foto.setVisibility(View.GONE);

            nomor = (TextView) itemView.findViewById(R.id.txt_nomor);
            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            tombol_edit = (TextView) itemView.findViewById(R.id.tombol_edit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);
            tombol_hapus = (TextView) itemView.findViewById(R.id.tombol_hapus);
            linearBaris = (LinearLayout) itemView.findViewById(R.id.linearBaris);
            image = (ImageView) itemView.findViewById(R.id.img);

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
                                    data_alumni_apiservice mAPIService =
                                            data_alumni_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    Log.d("POSITION", Integer.toString(getAdapterPosition()));
                                    mAPIService.proses_hapus_data_alumni(
                                            dataList.get(getAdapterPosition()).get_id_alumni(),
                                            token
                                    ).enqueue(new Callback<Object>() {
                                        @Override
                                        public void onResponse(Call<Object> call, Response<Object> response) {
                                            ((data_alumni_activity_v2) activity).fetch_data_alumni();
                                        }

                                        @Override
                                        public void onFailure(Call<Object> call, Throwable t) {
                                            Toast.makeText(activity, "Gagal", Toast.LENGTH_LONG).show();
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

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_alumni", dataList.get(getAdapterPosition()).get_id_alumni());
                    bundle.putString("nama_depan", dataList.get(getAdapterPosition()).get_nama_depan());
                    bundle.putString("nama_belakang", dataList.get(getAdapterPosition()).get_nama_belakang());
                    bundle.putString("alamat", dataList.get(getAdapterPosition()).get_alamat());
                    bundle.putString("email", dataList.get(getAdapterPosition()).get_email());
                    bundle.putString("no_telepon", dataList.get(getAdapterPosition()).get_no_telepon());
                    bundle.putString("nisn", dataList.get(getAdapterPosition()).get_nisn());
                    bundle.putString("id_sekolah", dataList.get(getAdapterPosition()).get_id_sekolah());
                    bundle.putString("jurusan", dataList.get(getAdapterPosition()).get_jurusan());
                    bundle.putString("tahun_masuk", dataList.get(getAdapterPosition()).get_tahun_masuk());
                    bundle.putString("tahun_keluar", dataList.get(getAdapterPosition()).get_tahun_keluar());
                    bundle.putString("jalur_penerimaan", dataList.get(getAdapterPosition()).get_jalur_penerimaan());
                    bundle.putString("jenjang", dataList.get(getAdapterPosition()).get_jenjang());
                    bundle.putString("linkedin", dataList.get(getAdapterPosition()).get_linkedin());
                    bundle.putString("instagram", dataList.get(getAdapterPosition()).get_instagram());
                    bundle.putString("facebook", dataList.get(getAdapterPosition()).get_facebook());
                    bundle.putString("tempat_kerja", dataList.get(getAdapterPosition()).get_tempat_kerja());
                    bundle.putString("jabatan_kerja", dataList.get(getAdapterPosition()).get_jabatan_kerja());
                    bundle.putString("alamat_kerja", dataList.get(getAdapterPosition()).get_alamat_kerja());
                    bundle.putString("tahun_masuk_kerja", dataList.get(getAdapterPosition()).get_tahun_masuk_kerja());
                    bundle.putString("tahun_resign", dataList.get(getAdapterPosition()).get_tahun_resign());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("username", dataList.get(getAdapterPosition()).get_username());
                    bundle.putString("password", dataList.get(getAdapterPosition()).get_password());
                    ;

                    Intent intent = new Intent(activity, data_alumni_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_alumni", dataList.get(getAdapterPosition()).get_id_alumni());
                    bundle.putString("nama_depan", dataList.get(getAdapterPosition()).get_nama_depan());
                    bundle.putString("nama_belakang", dataList.get(getAdapterPosition()).get_nama_belakang());
                    bundle.putString("alamat", dataList.get(getAdapterPosition()).get_alamat());
                    bundle.putString("email", dataList.get(getAdapterPosition()).get_email());
                    bundle.putString("no_telepon", dataList.get(getAdapterPosition()).get_no_telepon());
                    bundle.putString("nisn", dataList.get(getAdapterPosition()).get_nisn());
                    bundle.putString("id_sekolah", dataList.get(getAdapterPosition()).get_id_sekolah());
                    bundle.putString("jurusan", dataList.get(getAdapterPosition()).get_jurusan());
                    bundle.putString("tahun_masuk", dataList.get(getAdapterPosition()).get_tahun_masuk());
                    bundle.putString("tahun_keluar", dataList.get(getAdapterPosition()).get_tahun_keluar());
                    bundle.putString("jalur_penerimaan", dataList.get(getAdapterPosition()).get_jalur_penerimaan());
                    bundle.putString("jenjang", dataList.get(getAdapterPosition()).get_jenjang());
                    bundle.putString("linkedin", dataList.get(getAdapterPosition()).get_linkedin());
                    bundle.putString("instagram", dataList.get(getAdapterPosition()).get_instagram());
                    bundle.putString("facebook", dataList.get(getAdapterPosition()).get_facebook());
                    bundle.putString("tempat_kerja", dataList.get(getAdapterPosition()).get_tempat_kerja());
                    bundle.putString("jabatan_kerja", dataList.get(getAdapterPosition()).get_jabatan_kerja());
                    bundle.putString("alamat_kerja", dataList.get(getAdapterPosition()).get_alamat_kerja());
                    bundle.putString("tahun_masuk_kerja", dataList.get(getAdapterPosition()).get_tahun_masuk_kerja());
                    bundle.putString("tahun_resign", dataList.get(getAdapterPosition()).get_tahun_resign());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("username", dataList.get(getAdapterPosition()).get_username());
                    bundle.putString("password", dataList.get(getAdapterPosition()).get_password());
                    ;

                }
            });
        }
    }

    public void updateResults(ArrayList<data_alumni_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
