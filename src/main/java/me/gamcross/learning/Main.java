package me.gamcross.learning;

import me.gamcross.learning.commands.CommandBroadcast;
import me.gamcross.learning.commands.CommandTestEnable;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String prefix = "§7§l[§6§lLearning§7§l]§r "; // Prefix for all messages

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Learning is enable!");
        saveDefaultConfig(); // Save default config.yml

        // Register commands
        getCommand("testLearning").setExecutor(new CommandTestEnable(this));
        getCommand("broadcast").setExecutor(new CommandBroadcast());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Learning is disable!");
    }
}
