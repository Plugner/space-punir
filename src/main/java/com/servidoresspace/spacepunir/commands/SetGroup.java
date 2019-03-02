package com.servidoresspace.spacepunir.commands;

import com.servidoresspace.spacepunir.poo.Grupo;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetGroup implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            if(args.length != 2) {
                sender.sendMessage("§cErro!");

            }
            Player p = Bukkit.getPlayer(args[0]);
            String cargo = args[1];
            cargo = cargo.toUpperCase();
            try{
                sender.sendMessage("§5O Cargo de " + p.getName() + " foi alterado para §d" +cargo);
                Grupo.setGrupo(p, Grupo.Grupos.valueOf(cargo));
                p.sendMessage("§5Seu grupo foi alterado para §d" + cargo);
            }catch(Exception e) {
                sender.sendMessage("Erro!");
            }




        }
        return false;
    }
}
