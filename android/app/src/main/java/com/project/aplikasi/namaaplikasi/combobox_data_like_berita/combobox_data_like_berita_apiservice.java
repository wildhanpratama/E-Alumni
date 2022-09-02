package com.project.aplikasi.namaaplikasi.combobox_data_like_berita;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_like_berita_apiservice {

    @POST("api/include/combobox/data_like_berita.php")
    Call<combobox_data_like_berita_api> api();
}





