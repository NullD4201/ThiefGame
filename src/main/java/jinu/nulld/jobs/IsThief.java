package jinu.nulld.jobs;

import org.bukkit.entity.Player;

import java.util.*;

public class IsThief {
    public static Map<UUID, Boolean> findThief = new HashMap<>();

    public static List<String> REVEALED_THIEF = new ArrayList<>();

    public static boolean booleanThief(Player player) {
        if (findThief.get(player.getUniqueId()) != null) return findThief.get(player.getUniqueId());
        else return false;
    }

    public static List<UUID> getThieves(){
        List<UUID> players = new ArrayList<>();
        for(UUID ap : findThief.keySet()){
            if(findThief.containsKey(ap) && findThief.get(ap)) players.add(ap);
        }
        return players;
    }

    public static boolean isRevealed(Player player){
        return booleanThief(player) && REVEALED_THIEF.contains(player.getName().toLowerCase());
    }

    public static void setThief(Player player) {
        findThief.put(player.getUniqueId(), true);
    }

    public static void setNone(Player player) {
        findThief.put(player.getUniqueId(), false);
    }
}
