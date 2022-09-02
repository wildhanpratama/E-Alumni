package com.project.aplikasi.namaaplikasi.data_admin;

import com.project.aplikasi.namaaplikasi.data_admin.data_admin_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_admin_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_admin/tampil.php")
	/* @POST("/data_admin/data_admin") */
    Call<data_admin_api> tampil_data_admin(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_admin/proses_simpan.php") 
	/* @POST("/data_admin/insert") */
    Call<Object> proses_simpan_data_admin(
            @Field("id_admin") String id_admin,
                   @Field("nama_depan") String nama_depan,
                   @Field("nama_belakang") String nama_belakang,
                   @Field("alamat") String alamat,
                   @Field("email") String email,
                   @Field("no_telepon") String no_telepon,
                   @Field("hak_akses") String hak_akses,
                   @Field("id_sekolah") String id_sekolah,
                   @Field("status_pekerjaan") String status_pekerjaan,
                   @Field("foto") String foto,
                   @Field("username") String username,
                   @Field("password") String password,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_admin/proses_update.php") 
	/* @POST("/data_admin/update") */
    Call<Object> proses_update_data_admin(
            @Field("id_admin") String id_admin,
                   @Field("nama_depan") String nama_depan,
                   @Field("nama_belakang") String nama_belakang,
                   @Field("alamat") String alamat,
                   @Field("email") String email,
                   @Field("no_telepon") String no_telepon,
                   @Field("hak_akses") String hak_akses,
                   @Field("id_sekolah") String id_sekolah,
                   @Field("status_pekerjaan") String status_pekerjaan,
                   @Field("foto") String foto,
                   @Field("username") String username,
                   @Field("password") String password,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_admin/proses_hapus.php")
	/* @POST("/data_admin/delete") */
    Call<Object> proses_hapus_data_admin(
            @Field("id_admin") String id_admin,
			@Header("Authorization") String auth
    );


}
