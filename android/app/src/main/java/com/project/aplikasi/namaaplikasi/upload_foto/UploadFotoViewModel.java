package com.project.aplikasi.namaaplikasi.upload_foto;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Part;

public class UploadFotoViewModel extends ViewModel {
    private final MutableLiveData<UploadState> uploadState = new MutableLiveData<>(UploadState.idle);
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(false);
    private final CompositeDisposable disposables = new CompositeDisposable();

    public LiveData<UploadState> getUploadState() {
        return uploadState;
    }

    public void uploadBukti(
            RequestBody id_alumni,
            RequestBody nama_depan,
            RequestBody nama_belakang,
            RequestBody alamat,
            RequestBody email,
            RequestBody no_telepon,
            RequestBody nisn,
            RequestBody id_sekolah,
            RequestBody jurusan,
            RequestBody tahun_masuk,
            RequestBody tahun_keluar,
            RequestBody jalur_penerimaan,
            RequestBody jenjang,
            RequestBody linkedin,
            RequestBody instagram,
            RequestBody facebook,
            RequestBody tempat_kerja,
            RequestBody jabatan_kerja,
            RequestBody alamat_kerja,
            RequestBody tahun_masuk_kerja,
            RequestBody tahun_resign,
            MultipartBody.Part foto,
            RequestBody username,
            RequestBody password,
            RequestBody login_sebagai
    ) {
        Disposable disposable = upload_foto_apiutils.getAPIService().upload(
                        id_alumni,
                        nama_depan,
                        nama_belakang,
                        alamat,
                        email,
                        no_telepon,
                        nisn,
                        id_sekolah,
                        jurusan,
                        tahun_masuk,
                        tahun_keluar,
                        jalur_penerimaan,
                        jenjang,
                        linkedin,
                        instagram,
                        facebook,
                        tempat_kerja,
                        jabatan_kerja,
                        alamat_kerja,
                        tahun_masuk_kerja,
                        tahun_resign,
                        foto,
                        username,
                        password,
                       login_sebagai
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .debounce(1, TimeUnit.SECONDS)
                .flatMap(response -> {
                    if (!response.getStatus().equalsIgnoreCase("success")) {
                        return Observable.error(new Exception("Upload foto gagal"));
                    }
                    return Observable.just(response);
                })
                .subscribe(upload -> {
                    uploadState.setValue(UploadState.upload_ok);
                    loading.setValue(false);
                }, error -> {
                    uploadState.setValue(UploadState.upload_error);
                    loading.setValue(false);
                });

        disposables.add(disposable);
    }

    public void setUploadState(UploadState state) {
        uploadState.setValue(state);
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public enum UploadState {
        idle,
        foto_ok,
        foto_error,
        upload_ok,
        upload_error
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }


}

