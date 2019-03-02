package com.servidoresspace.spacepunir.commands;

import com.servidoresspace.spacepunir.poo.Punishment;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Click_Command implements CommandExecutor {
    public static String cmd_name;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase(cmd_name)) return false;
        Player p = (Player) sender;
        String alvo = Punir.alvo;
        OfflinePlayer off = Bukkit.getOfflinePlayer(alvo);

        int i = 0;
        int id = 0;
        boolean real = false;
        while (i != 1000000 && real == false) {

            if (Punishment.pu_id.containsValue(i)) {
                i++;
                real = false;

            } else {
                Punishment.pu_id.put(alvo, i);
                real = true;
            }


            if(off.isOnline()) {
                Player alvop = Bukkit.getPlayer(alvo);
                alvop.kickPlayer("§5§lSERVIDORES SPACE\n§cVocê foi banido de nosso servidor!\n§cMotivo: §5" + cmd_name + "\n§cAplicador da punição: §5" + sender.getName() + "\n§cID Da punição: §5#" + i);
                alvop.setBanned(true);
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§cO Jogador " + alvo + " foi punido!");
                Bukkit.broadcastMessage("§cMotivo: " + cmd_name);
            }else {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§cO Jogador " + alvo + " foi punido!");
                Bukkit.broadcastMessage("§cMotivo: " + cmd_name);
                off.setBanned(true);


            return false;
        }
    return false;
    }
return false;
    }}