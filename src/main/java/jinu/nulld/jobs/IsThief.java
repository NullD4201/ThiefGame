package jinu.nulld.jobs;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsThief {
    public static Map<Player, Boolean> findThief = new HashMap<>();

    public static boolean booleanThief(Player player) {
        if (findThief.get(player) != null) return findThief.get(player);
        else return false;
    }

    public static List<Player> getThieves(){
        List<Player> players = new ArrayList<>();
        for(Player ap : findThief.keySet()){
            if(findThief.containsKey(ap) && findThief.get(ap)) players.add(ap);
        }
        return players;
    }

    public static void setThief(Player player) {
        findThief.put(player, true);
    }

    public static void setNone(Player player) {
        findThief.put(player, false);
    }
}
