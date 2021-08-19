package br.com.pedrodcp.ppunish.commands;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.models.PunishmentAccount;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class unpunish implements CommandExecutor {

    protected static String keyStringID;
    protected static int keyID;

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (s instanceof Player) {

            if (c.getName().equalsIgnoreCase("unpunish")) {
                Player p = (Player) s;
                if (!p.hasPermission("ppunish.unpunish")) {
                    p.sendMessage("§cVocê não possui permissão para utilizar este comando.");
                } else {
                    if (args.length >= 1) {
                        try {
                            if (args[0].contains("#")) {
                                keyStringID = args[0].replace("#", "");
                            } else {
                                keyStringID = args[0];
                            }
                            Double keyIDLong = Double.parseDouble(keyStringID);
                            keyID = keyIDLong.intValue();
                            for (Account accounts : Account.accounts) {
                                if (accounts.getID() == keyID) {
                                    if (API.getAccount(accounts.getPlayerName()).getMotivo().equalsIgnoreCase("none")) {
                                        p.sendMessage("§cEste jogador não está punido.");
                                    } else {
                                        for (Player all : Bukkit.getOnlinePlayers()) {
                                            all.sendMessage("");
                                            new FancyMessage(" §e» ").text("§e" + accounts.getPlayerName() + " §eteve §esua §epunição §erevogada §epor §e" + p.getName()).hover("§7Clique §7para §7detalhes §7sobre §7a §7punição").command("/checkpunish #" + keyID).send(p);
                                            new FancyMessage(" §e» ").text("§e" + accounts.getPlayerName() + " §eAplicada §einicialmente §epor §e" + API.getAccount(accounts.getPlayerName()).getAutor()).hover("§7Clique §7para §7detalhes §7sobre §7a §7punição").command("/checkpunish #" + keyID).send(p);
                                            new FancyMessage(" §e» ").text("§e" + accounts.getPlayerName() + " §eMotivo: §ePunição aplicada incorretamente.").hover("§7Clique §7para §7detalhes §7sobre §7a §7punição").command("/checkpunish #" + keyID).send(p);
                                            all.sendMessage("");
                                            p.sendMessage("§eA punição §b#" + accounts.getID() + " §edo jogador " + accounts.getPlayerName() + " foi revogada.");
                                            for (PunishmentAccount punishmentAccounts : PunishmentAccount.accountsPunicoes) {
                                                if (punishmentAccounts.getID() == API.getAccount(accounts.getPlayerName()).getID()) {
                                                    punishmentAccounts.setUnpunish_autor(p.getName());
                                                    punishmentAccounts.setUnpunish_motivo("Punição aplicada incorretamente.");
                                                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                                                    calendar.add(Calendar.HOUR, 1);
                                                    punishmentAccounts.setUnpunish_data(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()));
                                                }
                                            }
                                            API.getAccount(accounts.getPlayerName()).setTempo(0);
                                            API.getAccount(accounts.getPlayerName()).setAutor("none");
                                            API.getAccount(accounts.getPlayerName()).setMotivo("none");
                                            API.getAccount(accounts.getPlayerName()).setID(0);
                                            API.getAccount(accounts.getPlayerName()).setProvas("none");
                                            API.getAccount(accounts.getPlayerName()).setTipo("none");
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            p.sendMessage("§cEste ID de punição é inválido.");
                        }
                    } else {
                        p.sendMessage("§cUtilize /unpunish <#ID>.");
                    }
                }
            }
        } else {
            if (c.getName().equalsIgnoreCase("unpunish")) {
                if (!s.hasPermission("ppunish.despunir")) {
                    s.sendMessage("§cVocê não possui permissão para utilizar este comando.");
                } else {
                    if (args.length >= 1) {
                        try {
                            if (args[0].contains("#")) {
                                keyStringID = args[0].replace("#", "");
                            } else {
                                keyStringID = args[0];
                            }
                            Double keyIDLong = Double.parseDouble(keyStringID);
                            keyID = keyIDLong.intValue();
                            for (Account accounts : Account.accounts) {
                                if (accounts.getID() == keyID) {
                                    if (API.getAccount(accounts.getPlayerName()).getMotivo().equalsIgnoreCase("none")) {
                                        s.sendMessage("§cEste jogador não está punido.");
                                    } else {
                                        Bukkit.getConsoleSender().sendMessage("");
                                        Bukkit.getConsoleSender().sendMessage(" §e» " + accounts.getPlayerName() + " §eteve sua punição revogada por CONSOLE");
                                        Bukkit.getConsoleSender().sendMessage(" §e» Aplicada inicialmente por: " + API.getAccount(accounts.getPlayerName()).getAutor());
                                        Bukkit.getConsoleSender().sendMessage(" §e» Motivo: Punição aplicada incorretamente.");
                                        Bukkit.getConsoleSender().sendMessage("");
                                        s.sendMessage("§eA punição §b#" + accounts.getID() + " §edo jogador " + accounts.getPlayerName() + " foi revogada.");
                                        for (PunishmentAccount punishmentAccounts : PunishmentAccount.accountsPunicoes) {
                                            if (punishmentAccounts.getID() == API.getAccount(accounts.getPlayerName()).getID()) {
                                                punishmentAccounts.setUnpunish_autor("CONSOLE");
                                                punishmentAccounts.setUnpunish_motivo("Punição aplicada incorretamente.");
                                                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                                                calendar.add(Calendar.HOUR, 1);
                                                punishmentAccounts.setUnpunish_data(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()));
                                            }
                                        }
                                        API.getAccount(accounts.getPlayerName()).setTempo(0);
                                        API.getAccount(accounts.getPlayerName()).setAutor("none");
                                        API.getAccount(accounts.getPlayerName()).setMotivo("none");
                                        API.getAccount(accounts.getPlayerName()).setID(0);
                                        API.getAccount(accounts.getPlayerName()).setProvas("none");
                                        API.getAccount(accounts.getPlayerName()).setTipo("none");
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            s.sendMessage("§cEste ID de punição é inválido.");
                            return false;
                        }
                    } else {
                        s.sendMessage("§cUtilize /unpunish <#ID>.");
                    }
                }
            }
        }
        return false;
    }

}
