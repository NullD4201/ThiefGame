package jinu.nulld.jobs;

import org.bukkit.entity.Player;

import java.util.*;

public class IsThief {
    public static Map<UUID, Boolean> findThief = new HashMap<>();

    public static List<UUID> REVEALED_THIEF = new ArrayList<>();

    public static boolean booleanThief(Player player) {
        return booleanThief(player.getUniqueId());
    }

    public static boolean booleanThief(UUID uuid){
        if (findThief.get(uuid) != null)
            return findThief.get(uuid);
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
        return isRevealed(player.getUniqueId());
    }

    public static boolean isRevealed(UUID uuid){
        return booleanThief(uuid) && REVEALED_THIEF.contains(uuid);
    }

    public static void setThief(Player player) {
        findThief.put(player.getUniqueId(), true);
    }

    public static void setNone(Player player) {
        findThief.put(player.getUniqueId(), false);
    }
}
