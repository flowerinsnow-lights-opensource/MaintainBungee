package online.flowerinsnow.maintainbc.config;

import cc.carm.lib.configuration.core.ConfigurationRoot;
import cc.carm.lib.configuration.core.annotation.HeaderComment;
import cc.carm.lib.mineconfiguration.bungee.value.ConfiguredMessageList;

public class Message extends ConfigurationRoot {
    @HeaderComment("禁止玩家进入时的消息")
    public static final ConfiguredMessageList<String> KICK_MESSAGE = ConfiguredMessageList
            .ofStrings("&c服务器正在维护，请您耐心等待");

    public static class Command extends ConfigurationRoot {
        @HeaderComment("变量：%(permission)")
        public static ConfiguredMessageList<String> NO_PERMISSION = ConfiguredMessageList.asStrings()
                .defaults("&c您没有使用该命令的权限")
                .params("permission")
                .build();

        public static class Maintain extends ConfigurationRoot {
            public static ConfiguredMessageList<String> USAGE = ConfiguredMessageList
                    .ofStrings(
                            "&7- &f/maintain reload",
                            "&7# 重载配置文件",
                            "&7- &f/maintain enable",
                            "&7# 启用维护",
                            "&7- &f/maintain disable",
                            "&7# 停用维护"
                    );

            public static ConfiguredMessageList<String> RELOAD = ConfiguredMessageList
                    .ofStrings("&7重载成功");

            public static ConfiguredMessageList<String> ENABLE = ConfiguredMessageList
                    .ofStrings("&7维护模式已&a启用");

            public static ConfiguredMessageList<String> DISABLE = ConfiguredMessageList
                    .ofStrings("&7维护模式已&c禁用");
        }
    }
}
