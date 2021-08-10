package br.com.pedrodcp.ppunish.commands;

import br.com.pedrodcp.ppunish.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class unpunish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (s instanceof Player) {

            if (c.getName().equalsIgnoreCase("unpunish")) {
                Player p = (Player) s;
                if (!p.hasPermission("ppunish.despunir")) {
                    p.sendMessage("§cVocê não possui permissão para utilizar este comando.");
                } else {
                    if (args.length >= 1) {
                        if (API.getAccount(args[0]) == null) {
                            p.sendMessage("§cEste jogador não existe.");
                        } else {
                            if (API.getAccount(args[0]).getTempo() == 0) {
                                p.sendMessage("§cEste jogador não está punido.");
                            } else {
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    if (Bukkit.getPlayer(args[0]) == null) {
                                        all.sendMessage("");
                                        all.sendMessage(" §e* " + args[0] + " §eteve sua punição revogada por " + p.getName());
                                        all.sendMessage(" §e* Aplicada inicialmente por: " + API.getAccount(args[0]).getAutor());
                                        all.sendMessage(" §e* Motivo: Punição aplicada incorretamente.");
                                        all.sendMessage("");
                                        API.getAccount(args[0]).setTempo(0);
                                        API.getAccount(args[0]).setAutor("none");
                                        API.getAccount(args[0]).setMotivo("none");
                                        API.getAccount(args[0]).setID(0);
                                        API.getAccount(args[0]).setProvas("none");
                                        API.getAccount(args[0]).setTipo("none");
                                    } else {
                                        all.sendMessage("");
                                        all.sendMessage(" §e* " + Bukkit.getPlayer(args[0]).getName() + " §eteve sua punição revogada por " + p.getName());
                                        all.sendMessage(" §e* Aplicada inicialmente por: " + API.getAccount(args[0]).getAutor());
                                        all.sendMessage(" §e* Motivo: Punição aplicada incorretamente.");
                                        all.sendMessage("");
                                        API.getAccount(args[0]).setTempo(0);
                                        API.getAccount(args[0]).setAutor("none");
                                        API.getAccount(args[0]).setMotivo("none");
                                        API.getAccount(args[0]).setID(0);
                                        API.getAccount(args[0]).setProvas("none");
                                        API.getAccount(args[0]).setTipo("none");
                                    }
                                }
                            }
                        }
                    } else {
                        p.sendMessage("§cUtilize /unpunish <jogador>.");
                    }
                }
            }
        } else {
            if (c.getName().equalsIgnoreCase("unpunish")) {
                if (!s.hasPermission("ppunish.despunir")) {
                    s.sendMessage("§cVocê não possui permissão para utilizar este comando.");
                } else {
                    if (args.length >= 1) {
                        if (API.getAccount(args[0]) == null) {
                            s.sendMessage("§cEste jogador não existe.");
                        } else {
                            if (API.getAccount(args[0]).getTempo() == 0) {
                                s.sendMessage("§cEste jogador não está punido.");
                            } else {
                                Bukkit.getConsoleSender().sendMessage("");
                                Bukkit.getConsoleSender().sendMessage(" " + args[0] + " §efoi despunido por CONSOLE");
                                Bukkit.getConsoleSender().sendMessage(" Motivo: Punição aplicada incorretamente.");
                                Bukkit.getConsoleSender().sendMessage("");
                                API.getAccount(args[0]).setTempo(0);
                                API.getAccount(args[0]).setAutor("none");
                                API.getAccount(args[0]).setMotivo("none");
                                API.getAccount(args[0]).setID(0);
                                API.getAccount(args[0]).setProvas("none");
                                API.getAccount(args[0]).setTipo("none");
                            }
                        }
                    } else {
                        s.sendMessage("§cUtilize /unpunish <jogador>.");
                    }
                }
            }
        }
        return false;
    }
}
