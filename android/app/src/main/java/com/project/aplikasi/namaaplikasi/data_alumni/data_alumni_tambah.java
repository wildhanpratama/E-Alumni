package com.project.aplikasi.namaaplikasi.data_alumni;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.combobox_data_sekolah.combobox_data_sekolah;
import com.project.aplikasi.namaaplikasi.combobox_data_sekolah.combobox_data_sekolah_api;
import com.project.aplikasi.namaaplikasi.combobox_data_sekolah.combobox_data_sekolah_apidata;
import com.project.aplikasi.namaaplikasi.combobox_data_sekolah.combobox_data_sekolah_apiservice;
import com.project.aplikasi.namaaplikasi.combobox_data_sekolah.combobox_data_sekolah_apiutils;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.activity.loading;
import com.project.aplikasi.namaaplikasi.upload_foto.UploadFotoViewModel;
import com.tbruyelle.rxpermissions3.RxPermissions;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.project.aplikasi.namaaplikasi.config.config_global.inputTypes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

public class data_alumni_tambah extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 3423;
    String validasi;
    Button tombol_simpan;
    data_alumni_apiservice mAPIService;
    EditText id_alumni, nama_depan, nama_belakang, alamat, email, no_telepon, nisn, id_sekolah, jurusan, tahun_masuk, tahun_keluar, jalur_penerimaan, jenjang, linkedin, instagram, facebook, tempat_kerja, jabatan_kerja, alamat_kerja, tahun_masuk_kerja, tahun_resign, foto, username, password;
    loading loading;
    UploadFotoViewModel model;
    MultipartBody.Part filePart;
    CompositeDisposable disposables = new CompositeDisposable();
    ImageView image;
    Spinner kuliah_atau_kerja;
    LinearLayout form_kuliah, form_kerja;
    String login_sebagai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_alumni_tambah);
        tombol_simpan = (Button) findViewById(R.id.tombol_simpan);
        loading = new loading(this);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        nama_depan = (EditText) findViewById(R.id.nama_depan);
        nama_belakang = (EditText) findViewById(R.id.nama_belakang);
        alamat = (EditText) findViewById(R.id.alamat);
        email = (EditText) findViewById(R.id.email);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        nisn = (EditText) findViewById(R.id.nisn);
        id_sekolah = (EditText) findViewById(R.id.id_sekolah);
        jurusan = (EditText) findViewById(R.id.jurusan);
        tahun_masuk = (EditText) findViewById(R.id.tahun_masuk);
        tahun_keluar = (EditText) findViewById(R.id.tahun_keluar);
        jalur_penerimaan = (EditText) findViewById(R.id.jalur_penerimaan);
        jenjang = (EditText) findViewById(R.id.jenjang);
        linkedin = (EditText) findViewById(R.id.linkedin);
        instagram = (EditText) findViewById(R.id.instagram);
        facebook = (EditText) findViewById(R.id.facebook);
        tempat_kerja = (EditText) findViewById(R.id.tempat_kerja);
        jabatan_kerja = (EditText) findViewById(R.id.jabatan_kerja);
        alamat_kerja = (EditText) findViewById(R.id.alamat_kerja);
        tahun_masuk_kerja = (EditText) findViewById(R.id.tahun_masuk_kerja);
        tahun_resign = (EditText) findViewById(R.id.tahun_resign);
        foto = (EditText) findViewById(R.id.foto);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        image = findViewById(R.id.image);
        kuliah_atau_kerja = findViewById(R.id.kuliah_atau_kerja);
        form_kuliah = findViewById(R.id.form_kuliah);
        form_kerja = findViewById(R.id.form_kerja);

        login_sebagai = getIntent().getStringExtra("login_sebagai");
        setTitle(login_sebagai.toUpperCase(Locale.ROOT));


        final RxPermissions rxPermissions = new RxPermissions(this);
        Disposable disposable = rxPermissions
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
//                        Toast.makeText(this, "Permission ok, terimakasih", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(this, "Aplikasi butuh izin kamera dan penyimpanan", Toast.LENGTH_SHORT).show();
                });
        disposables.add(disposable);

        kuliah_atau_kerja.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    form_kuliah.setVisibility(View.VISIBLE);
                    form_kerja.setVisibility(View.GONE);
                    return;
                }
                if (position == 2) {
                    form_kuliah.setVisibility(View.GONE);
                    form_kerja.setVisibility(View.VISIBLE);
                    return;
                }
                form_kuliah.setVisibility(View.GONE);
                form_kerja.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        id_alumni.setText(config_global.generate_id(this, "data_alumni"));
        mAPIService = data_alumni_apiutils.getAPIService();

        config_global.init_inputTypes();

        model = new ViewModelProvider(this).get(UploadFotoViewModel.class);

        model.getUploadState().observe(this, uploadState -> {
            if (uploadState == UploadFotoViewModel.UploadState.upload_ok) {
                Toast.makeText(data_alumni_tambah.this, "Berhasil Disimpan, Silahkan login", Toast.LENGTH_LONG).show();
                setResult(RESULT_OK);
                loading.hideDialog();
                finish();
                return;
            }
            if (uploadState == UploadFotoViewModel.UploadState.upload_error) {
                Toast.makeText(data_alumni_tambah.this, "Proses gagal.", Toast.LENGTH_LONG).show();
                loading.hideDialog();
                return;
            }

        });

        tombol_simpan.setOnClickListener(v -> {
            if (model.getUploadState().getValue() != UploadFotoViewModel.UploadState.foto_ok) {
                openCamera();
                return;
            }

            loading.showDialog(1, "Please Wait", "Proses Simpan Data..");
            id_alumni.setText(config_global.generate_id(data_alumni_tambah.this, "data_alumni"));
            validasi = "berhasil";
            validasiForm((ViewGroup) findViewById(R.id.group));
            if (validasi == "gagal") {
                loading.hideDialog();
                Toast.makeText(data_alumni_tambah.this, "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                        Toast.LENGTH_LONG).show();

            } else {

                model.uploadBukti(
                        RequestBody.create(MediaType.parse("multipart/form-data"), id_alumni.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), nama_depan.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), nama_belakang.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), alamat.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), email.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), no_telepon.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), nisn.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), id_sekolah.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), jurusan.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), tahun_masuk.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), tahun_keluar.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), jalur_penerimaan.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), jenjang.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), linkedin.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), instagram.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), facebook.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), tempat_kerja.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), jabatan_kerja.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), alamat_kerja.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), tahun_masuk_kerja.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), tahun_resign.getText().toString())
                        , filePart
                        , RequestBody.create(MediaType.parse("multipart/form-data"), username.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), password.getText().toString())
                        , RequestBody.create(MediaType.parse("multipart/form-data"), login_sebagai)
                );

