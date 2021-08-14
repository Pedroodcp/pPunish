package br.com.pedrodcp.ppunish.gui;

import br.com.pedrodcp.ppunish.api.API;
import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.utils.Scroller;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static br.com.pedrodcp.ppunish.commands.checkpunish.*;

public class Punishments {

    protected String keyProvas;
    protected String keyCor;
    protected String keyStatus;

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
                        if (key.getProvas().equalsIgnoreCase("none")) {
                            keyProvas = "Não informado.";
                        } else {
                            keyProvas = key.getProvas();
                        }
                        if (String.valueOf(API.getAccount(key.getPlayerName()).getID()).contains(String.valueOf(key.getID()))) {
                            keyCor = "§a";
                            keyStatus = "§aAtiva.";
                        } else {
                            keyCor = "§c";
                            keyStatus = "§cExpirada.";
                        }
                        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
                        skullMeta.setOwner(key.getPlayerName());
                        skullMeta.setDisplayName(keyCor + key.getMotivo());
                        skullMeta.setLore(Arrays.asList(
                                "",
                                "§7ID: §f#" + key.getID(),
                                "§7Infrator: §f" + key.getPlayerName(),
                                "§7Autor: §f" + key.getAutor(),
                                // "§7Data: §f" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()), //
                                "",
                                "§7Motivo: §f" + key.getMotivo(),
                                "§7Tipo: §f" + key.getTipo(),
                                "§7Provas: §f" + keyProvas,
                                "",
                                "§7Status: " + keyStatus,
                                "",
                                "§eClique para mais detalhes."
                                ));
                        item.setItemMeta(skullMeta);
                        Integer i = Collections.max(listItens);
                        if (itens.size() < i) {
                            itens.add(item);
                        }
                    }
                });
                if (itens.size() == 0) {
                    p.sendMessage("§cEste jogador não possui um histórico de punições.");
                    return;
                }

                Scroller scroller = new Scroller.ScrollerBuilder()
                        .withSize(54)
                        .withName("§8Punições de " + API.getAccount(playerName).getPlayerName())
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
                                            p.openInventory(new PlayerPunishmentInfo().getInventory());
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
