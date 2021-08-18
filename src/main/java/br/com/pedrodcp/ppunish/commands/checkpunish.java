package br.com.pedrodcp.ppunish.commands;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.api.PunishmentsAPI;
import br.com.pedrodcp.ppunish.gui.Punishments;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class checkpunish implements CommandExecutor {

    private Punishments gui = new Punishments();

    public static String playerName;
    public static String autorName;

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;

        if (c.getName().equalsIgnoreCase("checkpunish")) {
            Player p = (Player) s;
            if (!p.hasPermission("ppunish.checkpunish")) {
                p.sendMessage("§cVocê não possui permissão para utilizar este comando.");
            } else {
                if (args.length >= 1) {
                    if (API.getAccount(args[0]) == null) {
                        p.sendMessage("§cEste jogador não existe.");
                    } else {
                        if (PunishmentsAPI.getAccount(args[0]) == null) {
                            p.sendMessage("§cEste jogador não possui um histórico de punições.");
                        } else {
                            playerName = args[0];
                            autorName = p.getName();
                            gui.gameGUI(p);
                        }
                    }
                } else {
                    p.sendMessage("");
                    new FancyMessage("§c§l[PUNIÇÃO §c§l- §c§lERRO] §c§l➜ §fUtilize ").text("§b§n/checkpunish §b§n<jogador>").hover("§7Clique §7para §7copiar §7o §7comando").suggest("/checkpunish ").text("§f.").send(p);
                    p.sendMessage("");
                }
            }
        }
        return false;
    }
}
