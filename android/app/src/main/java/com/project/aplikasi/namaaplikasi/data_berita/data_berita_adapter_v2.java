package com.project.aplikasi.namaaplikasi.data_berita;

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

public class data_berita_adapter_v2 extends RecyclerView.Adapter<data_berita_adapter_v2.data_berita_adapter_v2_view_holder> {
    private ArrayList<data_berita_apidata> dataList;
    private Activity activity;

    public data_berita_adapter_v2(ArrayList<data_berita_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_berita_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_berita_tampil_v2, parent, false);
        return new data_berita_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_berita_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_berita.setText(""+dataList.get(position).get_id_berita());
		holder.id_berita.setVisibility( View.GONE );
        holder.caption.setText(Html.fromHtml("Caption  : "+dataList.get(position).get_caption()+""));
        holder.tanggal.setText(Html.fromHtml("Tanggal  : "+dataList.get(position).get_tanggal()+""));
        holder.foto.setText(Html.fromHtml("Foto  : "+dataList.get(position).get_foto()+""));
        holder.id_alumni.setText(Html.fromHtml("Id Alumni  : "+dataList.get(position).get_id_alumni()+""));
        holder.jumlah_like.setText(Html.fromHtml("Jumlah Like  : "+dataList.get(position).get_jumlah_like()+""));
        holder.jumlah_komen.setText(Html.fromHtml("Jumlah Komen  : "+dataList.get(position).get_jumlah_komen()+""));


        thumb(holder,BASE_URL +"api/data/image/list/gambar1.png",false);
        edit(holder,"Edit",true);
        hapus(holder,"Hapus",true);
    }

     private void thumb(data_berita_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
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

    private void edit(data_berita_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    private void hapus(data_berita_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    public class data_berita_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_berita
        ,caption
        ,tanggal
        ,foto
        ,id_alumni
        ,jumlah_like
        ,jumlah_komen

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_berita_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_berita = (TextView) itemView.findViewById(R.id.id_berita);
            caption = (TextView) itemView.findViewById(R.id.caption);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
            foto = (TextView) itemView.findViewById(R.id.foto);
            id_alumni = (TextView) itemView.findViewById(R.id.id_alumni);
            jumlah_like = (TextView) itemView.findViewById(R.id.jumlah_like);
            jumlah_komen = (TextView) itemView.findViewById(R.id.jumlah_komen);

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
                                    data_berita_apiservice mAPIService = 
									data_berita_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_berita(
											dataList.get(getAdapterPosition()).get_id_berita(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_berita_activity_v2)activity).fetch_data_berita();
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

                    bundle.putString("id_berita", dataList.get(getAdapterPosition()).get_id_berita());
                    bundle.putString("caption", dataList.get(getAdapterPosition()).get_caption());
                    bundle.putString("tanggal", dataList.get(getAdapterPosition()).get_tanggal());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("id_alumni", dataList.get(getAdapterPosition()).get_id_alumni());
                    bundle.putString("jumlah_like", dataList.get(getAdapterPosition()).get_jumlah_like());
                    bundle.putString("jumlah_komen", dataList.get(getAdapterPosition()).get_jumlah_komen());
;

                    Intent intent = new Intent(activity, data_berita_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_berita", dataList.get(getAdapterPosition()).get_id_berita());
					                    bundle.putString("caption", dataList.get(getAdapterPosition()).get_caption());
                    bundle.putString("tanggal", dataList.get(getAdapterPosition()).get_tanggal());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("id_alumni", dataList.get(getAdapterPosition()).get_id_alumni());
                    bundle.putString("jumlah_like", dataList.get(getAdapterPosition()).get_jumlah_like());
                    bundle.putString("jumlah_komen", dataList.get(getAdapterPosition()).get_jumlah_komen());
;

                }
            });
        }
    }

    public void updateResults(ArrayList<data_berita_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
