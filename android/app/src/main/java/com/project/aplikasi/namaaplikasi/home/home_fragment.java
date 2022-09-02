package com.project.aplikasi.namaaplikasi.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.project.aplikasi.namaaplikasi.config.config_global;
import com.project.aplikasi.namaaplikasi.config.config_sessionmanager;

import com.project.aplikasi.namaaplikasi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class home_fragment extends Fragment {
    config_sessionmanager config_sessionmanager;
    TextView judul_a,judul_b;

    public home_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_fragment, container, false);
        config_sessionmanager = new config_sessionmanager(getActivity());
//        judul_a = (TextView) v.findViewById(R.id.a) ;
//        judul_b = (TextView) v.findViewById(R.id.b) ;
//		judul_a.setText("Assalamu'alaikum");
//        judul_b.setText(new config_global().capitalize(config_sessionmanager.getSPNama()));
        return v;
    }



}
