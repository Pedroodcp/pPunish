package br.com.pedrodcp.ppunish.commands;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.api.PunishmentsAPI;
import br.com.pedrodcp.ppunish.gui.PlayerPunishmentInfo;
import br.com.pedrodcp.ppunish.gui.Punishments;
import br.com.pedrodcp.ppunish.models.PunishmentAccount;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static br.com.pedrodcp.ppunish.gui.Punishments.*;
import static br.com.pedrodcp.ppunish.commands.punishevents.onPlayerPunished.*;

public class checkpunish implements CommandExecutor {

    private Punishments gui = new Punishments();

    public static String playerName;
    public static String autorName;
    public static String keyID;

    protected static Double keyDoubleID;

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;

        if (c.getName().equalsIgnoreCase("checkpunish")) {
            Player p = (Player) s;
            if (!p.hasPermission("ppunish.checkpunish")) {
                p.sendMessage("§cVocê não possui permissão para utilizar este comando.");
            } else {
                if (args.length >= 1) {
                    keyID = null;
                    keyDoubleID = null;
                    punishId = 0;
                    playerName = null;
                    autorName = null;
                    if (args[0].contains("#")) {
                        keyID = args[0].replace("#", "");
                    } else {
                        keyID = args[0];
                    }
                    try {
                        Double.parseDouble(keyID);
                        keyDoubleID = Double.parseDouble(keyID);
                        for (PunishmentAccount punishmentAccounts : PunishmentAccount.accountsPunicoes) {
                            if (punishmentAccounts.getID() == keyDoubleID.intValue()) {
                                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 5F, 1.0F);
                                punishId = punishmentAccounts.getID();
                                playerName = punishmentAccounts.getPlayerName();
                                autorName = p.getName();
                                p.openInventory(new PlayerPunishmentInfo().getInventory());
                            }
                        }
                    } catch (Exception e) {
                        if (args[0].equals("#")) {
                            new FancyMessage("§cUtilize ").text("§c/checkpunish §c<#ID>").suggest("/checkpunish #").text("§c.").send(p);
                        } else {
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
                            return false;
                        }
                    }
                } else {
                    p.sendMessage("");
                    new FancyMessage("§c§l[PUNIÇÃO §c§l- §c§lERRO] §c§l» §fUtilize ").text("§b§n/checkpunish §b§n<jogador>").hover("§7Clique §7para §7copiar §7o §7comando").suggest("/checkpunish ").text("§f §fou §b§n/checkpunish §b§n<#ID>").hover("§7Clique §7para §7copiar §7o §7comando").suggest("/checkpunish #").text("§f.").send(p);
                    p.sendMessage("");
                }
            }
        }
        return false;
    }
}
