package com.project.aplikasi.namaaplikasi.data_pertanyaan_akreditas_sqlite;

public class data_pertanyaan_akreditas_sqlite_data {
    private String id_pertanyaan_akreditas;
    private String id_sekolah;
    private String pertanyaan;


    public data_pertanyaan_akreditas_sqlite_data() {
    }

    public data_pertanyaan_akreditas_sqlite_data(String id_pertanyaan_akreditas
    ,String id_sekolah
    ,String pertanyaan

	
	) {
        this.id_pertanyaan_akreditas = id_pertanyaan_akreditas;
        this.id_sekolah = id_sekolah;
        this.pertanyaan = pertanyaan;

        
    }

    public String get_id_pertanyaan_akreditas() {
        return id_pertanyaan_akreditas;
    }
    public void set_id_pertanyaan_akreditas(String id_pertanyaan_akreditas) {
        this.id_pertanyaan_akreditas = id_pertanyaan_akreditas;
    }

public String get_id_sekolah() {
    return id_sekolah;
}
public void set_id_sekolah(String id_sekolah) {
    this.id_sekolah = id_sekolah;
}
public String get_pertanyaan() {
    return pertanyaan;
}
public void set_pertanyaan(String pertanyaan) {
    this.pertanyaan = pertanyaan;
}

    
    
}







