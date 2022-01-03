package jinu.nulld.jobs;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.Listener;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class JobCommand implements Listener, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("thjob")) {
            if (args.length == 0) help(sender);
            else {
                if (args[0].equalsIgnoreCase("get")) get(sender, args);
                if (args[0].equalsIgnoreCase("set")) set(sender, args);
            }
        }
        return false;
    }

    private void get(CommandSender sender, String[] args) {
        String playerName = args[1];
        try {
            sender.sendMessage("§f"+playerName+"의 직업 : "+JobAPI.getJob(Objects.requireNonNull(Bukkit.getPlayer(playerName))).getJobName());
        } catch (Exception e) {
            sender.sendMessage("§cUnknown Player Name : §c"+playerName);
        }
    }
    private void set(CommandSender sender, String[] args) {
        String playerName = args[1];
        String job = args[2];
        if (Pattern.matches("^[a-zA-Z]*$", job)) job = Jobs.valueOf(job).getJobName();
        try {
            sender.sendMessage("§f"+playerName+"의 직업 설정 : "+job);
            JobAPI.setJob(Objects.requireNonNull(Bukkit.getPlayer(playerName)), JobAPI.getJobByName(job));
        } catch (Exception e) {
            sender.sendMessage("§cUnknown Player Name : §c"+playerName);
        }
    }

    private void help(CommandSender sender) {
        sender.sendMessage("§f/thjob get [player]");
        sender.sendMessage("§f/thjob set [player] [job]");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("thjob") && args.length == 1) StringUtil.copyPartialMatches(args[0], Arrays.asList("get", "set"), new ArrayList<>());
        if (label.equalsIgnoreCase("thjob") && args.length > 2) StringUtil.copyPartialMatches(args[0], new ArrayList<>(), new ArrayList<>());
        return null;
    }
}
