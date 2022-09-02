package com.project.aplikasi.namaaplikasi.data_kenangan;

import java.util.ArrayList;

public class data_kenangan_api {
    private ArrayList<data_kenangan_apidata> result = null;
	private String status;					  
    public ArrayList<data_kenangan_apidata> get_data_kenangan() {
        return result;
    }
    public void set_data_kenangan(ArrayList<data_kenangan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
