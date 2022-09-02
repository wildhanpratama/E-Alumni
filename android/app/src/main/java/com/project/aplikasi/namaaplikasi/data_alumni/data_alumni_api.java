package com.project.aplikasi.namaaplikasi.data_alumni;

import java.util.ArrayList;

public class data_alumni_api {
    private ArrayList<data_alumni_apidata> result = null;
	private String status;					  
    public ArrayList<data_alumni_apidata> get_data_alumni() {
        return result;
    }
    public void set_data_alumni(ArrayList<data_alumni_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
