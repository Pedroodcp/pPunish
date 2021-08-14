package br.com.pedrodcp.ppunish.events;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.gui.Punishments;
import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.utils.FancyMessage;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static br.com.pedrodcp.ppunish.gui.Punishments.*;
import static br.com.pedrodcp.ppunish.commands.checkpunish.*;

public class InventoryClick implements Listener {

    private Punishments gui = new Punishments();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getName().equals(API.getAccount(playerName).getPlayerName() + " - Punição #" + punishId)) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            ItemStack i = e.getCurrentItem();

            if (i.getType() == Material.BOOK) {
                for (Account account : Account.accountsPunicoes) {
                    if (account.getID() == punishId) {
                        if (!account.getProvas().equalsIgnoreCase("none")) {
                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 5F, 1.0F);
                            p.sendMessage("");
                            new FancyMessage("§c§l[PUNIÇÃO §c§l- §c§l#" + punishId + "§c§l] §c§l➜ §fClique ").text("§b§l§nAQUI").suggest(account.getProvas()).hover("§eAcesse §eas §eprovas §eda §epunição.").text(" §fpara §facessar §fas §fprovas §fda §fpunição.").send(p);
                            p.sendMessage("");
                        } else {
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5F, 1.0F);
                        }
                    }
                }
            } else {
                if (i.getType() == Material.BARRIER) {
                    for (Account account : Account.accountsPunicoes) {
                        if (account.getID() == punishId) {
                            if (account.getTempo() < System.currentTimeMillis()) {
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5F, 1.0F);
                            } else {
                                if (account.getAutor().equals(p.getName())) {
                                    p.playSound(p.getLocation(), Sound.CLICK, 5F, 1.0F);
                                    //
                                } else {
                                    if (p.hasPermission("ppunish.admin")) {
                                        p.playSound(p.getLocation(), Sound.CLICK, 5F, 1.0F);
                                        //
                                    } else {
                                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 5F, 1.0F);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (i.getType() == Material.SKULL_ITEM) {
                        p.playSound(p.getLocation(), Sound.CLICK, 5F, 1.0F);
                    } else {
                        if (i.getType() == Material.ARROW) {
                            p.playSound(p.getLocation(), Sound.CLICK, 5F, 1.0F);
                            gui.gameGUI(p);
                        }
                    }
                }
            }
        }
    }

}
