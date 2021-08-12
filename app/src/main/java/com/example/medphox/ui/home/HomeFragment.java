package com.example.medphox.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medphox.R;
import com.example.medphox.adapter.RecyclerHomeAdapter;
import com.example.medphox.model.ItemModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ItemModel> list;
    private String url = "https://dipantan.me/api.php";
    private RecyclerHomeAdapter adapter;
    private RequestQueue queue;
    private LinearLayoutManager layoutManager;
    private ShimmerFrameLayout mFrameLayout;
    private int MY_SOCKET_TIMEOUT_MS = 5000;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFrameLayout = view.findViewById(R.id.shimmerLayout);
        recyclerView = view.findViewById(R.id.rechome);
        queue = Volley.newRequestQueue(view.getContext());
        list = new ArrayList<>();
        adapter = new RecyclerHomeAdapter(list, view.getContext());
        layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        mFrameLayout.startShimmer();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, response -> {
            try {
                for (int i = 0; i < response.length(); i++) {
                    ItemModel model = new ItemModel();
                    JSONObject jsonObject = response.getJSONObject(i);
                    model.setName(jsonObject.getString("name"));
                    model.setPrice(jsonObject.getString("price"));
                    model.setDescription(jsonObject.getString("description"));
                    list.add(model);
                    mFrameLayout.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();

                }
            } catch (Exception e) {
                AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(e.getMessage());
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();
            }
        }, error -> {
            AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage(error.getMessage());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        queue.add(jsonArrayRequest);
    }
}