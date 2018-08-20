package com.example.ba.mvpstart.data.data.data.entity;

public class Song {
    private String mName;
    private String mArtist;
    private String mPath;

    public Song() {
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mame) {
        this.mName = mame;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

}
