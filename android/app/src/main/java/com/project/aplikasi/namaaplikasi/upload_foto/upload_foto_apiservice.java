package com.project.aplikasi.namaaplikasi.upload_foto;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface upload_foto_apiservice {
    @Multipart
    @POST("api/app/page/data_alumni/proses_simpan.php")
    Observable<upload_foto_apidata> upload(
            @Part("id_alumni") RequestBody id_alumni,
            @Part("nama_depan") RequestBody nama_depan,
            @Part("nama_belakang") RequestBody nama_belakang,
            @Part("alamat") RequestBody alamat,
            @Part("email") RequestBody email,
            @Part("no_telepon") RequestBody no_telepon,
            @Part("nisn") RequestBody nisn,
            @Part("id_sekolah") RequestBody id_sekolah,
            @Part("jurusan") RequestBody jurusan,
            @Part("tahun_masuk") RequestBody tahun_masuk,
            @Part("tahun_keluar") RequestBody tahun_keluar,
            @Part("jalur_penerimaan") RequestBody jalur_penerimaan,
            @Part("jenjang") RequestBody jenjang,
            @Part("linkedin") RequestBody linkedin,
            @Part("instagram") RequestBody instagram,
            @Part("facebook") RequestBody facebook,
            @Part("tempat_kerja") RequestBody tempat_kerja,
            @Part("jabatan_kerja") RequestBody jabatan_kerja,
            @Part("alamat_kerja") RequestBody alamat_kerja,
            @Part("tahun_masuk_kerja") RequestBody tahun_masuk_kerja,
            @Part("tahun_resign") RequestBody tahun_resign,
            @Part MultipartBody.Part foto,
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("login_sebagai") RequestBody login_sebagai
    );
}
