package br.com.pedrodcp.ppunish.commands.punishmentapi;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.managers.TimeManager;
import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.models.PunishmentAccount;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static br.com.pedrodcp.ppunish.commands.checkpunish.*;

public class onPlayerPunished {

    public static String PlayerPunished(CommandSender player, String jogador, String provas, String motivo, int tempo, String tipo, String msg) {
        if (player instanceof Player) {
            if (provas.equalsIgnoreCase("none")) {
                if (!player.hasPermission("ppunish.admin")) {
                    player.sendMessage("§cSomente administradores e superiores podem punir sem provas.");
                } else {
                    int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                    long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                    calendar.add(Calendar.HOUR, 1);
                    PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()), "none", "none", "none"));
                    API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                    API.getAccount(jogador).setAutor(player.getName());
                    API.getAccount(jogador).setMotivo(motivo);
                    API.getAccount(jogador).setID(IdCount);
                    API.getAccount(jogador).setProvas("none");
                    API.getAccount(jogador).setTipo(tipo);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("");
                        new FancyMessage(" §c» ").text("§c" + API.getAccount(jogador).getPlayerName() + " §cfoi §c" + msg + " §cpor §c" + player.getName()).hover("§7Clique §7para §7mais §7informações").command("/checkpunish #" + IdCount).send(all);
                        new FancyMessage(" §c» ").text("§cMotivo: §c" + motivo).hover("§7Clique para mais informações").command("/checkpunish #" + keyID).send(all);
                        all.sendMessage("");
                    }
                    player.sendMessage("§ePunição §b#" + IdCount + " §eaplicada com sucesso.");
                    if (Bukkit.getPlayer(jogador) != null) {
                        Player infrator = Bukkit.getPlayer(jogador);
                        Account infratorAccount = API.getAccount(infrator.getName());
                        if (infratorAccount.getTipo().equals("BAN")) {
                            infrator.kickPlayer("§cVocê foi banido! Seu ID é §e#" + infratorAccount.getID());
                        } else {
                            if (infratorAccount.getTipo().equals("TEMP_BAN")) {
                                infrator.kickPlayer("§cVocê foi banido! Seu ID é §e#" + infratorAccount.getID());
                            } else {
                                if (infratorAccount.getTipo().equals("MUTE")) {
                                    long dif = infratorAccount.getTempo() - System.currentTimeMillis();
                                    infrator.sendMessage("");
                                    infrator.sendMessage(" §c* Você foi silenciado por " + TimeManager.getTempo(dif) + ".");
                                    infrator.sendMessage("");
                                    infrator.sendMessage(" §c* Motivo: " + motivo);
                                    infrator.sendMessage(" §c* ID: §e#" + infratorAccount.getID());
                                    infrator.sendMessage(" §c* Autor: " + infratorAccount.getAutor());
                                    infrator.sendMessage(" §c* Crie um ticket de revisão em nosso Discord, acesse");
                                    infrator.sendMessage(" §e§nmineup.com.br/discord§c.");
                                    infrator.sendMessage("");
                                }
                            }
                        }
                    }
                }
            } else {
                if (provas.startsWith("https://")) {
                    int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                    long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                    calendar.add(Calendar.HOUR, 1);
                    PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()), "none", "none", "none"));
                    API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                    API.getAccount(jogador).setAutor(player.getName());
                    API.getAccount(jogador).setMotivo(motivo);
                    API.getAccount(jogador).setID(IdCount);
                    API.getAccount(jogador).setProvas(provas);
                    API.getAccount(jogador).setTipo(tipo);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("");
                        new FancyMessage(" §c» ").text("§c" + API.getAccount(jogador).getPlayerName() + " §cfoi §c" + msg + " §cpor §c" + player.getName()).hover("§7Clique §7para §7mais §7informações").command("/checkpunish " + IdCount).send(all);
                        new FancyMessage(" §c» ").text("§cMotivo: §c" + motivo).hover("§7Clique para mais informações").command("/checkpunish #" + keyID).send(all);
                        all.sendMessage("");
                    }
                    player.sendMessage("§ePunição §b#" + IdCount + " §eaplicada com sucesso.");
                    if (Bukkit.getPlayer(jogador) != null) {
                        Player infrator = Bukkit.getPlayer(jogador);
                        Account infratorAccount = API.getAccount(infrator.getName());
                        if (infratorAccount.getTipo().equals("BAN")) {
                            infrator.kickPlayer("§cVocê foi banido! Seu ID é §e#" + infratorAccount.getID());
                        } else {
                            if (infratorAccount.getTipo().equals("TEMP_BAN")) {
                                infrator.kickPlayer("§cVocê foi banido! Seu ID é §e#" + infratorAccount.getID());
                            } else {
                                if (infratorAccount.getTipo().equals("MUTE")) {
                                    long dif = infratorAccount.getTempo() - System.currentTimeMillis();
                                    infrator.sendMessage("");
                                    infrator.sendMessage(" §c* Você foi silenciado por " + TimeManager.getTempo(dif) + ".");
                                    infrator.sendMessage("");
                                    infrator.sendMessage(" §c* Motivo: " + motivo);
                                    infrator.sendMessage(" §c* ID: §e#" + infratorAccount.getID());
                                    infrator.sendMessage(" §c* Autor: " + infratorAccount.getAutor());
                                    infrator.sendMessage(" §c* Crie um ticket de revisão em nosso Discord, acesse");
                                    infrator.sendMessage(" §e§nmineup.com.br/discord§c.");
                                    infrator.sendMessage("");
                                }
                            }
                        }
                    }
                } else {
                    if (provas.startsWith("http://")) {
                        int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                        calendar.add(Calendar.HOUR, 1);
                        PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()), "none", "none", "none"));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas(provas);
                        API.getAccount(jogador).setTipo(tipo);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.sendMessage("");
                            new FancyMessage(" §c» ").text("§c" + API.getAccount(jogador).getPlayerName() + " §cfoi §c" + msg + " §cpor §c" + player.getName()).hover("§7Clique §7para §7mais §7informações").command("/checkpunish " + IdCount).send(all);
                            new FancyMessage(" §c» ").text("§cMotivo: §c" + motivo).hover("§7Clique §7para §7mais §7informações").command("/checkpunish #" + keyID).send(all);
                            all.sendMessage("");
                        }
                        player.sendMessage("§ePunição §b#" + IdCount + " §eaplicada com sucesso.");
                        if (Bukkit.getPlayer(jogador) != null) {
                            Player infrator = Bukkit.getPlayer(jogador);
                            Account infratorAccount = API.getAccount(infrator.getName());
                            if (infratorAccount.getTipo().equals("BAN")) {
                                infrator.kickPlayer("§cVocê foi banido! Seu ID é §e#" + infratorAccount.getID());
                            } else {
                                if (infratorAccount.getTipo().equals("TEMP_BAN")) {
                                    infrator.kickPlayer("§cVocê foi banido! Seu ID é §e#" + infratorAccount.getID());
                                } else {
                                    if (infratorAccount.getTipo().equals("MUTE")) {
                                        long dif = infratorAccount.getTempo() - System.currentTimeMillis();
                                        infrator.sendMessage("");
                                        infrator.sendMessage(" §c* Você foi silenciado por " + TimeManager.getTempo(dif) + ".");
                                        infrator.sendMessage("");
                                        infrator.sendMessage(" §c* Motivo: " + motivo);
                                        infrator.sendMessage(" §c* ID: §e#" + infratorAccount.getID());
                                        infrator.sendMessage(" §c* Autor: " + infratorAccount.getAutor());
                                        infrator.sendMessage(" §c* Crie um ticket de revisão em nosso Discord, acesse");
                                        infrator.sendMessage(" §e§nmineup.com.br/discord§c.");
                                        infrator.sendMessage("");
                                    }
                                }
                            }
                        }
                    } else {
                        player.sendMessage("§cAs provas inseridas são consideradas inválidas.");
                    }
                }
            }
            //CONSOLE
        } else {
            if (provas.equalsIgnoreCase("none")) {
                if (!player.hasPermission("ppunish.admin")) {
                    player.sendMessage("§cSomente administradores e superiores podem punir sem provas.");
                } else {
                    int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                    long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                    calendar.add(Calendar.HOUR, 1);
                    PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()), "none", "none", "none"));
                    API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                    API.getAccount(jogador).setAutor(player.getName());
                    API.getAccount(jogador).setMotivo(motivo);
                    API.getAccount(jogador).setID(IdCount);
                    API.getAccount(jogador).setProvas("none");
                    API.getAccount(jogador).setTipo(tipo);
                        Bukkit.getConsoleSender().sendMessage("");
                        Bukkit.getConsoleSender().sendMessage(" §c» " + API.getAccount(jogador).getPlayerName() + " foi " + msg + " por " + player.getName());
                        Bukkit.getConsoleSender().sendMessage(" §c» Motivo: " + motivo);
                        Bukkit.getConsoleSender().sendMessage("");
                        player.sendMessage("§ePunição §b#" + IdCount + " §eaplicada com sucesso.");
                }
            } else {
                if (provas.startsWith("https://")) {
                    int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                    long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                    calendar.add(Calendar.HOUR, 1);
                    PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()), "none", "none", "none"));
                    API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                    API.getAccount(jogador).setAutor(player.getName());
                    API.getAccount(jogador).setMotivo(motivo);
                    API.getAccount(jogador).setID(IdCount);
                    API.getAccount(jogador).setProvas(provas);
                    API.getAccount(jogador).setTipo(tipo);
                    Bukkit.getConsoleSender().sendMessage("");
                    Bukkit.getConsoleSender().sendMessage(" §c» " + API.getAccount(jogador).getPlayerName() + " foi " + msg + " por " + player.getName());
                    Bukkit.getConsoleSender().sendMessage(" §c» Motivo: " + motivo + " - " + provas);
                    Bukkit.getConsoleSender().sendMessage("");
                    player.sendMessage("§ePunição §b#" + IdCount + " §eaplicada com sucesso.");
                } else {
                    if (provas.startsWith("http://")) {
                        int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                        calendar.add(Calendar.HOUR, 1);
                        PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime()), "none", "none", "none"));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas(provas);
                        API.getAccount(jogador).setTipo(tipo);
                        Bukkit.getConsoleSender().sendMessage("");
                        Bukkit.getConsoleSender().sendMessage(" §c» " + API.getAccount(jogador).getPlayerName() + " foi " + msg + " por " + player.getName());
                        Bukkit.getConsoleSender().sendMessage(" §c» Motivo: " + motivo + " - " + provas);
                        Bukkit.getConsoleSender().sendMessage("");
                        player.sendMessage("§ePunição §b#" + IdCount + " §eaplicada com sucesso.");
                    } else {
                        Bukkit.getConsoleSender().sendMessage("§cAs provas inseridas são consideradas inválidas.");
                    }
                }
            }
        }
        return player + jogador + provas + motivo + tempo;
    }

}
