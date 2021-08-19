package br.com.pedrodcp.ppunish.models;

import java.util.ArrayList;

public class PunishmentAccount {

    public static ArrayList<PunishmentAccount> accountsPunicoes = new ArrayList<>();

    private String playerName;
    private String autor;
    private String tempo;
    private String motivo;
    private int id;
    private String provas;
    private String tipo;
    private String data;
    private String unpunish_autor;
    private String unpunish_motivo;
    private String unpunish_data;

    public PunishmentAccount(String playerName, String autor, long tempo, String motivo, int id, String provas, String tipo, String data, String unpunish_autor, String unpunish_motivo, String unpunish_data) {
        this.playerName = playerName;
        this.autor = autor;
        this.tempo = String.valueOf(tempo);
        this.motivo = motivo;
        this.id = id;
        this.provas = provas;
        this.tipo = tipo;
        this.data = data;
        this.unpunish_autor = unpunish_autor;
        this.unpunish_motivo = unpunish_motivo;
        this.unpunish_data = unpunish_data;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getTempo() {
        return Long.parseLong(tempo);
    }

    public void setTempo(long tempo) {
        this.tempo = String.valueOf(tempo);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getProvas() {
        return provas;
    }

    public void setProvas(String provas) {
        this.provas = provas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUnpunish_autor() {
        return unpunish_autor;
    }

    public void setUnpunish_autor(String unpunish_autor) {
        this.unpunish_autor = unpunish_autor;
    }

    public String getUnpunish_motivo() {
        return unpunish_motivo;
    }

    public void setUnpunish_motivo(String unpunish_motivo) {
        this.unpunish_motivo = unpunish_motivo;
    }

    public String getUnpunish_data() {
        return unpunish_data;
    }

    public void setUnpunish_data(String unpunish_data) {
        this.unpunish_data = unpunish_data;
    }

}
