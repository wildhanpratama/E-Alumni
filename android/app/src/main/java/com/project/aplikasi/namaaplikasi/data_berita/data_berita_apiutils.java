package com.project.aplikasi.namaaplikasi.data_berita;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_berita_apiutils {


    public static data_berita_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_berita_apiservice.class);
    }
}
