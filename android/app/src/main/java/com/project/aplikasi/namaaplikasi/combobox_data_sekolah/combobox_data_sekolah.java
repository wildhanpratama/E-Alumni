package com.project.aplikasi.namaaplikasi.combobox_data_sekolah;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class combobox_data_sekolah {
    private Spinner spinner;
    private Activity activity;
    private List<String> comboItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    public combobox_data_sekolah(Spinner spinner, Activity activity) {
        this.spinner = spinner;
        this.activity = activity;

        adapter = new ArrayAdapter<>(activity,
                android.R.layout.simple_dropdown_item_1line, comboItems);
        spinner.setAdapter(adapter);
    }

    public List<String> getComboItems() {
        return comboItems;
    }

    public void setComboItems(List<String> comboItems) {
        this.comboItems = comboItems;
        this.adapter.notifyDataSetChanged();
    }

    public void add(String item){
        comboItems.add(item);
        adapter.notifyDataSetChanged();
    }

    public void clearAll(){
        comboItems.clear();
        adapter.notifyDataSetChanged();
    }
}


//Combobox
   /*
   private Spinner combobox_data_sekolah_spinner;
    private combobox_data_sekolah combobox_data_sekolah;
    private combobox_data_sekolah_apiservice combobox_data_sekolah_mAPIService;
    private List<combobox_data_sekolah_apidata> combobox_data_sekolah_data;
    public void tampil_combobox_data_sekolah()
    {
        data_sekolah.setVisibility(View.GONE);
        combobox_data_sekolah_spinner = (Spinner) findViewById(R.id.combo_data_sekolah);
        combobox_data_sekolah = new combobox_data_sekolah(combobox_data_sekolah_spinner, this);
        combobox_data_sekolah_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(detail_rencana_pemeliharaan_tambah.this, "Selected "+ combobox_data_sekolah_data.get(i).getNama() + " ", Toast.LENGTH_SHORT).show();
                if (i == 0)
                {
                    data_sekolah.setText("");
                }
                else {
                    data_sekolah.setText(combobox_data_sekolah_data.get(i).getId());
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
                if (response.code() == 200){
                    if (response.body() != null) {
                        combobox_data_sekolah.clearAll();
                        combobox_data_sekolah_data = response.body().getComboBoxApiData();
                        for (int i=0; i < combobox_data_sekolah_data.size(); i++){
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

*/
