package com.project.aplikasi.namaaplikasi.combobox_data_alumni;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_alumni_apiservice {

    @POST("api/include/combobox/data_alumni.php")
    Call<combobox_data_alumni_api> api();
}





