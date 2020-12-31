package com.pwneill.quizing.view;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pwneill.quizing.R;

import org.w3c.dom.Text;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private TextView txtMusicQuestion;
    private ImageButton imgBtnTrue;
    private ImageButton imgBtnFalse;

    public MusicViewHolder(@NonNull View itemView) {

        super(itemView);

        txtMusicQuestion = itemView.findViewById(R.id.music_question_text);
        imgBtnTrue = itemView.findViewById(R.id.true_btn);
        imgBtnFalse = itemView.findViewById(R.id.false_btn);

    }

    public TextView getTxtMusicQuestion() {
        return txtMusicQuestion;
    }


    public ImageButton getImgBtnTrue() {
        return imgBtnTrue;
    }


    public ImageButton getImgBtnFalse() {
        return imgBtnFalse;
    }

}