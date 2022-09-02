package com.project.aplikasi.namaaplikasi.data_like_kenangan;

public class data_like_kenangan_apidata {
    private String id_like_kenangan;
      private String tanggal;
      private String id_kenangan;
      private String id_alumni;

	
	
	public data_like_kenangan_apidata(String id_like_kenangan
	,String tanggal
	,String id_kenangan
	,String id_alumni

	) {
        this.id_like_kenangan = id_like_kenangan;
        this.tanggal = tanggal;
        this.id_kenangan = id_kenangan;
        this.id_alumni = id_alumni;

    }

    public String get_id_like_kenangan() {
        return id_like_kenangan;
    }
    public void set_id_like_kenangan(String id_like_kenangan) {
        this.id_like_kenangan = id_like_kenangan;
    }

    public String get_tanggal() {
        return tanggal;
    }
    public void set_tanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String get_id_kenangan() {
        return id_kenangan;
    }
    public void set_id_kenangan(String id_kenangan) {
        this.id_kenangan = id_kenangan;
    }
    public String get_id_alumni() {
        return id_alumni;
    }
    public void set_id_alumni(String id_alumni) {
        this.id_alumni = id_alumni;
    }

}
