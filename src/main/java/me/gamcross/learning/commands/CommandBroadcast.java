package me.gamcross.learning.commands;

import me.gamcross.learning.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandBroadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0) {
            commandSender.sendMessage(Main.prefix + ChatColor.DARK_RED + "Usage §r: /broadcast <message>");
            return true;
        }

        String message = String.join(" ", strings);
        message = ChatColor.translateAlternateColorCodes('&', message);
        message = Main.prefix + message;

        Bukkit.broadcastMessage(message);

        return false;
    }
}
