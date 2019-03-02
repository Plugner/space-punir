package com.servidoresspace.spacepunir.commands;

import com.servidoresspace.spacepunir.poo.Grupo;
import com.servidoresspace.spacepunir.poo.Punishment;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Punir implements CommandExecutor {
    public static String alvo;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        if(Grupo.getGrupo(p) == null) {
            Grupo.setGrupo(p, Grupo.Grupos.MEMBRO);
            return false;
        }
        if(Grupo.getGrupo(p) == Grupo.Grupos.MEMBRO) {
            p.sendMessage("§cVocê não tem permissão para efetuar essa ação!");
            return false;
        }
        if(args.length == 0){p.sendMessage("§cUse: /punir (Usuário)");return false;}
        if(Bukkit.getPlayer(args[0]) == null) {
            OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
            String nome = off.getName();
            p.sendMessage("");
            p.sendMessage("   §7Punindo o Jogador: §c" + nome + "\n§6");

            Punishment p_3 = new Punishment("Ofensa a Jogador e Staff", nome, Grupo.Grupos.AJUDANTE);
            p_3.showTo(p);

            Punishment p_1 = new Punishment("Uso de Hack", nome, Grupo.Grupos.MODERADOR);
            p_1.showTo(p);

            Punishment p_2 = new Punishment("Abuso de Bugs", nome, Grupo.Grupos.ADMIN);
            p_2.showTo(p);








            alvo = nome;
        }else{
            Player off = Bukkit.getPlayer(args[0]);
            String nome = off.getName();
            p.sendMessage("");
            p.sendMessage("   §7Punindo o Jogador: §c" + nome + "");
            p.sendMessage("");
            Punishment p_3 = new Punishment("Ofensa a Jogador e Staff", nome, Grupo.Grupos.AJUDANTE);
            p_3.showTo(p);

            Punishment p_1 = new Punishment("Uso de Hack", nome, Grupo.Grupos.MODERADOR);
            alvo = nome;
            p_1.showTo(p);

            Punishment p_2 = new Punishment("Abuso de Bugs", nome, Grupo.Grupos.ADMIN);
            p_2.showTo(p);


        }
        return false;
    }
}
