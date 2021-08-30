package br.com.pedrodcp.ppunish.events;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.managers.TimeManager;
import br.com.pedrodcp.ppunish.models.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    private static String motivo;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (API.getAccount(p.getName()) == null) {
            Account.accounts.add(new Account(p.getName(), "none", 0, "none", 0, "none", "none"));
        }
        if (API.getAccount(p.getName()).getTempo() != 0) {
            if (API.getAccount(p.getName()).getTipo().equalsIgnoreCase("BAN")) {
                p.kickPlayer("§cVocê foi banido! Seu ID é §e#" + API.getAccount(p.getName()).getID());
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
                        p.kickPlayer("§cVocê foi banido! Seu ID é §e#" + API.getAccount(p.getName()).getID());
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
                p.sendMessage(" §c* Você está silenciado por " + TimeManager.getTempo(dif) + ".");
                p.sendMessage("");
                p.sendMessage(" §c* Motivo: " + motivo);
                p.sendMessage(" §c* ID: §e#" + API.getAccount(p.getName()).getID());
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
