package com.project.aplikasi.namaaplikasi.data_berita;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.activity.loading;

import com.project.aplikasi.namaaplikasi.config.config_sessionmanager;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class data_berita_tambah extends AppCompatActivity {

    String validasi;
    Button tombol_simpan;
    data_berita_apiservice mAPIService;
    EditText id_berita, caption, tanggal, foto, id_alumni, jumlah_like, jumlah_komen;
    loading loading;
    Spinner kategori;
    com.project.aplikasi.namaaplikasi.config.config_sessionmanager config_sessionmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_berita_tambah);
        tombol_simpan = (Button) findViewById(R.id.tombol_simpan);
        loading = new loading(this);
        id_berita = (EditText) findViewById(R.id.id_berita);
        caption = (EditText) findViewById(R.id.caption);
        tanggal = (EditText) findViewById(R.id.tanggal);
        foto = (EditText) findViewById(R.id.foto);
        id_alumni = (EditText) findViewById(R.id.id_alumni);
        jumlah_like = (EditText) findViewById(R.id.jumlah_like);
        jumlah_komen = (EditText) findViewById(R.id.jumlah_komen);

        id_berita.setText(config_global.generate_id(this, "data_berita"));
        mAPIService = data_berita_apiutils.getAPIService();
        persiapan_upload();
        config_global.init_inputTypes();
        tanggal.setVisibility(View.GONE);
        foto.setVisibility(View.GONE);
        id_alumni.setVisibility(View.GONE);
        jumlah_like.setVisibility(View.GONE);
        jumlah_komen.setVisibility(View.GONE);

        config_sessionmanager = new config_sessionmanager(data_berita_tambah.this);
        String token = config_sessionmanager.getSPToken();
        id_alumni.setText(token);


        kategori = (Spinner) findViewById(R.id.kategori);


        tombol_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loading.showDialog(1, "Please Wait", "Proses Simpan Data..");
                id_berita.setText(config_global.generate_id(data_berita_tambah.this, "data_berita"));
                validasi = "berhasil";
                //validasiForm((ViewGroup) findViewById(R.id.group));
                upload(id_berita.getText().toString(), gambarnya);
                if (validasi == "gagal") {
                    loading.hideDialog();
                    Toast.makeText(data_berita_tambah.this, "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG).show();

                } else {

                    String token = "Bearer " + new config_global().ambil(data_berita_tambah.this);
                    mAPIService.proses_simpan_data_berita(id_berita.getText().toString()
                            , caption.getText().toString()
                            , (String) kategori.getSelectedItem()
                            , foto.getText().toString()
                            , id_alumni.getText().toString()
                            , jumlah_like.getText().toString()
                            , jumlah_komen.getText().toString()

                            , token

                    ).enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                            Toast.makeText(data_berita_tambah.this, "Berhasil Disimpan", Toast.LENGTH_LONG).show();
                            setResult(RESULT_OK);
                            clearForm((ViewGroup) findViewById(R.id.group));
                            id_berita.requestFocus();
                            loading.hideDialog();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                            Toast.makeText(data_berita_tambah.this, "Gagal Disimpan", Toast.LENGTH_LONG).show();
                            loading.hideDialog();
                        }
                    });
                }
            }
        });
    }

    public void validasiForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                if (!TextUtils.isEmpty(((EditText) view).getText().toString())) {
                } else {
                    validasi = "gagal";
                    ((EditText) view).setError("Silahkan Input Terlebih Dahulu");
                    ((EditText) view).requestFocus();
                }
            }
            if (view instanceof ViewGroup && (((ViewGroup) view).getChildCount() > 0))
                validasiForm((ViewGroup) view);
        }
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

    //UPLOADER
    private ImageView imageView;
    Bitmap gambarnya;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private static final int MY_EXTERNAL_STORAGE_REQUEST_CODE = 101;

    public void pilih(View view) {
        pilih_jenis_upload(data_berita_tambah.this);
    }

    public void persiapan_upload() {
        imageView = (ImageView) findViewById(R.id.my_avatar);
        perizinan_upload();
    }

    public void perizinan_upload() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        MY_CAMERA_REQUEST_CODE);
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_EXTERNAL_STORAGE_REQUEST_CODE);
            }
        }
    }

    public void pilih_jenis_upload(Context context) {
        final CharSequence[] options = {"Buka Kamera", "Pilih Dari Galeri", "Batal"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Buka Kamera")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Pilih Dari Galeri")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);

                } else if (options[item].equals("Batal")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        gambarnya = selectedImage;
                        imageView.setImageBitmap(selectedImage);
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                gambarnya = BitmapFactory.decodeFile(picturePath);

                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
    }

    public File kompres_webp(Bitmap bitmap) {
        String namafile = id_berita.getText().toString() + "_image.webp";
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                , namafile);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 100, bos);
        byte[] bitmapdata = bos.toByteArray();

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void upload(String id, Bitmap gambarbitmap) {
        HashMap<String, RequestBody> map = new HashMap<>();
        File file = kompres_webp(gambarbitmap);
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        foto.setText(file.getName());
        MultipartBody.Part body = MultipartBody.Part.createFormData("foto", file.getName(),
                reqFile);
        Call<ResponseBody> call = mAPIService.uploadImage(body, map,
                "Bearer " + new config_global().ambil(this));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //BERHASIL
                Toast.makeText(data_berita_tambah.this, "Berhasil Diupload", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
//UPLOADER ============


}
