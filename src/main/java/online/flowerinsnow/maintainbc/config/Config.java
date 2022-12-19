package online.flowerinsnow.maintainbc.config;

import cc.carm.lib.configuration.core.ConfigurationRoot;
import cc.carm.lib.configuration.core.annotation.HeaderComment;
import cc.carm.lib.configuration.core.value.type.ConfiguredList;
import cc.carm.lib.configuration.core.value.type.ConfiguredValue;

public class Config extends ConfigurationRoot {
    @HeaderComment("是否正在维护，禁止玩家进入")
    public static final ConfiguredValue<Boolean> IN_MAINTAIN = ConfiguredValue.of(Boolean.class, false);

    @HeaderComment({"允许进入的玩家名", "区分大小写"})
    public static final ConfiguredList<String> WHITELIST = ConfiguredList.builder(String.class)
            .fromString().defaults("flowerinsnow").build();
}
