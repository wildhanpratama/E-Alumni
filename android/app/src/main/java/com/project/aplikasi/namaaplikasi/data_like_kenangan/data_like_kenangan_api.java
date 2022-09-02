package com.project.aplikasi.namaaplikasi.data_like_kenangan;

import java.util.ArrayList;

public class data_like_kenangan_api {
    private ArrayList<data_like_kenangan_apidata> result = null;
	private String status;					  
    public ArrayList<data_like_kenangan_apidata> get_data_like_kenangan() {
        return result;
    }
    public void set_data_like_kenangan(ArrayList<data_like_kenangan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
