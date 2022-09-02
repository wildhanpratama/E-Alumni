package com.project.aplikasi.namaaplikasi.data_karyawan;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_karyawan_apiutils {


    public static data_karyawan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_karyawan_apiservice.class);
    }
}
