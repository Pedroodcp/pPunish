package br.com.pedrodcp.ppunish.events;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    private static String motivo;

    public static String getTempo(long time) {
        long variacao = time;
        long varsegundos = variacao / 1000L % 60L;
        long varminutos = variacao / 60000L % 60L;
        long varhoras = variacao / 3600000L % 24L;
        long vardias = variacao / 86400000L % 7L;

        String segundos = String.valueOf(varsegundos).replaceAll("-", "");
        String minutos = String.valueOf(varminutos).replaceAll("-", "");
        String horas = String.valueOf(varhoras).replaceAll("-", "");
        String dias = String.valueOf(vardias).replaceAll("-", "");
        if (dias.equals("0") && horas.equals("0") && minutos.equals("0")) {
            return "" + segundos + "s";
        }
        if (dias.equals("0") && horas.equals("0")) {
            return "" + minutos + "m e " + segundos + "s";
        }
        if (dias.equals("0")) {
            return "" + horas + "h, " + minutos + "m e " + segundos + "s";
        }
        return "" + dias + "d, " + horas + "h, " + minutos + "m e " + segundos + "s";
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (API.getAccount(p.getName()) == null) {
            Account.accounts.add(new Account(p.getName(), "none", 0, "none", 0, "none", "none"));
        }
        if (API.getAccount(p.getName()).getTempo() != 0) {
            if (API.getAccount(p.getName()).getTipo().equalsIgnoreCase("BAN")) {
                p.kickPlayer("§cVocê foi banido!");
            } else {
                if (API.getAccount(p.getName()).getTipo().equalsIgnoreCase("TEMP_BAN")) {
                    if (System.currentTimeMillis() > API.getAccount(p.getName()).getTempo()) {
                        API.getAccount(p.getName()).setTempo(0);
                        API.getAccount(p.getName()).setAutor("none");
                        API.getAccount(p.getName()).setMotivo("none");
                        API.getAccount(p.getName()).setID(0);
                        API.getAccount(p.getName()).setProvas("none");
                        API.getAccount(p.getName()).setTipo("none");
                    } else {
                        p.kickPlayer("§cVocê foi banido!");
                    }
                } else {
                    if (System.currentTimeMillis() > API.getAccount(p.getName()).getTempo()) {
                        API.getAccount(p.getName()).setTempo(0);
                        API.getAccount(p.getName()).setAutor("none");
                        API.getAccount(p.getName()).setMotivo("none");
                        API.getAccount(p.getName()).setID(0);
                        API.getAccount(p.getName()).setProvas("none");
                        API.getAccount(p.getName()).setTipo("none");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (API.getAccount(p.getName()) == null) {
            Account.accounts.add(new Account(p.getName(), "none", 0, "none", 0, "none", "none"));
        }
        if (API.getAccount(p.getName()).getTempo() != 0) {
            if (System.currentTimeMillis() > API.getAccount(p.getName()).getTempo()) {
                API.getAccount(p.getName()).setTempo(0);
                API.getAccount(p.getName()).setAutor("none");
                API.getAccount(p.getName()).setMotivo("none");
                API.getAccount(p.getName()).setID(0);
                API.getAccount(p.getName()).setProvas("none");
                API.getAccount(p.getName()).setTipo("none");
            }
        }
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (API.getAccount(p.getName()).getTempo() != 0) {
            if (System.currentTimeMillis() < API.getAccount(p.getName()).getTempo()) {
                long dif = API.getAccount(p.getName()).getTempo() - System.currentTimeMillis();
                e.setCancelled(true);
                if (API.getAccount(p.getName()).getProvas().equalsIgnoreCase("none")) {
                    motivo = API.getAccount(p.getName()).getMotivo();
                } else {
                    motivo = API.getAccount(p.getName()).getMotivo() + " - " + API.getAccount(p.getName()).getProvas();
                }
                p.sendMessage("");
                p.sendMessage(" §c* Você está silenciado por " + getTempo(dif) + ".");
                p.sendMessage("");
                p.sendMessage(" §c* Motivo: " + motivo);
                p.sendMessage(" §c* Autor: " + API.getAccount(p.getName()).getAutor());
                p.sendMessage(" §c* Crie um ticket de revisão em nosso Discord, acesse");
                p.sendMessage(" §e§nmineup.com.br/discord§c.");
                p.sendMessage("");
            } else {
                if (API.getAccount(p.getName()).getTempo() != 0) {
                    API.getAccount(p.getName()).setTempo(0);
                    API.getAccount(p.getName()).setAutor("none");
                    API.getAccount(p.getName()).setMotivo("none");
                    API.getAccount(p.getName()).setID(0);
                    API.getAccount(p.getName()).setProvas("none");
                    API.getAccount(p.getName()).setTipo("none");
                }
            }
        }
    }

}
