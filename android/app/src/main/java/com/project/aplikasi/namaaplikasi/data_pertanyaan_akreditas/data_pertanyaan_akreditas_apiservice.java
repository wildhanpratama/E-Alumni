package com.project.aplikasi.namaaplikasi.data_pertanyaan_akreditas;

import com.project.aplikasi.namaaplikasi.data_pertanyaan_akreditas.data_pertanyaan_akreditas_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_pertanyaan_akreditas_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_pertanyaan_akreditas/tampil.php")
	/* @POST("/data_pertanyaan_akreditas/data_pertanyaan_akreditas") */
    Call<data_pertanyaan_akreditas_api> tampil_data_pertanyaan_akreditas(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pertanyaan_akreditas/proses_simpan.php") 
	/* @POST("/data_pertanyaan_akreditas/insert") */
    Call<Object> proses_simpan_data_pertanyaan_akreditas(
            @Field("id_pertanyaan_akreditas") String id_pertanyaan_akreditas,
                   @Field("id_sekolah") String id_sekolah,
                   @Field("pertanyaan") String pertanyaan,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pertanyaan_akreditas/proses_update.php") 
	/* @POST("/data_pertanyaan_akreditas/update") */
    Call<Object> proses_update_data_pertanyaan_akreditas(
            @Field("id_pertanyaan_akreditas") String id_pertanyaan_akreditas,
                   @Field("id_sekolah") String id_sekolah,
                   @Field("pertanyaan") String pertanyaan,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pertanyaan_akreditas/proses_hapus.php")
	/* @POST("/data_pertanyaan_akreditas/delete") */
    Call<Object> proses_hapus_data_pertanyaan_akreditas(
            @Field("id_pertanyaan_akreditas") String id_pertanyaan_akreditas,
			@Header("Authorization") String auth
    );


}
