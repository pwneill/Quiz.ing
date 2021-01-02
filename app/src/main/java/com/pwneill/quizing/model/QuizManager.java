package com.pwneill.quizing.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.pwneill.quizing.R;
import com.pwneill.quizing.VolleySingleton;
import com.pwneill.quizing.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    Context mContext;
    private RequestQueue mRequestQueue;
    private String url;

    public QuizManager(Context context) {

        mContext = context;
        url = "https://opentdb.com/api.php?amount=10&category=12&difficulty=medium&type=boolean";
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();

    }

    public void getQuizQuestions(Activity activity) {


        List<QuizQuestion> quizQuestions = new ArrayList<>();

        JsonObjectRequest musicJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("MUSIC", response + "" );

                try {
                    JSONArray results = response.getJSONArray("results");

                    for (int i = 0; i < results.length(); i++) {

                        String questionString = results.getJSONObject(i).getString("question");
                        Boolean questionAnswer = results.getJSONObject(i).getBoolean("correct_answer");

                        QuizQuestion newQuestion = new QuizQuestion(questionString, questionAnswer);

                        quizQuestions.add(newQuestion);
                    };

                    CardStackView mCardStackView = activity.findViewById(R.id.mycardstackview);
                    mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    mCardStackView.setAdapter(new CardStackAdapter(mContext, quizQuestions));


                } catch (JSONException e) {

                    e.printStackTrace();
                }

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
