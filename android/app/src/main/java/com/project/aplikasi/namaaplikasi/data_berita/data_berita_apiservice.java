package com.project.aplikasi.namaaplikasi.data_berita;

import com.project.aplikasi.namaaplikasi.data_berita.data_berita_api;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface data_berita_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_berita/tampil.php")
	/* @POST("/data_berita/data_berita") */
    Call<data_berita_api> tampil_data_berita(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_berita/proses_simpan.php") 
	/* @POST("/data_berita/insert") */
    Call<Object> proses_simpan_data_berita(
            @Field("id_berita") String id_berita,
                   @Field("caption") String caption,
                   @Field("tanggal") String tanggal,
                   @Field("foto") String foto,
                   @Field("id_alumni") String id_alumni,
                   @Field("jumlah_like") String jumlah_like,
                   @Field("jumlah_komen") String jumlah_komen,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_berita/proses_update.php") 
	/* @POST("/data_berita/update") */
    Call<Object> proses_update_data_berita(
            @Field("id_berita") String id_berita,
                   @Field("caption") String caption,
                   @Field("tanggal") String tanggal,
                   @Field("foto") String foto,
                   @Field("id_alumni") String id_alumni,
                   @Field("jumlah_like") String jumlah_like,
                   @Field("jumlah_komen") String jumlah_komen,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_berita/proses_hapus.php")
	/* @POST("/data_berita/delete") */
    Call<Object> proses_hapus_data_berita(
            @Field("id_berita") String id_berita,
			@Header("Authorization") String auth
    );

    //API SERVICE
    @Multipart
    @POST("api/app/page/data_berita/proses_simpan2.php")
    Call<ResponseBody> uploadImage(
            @Part MultipartBody.Part photo,
            @PartMap Map<String, RequestBody> text,
            @Header("Authorization") String auth
    );


}
