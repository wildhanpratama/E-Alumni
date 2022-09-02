package com.project.aplikasi.namaaplikasi.combobox_data_sekolah;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_sekolah_apiservice {

    @POST("api/include/combobox/data_sekolah.php")
    Call<combobox_data_sekolah_api> api();
}





