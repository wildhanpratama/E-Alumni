package com.project.aplikasi.namaaplikasi.combobox_data_alumni;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class combobox_data_alumni {
    private Spinner spinner;
    private Activity activity;
    private List<String> comboItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    public combobox_data_alumni(Spinner spinner, Activity activity) {
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
   /* private Spinner combobox_data_alumni_spinner;
    private combobox_data_alumni combobox_data_alumni;
    private combobox_data_alumni_apiservice combobox_data_alumni_mAPIService;
    private List<combobox_data_alumni_apidata> combobox_data_alumni_data;
    public void tampil_combobox_data_alumni()
    {
        data_alumni.setVisibility(View.GONE);
        combobox_data_alumni_spinner = (Spinner) findViewById(R.id.combo_data_alumni);
        combobox_data_alumni = new combobox_data_alumni(combobox_data_alumni_spinner, this);
        combobox_data_alumni_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(detail_rencana_pemeliharaan_tambah.this, "Selected "+ combobox_data_alumni_data.get(i).getNama() + " ", Toast.LENGTH_SHORT).show();
                if (i == 0)
                {
                    data_alumni.setText("");
                }
                else {
                    data_alumni.setText(combobox_data_alumni_data.get(i).getId());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        combobox_data_alumni_mAPIService = combobox_data_alumni_apiutils.getAPIService();
        combobox_data_alumni_mAPIService.api().enqueue(new Callback<combobox_data_alumni_api>() {
            @Override
            public void onResponse(Call<combobox_data_alumni_api> call, Response<combobox_data_alumni_api> response) {
                if (response.code() == 200){
                    if (response.body() != null) {
                        combobox_data_alumni.clearAll();
                        combobox_data_alumni_data = response.body().getComboBoxApiData();
                        for (int i=0; i < combobox_data_alumni_data.size(); i++){
                            combobox_data_alumni.add(combobox_data_alumni_data.get(i).getNama());
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<combobox_data_alumni_api> call, Throwable t) {

            }
        });
    }

*/
