package com.project.aplikasi.namaaplikasi.combobox_data_komentar_berita;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_komentar_berita_apiservice {

    @POST("api/include/combobox/data_komentar_berita.php")
    Call<combobox_data_komentar_berita_api> api();
}





