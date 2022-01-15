package jinu.nulld.flow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class List_StringPlayer {
    public static List<Player> string_to_player(List<String> list) {
        List<Player> playerList = new ArrayList<>();
        for (String string : list) {
            if (Bukkit.getPlayer(string) != null) playerList.add(Bukkit.getPlayer(string));
            else Bukkit.getLogger().log(Level.WARNING, "Player \""+string+"\" does not exist.");
        }
        return playerList;
    }

    public static List<String> player_to_string(List<Player> playerList) {
        List<String> list = new ArrayList<>();
        for (Player player : playerList) {
            if (player != null) list.add(player.getName());
            else {
                Bukkit.getLogger().log(Level.WARNING, "List contains null. Returned new ArrayList.");
                list = new ArrayList<>();
                break;
            }
        }
        return list;
    }

}
