package com.project.aplikasi.namaaplikasi.data_akreditas;

public class data_akreditas_apidata {
    private String id_akreditas;
      private String nama_lengkap;
      private String nisn;
      private String kelas;
      private String tahun_lulus;
      private String email;
      private String status_pekerjaan;

	
	
	public data_akreditas_apidata(String id_akreditas
	,String nama_lengkap
	,String nisn
	,String kelas
	,String tahun_lulus
	,String email
	,String status_pekerjaan

	) {
        this.id_akreditas = id_akreditas;
        this.nama_lengkap = nama_lengkap;
        this.nisn = nisn;
        this.kelas = kelas;
        this.tahun_lulus = tahun_lulus;
        this.email = email;
        this.status_pekerjaan = status_pekerjaan;

    }

    public String get_id_akreditas() {
        return id_akreditas;
    }
    public void set_id_akreditas(String id_akreditas) {
        this.id_akreditas = id_akreditas;
    }

    public String get_nama_lengkap() {
        return nama_lengkap;
    }
    public void set_nama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }
    public String get_nisn() {
        return nisn;
    }
    public void set_nisn(String nisn) {
        this.nisn = nisn;
    }
    public String get_kelas() {
        return kelas;
    }
    public void set_kelas(String kelas) {
        this.kelas = kelas;
    }
    public String get_tahun_lulus() {
        return tahun_lulus;
    }
    public void set_tahun_lulus(String tahun_lulus) {
        this.tahun_lulus = tahun_lulus;
    }
    public String get_email() {
        return email;
    }
    public void set_email(String email) {
        this.email = email;
    }
    public String get_status_pekerjaan() {
        return status_pekerjaan;
    }
    public void set_status_pekerjaan(String status_pekerjaan) {
        this.status_pekerjaan = status_pekerjaan;
    }

}
