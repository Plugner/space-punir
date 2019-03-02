package com.servidoresspace.spacepunir.poo;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Grupo {
    public enum Grupos {
        FUNDADOR, GERENTE, ADMIN, MODERADOR, AJUDANTE, MEMBRO
    }
    public Player p;
    public static Grupos grupo;
    public static Map<Player, Grupos> gruposMap = new HashMap<>();
    public static Grupos getGrupo(Player p) {
        try {
            grupo = gruposMap.get(p);
        }catch(Exception e) {
            System.out.println("Erro!");
            return null;
        }
        return grupo;
    }
    public static void setGrupo(Player p, Grupos g) {
        gruposMap.put(p,g);
    }
}
