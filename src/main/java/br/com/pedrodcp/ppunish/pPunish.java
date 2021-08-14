package br.com.pedrodcp.ppunish;

import br.com.pedrodcp.ppunish.commands.checkpunish;
import br.com.pedrodcp.ppunish.commands.punir;
import br.com.pedrodcp.ppunish.commands.unpunish;
import br.com.pedrodcp.ppunish.events.InventoryClick;
import br.com.pedrodcp.ppunish.events.Listeners;
import br.com.pedrodcp.ppunish.models.database.ConnectionModel;
import br.com.pedrodcp.ppunish.models.database.MySQLConnection;
import br.com.pedrodcp.ppunish.models.database.SQLiteConnection;
import br.com.pedrodcp.ppunish.statements.Statements;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class pPunish extends JavaPlugin {

    private static pPunish instance;

    public static File database;
    public static ConnectionModel connectionModel;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        if (!new File(getDataFolder(), "config.yml").exists()) saveDefaultConfig();
        database = new File(getDataFolder(), "database.db");
        connectionModel = getConfig().getBoolean("Database.mysql") ? new MySQLConnection(getConfig().getString("Database.host"), getConfig().getInt("Database.port"), getConfig().getString("Database.database"), getConfig().getString("Database.user"), getConfig().getString("Database.password")) : new SQLiteConnection();
        Statements.initialize();
        loadCommands();
        loadConfig();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§a[pPunish] Sistemas carregados e ativados com sucesso.");
        Bukkit.getConsoleSender().sendMessage("");
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        Statements.saveAccounts();
        Statements.saveAccountsPunicoes();
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§c[pPunish] Sistemas desativados sem quaisquer erro aparente.");
        Bukkit.getConsoleSender().sendMessage("");
    }

    public void loadCommands() {
        getCommand("punir").setExecutor(new punir());
        getCommand("unpunish").setExecutor(new unpunish());
        getCommand("checkpunish").setExecutor(new checkpunish());
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public void loadEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Listeners(), this);
        pm.registerEvents(new InventoryClick(), this);
    }

    public static pPunish getInstance() {
        return instance;
    }

}
