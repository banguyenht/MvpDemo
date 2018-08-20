package com.example.ba.mvpstart.data.data.data.internal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.ba.mvpstart.data.data.data.entity.Song;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;

public class DataManager {
    private static final String COLUMN_SONG_NAME = "title";
    private static final String COLUMN_SONG_ARTIST = "artist";
    private static final String COLUMN_SONG_PATH = "_data";
    private Context mContext;
    private List<Song> mListSong;

    public DataManager() {
        mListSong = new ArrayList<>();
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public List<Song> getListSong() {
        return mListSong;
    }

    public void loadData() {
        Cursor cursor = mContext.getContentResolver().query(MediaStore
                        .Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);
        if (cursor == null) {
            return;
        } else {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int indexDisplayName = cursor.getColumnIndex(COLUMN_SONG_NAME);
                String displayName = cursor.getString(indexDisplayName);
                int indexArtist = cursor.getColumnIndex(COLUMN_SONG_ARTIST);
                String artist = cursor.getString(indexArtist);
                int indexPath = cursor.getColumnIndex(COLUMN_SONG_PATH);
                String path = cursor.getString(indexPath);
                Song song = new Song();
                song.setName(displayName);
                song.setArtist(artist);
                song.setPath(path);
                mListSong.add(song);
                cursor.moveToNext();
            }
            cursor.close();
        }
    }


}
