package _NetworkChat.server;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/ServerDB.sqlite");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String getNickByLoginAndPass(String login, String pass,ClientHandler clientHandler) {

        String sql = String.format("select nickname,userID FROM userTable where" +
                " login = '%s' and password = '%s'", login, pass);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                clientHandler.userID = rs.getString(2);
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeClientNick(String newNickName, ClientHandler clientHandler) throws SQLException {
        String sql = String.format("UPDATE \"userTable\" SET \"nickname\" = '%s' WHERE \"userID\" = %s", newNickName, clientHandler.userID);
        try {
            stmt.executeUpdate(sql);
            clientHandler.nick = newNickName;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
