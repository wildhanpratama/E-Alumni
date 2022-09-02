package com.project.aplikasi.namaaplikasi.data_komentar_kenangan;

import com.project.aplikasi.namaaplikasi.data_komentar_kenangan.data_komentar_kenangan_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_komentar_kenangan_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_komentar_kenangan/tampil.php")
	/* @POST("/data_komentar_kenangan/data_komentar_kenangan") */
    Call<data_komentar_kenangan_api> tampil_data_komentar_kenangan(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_komentar_kenangan/proses_simpan.php") 
	/* @POST("/data_komentar_kenangan/insert") */
    Call<Object> proses_simpan_data_komentar_kenangan(
            @Field("id_komentar_kenangan") String id_komentar_kenangan,
                   @Field("id_kenangan") String id_kenangan,
                   @Field("id_alumni") String id_alumni,
                   @Field("tanggal") String tanggal,
                   @Field("komentar") String komentar,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_komentar_kenangan/proses_update.php") 
	/* @POST("/data_komentar_kenangan/update") */
    Call<Object> proses_update_data_komentar_kenangan(
            @Field("id_komentar_kenangan") String id_komentar_kenangan,
                   @Field("id_kenangan") String id_kenangan,
                   @Field("id_alumni") String id_alumni,
                   @Field("tanggal") String tanggal,
                   @Field("komentar") String komentar,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_komentar_kenangan/proses_hapus.php")
	/* @POST("/data_komentar_kenangan/delete") */
    Call<Object> proses_hapus_data_komentar_kenangan(
            @Field("id_komentar_kenangan") String id_komentar_kenangan,
			@Header("Authorization") String auth
    );


}
