package com.project.aplikasi.namaaplikasi.data_like_kenangan;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_like_kenangan_apiutils {


    public static data_like_kenangan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_like_kenangan_apiservice.class);
    }
}
