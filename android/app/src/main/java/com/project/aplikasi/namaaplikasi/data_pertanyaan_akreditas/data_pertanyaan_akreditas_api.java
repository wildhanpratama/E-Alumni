package com.project.aplikasi.namaaplikasi.data_pertanyaan_akreditas;

import java.util.ArrayList;

public class data_pertanyaan_akreditas_api {
    private ArrayList<data_pertanyaan_akreditas_apidata> result = null;
	private String status;					  
    public ArrayList<data_pertanyaan_akreditas_apidata> get_data_pertanyaan_akreditas() {
        return result;
    }
    public void set_data_pertanyaan_akreditas(ArrayList<data_pertanyaan_akreditas_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
