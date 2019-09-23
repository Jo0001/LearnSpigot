package de.yourName.Test;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;

public class Examples implements Listener {

    @EventHandler
    public void onPlayerBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        //Spieler bekommt eine Nachricht
        //Durch ChatColor.FARBE kann die Nachricht farbig gemacht werden
        player.sendMessage(ChatColor.BLUE+"Du liegst im Bett");
    }

    @EventHandler
    public void onBlockBreake(BlockBreakEvent event) {
        Player player = event.getPlayer();
        //Auslesen welchen Block ein Spieler abgebaut hat
        Material material = event.getBlock().getType();
        //Der Spieler sendet als Chatnachricht welchen Block er abgebaut hat (Farbe siehe oben)
        player.chat("Ich habe "+material+" abgebaut");
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        //testen ob der Spieler sneakt
        if(player.isSneaking()){
            //Event abbrechen -> Item wird nicht getroppt
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onRightCLick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        //Wenn der Spieler ein Buch in der Haupthand hält
        if (player.getInventory().getItemInMainHand().getType() == Material.BOOK) {
            //und er in die Luft rechtsklickt
            if (e.getAction() == Action.RIGHT_CLICK_AIR ) {
              player.chat("Hello World");
            }
        }
    }

    @EventHandler
    public void onBlockLeftCLick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        //wenn der Spieler einen Block linksklickt (beim Abbauen z.B.)
        if (event.getAction() == Action.LEFT_CLICK_BLOCK ) {
            //und es ein Diamandblock ist
            if(event.getClickedBlock().equals(Material.DIAMOND_BLOCK)){
                //dann soll geprüft werden ob der die Berechtigung dazu hat
                if(player.hasPermission("Ich.darf.dias.abbauen")){
                    player.sendMessage("Du darfst ihn abbauen");
                }else  {
                    player.sendMessage("Du darfst ihn nicht abbauen");
                    //Event abbrechen
                    event.setCancelled(true);
                }
            }

        }

    }

}
