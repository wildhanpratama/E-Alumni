package com.project.aplikasi.namaaplikasi.data_sekolah;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_sekolah_apiutils {


    public static data_sekolah_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_sekolah_apiservice.class);
    }
}
