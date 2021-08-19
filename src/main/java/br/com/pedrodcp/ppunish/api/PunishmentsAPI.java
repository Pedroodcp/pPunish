package br.com.pedrodcp.ppunish.api;

import br.com.pedrodcp.ppunish.models.PunishmentAccount;
import org.bukkit.entity.Player;

public class PunishmentsAPI {

    public static PunishmentAccount getAccount(Player player) {
        return getAccount(player.getName());
    }

    public static PunishmentAccount getAccount(String player) {
        for (PunishmentAccount account : PunishmentAccount.accountsPunicoes)
            if (account.getPlayerName().equalsIgnoreCase(player)) return account;
        return null;
    }

    public static boolean setAutor(String player, String autor) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setAutor(autor);
        return true;
    }

    public static boolean getAutor(String player, String autor) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getAutor() == autor;
    }

    public static boolean setTempo(String player, long tempo) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setTempo(tempo);
        return true;
    }

    public static boolean getTempo(String player, long tempo) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getTempo() == tempo;
    }

    public static boolean setMotivo(String player, String motivo) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setMotivo(motivo);
        return true;
    }

    public static boolean getMotivo(String player, String motivo) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getMotivo() == motivo;
    }

    public static boolean setID(String player, int id) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setID(id);
        return true;
    }

    public static boolean getID(String player, int id) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getID() == id;
    }

    public static boolean setProvas(String player, String provas) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setProvas(provas);
        return true;
    }

    public static boolean getProvas(String player, String provas) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getProvas() == provas;
    }

    public static boolean setTipo(String player, String tipo) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setTipo(tipo);
        return true;
    }

    public static boolean getTipo(String player, String tipo) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getTipo() == tipo;
    }

    public static boolean setData(String player, String data) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setData(data);
        return true;
    }

    public static boolean getData(String player, String data) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getData() == data;
    }

    public static boolean setUnpunishAutor(String player, String autor) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setUnpunish_autor(autor);
        return true;
    }

    public static boolean getUnpunishAutor(String player, String autor) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getUnpunish_autor() == autor;
    }

    public static boolean setUnpunishMotivo(String player, String motivo) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setUnpunish_motivo(motivo);
        return true;
    }

    public static boolean getUnpunishMotivo(String player, String motivo) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getUnpunish_motivo() == motivo;
    }

    public static boolean setUnpunishData(String player, String data) {
        PunishmentAccount account = getAccount(player);
        if (account == null) return false;
        account.setUnpunish_data(data);
        return true;
    }

    public static boolean getUnpunishData(String player, String data) {
        PunishmentAccount account = getAccount(player);
        return account != null && account.getUnpunish_data() == data;
    }

    //

    public static boolean setAutor(Player player, String ID) {
        return setAutor(player.getName(), ID);
    }

    public static boolean getAutor(Player player, String ID) {
        return getAutor(player.getName(), ID);
    }

    public static boolean setTempo(Player player, long tempo) {
        return setTempo(player.getName(), tempo);
    }

    public static boolean getTempo(Player player, long tempo) {
        return getTempo(player.getName(), tempo);
    }

    public static boolean setMotivo(Player player, String motivo) {
        return setMotivo(player.getName(), motivo);
    }

    public static boolean getMotivo(Player player, String motivo) {
        return getMotivo(player.getName(), motivo);
    }

    public static boolean setID(Player player, int id) {
        return setID(player.getName(), id);
    }

    public static boolean getID(Player player, int id) {
        return setID(player.getName(), id);
    }

    public static boolean setProvas(Player player, String provas) {
        return setProvas(player.getName(), provas);
    }

    public static boolean getProvas(Player player, String provas) {
        return getProvas(player.getName(), provas);
    }

    public static boolean setTipo(Player player, String tipo) {
        return setTipo(player.getName(), tipo);
    }

    public static boolean getTipo(Player player, String tipo) {
        return getTipo(player.getName(), tipo);
    }

    public static boolean getData(Player player, String data) {
        return getData(player.getName(), data);
    }

    public static boolean setData(Player player, String data) {
        return setData(player.getName(), data);
    }

    public static boolean setUnpunishAutor(Player player, String autor) {
        return setUnpunishAutor(player.getName(), autor);
    }

    public static boolean getUnpunishAutor(Player player, String autor) {
        return getUnpunishAutor(player.getName(), autor);
    }

    public static boolean getUnpunishMotivo(Player player, String motivo) {
        return getUnpunishMotivo(player.getName(), motivo);
    }

    public static boolean setUnpunishMotivo(Player player, String motivo) {
        return setUnpunishMotivo(player.getName(), motivo);
    }

    public static boolean getUnpunishData(Player player, String data) {
        return getUnpunishData(player.getName(), data);
    }

    public static boolean setUnpunishData(Player player, String data) {
        return setUnpunishData(player.getName(), data);
    }

}
