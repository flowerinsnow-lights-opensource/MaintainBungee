package online.flowerinsnow.maintainbc;

import cc.carm.lib.configuration.core.source.ConfigurationProvider;
import cc.carm.lib.mineconfiguration.bungee.MineConfiguration;
import net.md_5.bungee.api.plugin.Plugin;
import online.flowerinsnow.maintainbc.command.CommandMaintain;
import online.flowerinsnow.maintainbc.config.Config;
import online.flowerinsnow.maintainbc.config.Message;
import online.flowerinsnow.maintainbc.listener.LoginListener;

public class Maintain extends Plugin {
    private static Maintain instance;
    private static ConfigurationProvider<?> configProvider;
    private static ConfigurationProvider<?> messageProvider;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        loadConfiguration();

        getProxy().getPluginManager().registerCommand(this, new CommandMaintain());
        getProxy().getPluginManager().registerListener(this, new LoginListener());
    }

    public static void loadConfiguration() {
        configProvider = MineConfiguration.fromYAML(instance, "config.yml");
        configProvider.initialize(Config.class);

        messageProvider = MineConfiguration.fromYAML(instance, "messages.yml");
        messageProvider.initialize(Message.class);
    }

    public static void reloadConfiguration() {
        try {
            configProvider.reload();
            configProvider.initialize(Config.class);
            messageProvider.reload();
            messageProvider.initialize(Message.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveConfiguration() {
        try {
            configProvider.save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
