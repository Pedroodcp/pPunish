package br.com.pedrodcp.ppunish.gui;

import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.utils.Item;
import br.com.pedrodcp.ppunish.utils.Scroller;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static br.com.pedrodcp.ppunish.commands.checkpunish.*;

public class Punishments {

    private static final Pattern pattern = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");
    public static int punishId;

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
                    if (String.valueOf(key.getID()).equals(String.valueOf(account.getID()))) {
                        ItemStack item = new Item(Material.STAINED_GLASS_PANE, 1, (short) 14)
                                .setName("§c" + key.getMotivo())
                                .setLore(Arrays.asList(
                                        "",
                                        "§7ID: §f#" + key.getID(),
                                        "§7Infrator: §f" + key.getPlayerName(),
                                        "§7Autor: §f" + key.getAutor(),
                                        // "§7Data: §f" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()), //
                                        "",
                                        "§7Motivo: §f" + key.getMotivo(),
                                        "§7Tipo: §f" + key.getTipo(),
                                        "§7Provas: §f" + key.getProvas().replace("none", "Não informado."),
                                        "",
                                        "§eClique para mais detalhes."
                                ))
                                .getItemStack();
                        ItemMeta itemMeta = item.getItemMeta();
                        item.setItemMeta(itemMeta);
                        Integer i = Collections.max(listItens);
                        if (itens.size() < i) {
                            itens.add(item);
                        }
                    }
                });
                if (itens.size() == 0) {
                    p.sendMessage("§cEste jogador não possui histórico de punições.");
                    return;
                }

                Scroller scroller = new Scroller.ScrollerBuilder()
                        .withSize(54)
                        .withName("§8Registro de Punições")
                        .withItems(itens)
                        .withItemsSlots(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43)
                        .withArrowsSlots(45, 53)
                        .withOnClick(new Scroller.ChooseItemRunnable() {
                            @Override
                            public void run(Player player, ItemStack item) {
                                for (Account account : Account.accountsPunicoes) {
                                    if (account.getPlayerName().equalsIgnoreCase(playerName)) {
                                        Matcher m = pattern.matcher(item.getItemMeta().getLore().toString());
                                        if (m.find()) {
                                            String punishStringId = m.group(1);
                                            Double punishDoubleId = Double.parseDouble(punishStringId);
                                            punishId = punishDoubleId.intValue();
                                            System.out.println(punishId);
                                        } else {
                                            p.sendMessage("§cOcorreu um erro ao tentar abrir esta aba de informações.");
                                        }
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
