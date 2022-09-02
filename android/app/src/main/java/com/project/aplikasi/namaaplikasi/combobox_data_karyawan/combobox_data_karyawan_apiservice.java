package com.project.aplikasi.namaaplikasi.combobox_data_karyawan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_karyawan_apiservice {

    @POST("api/include/combobox/data_karyawan.php")
    Call<combobox_data_karyawan_api> api();
}





