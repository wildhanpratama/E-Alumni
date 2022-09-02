package com.project.aplikasi.namaaplikasi.data_sekolah;

import java.util.ArrayList;

public class data_sekolah_api {
    private ArrayList<data_sekolah_apidata> result = null;
	private String status;					  
    public ArrayList<data_sekolah_apidata> get_data_sekolah() {
        return result;
    }
    public void set_data_sekolah(ArrayList<data_sekolah_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
