package com.project.aplikasi.namaaplikasi.data_admin;

public class data_admin_apidata {
    private String id_admin;
      private String nama_depan;
      private String nama_belakang;
      private String alamat;
      private String email;
      private String no_telepon;
      private String hak_akses;
      private String id_sekolah;
      private String status_pekerjaan;
      private String foto;
      private String username;
      private String password;

	
	
	public data_admin_apidata(String id_admin
	,String nama_depan
	,String nama_belakang
	,String alamat
	,String email
	,String no_telepon
	,String hak_akses
	,String id_sekolah
	,String status_pekerjaan
	,String foto
	,String username
	,String password

	) {
        this.id_admin = id_admin;
        this.nama_depan = nama_depan;
        this.nama_belakang = nama_belakang;
        this.alamat = alamat;
        this.email = email;
        this.no_telepon = no_telepon;
        this.hak_akses = hak_akses;
        this.id_sekolah = id_sekolah;
        this.status_pekerjaan = status_pekerjaan;
        this.foto = foto;
        this.username = username;
        this.password = password;

    }

    public String get_id_admin() {
        return id_admin;
    }
    public void set_id_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String get_nama_depan() {
        return nama_depan;
    }
    public void set_nama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }
    public String get_nama_belakang() {
        return nama_belakang;
    }
    public void set_nama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
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
    public String get_hak_akses() {
        return hak_akses;
    }
    public void set_hak_akses(String hak_akses) {
        this.hak_akses = hak_akses;
    }
    public String get_id_sekolah() {
        return id_sekolah;
    }
    public void set_id_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }
    public String get_status_pekerjaan() {
        return status_pekerjaan;
    }
    public void set_status_pekerjaan(String status_pekerjaan) {
        this.status_pekerjaan = status_pekerjaan;
    }
    public String get_foto() {
        return foto;
    }
    public void set_foto(String foto) {
        this.foto = foto;
    }
    public String get_username() {
        return username;
    }
    public void set_username(String username) {
        this.username = username;
    }
    public String get_password() {
        return password;
    }
    public void set_password(String password) {
        this.password = password;
    }

}
