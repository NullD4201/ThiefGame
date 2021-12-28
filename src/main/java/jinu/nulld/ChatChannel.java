package jinu.nulld;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.regex.Pattern;

public enum ChatChannel {
    ADMIN("운영자"),
    LAW("법원"),
    PARK("공원"),
    BANK("은행"),
    NONE("없음");

    public final static Map<ChatChannel, List<UUID>> channelPlayers = new HashMap<>();
    public final static Map<String, ChatChannel> NAME_TO_CHANNEL = new HashMap<>();

    private final String channelName;

    ChatChannel(String name) {
        this.channelName = name;
    }

    public String getChannelName() {
        return channelName;
    }

    public static ChatChannel getChannel(String channelName) {
        ChatChannel cc;
        if (Pattern.matches("^[a-zA-Z]*$", channelName)) cc = ChatChannel.valueOf(channelName);
        else cc = NAME_TO_CHANNEL.get(channelName);

        return cc;
    }

    public static List<UUID> getChannelPlayers(String channelName) {
        return channelPlayers.get(getChannel(channelName));
    }

    public static List<UUID> getChannelPlayers(ChatChannel channel) {
        return channelPlayers.get(channel);
    }

    public static ChatChannel getPlayerChannel(Player player) {
        ChatChannel cc = null;
        for (UUID uid : getChannelPlayers("LAW")) {
            if (Objects.equals(Bukkit.getPlayer(uid), player)) cc = LAW;
        }
        for (UUID uid : getChannelPlayers("PARK")) {
            if (Objects.equals(Bukkit.getPlayer(uid), player)) cc = PARK;
        }
        for (UUID uid : getChannelPlayers("BANK")) {
            if (Objects.equals(Bukkit.getPlayer(uid), player)) cc = BANK;
        }

        return cc;
    }

    public static void addPlayerToChannel(Player player, String channelName) {
        List<UUID> current = getChannelPlayers(channelName);
        current.add(player.getUniqueId());

        channelPlayers.put(getChannel(channelName), current);
    }

    public static void addPlayerToChannel(Player player, ChatChannel channel) {
        List<UUID> current = getChannelPlayers(channel);
        current.add(player.getUniqueId());

        channelPlayers.put(channel, current);
    }

    public static void removePlayerFromChannel(Player player, String channelName) {
        List<UUID> current = getChannelPlayers(channelName);
        current.remove(player.getUniqueId());

        channelPlayers.put(getChannel(channelName), current);
    }

    public static void removePlayerFromChannel(Player player, ChatChannel channel) {
        List<UUID> current = getChannelPlayers(channel);
        current.remove(player.getUniqueId());

        channelPlayers.put(channel, current);
    }

    public static void register() {
        for (ChatChannel cc : ChatChannel.values()) {
            NAME_TO_CHANNEL.put(cc.getChannelName(), cc);
            channelPlayers.put(cc, new ArrayList<>());
        }
    }
}
