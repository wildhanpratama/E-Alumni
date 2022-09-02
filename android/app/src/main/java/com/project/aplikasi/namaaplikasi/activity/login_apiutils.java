package com.project.aplikasi.namaaplikasi.activity;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;
import com.project.aplikasi.namaaplikasi.data_admin.data_admin_apiservice;

import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class login_apiutils {


    public static login_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create(login_apiservice.class);
    }
}


