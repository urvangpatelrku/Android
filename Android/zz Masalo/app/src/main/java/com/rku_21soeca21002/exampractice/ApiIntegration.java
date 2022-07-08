package com.rku_21soeca21002.exampractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiIntegration extends AppCompatActivity {

    RecyclerView recyclerView;
    VolleyAdapter adapter;
    ArrayList<VolleyPOJO> pojo;
    RequestQueue queue;
    JsonArrayRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_integration);
        setTitle("Volley");
        recyclerView = findViewById(R.id.recyclerViewVolley);
        queue = Volley.newRequestQueue(this);
        pojo = new ArrayList<VolleyPOJO>();
        fetchOnlineData();
        adapter = new VolleyAdapter(pojo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void fetchOnlineData() {
        request = new JsonArrayRequest(
                Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        generateData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ApiIntegration.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(request);
    }

    private void generateData(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject object = response.getJSONObject(i);
                String username = object.getString("username");
                String phone = object.getString("phone");
                pojo.add(new VolleyPOJO(username,phone));
            }
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Catch", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

}