package br.com.pedrodcp.ppunish.commands.PunishEvents;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.Account;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class onPlayerPunished {

    public static String PlayerMuted(CommandSender player, String jogador, String provas, String motivo, int tempo, String tipo, String msg) {
        if (player instanceof Player) {
            if (provas.equalsIgnoreCase("none")) {
                if (!player.hasPermission("ppunish.admin")) {
                    player.sendMessage("§cSomente administradores e superiores podem punir sem provas.");
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (Bukkit.getPlayer(jogador) == null) {
                            all.sendMessage("");
                            all.sendMessage("§c• " + jogador + " foi " + msg + " por " + player.getName());
                            all.sendMessage("§c• Motivo: " + motivo);
                            all.sendMessage("");
                            int IdCount = Account.accountsPunicoes.size() + 1;
                            player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                            long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                            API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                            API.getAccount(jogador).setAutor(player.getName());
                            API.getAccount(jogador).setMotivo(motivo);
                            API.getAccount(jogador).setID(IdCount);
                            API.getAccount(jogador).setProvas("none");
                            API.getAccount(jogador).setTipo(tipo);
                        } else {
                            all.sendMessage("");
                            all.sendMessage("§c• " + Bukkit.getPlayer(jogador).getName() + " foi " + msg + " por " + player.getName());
                            all.sendMessage("§c• Motivo: " + motivo);
                            all.sendMessage("");
                            int IdCount = Account.accountsPunicoes.size() + 1;
                            player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                            long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                            API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                            API.getAccount(jogador).setAutor(player.getName());
                            API.getAccount(jogador).setMotivo(motivo);
                            API.getAccount(jogador).setID(IdCount);
                            API.getAccount(jogador).setProvas("none");
                            API.getAccount(jogador).setTipo(tipo);
                            if (API.getAccount(jogador).getTipo().equalsIgnoreCase("BAN")) {
                                Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                            } else {
                                if (API.getAccount(jogador).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                                    Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                                }
                            }
                        }
                    }
                }
            } else {
                if (provas.startsWith("https://")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (Bukkit.getPlayer(jogador) == null) {
                            all.sendMessage("");
                            all.sendMessage("§c• " + jogador + " foi " + msg + " por " + player.getName());
                            all.sendMessage("§c• Motivo:" + motivo + " - " + provas);
                            all.sendMessage("");
                            int IdCount = Account.accountsPunicoes.size() + 1;
                            player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                            long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                            API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                            API.getAccount(jogador).setAutor(player.getName());
                            API.getAccount(jogador).setMotivo(motivo);
                            API.getAccount(jogador).setID(IdCount);
                            API.getAccount(jogador).setProvas(provas);
                            API.getAccount(jogador).setTipo(tipo);
                        } else {
                            all.sendMessage("");
                            all.sendMessage("§c• " + Bukkit.getPlayer(jogador).getName() + " foi " + msg + " por " + player.getName());
                            all.sendMessage("§c• Motivo: " + motivo + " - " + provas);
                            all.sendMessage("");
                            int IdCount = Account.accountsPunicoes.size() + 1;
                            player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                            long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                            API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                            API.getAccount(jogador).setAutor(player.getName());
                            API.getAccount(jogador).setMotivo(motivo);
                            API.getAccount(jogador).setID(IdCount);
                            API.getAccount(jogador).setProvas(provas);
                            API.getAccount(jogador).setTipo(tipo);
                            if (API.getAccount(jogador).getTipo().equalsIgnoreCase("BAN")) {
                                Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                            } else {
                                if (API.getAccount(jogador).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                                    Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                                }
                            }
                        }
                    }
                } else {
                    if (provas.startsWith("http://")) {
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (Bukkit.getPlayer(jogador) == null) {
                                all.sendMessage("");
                                all.sendMessage("§c• " + jogador + " foi " + msg + " por " + player.getName());
                                all.sendMessage("§c• Motivo: " + motivo + " - " + provas);
                                all.sendMessage("");
                                int IdCount = Account.accountsPunicoes.size() + 1;
                                player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                                long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                                Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                                API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                                API.getAccount(jogador).setAutor(player.getName());
                                API.getAccount(jogador).setMotivo(motivo);
                                API.getAccount(jogador).setID(IdCount);
                                API.getAccount(jogador).setProvas(provas);
                                API.getAccount(jogador).setTipo(tipo);
                            } else {
                                all.sendMessage("");
                                all.sendMessage("§c• " + Bukkit.getPlayer(jogador).getName() + " foi " + msg + " por " + player.getName());
                                all.sendMessage("§c• Motivo: " + motivo + " - " + provas);
                                all.sendMessage("");
                                int IdCount = Account.accountsPunicoes.size() + 1;
                                player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                                long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                                Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                                API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                                API.getAccount(jogador).setAutor(player.getName());
                                API.getAccount(jogador).setMotivo(motivo);
                                API.getAccount(jogador).setID(IdCount);
                                API.getAccount(jogador).setProvas(provas);
                                API.getAccount(jogador).setTipo(tipo);
                                if (API.getAccount(jogador).getTipo().equalsIgnoreCase("BAN")) {
                                    Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                                } else {
                                    if (API.getAccount(jogador).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                                        Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
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
                    if (Bukkit.getPlayer(jogador) == null) {
                        Bukkit.getConsoleSender().sendMessage("");
                        Bukkit.getConsoleSender().sendMessage("§c " + jogador + " foi " + msg + " por " + player.getName());
                        Bukkit.getConsoleSender().sendMessage("§c Motivo: " + motivo);
                        Bukkit.getConsoleSender().sendMessage("");
                        int IdCount = Account.accountsPunicoes.size() + 1;
                        player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas("none");
                        API.getAccount(jogador).setTipo(tipo);
                    } else {
                        Bukkit.getConsoleSender().sendMessage("");
                        Bukkit.getConsoleSender().sendMessage("§c• " + Bukkit.getPlayer(jogador).getName() + " foi " + msg + " por " + player.getName());
                        Bukkit.getConsoleSender().sendMessage("§c• Motivo: " + motivo);
                        Bukkit.getConsoleSender().sendMessage("");
                        int IdCount = Account.accountsPunicoes.size() + 1;
                        player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                        long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                        Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                        API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                        API.getAccount(jogador).setAutor(player.getName());
                        API.getAccount(jogador).setMotivo(motivo);
                        API.getAccount(jogador).setID(IdCount);
                        API.getAccount(jogador).setProvas("none");
                        API.getAccount(jogador).setTipo(tipo);
                        if (API.getAccount(jogador).getTipo().equalsIgnoreCase("BAN")) {
                            Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                        } else {
                            if (API.getAccount(jogador).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                                Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                            }
                        }
                    }
                }
            } else {
                if (provas.startsWith("https://")) {
                        if (Bukkit.getPlayer(jogador) == null) {
                            Bukkit.getConsoleSender().sendMessage("");
                            Bukkit.getConsoleSender().sendMessage("§c• " + jogador + " foi " + msg + " por " + player.getName());
                            Bukkit.getConsoleSender().sendMessage("§c• Motivo:" + motivo + " - " + provas);
                            Bukkit.getConsoleSender().sendMessage("");
                            int IdCount = Account.accountsPunicoes.size() + 1;
                            player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                            long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                            API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                            API.getAccount(jogador).setAutor(player.getName());
                            API.getAccount(jogador).setMotivo(motivo);
                            API.getAccount(jogador).setID(IdCount);
                            API.getAccount(jogador).setProvas(provas);
                            API.getAccount(jogador).setTipo(tipo);
                        } else {
                            Bukkit.getConsoleSender().sendMessage("");
                            Bukkit.getConsoleSender().sendMessage("§c• " + Bukkit.getPlayer(jogador).getName() + " foi " + msg + " por " + player.getName());
                            Bukkit.getConsoleSender().sendMessage("§c• Motivo: " + motivo + " - " + provas);
                            Bukkit.getConsoleSender().sendMessage("");
                            int IdCount = Account.accountsPunicoes.size() + 1;
                            player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                            long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                            Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                            API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                            API.getAccount(jogador).setAutor(player.getName());
                            API.getAccount(jogador).setMotivo(motivo);
                            API.getAccount(jogador).setID(IdCount);
                            API.getAccount(jogador).setProvas(provas);
                            API.getAccount(jogador).setTipo(tipo);
                            if (API.getAccount(jogador).getTipo().equalsIgnoreCase("BAN")) {
                                Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                            } else {
                                if (API.getAccount(jogador).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                                    Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                                }
                            }
                        }
                } else {
                    if (provas.startsWith("http://")) {
                            if (Bukkit.getPlayer(jogador) == null) {
                                Bukkit.getConsoleSender().sendMessage("");
                                Bukkit.getConsoleSender().sendMessage("§c• " + jogador + " foi " + msg + " por " + player.getName());
                                Bukkit.getConsoleSender().sendMessage("§c• Motivo: " + motivo + " - " + provas);
                                Bukkit.getConsoleSender().sendMessage("");
                                int IdCount = Account.accountsPunicoes.size() + 1;
                                player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                                long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                                Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                                API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                                API.getAccount(jogador).setAutor(player.getName());
                                API.getAccount(jogador).setMotivo(motivo);
                                API.getAccount(jogador).setID(IdCount);
                                API.getAccount(jogador).setProvas(provas);
                                API.getAccount(jogador).setTipo(tipo);
                            } else {
                                Bukkit.getConsoleSender().sendMessage("");
                                Bukkit.getConsoleSender().sendMessage("§c• " + Bukkit.getPlayer(jogador).getName() + " foi " + msg + " por " + player.getName());
                                Bukkit.getConsoleSender().sendMessage("§c• Motivo: " + motivo + " - " + provas);
                                Bukkit.getConsoleSender().sendMessage("");
                                int IdCount = Account.accountsPunicoes.size() + 1;
                                player.sendMessage("§eJogador punido com sucesso. §e#" + IdCount);
                                long time = TimeUnit.MILLISECONDS.convert(tempo, TimeUnit.HOURS);
                                Account.accountsPunicoes.add(new Account(API.getAccount(jogador).getPlayerName(), player.getName(), System.currentTimeMillis() + time, motivo, IdCount, provas, tipo));
                                API.getAccount(jogador).setTempo(System.currentTimeMillis() + time);
                                API.getAccount(jogador).setAutor(player.getName());
                                API.getAccount(jogador).setMotivo(motivo);
                                API.getAccount(jogador).setID(IdCount);
                                API.getAccount(jogador).setProvas(provas);
                                API.getAccount(jogador).setTipo(tipo);
                                if (API.getAccount(jogador).getTipo().equalsIgnoreCase("BAN")) {
                                    Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                                } else {
                                    if (API.getAccount(jogador).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                                        Bukkit.getPlayer(jogador).kickPlayer("§cVocê foi banido!");
                                    }
                                }
                            }
                    } else {
                        Bukkit.getConsoleSender().sendMessage("§cAs provas inseridas são consideradas inválidas.");
                    }
                }
            }
        }
        return player + jogador + provas + motivo + tempo;
    }

}
