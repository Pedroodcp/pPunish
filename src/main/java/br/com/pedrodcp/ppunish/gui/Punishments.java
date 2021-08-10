package br.com.pedrodcp.ppunish.gui;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.utils.Item;
import br.com.pedrodcp.ppunish.utils.Scroller;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.*;

import static br.com.pedrodcp.ppunish.commands.checkpunish.*;

public class Punishments {

    public void gameGUI(Player p) {
        ArrayList<Integer> listItens = new ArrayList<>();
        for (Account account : Account.accountsPunicoes) {
            if (account.getPlayerName().equalsIgnoreCase(playerName)) {
                listItens.add(account.getID());
            }
        }
        //
        List<ItemStack> itens = new ArrayList<>();
        for (Account account : Account.accountsPunicoes) {
            if (account.getPlayerName().equalsIgnoreCase(playerName)) {
                Account.accountsPunicoes.forEach(key -> {
                    ItemStack itemGreen = new Item(Material.STAINED_GLASS_PANE, 1, (short) 5)
                            .setName("§a" + key.getMotivo())
                            .setLore(Arrays.asList(
                                    "",
                                    "§7ID: §f#" + key.getID(),
                                    "§7Player: §f" + key.getPlayerName(),
                                    "§7Autor: §fIndefinido",
                                    "§7Data: §f" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()),
                                    "§7Motivo: §fNenhum".replace("_", " "),
                                    "",
                                    "§aClique para mais detalhes."
                            ))
                            .getItemStack();
                    ItemMeta metaGreen = itemGreen.getItemMeta();
                    //
                    ItemStack itemRed = new Item(Material.STAINED_GLASS_PANE, 1, (short) 14)
                            .setName("§c" + key.getMotivo())
                            .setLore(Arrays.asList(
                                    "",
                                    "§7ID: §f#" + key.getID(),
                                    "§7Player: §f" + key.getPlayerName(),
                                    "§7Autor: §fIndefinido",
                                    "§7Data: §f" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()),
                                    "§7Motivo: §fNenhum".replace("_", " "),
                                    "",
                                    "§aClique para mais detalhes."
                            ))
                            .getItemStack();
                    ItemMeta metaRed = itemRed.getItemMeta();
                    if (itens.size() < listItens.size()) {
                        if (String.valueOf(API.getAccount(playerName).getID()).contains(String.valueOf(account.getID()))) {
                            itemGreen.setItemMeta(metaGreen);
                            itens.add(itemGreen);
                        } else {
                            itemRed.setItemMeta(metaRed);
                            itens.add(itemRed);
                        }
                    }
                });
                if (itens.size() == 0) {
                    p.sendMessage("§cEste jogador não possui histórico de punições.");
                    return;
                }

                Scroller scroller = new Scroller.ScrollerBuilder()
                        .withSize(54)
                        .withName("Punições")
                        .withItems(itens)
                        .withItemsSlots(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43)
                        .withArrowsSlots(45, 53)
                        .withOnClick(new Scroller.ChooseItemRunnable() {
                            @Override
                            public void run(Player player, ItemStack item) {
                                for (Account account : Account.accountsPunicoes) {
                                    if (account.getPlayerName().equalsIgnoreCase(playerName)) {
                                        Account.accountsPunicoes.forEach(key -> {
                                            if (item.getItemMeta().getDisplayName().replace("§a", "").equalsIgnoreCase(key.getPlayerName())) {
                                                p.sendMessage("§aTeste concluído!");
                                            }
                                        });
                                    }
                                }
                            }
                        })
                        .build();

                scroller.open(p);
            }
        }
    }

}
