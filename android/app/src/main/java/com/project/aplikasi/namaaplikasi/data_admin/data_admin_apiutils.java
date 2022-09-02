package com.project.aplikasi.namaaplikasi.data_admin;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_admin_apiutils {


    public static data_admin_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_admin_apiservice.class);
    }
}
