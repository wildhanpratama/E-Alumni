package com.project.aplikasi.namaaplikasi.activity;

import com.project.aplikasi.namaaplikasi.data_admin.data_admin_api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface login_apiservice {

    @FormUrlEncoded
    @POST("api/login/login.php")
    Call<login_pegawai_api> login_pegawai(
            @Field("username") String username,
            @Field("password") String password,
            @Field("sebagai") String sebagai
    );
}





