package cmd.me.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class Alert implements CommandExecutor {
    private static String titlePrefix = "&8[&9Server&8]";
    private static String chatPrefix = "&8[&9Server&8]";

    public static void setTitlePrefix(String prefix) {
        titlePrefix = ChatColor.translateAlternateColorCodes('&', prefix);
    }

    public static void setChatPrefix(String prefix) {
        chatPrefix = ChatColor.translateAlternateColorCodes('&', prefix);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        if (!sender.hasPermission("alert.use")) {
            sender.sendMessage(titlePrefix + " " + ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(titlePrefix + " " + ChatColor.GRAY + "/alert <message>");
            return true;
        }

        String message = String.join(" ", args);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(titlePrefix, ChatColor.WHITE + message);
            player.sendMessage(chatPrefix + " " + ChatColor.GRAY + message);
        }
        return true;
    }
}
