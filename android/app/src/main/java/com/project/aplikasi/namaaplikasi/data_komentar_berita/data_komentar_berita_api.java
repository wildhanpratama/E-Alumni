package com.project.aplikasi.namaaplikasi.data_komentar_berita;

import java.util.ArrayList;

public class data_komentar_berita_api {
    private ArrayList<data_komentar_berita_apidata> result = null;
	private String status;					  
    public ArrayList<data_komentar_berita_apidata> get_data_komentar_berita() {
        return result;
    }
    public void set_data_komentar_berita(ArrayList<data_komentar_berita_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
