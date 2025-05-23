package me.michal737.colorfulchat;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Events implements Listener {

    @EventHandler
    public void onChatMessage(@NotNull AsyncChatEvent event){

        if (!event.getPlayer().hasPermission("colorfulchat.chat")) return;

        Component originalMessage = event.message();
        String rawOriginalMessage = PlainTextComponentSerializer.plainText().serialize(originalMessage);

        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Component itemComponent = item.isEmpty() ? Component.text("Empty") : item.displayName().hoverEvent(item);

        Component finalMessage = MiniMessage.miniMessage().deserialize(rawOriginalMessage, Placeholder.component("item", itemComponent));

        event.message(finalMessage);

    }

}
