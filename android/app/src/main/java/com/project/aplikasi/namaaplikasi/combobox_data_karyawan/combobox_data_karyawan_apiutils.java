package com.project.aplikasi.namaaplikasi.combobox_data_karyawan;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;
import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class combobox_data_karyawan_apiutils {
    public static combobox_data_karyawan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create(combobox_data_karyawan_apiservice.class);
    }
}


