package jinu.nulld;

import jinu.nulld.jobs.JobCommand;
import jinu.nulld.jobs.Jobs;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ThiefGame extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Jobs.register();
        Jobs.setNone();

        Bukkit.getPluginManager().registerEvents(new EventManager(), this);

        getCommand("thjob").setExecutor(new JobCommand());
        getCommand("thjob").setTabCompleter(new JobCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
