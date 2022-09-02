package com.project.aplikasi.namaaplikasi.data_kenangan_sqlite;

public class data_kenangan_sqlite_data {
    private String id_kenangan;
    private String caption;
    private String tanggal;
    private String foto;
    private String id_alumni;
    private String jumlah_like;
    private String jumlah_komen;


    public data_kenangan_sqlite_data() {
    }

    public data_kenangan_sqlite_data(String id_kenangan
    ,String caption
    ,String tanggal
    ,String foto
    ,String id_alumni
    ,String jumlah_like
    ,String jumlah_komen

	
	) {
        this.id_kenangan = id_kenangan;
        this.caption = caption;
        this.tanggal = tanggal;
        this.foto = foto;
        this.id_alumni = id_alumni;
        this.jumlah_like = jumlah_like;
        this.jumlah_komen = jumlah_komen;

        
    }

    public String get_id_kenangan() {
        return id_kenangan;
    }
    public void set_id_kenangan(String id_kenangan) {
        this.id_kenangan = id_kenangan;
    }

public String get_caption() {
    return caption;
}
public void set_caption(String caption) {
    this.caption = caption;
}
public String get_tanggal() {
    return tanggal;
}
public void set_tanggal(String tanggal) {
    this.tanggal = tanggal;
}
public String get_foto() {
    return foto;
}
public void set_foto(String foto) {
    this.foto = foto;
}
public String get_id_alumni() {
    return id_alumni;
}
public void set_id_alumni(String id_alumni) {
    this.id_alumni = id_alumni;
}
public String get_jumlah_like() {
    return jumlah_like;
}
public void set_jumlah_like(String jumlah_like) {
    this.jumlah_like = jumlah_like;
}
public String get_jumlah_komen() {
    return jumlah_komen;
}
public void set_jumlah_komen(String jumlah_komen) {
    this.jumlah_komen = jumlah_komen;
}

    
    
}







