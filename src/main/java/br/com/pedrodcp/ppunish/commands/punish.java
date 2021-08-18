package br.com.pedrodcp.ppunish.commands;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static br.com.pedrodcp.ppunish.commands.punishevents.onPlayerPunished.*;

public class punish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (s instanceof Player) {

            if (c.getName().equalsIgnoreCase("punish")) {
                Player p = (Player) s;
                if (!p.hasPermission("ppunish.use")) {
                    p.sendMessage("§cVocê não possui permissão para utilizar este comando.");
                } else {
                    if (args.length >= 1) {
                        if (API.getAccount(args[0]) == null) {
                            p.sendMessage("§cEste jogador não existe.");
                        } else {
                            if (args[0].equalsIgnoreCase(p.getName())) {
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5F, 1.0F);
                                p.sendMessage("");
                                p.sendMessage("§c§l[PUNIÇÃO - ERRO] » §fVocê não pode punir a si mesmo!");
                                p.sendMessage("");
                            } else {
                                if (!API.getAccount(args[0]).getMotivo().equalsIgnoreCase("none")) {
                                    p.sendMessage("");
                                    new FancyMessage("§c§l[PUNIÇÃO §c§l- §c§lERRO] §c§l» ").text("§fEste §fjogador §fjá §fse §fencontra §fpunido §fpor §f'" + API.getAccount(args[0]).getMotivo() + "§f'.").hover("§7Clique §7para §7mais §7informações").command("/checkpunish " + args[0]).send(p);
                                    p.sendMessage("");
                                } else {
                                    if (args.length >= 2) {
                                        if (args[1].equalsIgnoreCase("ameaca")) {
                                            if (args.length >= 3) {
                                                PlayerMuted(p, args[0], args[2], "Ameaça", 12, "MUTE", "mutado");
                                            } else {
                                                PlayerMuted(p, args[0], "none", "Ameaça", 12, "MUTE", "mutado");
                                            }
                                        } else {
                                            if (args[1].equalsIgnoreCase("hack")) {
                                                if (args.length >= 3) {
                                                    PlayerMuted(p, args[0], args[2], "Uso de Hack", 100, "BAN", "banido");
                                                } else {
                                                    PlayerMuted(p, args[0], "none", "Uso de Hack", 100, "BAN", "banido");
                                                }
                                            } else {
                                                p.sendMessage("§cEste motivo não está presente na lista de infrações.");
                                            }
                                        }
                                    } else {
                                        p.sendMessage("");
                                        p.sendMessage("§eLista de infrações disponíveis:");
                                        new FancyMessage("").text("§fAmeaça").hover("§eClique para punir!").suggest("/punir " + args[0] + " AMEACA ").send(p);
                                        new FancyMessage("").text("§fUso de Hack").hover("§eClique para punir!").suggest("/punir " + args[0] + " HACK ").send(p);
                                        p.sendMessage("");
                                    }
                                }
                            }
                        }
                    } else {
                        p.sendMessage("§cUtilize /punir <jogador>.");
                    }
                }
            }
        } else {
            if (c.getName().equalsIgnoreCase("punir")) {
                if (!s.hasPermission("ppunish.use")) {
                    s.sendMessage("§cVocê não possui permissão para utilizar este comando.");
                } else {
                    if (args.length >= 1) {
                        if (API.getAccount(args[0]) == null) {
                            s.sendMessage("§cEste jogador não existe.");
                        } else {
                            if (API.getAccount(args[0]).getTempo() != 0) {
                                s.sendMessage("§cEste jogador já se encontra punido por §c§l" + API.getAccount(args[0]).getMotivo() + "§c.");
                            } else {
                                if (args.length >= 2) {
                                    if (args[1].equalsIgnoreCase("ameaca")) {
                                        if (args.length >= 3) {
                                            PlayerMuted(s, args[0], args[2], "Ameaça", 12, "MUTE", "mutado");
                                        } else {
                                            PlayerMuted(s, args[0], "none", "Ameaça", 12, "MUTE", "mutado");
                                        }
                                    } else {
                                        if (args[1].equalsIgnoreCase("hack")) {
                                            if (args.length >= 3) {
                                                PlayerMuted(s, args[0], args[2], "Uso de Hack", 100, "BAN", "banido");
                                            } else {
                                                PlayerMuted(s, args[0], "none", "Uso de Hack", 100, "BAN", "banido");
                                            }
                                        } else {
                                            s.sendMessage("§cEste motivo não está presente na lista de infrações.");
                                        }
                                    }
                                } else {
                                    s.sendMessage("");
                                    s.sendMessage("§eLista de infrações disponíveis:");
                                    s.sendMessage("§fAmeaça - AMEACA");
                                    s.sendMessage("§fUso de Hack - HACK");
                                    s.sendMessage("");
                                }
                            }
                        }
                    } else {
                        s.sendMessage("§cUtilize /punir <jogador>.");
                    }
                }
            }
        }

        return false;
    }
}
