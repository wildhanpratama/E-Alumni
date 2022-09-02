package com.project.aplikasi.namaaplikasi.data_jawaban_akreditas;

import com.project.aplikasi.namaaplikasi.data_jawaban_akreditas.data_jawaban_akreditas_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_jawaban_akreditas_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_jawaban_akreditas/tampil.php")
	/* @POST("/data_jawaban_akreditas/data_jawaban_akreditas") */
    Call<data_jawaban_akreditas_api> tampil_data_jawaban_akreditas(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_jawaban_akreditas/proses_simpan.php") 
	/* @POST("/data_jawaban_akreditas/insert") */
    Call<Object> proses_simpan_data_jawaban_akreditas(
            @Field("id_jawaban_akreditas") String id_jawaban_akreditas,
                   @Field("id_pertanyaan_akreditas") String id_pertanyaan_akreditas,
                   @Field("jawaban") String jawaban,
                   @Field("id_alumni") String id_alumni,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_jawaban_akreditas/proses_update.php") 
	/* @POST("/data_jawaban_akreditas/update") */
    Call<Object> proses_update_data_jawaban_akreditas(
            @Field("id_jawaban_akreditas") String id_jawaban_akreditas,
                   @Field("id_pertanyaan_akreditas") String id_pertanyaan_akreditas,
                   @Field("jawaban") String jawaban,
                   @Field("id_alumni") String id_alumni,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_jawaban_akreditas/proses_hapus.php")
	/* @POST("/data_jawaban_akreditas/delete") */
    Call<Object> proses_hapus_data_jawaban_akreditas(
            @Field("id_jawaban_akreditas") String id_jawaban_akreditas,
			@Header("Authorization") String auth
    );


}
