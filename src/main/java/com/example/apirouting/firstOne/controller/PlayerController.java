package com.example.apirouting.firstOne.controller;

import com.example.apirouting.firstOne.Service.PlayerRepository;
import com.example.apirouting.firstOne.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository repo;

    @GetMapping("/getAll")
    public List<Player> getPlayers() {
        return repo.getPlayers();
    }

    @GetMapping("/getById/{playerId}")
    public Player getPlayerById(@PathVariable int playerId) {
        return repo.getPlayerById(playerId);
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody Player player) {
        repo.addPlayer(player);
    }

    @PutMapping("/update/{playerId}")
    public void updatePlayer(@PathVariable int playerId, @RequestBody Player player){
        repo.updatePlayer(playerId , player);
    }
    @DeleteMapping("/delete/{playerId}")
    public void deletePlayer(@PathVariable int playerId){
        repo.deletePlayer(playerId);
    }


}
