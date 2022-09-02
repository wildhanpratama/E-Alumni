package com.project.aplikasi.namaaplikasi.combobox_data_komentar_kenangan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_komentar_kenangan_apiservice {

    @POST("api/include/combobox/data_komentar_kenangan.php")
    Call<combobox_data_komentar_kenangan_api> api();
}





