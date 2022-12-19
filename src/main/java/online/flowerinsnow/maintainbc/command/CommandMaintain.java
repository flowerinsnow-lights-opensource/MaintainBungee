package online.flowerinsnow.maintainbc.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import online.flowerinsnow.maintainbc.Maintain;
import online.flowerinsnow.maintainbc.config.Config;
import online.flowerinsnow.maintainbc.config.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandMaintain extends Command implements TabExecutor {
    public CommandMaintain() {
        super("maintain", "maintain.command");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            if ("reload".equalsIgnoreCase(args[0])) {
                if (sender.hasPermission("maintain.command.reload")) {
                    Maintain.reloadConfiguration();
                    Message.Command.Maintain.RELOAD.send(sender);
                } else {
                    Message.Command.NO_PERMISSION.send(sender, "maintain.command.reload");
                }
            } else if ("enable".equalsIgnoreCase(args[0])) {
                if (sender.hasPermission("maintain.command.enable")) {
                    Config.IN_MAINTAIN.set(true);
                    Maintain.saveConfiguration();
                    Message.Command.Maintain.ENABLE.send(sender);
                } else {
                    Message.Command.NO_PERMISSION.send(sender, "maintain.command.enable");
                }
            } else if ("disable".equalsIgnoreCase(args[0])) {
                if (sender.hasPermission("maintain.command.disable")) {
                    Config.IN_MAINTAIN.set(false);
                    Maintain.saveConfiguration();
                    Message.Command.Maintain.DISABLE.send(sender);
                } else {
                    Message.Command.NO_PERMISSION.send(sender, "maintain.command.disable");
                }
            } else {
                sendUsage(sender);
            }
        } else {
            sendUsage(sender);
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length == 1 && sender.hasPermission("maintain.command")) {
            List<String> subCommands = new ArrayList<>(Arrays.asList("reload", "enable", "disable"));
            subCommands.removeIf(s -> !s.toLowerCase().startsWith(args[0].toLowerCase()));
            return subCommands;
        }
        return new ArrayList<>();
    }

    private void sendUsage(CommandSender sender) {
        Message.Command.Maintain.USAGE.send(sender);
    }
}
