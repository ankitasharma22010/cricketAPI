package com.example.apirouting.firstOne.Service;

import com.example.apirouting.firstOne.entity.Player;

import java.util.List;

public interface PlayerRepository {
    public List<Player> getPlayers();
    public Player getPlayerById(int playerId);
    public void addPlayer(Player player);
    public void updatePlayer(int playerId , Player player );
    public void deletePlayer(int playerId);
}
