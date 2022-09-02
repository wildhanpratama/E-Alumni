package com.project.aplikasi.namaaplikasi.combobox_data_akreditas;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_akreditas_apiservice {

    @POST("api/include/combobox/data_akreditas.php")
    Call<combobox_data_akreditas_api> api();
}





