package com.example.apirouting.firstOne.Service;

import com.example.apirouting.firstOne.entity.Song;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int autoKey;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
        autoKey = 6;
    }

    @Override
    public List<Song> getAllSongs() {
        Collection<Song> values = playlist.values();
        return new ArrayList<>(values);
    }

    @Override
    public Song getSongById(int songId) {
        return playlist.get(songId);
    }

    @Override
    public void addSong(Song song) {
        song.setSongId(autoKey);
        playlist.put(autoKey, song);
        autoKey += 1;
    }

    @Override
    public void updateSong(int songId, Song song) {
        if(playlist.containsKey(songId)){
            song.setSongId(songId);
            playlist.put(songId,song);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteSong(int songId) {
        playlist.remove(songId);
    }
}
