package br.com.pedrodcp.ppunish.gui;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Collections;

import static br.com.pedrodcp.ppunish.gui.Punishments.*;
import static br.com.pedrodcp.ppunish.commands.checkpunish.*;

public class PlayerPunishmentInfo {

    private Inventory inventory;

    protected String keyProvas;
    protected String keyCor;
    protected String keyStatus;

    public PlayerPunishmentInfo() {
        inventory = Bukkit.createInventory(null, 9 * 4, API.getAccount(playerName).getPlayerName() + " - Punição #" + punishId);
        setItens();
    }

    private void setItens() {
        ItemStack book1 = new Item(Material.BOOK, 1, (short) 0)
                .setName("§aProvas")
                .setLore(Arrays.asList("§7Clique para visualizar as provas", "§7desta punição."))
                .getItemStack();

        ItemStack book2 = new Item(Material.BOOK, 1, (short) 0)
                .setName("§aProvas")
                .setLore(Arrays.asList("§7Esta punição não possui provas registradas.", "§7pelo autor da punição."))
                .getItemStack();

        for (Account account : Account.accountsPunicoes) {
            if (account.getID() == punishId) {
                if (account.getProvas().equalsIgnoreCase("none")) {
                    inventory.setItem(11, book2);
                } else {
                    inventory.setItem(11, book1);
                }
            }
        }

        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setOwner(playerName);
        for (Account account : Account.accountsPunicoes) {
            if (account.getID() == punishId) {
                if (account.getProvas().equalsIgnoreCase("none")) {
                    keyProvas = "Não informado.";
                } else {
                    keyProvas = account.getProvas();
                }
                if (String.valueOf(API.getAccount(account.getPlayerName()).getID()).contains(String.valueOf(account.getID()))) {
                    keyCor = "§a";
                    keyStatus = "§aAtiva.";
                } else {
                    keyCor = "§c";
                    keyStatus = "§cExpirada.";
                }
                skullMeta.setDisplayName(keyCor + account.getMotivo());
                skullMeta.setLore(Arrays.asList(
                        "",
                        "§7ID: §f#" + account.getID(),
                        "§7Infrator: §f" + account.getPlayerName(),
                        "§7Autor: §f" + account.getAutor(),
                        // "§7Data: §f" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()), //
                        "",
                        "§7Motivo: §f" + account.getMotivo(),
                        "§7Tipo: §f" + account.getTipo(),
                        "§7Provas: §f" + keyProvas,
                        "",
                        "§7Status: " + keyStatus
                ));
            }
            head.setItemMeta(skullMeta);
            inventory.setItem(13, head);
        }

        ItemStack barrier1 = new Item(Material.BARRIER, 1, (short) 0)
                .setName("§cRevogar Punição")
                .setLore(Collections.singletonList("§7Clique para revogar esta punição."))
                .getItemStack();

        ItemStack barrier2 = new Item(Material.BARRIER, 1, (short) 0)
                .setName("§cRevogar Punição")
                .setLore(Arrays.asList("§7Somente '" + API.getAccount(playerName).getAutor() + "' pode", "§7revogar esta punição."))
                .getItemStack();

        ItemStack barrier3 = new Item(Material.BARRIER, 1, (short) 0)
                .setName("§cRevogar Punição")
                .setLore(Collections.singletonList("§7Esta punição já expirou."))
                .getItemStack();

        ItemStack arrow = new Item(Material.ARROW, 1, (short) 0)
                .setName("§aVoltar")
                .setLore(Arrays.asList("§7Volte para a página de punições", "§7do jogador " + API.getAccount(playerName).getPlayerName() + "."))
                .getItemStack();

        inventory.setItem(31, arrow);

        for (Account account : Account.accountsPunicoes) {
            if (account.getID() == punishId) {
                if (String.valueOf(API.getAccount(account.getPlayerName()).getID()).contains(String.valueOf(account.getID()))) {
                    if (account.getAutor().equalsIgnoreCase(autorName)) {
                        inventory.setItem(15, barrier1);
                    } else {
                        if (Bukkit.getPlayer(autorName) != null) {
                            if (Bukkit.getPlayer(autorName).hasPermission("ppunish.admin")) {
                                inventory.setItem(15, barrier1);
                            } else {
                                inventory.setItem(15, barrier2);
                            }
                        }
                    }
                } else {
                    inventory.setItem(15, barrier3);
                }
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
