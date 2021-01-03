package com.pwneill.quizing.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pwneill.quizing.R;
import com.pwneill.quizing.model.QuizQuestion;
import com.pwneill.quizing.view.MusicViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    private Context mContext;
    private List<QuizQuestion> mMusicQuestions;
    private LayoutInflater mLayoutInflator;

    public CardStackAdapter(Context context, List<QuizQuestion> musicQuestions) {

        mContext = context;
        mMusicQuestions = musicQuestions;
        mLayoutInflator = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.music_view, parent,false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {

        holder.getTxtMusicQuestion().setText(mMusicQuestions.get(position).getQuestionText());

        holder.getImgBtnTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mMusicQuestions.get(position).isTrueFalse()) {

                    Toast.makeText(mContext, "Correct!", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(mContext, "Wrong!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        holder.getImgBtnFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mMusicQuestions.get(position).isTrueFalse()) {

                    Toast.makeText(mContext, "Correct!", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(mContext, "Wrong!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMusicQuestions.size();
    }
}
