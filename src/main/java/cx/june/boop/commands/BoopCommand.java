package cx.june.boop.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BoopCommand implements CommandExecutor {

    private final MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (!player.hasPermission("boop.use")) {
            player.sendMessage("You do not have permission to use this command.");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage("Usage: /boop <player>");
            return true;
        }

        Player target = player.getServer().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("Player not found.");
            return true;
        }

        if (target == player) {
            player.sendMessage(mm.deserialize("<color:#f9b4f6><italic>You booped yourself!"));
            player.playSound(player, Sound.ENTITY_ITEM_PICKUP, 1, 1);
        } else {
            player.sendMessage(mm.deserialize("<color:#f9b4f6><italic>Booped " + target.getName() + "!"));
            player.playSound(player, Sound.ENTITY_ITEM_PICKUP, 1, 1);

            target.sendMessage(mm.deserialize("<color:#f9b4f6><italic>" + player.getName() + " booped you!"));
            target.playSound(target, Sound.ENTITY_ITEM_PICKUP, 1, 1);
        }
        return true;
    }
}
