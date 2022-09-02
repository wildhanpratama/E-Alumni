package com.project.aplikasi.namaaplikasi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.project.aplikasi.namaaplikasi.R;

import org.json.JSONException;
import org.json.JSONObject;

public class qrcode_activity extends AppCompatActivity implements View.OnClickListener {
        // View Object
        private Button buttonScan;
        private TextView textViewNama, textViewTinggi;

        //qr code scanner object
        private IntentIntegrator intentIntegrator;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.qrcode_activity);

            // initialize object
            buttonScan = (Button) findViewById(R.id.buttonScan);
            textViewNama = (TextView) findViewById(R.id.textViewNama);
            textViewTinggi = (TextView) findViewById(R.id.textViewTinggi);

            // attaching onclickListener
            buttonScan.setOnClickListener(this);
        }


    public void onClick(View v) {
        // inisialisasi IntentIntegrator(scanQR)
        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
            }else{
                // jika qrcode berisi data
                try{
                    // converting the data json
                    JSONObject object = new JSONObject(result.getContents());
                    // atur nilai ke textviews
                    textViewNama.setText(object.getString("nama"));
                    textViewTinggi.setText(object.getString("tinggi"));
                }catch (JSONException e){
                    e.printStackTrace();
                    // jika format encoded tidak sesuai maka hasil
                    // ditampilkan ke toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