//                    String token = "Bearer " + new config_global().ambil(data_alumni_tambah.this);
//                    mAPIService.proses_simpan_data_alumni(
//                            id_alumni.getText().toString()
//                            , nama_depan.getText().toString()
//                            , nama_belakang.getText().toString()
//                            , alamat.getText().toString()
//                            , email.getText().toString()
//                            , no_telepon.getText().toString()
//                            , nisn.getText().toString()
//                            , id_sekolah.getText().toString()
//                            , jurusan.getText().toString()
//                            , tahun_masuk.getText().toString()
//                            , tahun_keluar.getText().toString()
//                            , jalur_penerimaan.getText().toString()
//                            , jenjang.getText().toString()
//                            , linkedin.getText().toString()
//                            , instagram.getText().toString()
//                            , facebook.getText().toString()
//                            , tempat_kerja.getText().toString()
//                            , jabatan_kerja.getText().toString()
//                            , alamat_kerja.getText().toString()
//                            , tahun_masuk_kerja.getText().toString()
//                            , tahun_resign.getText().toString()
//                            , foto.getText().toString()
//                            , username.getText().toString()
//                            , password.getText().toString()
//
//                            , token
//
//                    ).enqueue(new Callback<Object>() {
//                        @Override
//                        public void onResponse(Call<Object> call, Response<Object> response) {
//                            Toast.makeText(data_alumni_tambah.this, "Berhasil Disimpan, Silahkan login", Toast.LENGTH_LONG).show();
//                            setResult(RESULT_OK);
////                            clearForm((ViewGroup) findViewById(R.id.group));
////                            id_alumni.requestFocus();
////                            loading.hideDialog();
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(Call<Object> call, Throwable t) {
//                            Toast.makeText(data_alumni_tambah.this, "Gagal Disimpan", Toast.LENGTH_LONG).show();
//                            loading.hideDialog();
//                        }
//                    });
            }
        });
        tampil_combobox_data_sekolah();
        show_dialog_login_sebagai();
    }

    public void show_dialog_login_sebagai() {

    }

    public void validasiForm(ViewGroup group) {
//        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
//            View view = group.getChildAt(i);
//            if (view instanceof EditText) {
//                if (!TextUtils.isEmpty(((EditText) view).getText().toString())) {
//                } else {
//                    validasi = "gagal";
//                    ((EditText) view).setError("Silahkan Input Terlebih Dahulu");
//                    ((EditText) view).requestFocus();
//                }
//            }
//            if (view instanceof ViewGroup && (((ViewGroup) view).getChildCount() > 0))
//                validasiForm((ViewGroup) view);
//        }
    }

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }
            if (view instanceof ViewGroup && (((ViewGroup) view).getChildCount() > 0))
                clearForm((ViewGroup) view);
        }
    }

    private Spinner combobox_data_sekolah_spinner;
    private com.project.aplikasi.namaaplikasi.combobox_data_sekolah.combobox_data_sekolah combobox_data_sekolah;
    private combobox_data_sekolah_apiservice combobox_data_sekolah_mAPIService;
    private List<combobox_data_sekolah_apidata> combobox_data_sekolah_data;

    public void tampil_combobox_data_sekolah() {
        id_sekolah.setVisibility(View.GONE);
        combobox_data_sekolah_spinner = (Spinner) findViewById(R.id.combo_data_sekolah);
        combobox_data_sekolah = new combobox_data_sekolah(combobox_data_sekolah_spinner, this);
        combobox_data_sekolah_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(detail_rencana_pemeliharaan_tambah.this, "Selected "+ combobox_data_sekolah_data.get(i).getNama() + " ", Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    id_sekolah.setText("");
                } else {
                    id_sekolah.setText(combobox_data_sekolah_data.get(i).getId());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        combobox_data_sekolah_mAPIService = combobox_data_sekolah_apiutils.getAPIService();
        combobox_data_sekolah_mAPIService.api().enqueue(new Callback<combobox_data_sekolah_api>() {
            @Override
            public void onResponse(Call<combobox_data_sekolah_api> call, Response<combobox_data_sekolah_api> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        combobox_data_sekolah.clearAll();
                        combobox_data_sekolah_data = response.body().getComboBoxApiData();
                        for (int i = 0; i < combobox_data_sekolah_data.size(); i++) {
                            combobox_data_sekolah.add(combobox_data_sekolah_data.get(i).getNama());
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<combobox_data_sekolah_api> call, Throwable t) {

            }
        });
    }


    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposables.clear();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            final Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
            File file = savebitmap(photo);
            if (file == null) {
                model.setUploadState(UploadFotoViewModel.UploadState.foto_error);
                return;
            }
            filePart = MultipartBody.Part.createFormData(
                    "foto", file.getName(),
                    RequestBody.create(MediaType.parse("image/*"), file)
            );
            model.setUploadState(UploadFotoViewModel.UploadState.foto_ok);
        }
    }

    private File savebitmap(Bitmap bmp) {
        String extStorageDirectory = getFilesDir().toString();
        OutputStream outStream = null;
        // String temp = null;
        File file = new File(extStorageDirectory + File.separator + "temp.png");
        if (file.exists()) {
            file.delete();
            file = new File(extStorageDirectory + File.separator + "temp.png");
        }

        try {
            outStream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        foto.setText("tmp.png");
        return file;
    }

}
