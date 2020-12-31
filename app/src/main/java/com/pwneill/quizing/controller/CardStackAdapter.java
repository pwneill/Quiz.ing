package com.pwneill.quizing.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pwneill.quizing.R;
import com.pwneill.quizing.view.MusicViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    private Context mContext;
    private List<String> mMusicNames;
    private LayoutInflater mLayoutInflator;

    public CardStackAdapter(Context context, List<String> musicNames) {

        mContext = context;
        mMusicNames = musicNames;
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

        holder.getTxtMusicQuestion().setText(mMusicNames.get(position));

        holder.getImgBtnTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "True is tapped", Toast.LENGTH_SHORT).show();

            }
        });

        holder.getImgBtnFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "False is tapped", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mMusicNames.size();
    }
}
