package com.project.aplikasi.namaaplikasi.data_karyawan;

import com.project.aplikasi.namaaplikasi.data_karyawan.data_karyawan_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_karyawan_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_karyawan/tampil.php")
	/* @POST("/data_karyawan/data_karyawan") */
    Call<data_karyawan_api> tampil_data_karyawan(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_karyawan/proses_simpan.php") 
	/* @POST("/data_karyawan/insert") */
    Call<Object> proses_simpan_data_karyawan(
            @Field("id_karyawan") String id_karyawan,
                   @Field("nama_depan") String nama_depan,
                   @Field("nama_belakang") String nama_belakang,
                   @Field("alamat") String alamat,
                   @Field("email") String email,
                   @Field("no_telepon") String no_telepon,
                   @Field("kategori") String kategori,
                   @Field("kota") String kota,
                   @Field("tahun_masuk") String tahun_masuk,
                   @Field("tahun_keluar") String tahun_keluar,
                   @Field("bidang_keahlian") String bidang_keahlian,
                   @Field("id_sekolah") String id_sekolah,
                   @Field("linkedin") String linkedin,
                   @Field("instagram") String instagram,
                   @Field("facebook") String facebook,
                   @Field("foto") String foto,
                   @Field("username") String username,
                   @Field("password") String password,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_karyawan/proses_update.php") 
	/* @POST("/data_karyawan/update") */
    Call<Object> proses_update_data_karyawan(
            @Field("id_karyawan") String id_karyawan,
                   @Field("nama_depan") String nama_depan,
                   @Field("nama_belakang") String nama_belakang,
                   @Field("alamat") String alamat,
                   @Field("email") String email,
                   @Field("no_telepon") String no_telepon,
                   @Field("kategori") String kategori,
                   @Field("kota") String kota,
                   @Field("tahun_masuk") String tahun_masuk,
                   @Field("tahun_keluar") String tahun_keluar,
                   @Field("bidang_keahlian") String bidang_keahlian,
                   @Field("id_sekolah") String id_sekolah,
                   @Field("linkedin") String linkedin,
                   @Field("instagram") String instagram,
                   @Field("facebook") String facebook,
                   @Field("foto") String foto,
                   @Field("username") String username,
                   @Field("password") String password,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_karyawan/proses_hapus.php")
	/* @POST("/data_karyawan/delete") */
    Call<Object> proses_hapus_data_karyawan(
            @Field("id_karyawan") String id_karyawan,
			@Header("Authorization") String auth
    );


}
