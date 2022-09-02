package com.project.aplikasi.namaaplikasi.data_sekolah;

import com.project.aplikasi.namaaplikasi.data_sekolah.data_sekolah_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_sekolah_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_sekolah/tampil.php")
	/* @POST("/data_sekolah/data_sekolah") */
    Call<data_sekolah_api> tampil_data_sekolah(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_sekolah/proses_simpan.php") 
	/* @POST("/data_sekolah/insert") */
    Call<Object> proses_simpan_data_sekolah(
            @Field("id_sekolah") String id_sekolah,
                   @Field("nama_sekolah") String nama_sekolah,
                   @Field("alamat") String alamat,
                   @Field("email") String email,
                   @Field("no_telepon") String no_telepon,
                   @Field("kota") String kota,
                   @Field("deskripsi") String deskripsi,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_sekolah/proses_update.php") 
	/* @POST("/data_sekolah/update") */
    Call<Object> proses_update_data_sekolah(
            @Field("id_sekolah") String id_sekolah,
                   @Field("nama_sekolah") String nama_sekolah,
                   @Field("alamat") String alamat,
                   @Field("email") String email,
                   @Field("no_telepon") String no_telepon,
                   @Field("kota") String kota,
                   @Field("deskripsi") String deskripsi,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_sekolah/proses_hapus.php")
	/* @POST("/data_sekolah/delete") */
    Call<Object> proses_hapus_data_sekolah(
            @Field("id_sekolah") String id_sekolah,
			@Header("Authorization") String auth
    );


}
