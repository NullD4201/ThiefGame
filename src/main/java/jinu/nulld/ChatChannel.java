package jinu.nulld;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public enum ChatChannel {
    LAW("법원"),
    PARK("공원"),
    BANK("은행");

    public final static Map<ChatChannel, List<UUID>> channelPlayers = new HashMap<>();
    public final static Map<String, ChatChannel> NAME_TO_CHANNEL = new HashMap<>();

    private final String channelName;

    ChatChannel(String name) {
        this.channelName = name;
    }

    public String getChannelName() {
        return channelName;
    }

    public ChatChannel getChannel(String channelName) {
        ChatChannel cc;
        if (Pattern.matches("^[a-zA-Z]*$", channelName)) cc = ChatChannel.valueOf(channelName);
        else cc = NAME_TO_CHANNEL.get(channelName);

        return cc;
    }

    public List<UUID> getChannelPlayers(String channelName) {
        return channelPlayers.get(getChannel(channelName));
    }

    public void addPlayerToChannel(Player player, String channelName) {
        List<UUID> current = getChannelPlayers(channelName);
        current.add(player.getUniqueId());

        channelPlayers.put(getChannel(channelName), current);
    }

    public void removePlayerFromChannel(Player player, String channelName) {
        List<UUID> current = getChannelPlayers(channelName);
        current.remove(player.getUniqueId());

        channelPlayers.put(getChannel(channelName), current);
    }

    public static void register() {
        for (ChatChannel cc : ChatChannel.values()) NAME_TO_CHANNEL.put(cc.getChannelName(), cc);
    }
}
