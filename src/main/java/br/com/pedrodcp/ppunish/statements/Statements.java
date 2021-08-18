package br.com.pedrodcp.ppunish.statements;

import br.com.pedrodcp.ppunish.models.Account;
import br.com.pedrodcp.ppunish.models.PunishmentAccount;
import br.com.pedrodcp.ppunish.pPunish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statements {

    private static Connection connection;

    private static void openConnection() {
        Statements.connection = pPunish.connectionModel.getConnection();
    }

    public static void initialize() {
        try {
            openConnection();
            PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS ppunish_registro (nome varchar(16), autor text, tempo long, motivo text, id int, provas text, tipo text)");
            PreparedStatement st2 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS ppunish_punicoes (nome varchar(16), autor text, tempo long, motivo text, id int, provas text, tipo text, unpunish_autor text, unpunish_motivo text, unpunish_data text)");
            st.executeUpdate();
            st.close();
            st2.executeUpdate();
            st2.close();
            loadAccounts();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadAccounts() {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM ppunish_registro");
            PreparedStatement st2 = connection.prepareStatement("SELECT * FROM ppunish_punicoes");
            ResultSet rs = st.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            while (rs.next()) Account.accounts.add(new Account(rs.getString("nome"), rs.getString("autor"), rs.getLong("tempo"), rs.getString("motivo"), rs.getInt("id"), rs.getString("provas"), rs.getString("tipo")));
            while (rs2.next()) PunishmentAccount.accountsPunicoes.add(new PunishmentAccount(rs2.getString("nome"), rs2.getString("autor"), rs2.getLong("tempo"), rs2.getString("motivo"), rs2.getInt("id"), rs2.getString("provas"), rs2.getString("tipo"), rs2.getString("unpunish_autor"), rs2.getString("unpunish_motivo"), rs2.getString("unpunish_data")));
            rs.close();
            rs2.close();
            st.close();
            st2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean exists(String playerName) {
        boolean exists = false;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT nome FROM ppunish_registro WHERE nome=?");
            st.setString(1, playerName.toLowerCase());
            ResultSet rs = st.executeQuery();
            exists = rs.next();
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    private static boolean existsId(int ID) {
        boolean exists = false;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT nome FROM ppunish_punicoes WHERE id=?");
            st.setInt(1, ID);
            ResultSet rs = st.executeQuery();
            exists = rs.next();
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("[pPunish - Logs] Houve um erro ao salvar o ID de uma punição.");
        }
        return exists;
    }

    public static void saveAccounts() {
        try {
            openConnection();
            PreparedStatement existsStatement = connection.prepareStatement("UPDATE ppunish_registro SET autor=?, tempo=?, motivo=?, id=?, provas=?, tipo=? where nome=?");
            PreparedStatement st = connection.prepareStatement("INSERT INTO ppunish_registro (nome, autor, tempo, motivo, id, provas, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)");
            for (Account account : Account.accounts) {
                if (exists(account.getPlayerName())) {
                    existsStatement.setString(1, account.getAutor());
                    existsStatement.setLong(2, account.getTempo());
                    existsStatement.setString(3, account.getMotivo());
                    existsStatement.setInt(4, account.getID());
                    existsStatement.setString(5, account.getProvas());
                    existsStatement.setString(6, account.getTipo());
                    existsStatement.setString(7, account.getPlayerName());
                    existsStatement.executeUpdate();
                } else {
                    st.setString(1, account.getPlayerName());
                    st.setString(2, account.getAutor());
                    st.setLong(3, account.getTempo());
                    st.setString(4, account.getMotivo());
                    st.setInt(5, account.getID());
                    st.setString(6, account.getProvas());
                    st.setString(7, account.getTipo());
                    st.executeUpdate();
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveAccountsPunicoes() {
        try {
            openConnection();
            PreparedStatement st2 = connection.prepareStatement("INSERT INTO ppunish_punicoes (nome, autor, tempo, motivo, id, provas, tipo, unpunish_autor, unpunish_motivo, unpunish_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (PunishmentAccount account : PunishmentAccount.accountsPunicoes) {
                if (exists(account.getPlayerName())) {
                    if (!existsId(account.getID())) {
                        st2.setString(1, account.getPlayerName());
                        st2.setString(2, account.getAutor());
                        st2.setLong(3, account.getTempo());
                        st2.setString(4, account.getMotivo());
                        st2.setInt(5, account.getID());
                        st2.setString(6, account.getProvas());
                        st2.setString(7, account.getTipo());
                        st2.setString(8, account.getUnpunish_autor());
                        st2.setString(9, account.getUnpunish_motivo());
                        st2.setString(10, account.getUnpunish_data());
                        st2.executeUpdate();
                    }
                } else {
                    st2.setString(1, account.getPlayerName());
                    st2.setString(2, account.getAutor());
                    st2.setLong(3, account.getTempo());
                    st2.setString(4, account.getMotivo());
                    st2.setInt(5, account.getID());
                    st2.setString(6, account.getProvas());
                    st2.setString(7, account.getTipo());
                    st2.setString(8, account.getUnpunish_autor());
                    st2.setString(9, account.getUnpunish_motivo());
                    st2.setString(10, account.getUnpunish_data());
                    st2.executeUpdate();
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
