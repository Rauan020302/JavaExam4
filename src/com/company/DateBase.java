package com.company;

import java.sql.*;

public class DateBase {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "020302maks";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connetion successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public static boolean insertNews(News news){
        String sql = "INSERT INTO news(news_id,news_heading,news_text,news_time)" +
                "VALUES(?, ?, ?, now())";

        int result = 0;
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,news.getId());
            stmt.setString(2,news.getHeading());
            stmt.setString(3,news.getText());



            result = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return result > 0;
    }

    public static void getInfoAboutNews(){
        String sql = "SELECT news_heading, news_text FROM news";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getString(1) + "\n " + rs.getString(2));
            }
        }
        catch (SQLException ex ){
            System.out.println(ex.getMessage());
        }
    }

    public static boolean deleteNews(int id){
        String sql = "DELETE FROM news WHERE news_id = ?";

        int result = 0;
        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);

            result = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result > 0;
    }

    public static boolean setNewsTextAndHeading(News news) {
        String sql = "UPDATE news SET news_heading = ?,news_text = ?" +
                "WHERE news_id = ?";
        int result = 0;

        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,news.getHeading());
            stmt.setString(2,news.getText());
            stmt.setInt(3,news.getId());

            result = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result > 0;
    }

}


