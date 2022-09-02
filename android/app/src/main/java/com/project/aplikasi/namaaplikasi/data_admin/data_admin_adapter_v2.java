package com.project.aplikasi.namaaplikasi.data_admin;

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

public class data_admin_adapter_v2 extends RecyclerView.Adapter<data_admin_adapter_v2.data_admin_adapter_v2_view_holder> {
    private ArrayList<data_admin_apidata> dataList;
    private Activity activity;

    public data_admin_adapter_v2(ArrayList<data_admin_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_admin_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_admin_tampil_v2, parent, false);
        return new data_admin_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_admin_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_admin.setText(""+dataList.get(position).get_id_admin());
		holder.id_admin.setVisibility( View.GONE );
        holder.nama_depan.setText(Html.fromHtml("Nama Depan  : "+dataList.get(position).get_nama_depan()+""));
        holder.nama_belakang.setText(Html.fromHtml("Nama Belakang  : "+dataList.get(position).get_nama_belakang()+""));
        holder.alamat.setText(Html.fromHtml("Alamat  : "+dataList.get(position).get_alamat()+""));
        holder.email.setText(Html.fromHtml("Email  : "+dataList.get(position).get_email()+""));
        holder.no_telepon.setText(Html.fromHtml("No Telepon  : "+dataList.get(position).get_no_telepon()+""));
        holder.hak_akses.setText(Html.fromHtml("Hak Akses  : "+dataList.get(position).get_hak_akses()+""));
        holder.id_sekolah.setText(Html.fromHtml("Id Sekolah  : "+dataList.get(position).get_id_sekolah()+""));
        holder.status_pekerjaan.setText(Html.fromHtml("Status Pekerjaan  : "+dataList.get(position).get_status_pekerjaan()+""));
        holder.foto.setText(Html.fromHtml("Foto  : "+dataList.get(position).get_foto()+""));
        holder.username.setText(Html.fromHtml("Username  : "+dataList.get(position).get_username()+""));
        holder.password.setText(Html.fromHtml("Password  : "+dataList.get(position).get_password()+""));


        thumb(holder,BASE_URL +"api/data/image/list/gambar1.png",false);
        edit(holder,"Edit",true);
        hapus(holder,"Hapus",true);
    }

     private void thumb(data_admin_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
    {
        if (visible==true) {
            holder.image.setVisibility( View.VISIBLE );
            Picasso.get().load( url_gambar ).into( holder.image );
        }
        else
        {
            holder.image.setVisibility( View.GONE );
        }
    }

    private void edit(data_admin_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
    {
        holder.tombol_edit.setText(nama_tombol);
        if (visible==true) {
            holder.linearEdit.setVisibility( View.VISIBLE );
        }
        else
        {
            holder.linearEdit.setVisibility( View.GONE );
        }
    }

    private void hapus(data_admin_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
    {
        holder.tombol_hapus.setText(nama_tombol);
        if (visible==true) {
            holder.linearHapus.setVisibility( View.VISIBLE );
        }
        else
        {
            holder.linearHapus.setVisibility( View.GONE );
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class data_admin_adapter_v2_view_holder extends RecyclerView.ViewHolder {
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

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_admin_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_admin = (TextView) itemView.findViewById(R.id.id_admin);
            nama_depan = (TextView) itemView.findViewById(R.id.nama_depan);
            nama_belakang = (TextView) itemView.findViewById(R.id.nama_belakang);
            alamat = (TextView) itemView.findViewById(R.id.alamat);
            email = (TextView) itemView.findViewById(R.id.email);
            no_telepon = (TextView) itemView.findViewById(R.id.no_telepon);
            hak_akses = (TextView) itemView.findViewById(R.id.hak_akses);
            id_sekolah = (TextView) itemView.findViewById(R.id.id_sekolah);
            status_pekerjaan = (TextView) itemView.findViewById(R.id.status_pekerjaan);
            foto = (TextView) itemView.findViewById(R.id.foto);
            username = (TextView) itemView.findViewById(R.id.username);
            password = (TextView) itemView.findViewById(R.id.password);

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
                                    data_admin_apiservice mAPIService = 
									data_admin_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_admin(
											dataList.get(getAdapterPosition()).get_id_admin(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_admin_activity_v2)activity).fetch_data_admin();
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

                    bundle.putString("id_admin", dataList.get(getAdapterPosition()).get_id_admin());
                    bundle.putString("nama_depan", dataList.get(getAdapterPosition()).get_nama_depan());
                    bundle.putString("nama_belakang", dataList.get(getAdapterPosition()).get_nama_belakang());
                    bundle.putString("alamat", dataList.get(getAdapterPosition()).get_alamat());
                    bundle.putString("email", dataList.get(getAdapterPosition()).get_email());
                    bundle.putString("no_telepon", dataList.get(getAdapterPosition()).get_no_telepon());
                    bundle.putString("hak_akses", dataList.get(getAdapterPosition()).get_hak_akses());
                    bundle.putString("id_sekolah", dataList.get(getAdapterPosition()).get_id_sekolah());
                    bundle.putString("status_pekerjaan", dataList.get(getAdapterPosition()).get_status_pekerjaan());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("username", dataList.get(getAdapterPosition()).get_username());
                    bundle.putString("password", dataList.get(getAdapterPosition()).get_password());
;

                    Intent intent = new Intent(activity, data_admin_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_admin", dataList.get(getAdapterPosition()).get_id_admin());
					                    bundle.putString("nama_depan", dataList.get(getAdapterPosition()).get_nama_depan());
                    bundle.putString("nama_belakang", dataList.get(getAdapterPosition()).get_nama_belakang());
                    bundle.putString("alamat", dataList.get(getAdapterPosition()).get_alamat());
                    bundle.putString("email", dataList.get(getAdapterPosition()).get_email());
                    bundle.putString("no_telepon", dataList.get(getAdapterPosition()).get_no_telepon());
                    bundle.putString("hak_akses", dataList.get(getAdapterPosition()).get_hak_akses());
                    bundle.putString("id_sekolah", dataList.get(getAdapterPosition()).get_id_sekolah());
                    bundle.putString("status_pekerjaan", dataList.get(getAdapterPosition()).get_status_pekerjaan());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("username", dataList.get(getAdapterPosition()).get_username());
                    bundle.putString("password", dataList.get(getAdapterPosition()).get_password());
;

                }
            });
        }
    }

    public void updateResults(ArrayList<data_admin_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
