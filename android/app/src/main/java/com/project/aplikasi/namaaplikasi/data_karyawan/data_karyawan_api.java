package com.project.aplikasi.namaaplikasi.data_karyawan;

import java.util.ArrayList;

public class data_karyawan_api {
    private ArrayList<data_karyawan_apidata> result = null;
	private String status;					  
    public ArrayList<data_karyawan_apidata> get_data_karyawan() {
        return result;
    }
    public void set_data_karyawan(ArrayList<data_karyawan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
