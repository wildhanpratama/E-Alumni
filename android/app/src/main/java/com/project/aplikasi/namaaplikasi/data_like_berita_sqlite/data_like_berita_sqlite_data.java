package com.project.aplikasi.namaaplikasi.data_like_berita_sqlite;

public class data_like_berita_sqlite_data {
    private String id_like_berita;
    private String tanggal;
    private String id_berita;
    private String id_alumni;


    public data_like_berita_sqlite_data() {
    }

    public data_like_berita_sqlite_data(String id_like_berita
    ,String tanggal
    ,String id_berita
    ,String id_alumni

	
	) {
        this.id_like_berita = id_like_berita;
        this.tanggal = tanggal;
        this.id_berita = id_berita;
        this.id_alumni = id_alumni;

        
    }

    public String get_id_like_berita() {
        return id_like_berita;
    }
    public void set_id_like_berita(String id_like_berita) {
        this.id_like_berita = id_like_berita;
    }

public String get_tanggal() {
    return tanggal;
}
public void set_tanggal(String tanggal) {
    this.tanggal = tanggal;
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

    
    
}







