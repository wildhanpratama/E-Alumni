package com.project.aplikasi.namaaplikasi.data_alumni;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class data_alumni_apiutils {


    public static data_alumni_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_alumni_apiservice.class);
    }
}
