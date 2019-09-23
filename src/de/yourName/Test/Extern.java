package de.yourName.Test;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

//Wird benötigt damit die EventHandler erkannt werden
public class Extern implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }
}
