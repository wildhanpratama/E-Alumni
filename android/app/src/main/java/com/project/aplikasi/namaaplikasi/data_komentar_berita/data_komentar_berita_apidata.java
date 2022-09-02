package com.project.aplikasi.namaaplikasi.data_komentar_berita;

public class data_komentar_berita_apidata {
    private String id_komentar_berita;
      private String id_berita;
      private String id_alumni;
      private String tanggal;
      private String komentar;

	
	
	public data_komentar_berita_apidata(String id_komentar_berita
	,String id_berita
	,String id_alumni
	,String tanggal
	,String komentar

	) {
        this.id_komentar_berita = id_komentar_berita;
        this.id_berita = id_berita;
        this.id_alumni = id_alumni;
        this.tanggal = tanggal;
        this.komentar = komentar;

    }

    public String get_id_komentar_berita() {
        return id_komentar_berita;
    }
    public void set_id_komentar_berita(String id_komentar_berita) {
        this.id_komentar_berita = id_komentar_berita;
    }

    public String get_id_berita() {
        return id_berita;
    }
    public void set_id_berita(String id_berita) {
        this.id_berita = id_berita;
    }
    public String get_id_alumni() {
        return id_alumni;
    }
    public void set_id_alumni(String id_alumni) {
        this.id_alumni = id_alumni;
    }
    public String get_tanggal() {
        return tanggal;
    }
    public void set_tanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String get_komentar() {
        return komentar;
    }
    public void set_komentar(String komentar) {
        this.komentar = komentar;
    }

}
