package me.gamcross.learning;

import me.gamcross.learning.commands.CommandBroadcast;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String prefix = "§7[§6Learning§7]§r ";

    @Override
    public void onEnable() {
        System.out.println("Learning is enable!");

        getCommand("broadcast").setExecutor(new CommandBroadcast());
    }

    @Override
    public void onDisable() {
        System.out.println("Learning is disable!");
    }
}
