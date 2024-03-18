package cx.june.boop;

import cx.june.boop.commands.BoopCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Boop extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("boop").setExecutor(new BoopCommand());
        Bukkit.getLogger().info("Boop has been enabled!");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Boop has been disabled!");
    }
}
