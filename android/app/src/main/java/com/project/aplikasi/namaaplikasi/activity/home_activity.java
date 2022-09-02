package com.project.aplikasi.namaaplikasi.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.aplikasi.namaaplikasi.R;
import com.project.aplikasi.namaaplikasi.config.GetFileInfo;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.config.config_sessionmanager;
import com.project.aplikasi.namaaplikasi.data_alumni.data_alumni_activity_v2;
import com.project.aplikasi.namaaplikasi.data_berita.data_berita_tambah;

import im.delight.android.webview.AdvancedWebView;

import java.util.concurrent.ExecutionException;

public class home_activity extends Activity implements AdvancedWebView.Listener {

    private static final String TAG = "Main";

    //    private SwipeRefreshLayout refreshLayout;
    private AdvancedWebView mWebView;
    String judul;
    String deskripsi, sebagai;

    com.project.aplikasi.namaaplikasi.config.config_sessionmanager config_sessionmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_activity);

        config_sessionmanager = new config_sessionmanager(home_activity.this);
        String token = config_sessionmanager.getSPToken();
        sebagai = config_sessionmanager.getSPJabatan();

        String url = config_global.BASE_URL + "frame/app/page/index.php";
        judul = "test";
        deskripsi = "";


//        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);

        mWebView = (AdvancedWebView) findViewById(R.id.webview2);
        mWebView.loadUrl("about:blank");
        mWebView.setListener(this, this);
        mWebView.setMixedContentAllowed(false);
        mWebView.requestFocus();
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);


        webview2(config_global.BASE_URL + "frame/app/page/index.php?id=" + token + "&sebagai=" + sebagai);

        //Swipe Refresh
//        refreshLayout.setColorSchemeResources(android.R.color.holo_green_dark, android.R.color.holo_blue_dark, android.R.color.holo_orange_dark, android.R.color.holo_red_dark);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                mWebView.reload();
//
//            }
//        });
//        refreshLayout.setRefreshing(true);


        setupBottomNavigation(url, token);
    }


    private void setupBottomNavigation(final String url, final String token) {


        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bawah_1:
                        webview2(url + "?id=" + token + "&page=berita" + "&sebagai=" + sebagai);

                        return true;
                    case R.id.bawah_2:
                        webview2(url + "?id=" + token + "&page=kenangan" + "&sebagai=" + sebagai);
                        return true;
                    case R.id.bawah_3:
                        Intent intent = new Intent(home_activity.this, data_berita_tambah.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    case R.id.bawah_4:
                        webview2(url + "?id=" + token + "&page=profil" + "&sebagai=" + sebagai);
                        return true;

                    case R.id.bawah_5:
//                        webview2(url + "?id=" + token + "&page=akreditasi");
                        Intent intents = new Intent(home_activity.this, data_alumni_activity_v2.class);
                        intents.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intents);
                        return true;
                }
                return false;
            }
        });
    }


    private void webview2(String url) {
        Log.d(TAG, "webview2: url " + url);

        if (adaInternet()) {
            mWebView.setVisibility(View.VISIBLE);
            mWebView.loadUrl(url);
        } else {
            mWebView.setVisibility(View.GONE);
            pesan_error_koneksi();
        }

        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mWebView.loadUrl("about:blank");
                Toast.makeText(home_activity.this, "Koneksi Internet Lambat, Silahkan Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();

                mWebView.setVisibility(View.VISIBLE);
//                refreshLayout.setRefreshing(false);

                finish();
            }
        });

    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
