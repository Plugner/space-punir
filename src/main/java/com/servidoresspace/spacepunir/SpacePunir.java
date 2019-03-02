package com.servidoresspace.spacepunir;

import com.servidoresspace.spacepunir.commands.Click_Command;
import com.servidoresspace.spacepunir.commands.Punir;
import com.servidoresspace.spacepunir.commands.SetGroup;
import com.servidoresspace.spacepunir.listeners.List1;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpacePunir extends JavaPlugin {
    public static SpacePunir instance;
    public static SpacePunir getInstance() {return instance;}
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new List1(),this);


        this.getCommand("punir").setExecutor(new Punir());
        this.getCommand("setgroup").setExecutor(new SetGroup());
        this.getCommand("usodehack").setExecutor(new Click_Command());
        this.getCommand("abusodebugs").setExecutor(new Click_Command());
        this.getCommand("OfensaaJogadoreStaff").setExecutor(new Click_Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
