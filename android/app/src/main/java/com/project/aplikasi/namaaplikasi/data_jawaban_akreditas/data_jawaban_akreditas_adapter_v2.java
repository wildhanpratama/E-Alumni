package com.project.aplikasi.namaaplikasi.data_jawaban_akreditas;

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

public class data_jawaban_akreditas_adapter_v2 extends RecyclerView.Adapter<data_jawaban_akreditas_adapter_v2.data_jawaban_akreditas_adapter_v2_view_holder> {
    private ArrayList<data_jawaban_akreditas_apidata> dataList;
    private Activity activity;

    public data_jawaban_akreditas_adapter_v2(ArrayList<data_jawaban_akreditas_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_jawaban_akreditas_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_jawaban_akreditas_tampil_v2, parent, false);
        return new data_jawaban_akreditas_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_jawaban_akreditas_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_jawaban_akreditas.setText(""+dataList.get(position).get_id_jawaban_akreditas());
		holder.id_jawaban_akreditas.setVisibility( View.GONE );
        holder.id_pertanyaan_akreditas.setText(Html.fromHtml("Id Pertanyaan Akreditas  : "+dataList.get(position).get_id_pertanyaan_akreditas()+""));
        holder.jawaban.setText(Html.fromHtml("Jawaban  : "+dataList.get(position).get_jawaban()+""));
        holder.id_alumni.setText(Html.fromHtml("Id Alumni  : "+dataList.get(position).get_id_alumni()+""));


        thumb(holder,BASE_URL +"api/data/image/list/gambar1.png",false);
        edit(holder,"Edit",true);
        hapus(holder,"Hapus",true);
    }

     private void thumb(data_jawaban_akreditas_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
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

    private void edit(data_jawaban_akreditas_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    private void hapus(data_jawaban_akreditas_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    public class data_jawaban_akreditas_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_jawaban_akreditas
        ,id_pertanyaan_akreditas
        ,jawaban
        ,id_alumni

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_jawaban_akreditas_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_jawaban_akreditas = (TextView) itemView.findViewById(R.id.id_jawaban_akreditas);
            id_pertanyaan_akreditas = (TextView) itemView.findViewById(R.id.id_pertanyaan_akreditas);
            jawaban = (TextView) itemView.findViewById(R.id.jawaban);
            id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);

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
                                    data_jawaban_akreditas_apiservice mAPIService = 
									data_jawaban_akreditas_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_jawaban_akreditas(
											dataList.get(getAdapterPosition()).get_id_jawaban_akreditas(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_jawaban_akreditas_activity_v2)activity).fetch_data_jawaban_akreditas();
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

                    bundle.putString("id_jawaban_akreditas", dataList.get(getAdapterPosition()).get_id_jawaban_akreditas());
                    bundle.putString("id_pertanyaan_akreditas", dataList.get(getAdapterPosition()).get_id_pertanyaan_akreditas());
                    bundle.putString("jawaban", dataList.get(getAdapterPosition()).get_jawaban());
                    bundle.putString("id_alumni", dataList.get(getAdapterPosition()).get_id_alumni());
;

                    Intent intent = new Intent(activity, data_jawaban_akreditas_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_jawaban_akreditas", dataList.get(getAdapterPosition()).get_id_jawaban_akreditas());
					                    bundle.putString("id_pertanyaan_akreditas", dataList.get(getAdapterPosition()).get_id_pertanyaan_akreditas());
                    bundle.putString("jawaban", dataList.get(getAdapterPosition()).get_jawaban());
                    bundle.putString("id_alumni", dataList.get(getAdapterPosition()).get_id_alumni());
;

                }
            });
        }
    }

    public void updateResults(ArrayList<data_jawaban_akreditas_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
