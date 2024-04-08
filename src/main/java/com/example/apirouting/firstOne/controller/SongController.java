package com.example.apirouting.firstOne.controller;

import com.example.apirouting.firstOne.Service.SongRepository;
import com.example.apirouting.firstOne.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    @Autowired private SongRepository abc;
    @GetMapping("/songs")
    public List<Song> getAllSongs(){
        return abc.getAllSongs();
    }
    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable int songId){
        return abc.getSongById(songId);
    }
    @PostMapping("/songs")
    public void addSong(@RequestBody Song song){
        abc.addSong(song);
    }
    @PutMapping("/songs/{songId}")
    public void updateSong(@PathVariable int songId,@RequestBody Song song){
        abc.updateSong(songId, song);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable int songId){
        abc.deleteSong(songId);
    }

}
