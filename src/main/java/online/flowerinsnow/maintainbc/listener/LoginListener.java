package online.flowerinsnow.maintainbc.listener;

import cc.carm.lib.mineconfiguration.bungee.data.MessageText;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import online.flowerinsnow.maintainbc.config.Config;
import online.flowerinsnow.maintainbc.config.Message;

import java.util.ArrayList;
import java.util.List;

public class LoginListener implements Listener {
    @EventHandler
    public void onLogin(PreLoginEvent e) {
        if (Config.IN_MAINTAIN.getNotNull() && !Config.WHITELIST.getNotNull().contains(e.getConnection().getName())) {
            e.setCancelled(true);
            ArrayList<BaseComponent> var0 = new ArrayList<>();
            List<MessageText> kickMessage = Message.KICK_MESSAGE.getNotNull();
            for (int i = 0; i < kickMessage.size(); i++) {
                var0.add(new TextComponent(kickMessage.get(i).getMessage()
                        .replace("&", "§")
                        .replace("§§", "&")
                ));
                if (i + 1 < kickMessage.size()) {
                    var0.add(new TextComponent("\n"));
                }
            }
            BaseComponent[] texts = new BaseComponent[var0.size()];
            var0.toArray(texts);
            e.setCancelReason(texts);
        }
    }
}