//        if (!mWebView.onBackPressed()) { return; }

        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            finish();
        }
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
    }

    @Override
    public void onPageFinished(String url) {

        if (url.contains("&close=")) {
            //close
            Uri uri = Uri.parse(url);
            finish();
        } else if (url.contains("&logout=")) {
            //close
            Intent intent = new Intent(home_activity.this, login_activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (url.contains("&toast=")) {
            //Toast
            Uri uri = Uri.parse(url);
            String action = uri.getQueryParameter("toast");
            Toast.makeText(home_activity.this, action, Toast.LENGTH_SHORT).show();

        } else if (url.contains("&activity=")) {
            //Home
//            SessionManager.menuju_home = true;
//            Intent intent = new Intent(getApplicationContext(), home_activity.class);
//
//            Uri uri=Uri.parse(url);
//            String action = uri.getQueryParameter("action");
//            if (action.equals("close")) {
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            }
//            startActivity(intent);

        } else if (url.contains("&link=")) {
            //Link Eksternal
            Uri uri = Uri.parse(url);
            String link = uri.getQueryParameter("link");
            Uri uri2 = Uri.parse(link);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri2);
            startActivity(intent);
        } else if (url.contains("&app=")) {
            //Buka Aplikasi
            Uri uri = Uri.parse(url);
            String app = uri.getQueryParameter("app");

            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(app);
            if (launchIntent != null) {
                startActivity(launchIntent);
            }

        } else if (url.contains("&tel=")) {
            //Buka Aplikasi
            Uri uri = Uri.parse(url);
            String tel = uri.getQueryParameter("tel");


            String nomor = tel;
            Intent panggil = new Intent(Intent.ACTION_DIAL);
            panggil.setData(Uri.fromParts("tel", nomor, null));
            startActivity(panggil);

        } else if (url.contains("&wa=")) {
            //Buka Aplikasi
            Uri uri = Uri.parse(url);
            String wa = uri.getQueryParameter("wa");

            String link = "https://api.whatsapp.com/send?phone=" + wa;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(link));
            startActivity(i);

        } else if (url.contains("&share=")) {
            //Buka Aplikasi
            Uri uri = Uri.parse(url);
            String share = uri.getQueryParameter("share");


            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                shareIntent.putExtra(Intent.EXTRA_TEXT, share);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (url.contains("&newtab=")) {
            //Buka Aplikasi
            Uri uri = Uri.parse(url);
            String newtab = uri.getQueryParameter("newtab");
            String judule = uri.getQueryParameter("judul");
            String deskripsie = uri.getQueryParameter("deskripsi");


            Intent intent = new Intent(home_activity.this, home_activity.class);
            intent.putExtra("url", newtab);
            intent.putExtra("judul", judule);
            intent.putExtra("deskripsi", deskripsie);
            startActivity(intent);

        } else {

        }

        mWebView.setVisibility(View.VISIBLE);
//        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
        if (!hasPermissionToDownload(home_activity.this)) return;

        String filename = null;
        try {
            filename = new GetFileInfo().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (filename == null) {
            String fileExtenstion = MimeTypeMap.getFileExtensionFromUrl(url);
            filename = URLUtil.guessFileName(url, null, fileExtenstion);
        }


        if (AdvancedWebView.handleDownload(home_activity.this, url, filename)) {
            Toast.makeText(home_activity.this, "Download Diproses", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(home_activity.this, "Download Gagal", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onExternalPageRequest(String url) {
    }


    private static boolean hasPermissionToDownload(final Activity context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED)
            return true;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Untuk mengunduh file, Anda perlu memberi kami izin untuk penyimpanan Anda. Setelah memberi kami akses, Anda dapat melanjutkan dan mengunduh file.");
        builder.setPositiveButton("Memberikan ijin", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    context.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        return false;
    }


    public void pesan_error_koneksi() {
        AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(home_activity.this);
        BackAlertDialog.setTitle("Cek Koneksi..!!");
        BackAlertDialog.setMessage("Koneksi Internet Lambat, Silahkan Cek Koneksi Internet Anda");
        BackAlertDialog.setPositiveButton("Oke",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        BackAlertDialog.show();
    }


    private boolean adaInternet() {
        ConnectivityManager koneksi = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() != null;
    }
}
