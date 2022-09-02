package com.project.aplikasi.namaaplikasi.combobox_data_admin;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_admin_apiservice {

    @POST("api/include/combobox/data_admin.php")
    Call<combobox_data_admin_api> api();
}





