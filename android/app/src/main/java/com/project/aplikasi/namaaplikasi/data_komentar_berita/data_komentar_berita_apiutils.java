package com.project.aplikasi.namaaplikasi.data_komentar_berita;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_komentar_berita_apiutils {


    public static data_komentar_berita_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_komentar_berita_apiservice.class);
    }
}
