package com.project.aplikasi.namaaplikasi.combobox_data_alumni;

import com.project.aplikasi.namaaplikasi.config.config_apiclient;
import static com.project.aplikasi.namaaplikasi.config.config_global.BASE_URL;

public class combobox_data_alumni_apiutils {
    public static combobox_data_alumni_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create(combobox_data_alumni_apiservice.class);
    }
}


