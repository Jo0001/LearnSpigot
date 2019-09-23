package de.yourName.Core;

import de.yourName.Test.Examples;
import de.yourName.Test.Extern;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    //Alles was beim Starten des Plugins passieren soll
    public void onEnable() {
        System.out.println("Ich werde beim Start ausgeführt");

        //Laden einer externen Klasse
        getServer().getPluginManager().registerEvents(new Extern(), this);

        //Laden der Beispiel Klasse
        getServer().getPluginManager().registerEvents(new Examples(), this);

    }

    //Alles was beim Abschalten des Plugins passieren soll
    public void onDisable() {
        System.out.println("Ich werde beim Stop ausgeführt");

    }

    //1.Beispiel
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //Damit holen wir uns den Spieler, geht bei fast jedem Event
        Player player = event.getPlayer();
        System.out.println(player);
        //Hiermit ändern wir die Joinmeldung
        event.setJoinMessage("Eigene Spielbetreten Nachricht");

    }
}
