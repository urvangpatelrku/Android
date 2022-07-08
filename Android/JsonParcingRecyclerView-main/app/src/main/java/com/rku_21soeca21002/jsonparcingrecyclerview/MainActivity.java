package com.rku_21soeca21002.jsonparcingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Formula> formulas;
    FormulaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
//        formulas = getData();
        formulas = getAssetJSONData();
        adapter = new FormulaAdapter(formulas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

    }

    private ArrayList<Formula> getAssetJSONData() {
        ArrayList<Formula> formulas = new ArrayList<Formula>();
        String data = "";
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            data = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        if (!data.equals("")) {
            JSONObject object = null;
            try {
                object = new JSONObject(data);
                JSONArray array = object.getJSONArray("formulas");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject tempObj = array.getJSONObject(i);
                    String name = tempObj.getString("formula");
                    String url = tempObj.getString("url");
                    formulas.add(new Formula(name, url));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return formulas;
    }

    private ArrayList<Formula> getData() {
        ArrayList<Formula> formulas = new ArrayList<Formula>();
        formulas.add(new Formula("Name", "url"));
        formulas.add(new Formula("Name", "url"));
        formulas.add(new Formula("Name", "url"));
        formulas.add(new Formula("Name", "url"));
        formulas.add(new Formula("Name", "url"));
        formulas.add(new Formula("Name", "url"));
        return formulas;
    }
}