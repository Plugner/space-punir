package com.servidoresspace.spacepunir.poo;

import com.servidoresspace.spacepunir.SpacePunir;
import com.servidoresspace.spacepunir.commands.Click_Command;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Punishment {
    public static Map<String, Integer> pu_id = new HashMap<>();
    private String pun_nome;
    private String pun_alvo;
    private Grupo.Grupos pun_grupo;
    public Punishment(String nome, String alvo, Grupo.Grupos grupomin) {
        this.pun_nome = nome;
        this.pun_alvo = alvo;
        this.pun_grupo = grupomin;
    }

    public String getPun_nome() {
        return pun_nome;
    }

    public void setPun_nome(String pun_nome) {
        this.pun_nome = pun_nome;
    }
    public void showTo(Player p) {
        boolean allow = false;
        if(pun_grupo == Grupo.Grupos.AJUDANTE) {
            if(Grupo.getGrupo(p) == Grupo.Grupos.AJUDANTE || Grupo.getGrupo(p) == Grupo.Grupos.MODERADOR || Grupo.getGrupo(p) == Grupo.Grupos.ADMIN || Grupo.getGrupo(p) == Grupo.Grupos.GERENTE || Grupo.getGrupo(p) == Grupo.Grupos.FUNDADOR) {
                allow = true;
            }
        }else if(pun_grupo == Grupo.Grupos.MODERADOR) {
            if(Grupo.getGrupo(p) == Grupo.Grupos.MODERADOR || Grupo.getGrupo(p) == Grupo.Grupos.ADMIN || Grupo.getGrupo(p) == Grupo.Grupos.GERENTE || Grupo.getGrupo(p) == Grupo.Grupos.FUNDADOR) {
                allow = true;
            }
        }else if(pun_grupo == Grupo.Grupos.ADMIN) {
            if(Grupo.getGrupo(p) == Grupo.Grupos.ADMIN || Grupo.getGrupo(p) == Grupo.Grupos.GERENTE || Grupo.getGrupo(p) == Grupo.Grupos.FUNDADOR) {
                allow = true;
            }
        }else if(pun_grupo == Grupo.Grupos.GERENTE) {
            if( Grupo.getGrupo(p)== Grupo.Grupos.GERENTE || Grupo.getGrupo(p) == Grupo.Grupos.FUNDADOR) {
                allow = true;
            }
        }
        TextComponent text = new TextComponent(pun_nome);

        Click_Command.cmd_name = pun_nome.replace(" ", "");


        if(allow) {
            ComponentBuilder cb = new ComponentBuilder(" §7Clique aqui para punir por " + pun_nome);
            cb.append(" \n§7Cargo mínimo: §5" + pun_grupo.toString().toUpperCase());
            cb.append("\n");
            cb.append(" §e* Clique para punir!");
            BaseComponent[] bc = cb.create();
            HoverEvent hover = new HoverEvent(HoverEvent.Action.SHOW_TEXT, bc);
            text.setColor(ChatColor.GREEN);
            ClickEvent click = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/"+pun_nome.replace(" ", ""));
            text.setClickEvent(click);
            text.setHoverEvent(hover);
            p.spigot().sendMessage(text);

        }else{
            ComponentBuilder cb = new ComponentBuilder(" §7Clique aqui para punir por " + pun_nome);
            cb.append(" \n§7Cargo mínimo: §5" + pun_grupo.toString().toUpperCase());
            cb.append("\n");
            cb.append(" §e* Você não pode punir por esse motivo!");
            BaseComponent[] bc = cb.create();

            HoverEvent hover = new HoverEvent(HoverEvent.Action.SHOW_TEXT, bc);
            text.setColor(ChatColor.RED);
            text.setHoverEvent(hover);
            p.spigot().sendMessage(text);
        }

    }
}
