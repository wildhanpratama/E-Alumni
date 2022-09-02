package com.project.aplikasi.namaaplikasi.data_sekolah;

public class data_sekolah_apidata {
    private String id_sekolah;
      private String nama_sekolah;
      private String alamat;
      private String email;
      private String no_telepon;
      private String kota;
      private String deskripsi;

	
	
	public data_sekolah_apidata(String id_sekolah
	,String nama_sekolah
	,String alamat
	,String email
	,String no_telepon
	,String kota
	,String deskripsi

	) {
        this.id_sekolah = id_sekolah;
        this.nama_sekolah = nama_sekolah;
        this.alamat = alamat;
        this.email = email;
        this.no_telepon = no_telepon;
        this.kota = kota;
        this.deskripsi = deskripsi;

    }

    public String get_id_sekolah() {
        return id_sekolah;
    }
    public void set_id_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String get_nama_sekolah() {
        return nama_sekolah;
    }
    public void set_nama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }
    public String get_alamat() {
        return alamat;
    }
    public void set_alamat(String alamat) {
        this.alamat = alamat;
    }
    public String get_email() {
        return email;
    }
    public void set_email(String email) {
        this.email = email;
    }
    public String get_no_telepon() {
        return no_telepon;
    }
    public void set_no_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
    public String get_kota() {
        return kota;
    }
    public void set_kota(String kota) {
        this.kota = kota;
    }
    public String get_deskripsi() {
        return deskripsi;
    }
    public void set_deskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
