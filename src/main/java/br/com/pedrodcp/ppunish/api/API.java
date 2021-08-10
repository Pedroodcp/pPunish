package br.com.pedrodcp.ppunish.api;

import br.com.pedrodcp.ppunish.models.Account;
import org.bukkit.entity.Player;

public class API {

    public static Account getAccount(Player player) {
        return getAccount(player.getName());
    }

    public static Account getAccount(String player) {
        for (Account account : Account.accounts)
            if (account.getPlayerName().equalsIgnoreCase(player.toLowerCase())) return account;
        return null;
    }

    public static Account getAccountPunicoes(String player) {
        for (Account account : Account.accountsPunicoes)
            if (account.getPlayerName().equalsIgnoreCase(player.toLowerCase())) return account;
        return null;
    }

    public static boolean setAutor(String player, String autor) {
        Account account = getAccount(player);
        if (account == null) return false;
        account.setAutor(autor);
        return true;
    }

    public static boolean getAutor(String player, String autor) {
        Account account = getAccount(player);
        return account != null && account.getAutor() == autor;
    }

    public static boolean setTempo(String player, long tempo) {
        Account account = getAccount(player);
        if (account == null) return false;
        account.setTempo(tempo);
        return true;
    }

    public static boolean getTempo(String player, long tempo) {
        Account account = getAccount(player);
        return account != null && account.getTempo() == tempo;
    }

    public static boolean setMotivo(String player, String motivo) {
        Account account = getAccount(player);
        if (account == null) return false;
        account.setMotivo(motivo);
        return true;
    }

    public static boolean getMotivo(String player, String motivo) {
        Account account = getAccount(player);
        return account != null && account.getMotivo() == motivo;
    }

    public static boolean setID(String player, int id) {
        Account account = getAccount(player);
        if (account == null) return false;
        account.setID(id);
        return true;
    }

    public static boolean getID(String player, int id) {
        Account account = getAccount(player);
        return account != null && account.getID() == id;
    }

    public static boolean setProvas(String player, String provas) {
        Account account = getAccount(player);
        if (account == null) return false;
        account.setProvas(provas);
        return true;
    }

    public static boolean getProvas(String player, String provas) {
        Account account = getAccount(player);
        return account != null && account.getProvas() == provas;
    }

    public static boolean setTipo(String player, String tipo) {
        Account account = getAccount(player);
        if (account == null) return false;
        account.setTipo(tipo);
        return true;
    }

    public static boolean getTipo(String player, String tipo) {
        Account account = getAccount(player);
        return account != null && account.getTipo() == tipo;
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

}
