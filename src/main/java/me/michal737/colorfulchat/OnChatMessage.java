package me.michal737.colorfulchat;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnChatMessage implements Listener {

    @EventHandler
    public void OnChatMessage(AsyncChatEvent event){

        if (!event.getPlayer().hasPermission("colorfulchat.colors")) return;

        Component originalMessage = event.message();
        String rawOriginalMessage = PlainTextComponentSerializer.plainText().serialize(originalMessage);
        Component finalMessage = MiniMessage.miniMessage().deserialize(rawOriginalMessage);
        event.message(finalMessage);

    }

}
