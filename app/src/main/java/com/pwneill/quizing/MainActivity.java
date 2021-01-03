package com.pwneill.quizing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.pwneill.quizing.model.QuizManager;
import com.yuyakaido.android.cardstackview.CardStackView;

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