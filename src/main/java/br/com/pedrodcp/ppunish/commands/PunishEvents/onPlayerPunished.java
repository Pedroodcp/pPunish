package br.com.pedrodcp.ppunish.commands.punishevents;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.PunishmentAccount;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class onPlayerPunished {

    public static String PlayerMuted(CommandSender player, String jogador, String provas, String motivo, int tempo, String tipo, String msg) {
        if (player instanceof Player) {
            if (provas.equalsIgnoreCase("none")) {
                if (!player.hasPermission("ppunish.admin")) {
                    player.sendMessage("§cSomente administradores e superiores podem punir sem provas.");
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                        all.sendMessage("");
                        new FancyMessage(" §c» ").text("§c" + API.getAccount(jogador).getPlayerName() + " §cfoi §c" + msg + " §cpor §c" + player.getName()).hover("§7Clique §7para §7mais §7informações").command("/checkpunish #" + IdCount).send(((Player) player).getPlayer());
                        new FancyMessage(" §c» ").text("§cMotivo: §c" + motivo).hover("§7Clique para mais informações").command("/checkpunish #" + IdCount).send(((Player) player).getPlayer());
                        all.sendMessage("");
                        player.sendMessage("§eJogador punido com sucesso.");
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                        calendar.add(Calendar.HOUR, 1);
                        PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, "none", "none", "none", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime())));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas("none");
                        API.getAccount(jogador).setTipo(tipo);
                    }
                }
            } else {
                if (provas.startsWith("https://")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                        all.sendMessage("");
                        new FancyMessage(" §c» ").text("§c" + API.getAccount(jogador).getPlayerName() + " §cfoi §c" + msg + " §cpor §c" + player.getName()).hover("§7Clique §7para §7mais §7informações").command("/checkpunish " + IdCount).send(((Player) player).getPlayer());
                        new FancyMessage(" §c» ").text("§cMotivo: §c" + motivo).hover("§7Clique para mais informações").command("/checkpunish #" + IdCount).send(((Player) player).getPlayer());
                        all.sendMessage("");
                        player.sendMessage("§eJogador punido com sucesso.");
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                        calendar.add(Calendar.HOUR, 1);
                        PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, "none", "none", "none", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime())));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas(provas);
                        API.getAccount(jogador).setTipo(tipo);
                    }
                } else {
                    if (provas.startsWith("http://")) {
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                                all.sendMessage("");
                                new FancyMessage(" §c» ").text("§c" + API.getAccount(jogador).getPlayerName() + " §cfoi §c" + msg + " §cpor §c" + player.getName()).hover("§7Clique §7para §7mais §7informações").command("/checkpunish " + IdCount).send(((Player) player).getPlayer());
                                new FancyMessage(" §c» ").text("§cMotivo: §c" + motivo).hover("§7Clique §7para §7mais §7informações").command("/checkpunish #" + IdCount).send(((Player) player).getPlayer());
                                all.sendMessage("");
                                player.sendMessage("§eJogador punido com sucesso.");
                                long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                            calendar.add(Calendar.HOUR, 1);
                                PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, "none", "none", "none", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime())));
                                API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                                API.getAccount(jogador).setAutor(player.getName());
                                API.getAccount(jogador).setMotivo(motivo);
                                API.getAccount(jogador).setID(IdCount);
                                API.getAccount(jogador).setProvas(provas);
                                API.getAccount(jogador).setTipo(tipo);
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
                        Bukkit.getConsoleSender().sendMessage("");
                        Bukkit.getConsoleSender().sendMessage(" §c» " + API.getAccount(jogador).getPlayerName() + " foi " + msg + " por " + player.getName());
                        Bukkit.getConsoleSender().sendMessage(" §c» Motivo: " + motivo);
                        Bukkit.getConsoleSender().sendMessage("");
                        player.sendMessage("§eJogador punido com sucesso.");
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                        calendar.add(Calendar.HOUR, 1);
                        PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, "none", "none", "none", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime())));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas("none");
                        API.getAccount(jogador).setTipo(tipo);
                }
            } else {
                if (provas.startsWith("https://")) {
                    int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                    Bukkit.getConsoleSender().sendMessage("");
                    Bukkit.getConsoleSender().sendMessage(" §c» " + API.getAccount(jogador).getPlayerName() + " foi " + msg + " por " + player.getName());
                    Bukkit.getConsoleSender().sendMessage(" §c» Motivo: " + motivo + " - " + provas);
                    Bukkit.getConsoleSender().sendMessage("");
                    player.sendMessage("§eJogador punido com sucesso.");
                    long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                    calendar.add(Calendar.HOUR, 1);
                    PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, "none", "none", "none", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime())));
                    API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                    API.getAccount(jogador).setAutor(player.getName());
                    API.getAccount(jogador).setMotivo(motivo);
                    API.getAccount(jogador).setID(IdCount);
                    API.getAccount(jogador).setProvas(provas);
                    API.getAccount(jogador).setTipo(tipo);
                } else {
                    if (provas.startsWith("http://")) {
                        int IdCount = PunishmentAccount.accountsPunicoes.size() + 1;
                        Bukkit.getConsoleSender().sendMessage("");
                        Bukkit.getConsoleSender().sendMessage(" §c» " + API.getAccount(jogador).getPlayerName() + " foi " + msg + " por " + player.getName());
                        Bukkit.getConsoleSender().sendMessage(" §c» Motivo: " + motivo + " - " + provas);
                        Bukkit.getConsoleSender().sendMessage("");
                        player.sendMessage("§eJogador punido com sucesso.");
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                        calendar.add(Calendar.HOUR, 1);
                        PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo, "none", "none", "none", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(calendar.getTime())));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas(provas);
                        API.getAccount(jogador).setTipo(tipo);
                    } else {
                        Bukkit.getConsoleSender().sendMessage("§cAs provas inseridas são consideradas inválidas.");
                    }
                }
            }
        }
        return player + jogador + provas + motivo + tempo;
    }

}
