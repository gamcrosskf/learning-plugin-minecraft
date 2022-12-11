package me.gamcross.learning.commands;

import me.gamcross.learning.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandTestEnable implements CommandExecutor {
    private Main main; // Main class
    public CommandTestEnable(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(main.prefix + main.getConfig().getString("commands.testLearning.color") + main.getConfig().getString("commands.testLearning.message"));
        return false;
    }
}
