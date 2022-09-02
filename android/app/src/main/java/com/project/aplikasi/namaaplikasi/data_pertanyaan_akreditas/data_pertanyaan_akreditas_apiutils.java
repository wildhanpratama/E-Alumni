package com.project.aplikasi.namaaplikasi.data_pertanyaan_akreditas;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_pertanyaan_akreditas_apiutils {


    public static data_pertanyaan_akreditas_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_pertanyaan_akreditas_apiservice.class);
    }
}
