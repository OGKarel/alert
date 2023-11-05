package cmd.me;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import cmd.me.cmd.Alert;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        getLogger().info("Alert on!");

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        String titlePrefix = getConfig().getString("messages.title_prefix", "&8[&9Alert&8]");
        String chatPrefix = getConfig().getString("messages.chat_prefix", "&8[&9Alert&8]");

        Alert.setTitlePrefix(titlePrefix);
        Alert.setChatPrefix(chatPrefix);

        getCommand("alert").setExecutor(new Alert());
    }

    public void onDisable() {
        getLogger().info("Alert off!");
    }
}
