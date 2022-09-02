package com.project.aplikasi.namaaplikasi.combobox_data_pertanyaan_akreditas;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_pertanyaan_akreditas_apiservice {

    @POST("api/include/combobox/data_pertanyaan_akreditas.php")
    Call<combobox_data_pertanyaan_akreditas_api> api();
}





