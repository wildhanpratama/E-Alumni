package com.project.aplikasi.namaaplikasi.data_alumni;

import com.project.aplikasi.namaaplikasi.data_alumni.data_alumni_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_alumni_apiservice {

    @FormUrlEncoded
    @POST("api/app/page/data_alumni/tampil.php")
        /* @POST("/data_alumni/data_alumni") */
    Call<data_alumni_api> tampil_data_alumni(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_alumni/proses_simpan.php")
        /* @POST("/data_alumni/insert") */
    Call<Object> proses_simpan_data_alumni(
            @Field("id_alumni") String id_alumni,
            @Field("nama_depan") String nama_depan,
            @Field("nama_belakang") String nama_belakang,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("no_telepon") String no_telepon,
            @Field("nisn") String nisn,
            @Field("id_sekolah") String id_sekolah,
            @Field("jurusan") String jurusan,
            @Field("tahun_masuk") String tahun_masuk,
            @Field("tahun_keluar") String tahun_keluar,
            @Field("jalur_penerimaan") String jalur_penerimaan,
            @Field("jenjang") String jenjang,
            @Field("linkedin") String linkedin,
            @Field("instagram") String instagram,
            @Field("facebook") String facebook,
            @Field("tempat_kerja") String tempat_kerja,
            @Field("jabatan_kerja") String jabatan_kerja,
            @Field("alamat_kerja") String alamat_kerja,
            @Field("tahun_masuk_kerja") String tahun_masuk_kerja,
            @Field("tahun_resign") String tahun_resign,
            @Field("foto") String foto,
            @Field("username") String username,
            @Field("password") String password,

            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_alumni/proses_update.php")
        /* @POST("/data_alumni/update") */
    Call<Object> proses_update_data_alumni(
            @Field("id_alumni") String id_alumni,
            @Field("nama_depan") String nama_depan,
            @Field("nama_belakang") String nama_belakang,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("no_telepon") String no_telepon,
            @Field("nisn") String nisn,
            @Field("id_sekolah") String id_sekolah,
            @Field("jurusan") String jurusan,
            @Field("tahun_masuk") String tahun_masuk,
            @Field("tahun_keluar") String tahun_keluar,
            @Field("jalur_penerimaan") String jalur_penerimaan,
            @Field("jenjang") String jenjang,
            @Field("linkedin") String linkedin,
            @Field("instagram") String instagram,
            @Field("facebook") String facebook,
            @Field("tempat_kerja") String tempat_kerja,
            @Field("jabatan_kerja") String jabatan_kerja,
            @Field("alamat_kerja") String alamat_kerja,
            @Field("tahun_masuk_kerja") String tahun_masuk_kerja,
            @Field("tahun_resign") String tahun_resign,
            @Field("foto") String foto,
            @Field("username") String username,
            @Field("password") String password,

            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_alumni/proses_hapus.php")
        /* @POST("/data_alumni/delete") */
    Call<Object> proses_hapus_data_alumni(
            @Field("id_alumni") String id_alumni,
            @Header("Authorization") String auth
    );


}
