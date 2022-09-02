package com.project.aplikasi.namaaplikasi.data_jawaban_akreditas;

public class data_jawaban_akreditas_apidata {
    private String id_jawaban_akreditas;
      private String id_pertanyaan_akreditas;
      private String jawaban;
      private String id_alumni;

	
	
	public data_jawaban_akreditas_apidata(String id_jawaban_akreditas
	,String id_pertanyaan_akreditas
	,String jawaban
	,String id_alumni

	) {
        this.id_jawaban_akreditas = id_jawaban_akreditas;
        this.id_pertanyaan_akreditas = id_pertanyaan_akreditas;
        this.jawaban = jawaban;
        this.id_alumni = id_alumni;

    }

    public String get_id_jawaban_akreditas() {
        return id_jawaban_akreditas;
    }
    public void set_id_jawaban_akreditas(String id_jawaban_akreditas) {
        this.id_jawaban_akreditas = id_jawaban_akreditas;
    }

    public String get_id_pertanyaan_akreditas() {
        return id_pertanyaan_akreditas;
    }
    public void set_id_pertanyaan_akreditas(String id_pertanyaan_akreditas) {
        this.id_pertanyaan_akreditas = id_pertanyaan_akreditas;
    }
    public String get_jawaban() {
        return jawaban;
    }
    public void set_jawaban(String jawaban) {
        this.jawaban = jawaban;
    }
    public String get_id_alumni() {
        return id_alumni;
    }
    public void set_id_alumni(String id_alumni) {
        this.id_alumni = id_alumni;
    }

}
