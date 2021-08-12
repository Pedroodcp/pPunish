package br.com.pedrodcp.ppunish.commands;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.gui.Punishments;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class checkpunish implements CommandExecutor {

    private Punishments gui = new Punishments();
    public static String playerName;

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;

        if (c.getName().equalsIgnoreCase("checkpunish")) {
            Player p = (Player) s;
            if (args.length >= 1) {
                if (API.getAccount(args[0]) == null) {
                    p.sendMessage("§cEste jogador não existe.");
                } else {
                    if (API.getAccountPunicoes(args[0]) == null) {
                        p.sendMessage("§cEste jogador não possui um histórico de punições.");
                    } else {
                        playerName = args[0];
                        gui.gameGUI(p);
                    }
                }
            } else {
                p.sendMessage("§cVocê precisa inserir um nickname.");
            }
        }
        return false;
    }
}
