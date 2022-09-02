package com.project.aplikasi.namaaplikasi.data_like_berita;

import com.project.aplikasi.namaaplikasi.data_like_berita.data_like_berita_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_like_berita_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_like_berita/tampil.php")
	/* @POST("/data_like_berita/data_like_berita") */
    Call<data_like_berita_api> tampil_data_like_berita(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_like_berita/proses_simpan.php") 
	/* @POST("/data_like_berita/insert") */
    Call<Object> proses_simpan_data_like_berita(
            @Field("id_like_berita") String id_like_berita,
                   @Field("tanggal") String tanggal,
                   @Field("id_berita") String id_berita,
                   @Field("id_alumni") String id_alumni,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_like_berita/proses_update.php") 
	/* @POST("/data_like_berita/update") */
    Call<Object> proses_update_data_like_berita(
            @Field("id_like_berita") String id_like_berita,
                   @Field("tanggal") String tanggal,
                   @Field("id_berita") String id_berita,
                   @Field("id_alumni") String id_alumni,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_like_berita/proses_hapus.php")
	/* @POST("/data_like_berita/delete") */
    Call<Object> proses_hapus_data_like_berita(
            @Field("id_like_berita") String id_like_berita,
			@Header("Authorization") String auth
    );


}
