package com.servidoresspace.spacepunir.listeners;

import com.servidoresspace.spacepunir.poo.Punishment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class List1 implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if(e.getResult() == PlayerLoginEvent.Result.KICK_BANNED) {
            e.setKickMessage("§5§lSERVIDORES SPACE\n§cVocê foi banido de nosso servidor! \n§cSeu nick: " + e.getPlayer().getName() + "\n§cSeu IP: §5" + e.getAddress().getHostAddress() + "\n§cID Da punição: §5#" + Punishment.pu_id.get(e.getPlayer().getName()));
        }
        return;
    }
}
