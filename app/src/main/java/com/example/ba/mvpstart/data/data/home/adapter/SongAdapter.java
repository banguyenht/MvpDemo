package com.example.ba.mvpstart.data.data.home.adapter;



import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.ba.mvpstart.R;
import com.example.ba.mvpstart.data.data.data.entity.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ISongAdapter mInter;
    private List<Song> mListSong;
    public SongAdapter(ISongAdapter inter) {
        this.mInter = inter;
    }

    public void setListSong(List<Song> listSong) {
        this.mListSong = listSong;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new SongViewHolder(inflater.inflate(R.layout.item_song, viewGroup,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolder, final int i) {
        Song song=mInter.getItem(i);
        songViewHolder.mTextviewSong.setText(song.getName());
    }

    @Override
    public int getItemCount() {
        return mInter.getCount();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextviewSong;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextviewSong = itemView.findViewById(R.id.textview_songname);
        }
    }
    public interface ISongAdapter{
        int getCount();
        Song getItem(int positon);
    }
}

