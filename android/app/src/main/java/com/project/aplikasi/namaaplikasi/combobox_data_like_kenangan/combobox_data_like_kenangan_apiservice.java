package com.project.aplikasi.namaaplikasi.combobox_data_like_kenangan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_like_kenangan_apiservice {

    @POST("api/include/combobox/data_like_kenangan.php")
    Call<combobox_data_like_kenangan_api> api();
}





