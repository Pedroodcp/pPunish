package br.com.pedrodcp.ppunish.managers;

public class TimeManager {

    public static String getTempo(long time) {
        long variacao = time;
        long varsegundos = variacao / 1000L % 60L;
        long varminutos = variacao / 60000L % 60L;
        long varhoras = variacao / 3600000L % 24L;
        long vardias = variacao / 86400000L % 7L;

        String segundos = String.valueOf(varsegundos).replaceAll("-", "");
        String minutos = String.valueOf(varminutos).replaceAll("-", "");
        String horas = String.valueOf(varhoras).replaceAll("-", "");
        String dias = String.valueOf(vardias).replaceAll("-", "");
        if (dias.equals("0") && horas.equals("0") && minutos.equals("0")) {
            return "" + segundos + "s";
        }
        if (dias.equals("0") && horas.equals("0")) {
            return "" + minutos + "m e " + segundos + "s";
        }
        if (dias.equals("0")) {
            return "" + horas + "h, " + minutos + "m e " + segundos + "s";
        }
        return "" + dias + "d, " + horas + "h, " + minutos + "m e " + segundos + "s";
    }

}
