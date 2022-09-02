package com.project.aplikasi.namaaplikasi.data_komentar_berita;

import com.project.aplikasi.namaaplikasi.data_komentar_berita.data_komentar_berita_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_komentar_berita_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_komentar_berita/tampil.php")
	/* @POST("/data_komentar_berita/data_komentar_berita") */
    Call<data_komentar_berita_api> tampil_data_komentar_berita(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_komentar_berita/proses_simpan.php") 
	/* @POST("/data_komentar_berita/insert") */
    Call<Object> proses_simpan_data_komentar_berita(
            @Field("id_komentar_berita") String id_komentar_berita,
                   @Field("id_berita") String id_berita,
                   @Field("id_alumni") String id_alumni,
                   @Field("tanggal") String tanggal,
                   @Field("komentar") String komentar,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_komentar_berita/proses_update.php") 
	/* @POST("/data_komentar_berita/update") */
    Call<Object> proses_update_data_komentar_berita(
            @Field("id_komentar_berita") String id_komentar_berita,
                   @Field("id_berita") String id_berita,
                   @Field("id_alumni") String id_alumni,
                   @Field("tanggal") String tanggal,
                   @Field("komentar") String komentar,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_komentar_berita/proses_hapus.php")
	/* @POST("/data_komentar_berita/delete") */
    Call<Object> proses_hapus_data_komentar_berita(
            @Field("id_komentar_berita") String id_komentar_berita,
			@Header("Authorization") String auth
    );


}
