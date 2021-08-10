package br.com.pedrodcp.ppunish.models;

import java.util.ArrayList;

public class Account {

    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Account> accountsPunicoes = new ArrayList<>();

    private String playerName;
    private String autor;
    private String tempo;
    private String motivo;
    private int id;
    private String provas;
    private String tipo;

    public Account(String playerName, String autor, long tempo, String motivo, int id, String provas, String tipo) {
        this.playerName = playerName;
        this.autor = autor;
        this.tempo = String.valueOf(tempo);
        this.motivo = motivo;
        this.id = id;
        this.provas = provas;
        this.tipo = tipo;
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

}
