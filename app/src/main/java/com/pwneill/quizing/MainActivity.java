package com.pwneill.quizing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.pwneill.quizing.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String url;
    private RequestQueue mRequestQueue;
    private CardStackView mCardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "https://opentdb.com/api.php?amount=10&category=12&difficulty=medium&type=boolean";

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();

        mCardStackView = findViewById(R.id.mycardstackview);
        mCardStackView.setLayoutManager(new CardStackLayoutManager(this));

        ArrayList<String> testMusic = new ArrayList<>();

        testMusic.add("Soul Asylum");
        testMusic.add("Husker Du");
        testMusic.add("Replacements");
        testMusic.add("Hold Steady");
        testMusic.add("Lifter Puller");

        mCardStackView.setAdapter(new CardStackAdapter(this,testMusic ));

        JsonObjectRequest musicJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("Music", response + "");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(musicJsonObjectRequest);
    }
}