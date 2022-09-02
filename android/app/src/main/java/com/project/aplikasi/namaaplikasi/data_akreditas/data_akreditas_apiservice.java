package com.project.aplikasi.namaaplikasi.data_akreditas;

import com.project.aplikasi.namaaplikasi.data_akreditas.data_akreditas_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_akreditas_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_akreditas/tampil.php")
	/* @POST("/data_akreditas/data_akreditas") */
    Call<data_akreditas_api> tampil_data_akreditas(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_akreditas/proses_simpan.php") 
	/* @POST("/data_akreditas/insert") */
    Call<Object> proses_simpan_data_akreditas(
            @Field("id_akreditas") String id_akreditas,
                   @Field("nama_lengkap") String nama_lengkap,
                   @Field("nisn") String nisn,
                   @Field("kelas") String kelas,
                   @Field("tahun_lulus") String tahun_lulus,
                   @Field("email") String email,
                   @Field("status_pekerjaan") String status_pekerjaan,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_akreditas/proses_update.php") 
	/* @POST("/data_akreditas/update") */
    Call<Object> proses_update_data_akreditas(
            @Field("id_akreditas") String id_akreditas,
                   @Field("nama_lengkap") String nama_lengkap,
                   @Field("nisn") String nisn,
                   @Field("kelas") String kelas,
                   @Field("tahun_lulus") String tahun_lulus,
                   @Field("email") String email,
                   @Field("status_pekerjaan") String status_pekerjaan,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_akreditas/proses_hapus.php")
	/* @POST("/data_akreditas/delete") */
    Call<Object> proses_hapus_data_akreditas(
            @Field("id_akreditas") String id_akreditas,
			@Header("Authorization") String auth
    );


}
