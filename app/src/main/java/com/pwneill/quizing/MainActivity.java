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
import com.pwneill.quizing.model.QuizManager;
import com.pwneill.quizing.model.QuizQuestion;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url;
    private CardStackView mCardStackView;
    private QuizManager mQuizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizManager = new QuizManager(this);
        mQuizManager.getQuizQuestions(this);
    }
}