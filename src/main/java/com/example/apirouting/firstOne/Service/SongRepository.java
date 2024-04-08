package com.example.apirouting.firstOne.Service;

import com.example.apirouting.firstOne.entity.Song;

import java.util.List;

public interface SongRepository {
    public List<Song> getAllSongs();
    public Song getSongById(int songId);
    public void addSong(Song song);
    public void updateSong(int SongId , Song song);
    public void deleteSong(int SongId);

}
