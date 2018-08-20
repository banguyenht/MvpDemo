package com.example.ba.mvpstart.data.data.home;

import com.example.ba.mvpstart.data.data.data.entity.Song;

import java.util.List;

public interface HomeContract {
    interface View {
        void onUpdateUi(List<Song> songList);
    }

    interface Present {
        void loadDataSongs();

        int countSongs();

        Song getItemSong(int positon);
    }
}
