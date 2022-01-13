package jinu.nulld;

import javax.annotation.Nullable;
import org.bukkit.entity.Player;
import su.plo.voice.PlasmoVoice;
import su.plo.voice.PlasmoVoiceAPI;

public class Voice {
    public static PlasmoVoiceAPI api = PlasmoVoice.getInstance();

    /**
     * 강제 음소거
     * @param player   음소거할 플레이어
     */
    public static void mute(Player player) {
        if (!api.isMuted(player.getUniqueId())) api.mute(player.getUniqueId(), 0, null, null, true);
    }

    /**
     * 강제 음소거
     * @param player   음소거할 플레이어
     * @param reason   음소거 이유
     */
    public static void mute(Player player, @Nullable String reason) {
        if (!api.isMuted(player.getUniqueId())) api.mute(player.getUniqueId(), 0, null, reason, true);
    }

    /**
     * 강제 음소거
     * @param player   음소거할 플레이어
     * @param duration 음소거할 시간(초)
     * @param reason   음소거 이유
     */
    public static void mute(Player player, long duration, @Nullable String reason) {
        if (!api.isMuted(player.getUniqueId())) api.mute(player.getUniqueId(), duration, PlasmoVoiceAPI.DurationUnit.SECONDS, reason, true);
    }

    /**
     * 강제 음소거 해제
     * @param player   음소거 해제할 플레이어
     */
    public static void unmute(Player player) {
        if (api.isMuted(player.getUniqueId())) api.unmute(player.getUniqueId(), true);
    }
}
