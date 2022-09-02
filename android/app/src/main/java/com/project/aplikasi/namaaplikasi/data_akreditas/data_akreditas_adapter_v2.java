package com.project.aplikasi.namaaplikasi.data_akreditas;

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

public class data_akreditas_adapter_v2 extends RecyclerView.Adapter<data_akreditas_adapter_v2.data_akreditas_adapter_v2_view_holder> {
    private ArrayList<data_akreditas_apidata> dataList;
    private Activity activity;

    public data_akreditas_adapter_v2(ArrayList<data_akreditas_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_akreditas_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_akreditas_tampil_v2, parent, false);
        return new data_akreditas_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_akreditas_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_akreditas.setText(""+dataList.get(position).get_id_akreditas());
		holder.id_akreditas.setVisibility( View.GONE );
        holder.nama_lengkap.setText(Html.fromHtml("Nama Lengkap  : "+dataList.get(position).get_nama_lengkap()+""));
        holder.nisn.setText(Html.fromHtml("Nisn  : "+dataList.get(position).get_nisn()+""));
        holder.kelas.setText(Html.fromHtml("Kelas  : "+dataList.get(position).get_kelas()+""));
        holder.tahun_lulus.setText(Html.fromHtml("Tahun Lulus  : "+dataList.get(position).get_tahun_lulus()+""));
        holder.email.setText(Html.fromHtml("Email  : "+dataList.get(position).get_email()+""));
        holder.status_pekerjaan.setText(Html.fromHtml("Status Pekerjaan  : "+dataList.get(position).get_status_pekerjaan()+""));


        thumb(holder,BASE_URL +"api/data/image/list/gambar1.png",false);
        edit(holder,"Update data",true);
        hapus(holder,"Hapus",false);
    }

     private void thumb(data_akreditas_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
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

    private void edit(data_akreditas_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    private void hapus(data_akreditas_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    public class data_akreditas_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_akreditas
        ,nama_lengkap
        ,nisn
        ,kelas
        ,tahun_lulus
        ,email
        ,status_pekerjaan

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_akreditas_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_akreditas = (TextView) itemView.findViewById(R.id.id_akreditas);
            nama_lengkap = (TextView) itemView.findViewById(R.id.nama_lengkap);
            nisn = (TextView) itemView.findViewById(R.id.nisn);
            kelas = (TextView) itemView.findViewById(R.id.kelas);
            tahun_lulus = (TextView) itemView.findViewById(R.id.tahun_lulus);
            email = (TextView) itemView.findViewById(R.id.email);
            status_pekerjaan = (TextView) itemView.findViewById(R.id.status_pekerjaan);

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
                                    data_akreditas_apiservice mAPIService = 
									data_akreditas_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_akreditas(
											dataList.get(getAdapterPosition()).get_id_akreditas(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_akreditas_activity_v2)activity).fetch_data_akreditas();
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

                    bundle.putString("id_akreditas", dataList.get(getAdapterPosition()).get_id_akreditas());
                    bundle.putString("nama_lengkap", dataList.get(getAdapterPosition()).get_nama_lengkap());
                    bundle.putString("nisn", dataList.get(getAdapterPosition()).get_nisn());
                    bundle.putString("kelas", dataList.get(getAdapterPosition()).get_kelas());
                    bundle.putString("tahun_lulus", dataList.get(getAdapterPosition()).get_tahun_lulus());
                    bundle.putString("email", dataList.get(getAdapterPosition()).get_email());
                    bundle.putString("status_pekerjaan", dataList.get(getAdapterPosition()).get_status_pekerjaan());
;

                    Intent intent = new Intent(activity, data_akreditas_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_akreditas", dataList.get(getAdapterPosition()).get_id_akreditas());
					                    bundle.putString("nama_lengkap", dataList.get(getAdapterPosition()).get_nama_lengkap());
                    bundle.putString("nisn", dataList.get(getAdapterPosition()).get_nisn());
                    bundle.putString("kelas", dataList.get(getAdapterPosition()).get_kelas());
                    bundle.putString("tahun_lulus", dataList.get(getAdapterPosition()).get_tahun_lulus());
                    bundle.putString("email", dataList.get(getAdapterPosition()).get_email());
                    bundle.putString("status_pekerjaan", dataList.get(getAdapterPosition()).get_status_pekerjaan());
;

                }
            });
        }
    }

    public void updateResults(ArrayList<data_akreditas_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
