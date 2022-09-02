package com.project.aplikasi.namaaplikasi.data_komentar_kenangan_sqlite;

public class data_komentar_kenangan_sqlite_data {
    private String id_komentar_kenangan;
    private String id_kenangan;
    private String id_alumni;
    private String tanggal;
    private String komentar;


    public data_komentar_kenangan_sqlite_data() {
    }

    public data_komentar_kenangan_sqlite_data(String id_komentar_kenangan
    ,String id_kenangan
    ,String id_alumni
    ,String tanggal
    ,String komentar

	
	) {
        this.id_komentar_kenangan = id_komentar_kenangan;
        this.id_kenangan = id_kenangan;
        this.id_alumni = id_alumni;
        this.tanggal = tanggal;
        this.komentar = komentar;

        
    }

    public String get_id_komentar_kenangan() {
        return id_komentar_kenangan;
    }
    public void set_id_komentar_kenangan(String id_komentar_kenangan) {
        this.id_komentar_kenangan = id_komentar_kenangan;
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







