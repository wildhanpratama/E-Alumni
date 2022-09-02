package com.project.aplikasi.namaaplikasi.data_komentar_kenangan;

import java.util.ArrayList;

public class data_komentar_kenangan_api {
    private ArrayList<data_komentar_kenangan_apidata> result = null;
	private String status;					  
    public ArrayList<data_komentar_kenangan_apidata> get_data_komentar_kenangan() {
        return result;
    }
    public void set_data_komentar_kenangan(ArrayList<data_komentar_kenangan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
