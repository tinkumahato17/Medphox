package com.example.medphox.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medphox.R;
import com.example.medphox.adapter.RecyclerHomeAdapter;
import com.example.medphox.model.ItemModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ItemModel> list;
    String url = "https://dipantan.me/api.php";
    RecyclerHomeAdapter adapter;
    RequestQueue queue;
    LinearLayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rechome);
        queue = Volley.newRequestQueue(view.getContext());
        list = new ArrayList<>();
        adapter = new RecyclerHomeAdapter(list);
        layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @lombok.SneakyThrows
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    ItemModel model = new ItemModel();
                    JSONObject jsonObject = response.getJSONObject(i);
                    model.setName(jsonObject.getString("name"));
                    model.setPrice(jsonObject.getString("price"));
                    model.setDescription(jsonObject.getString("description"));
                    list.add(model);
                    adapter.notifyDataSetChanged();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }
}