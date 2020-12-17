package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DB {

    protected static String URL = "jdbc:mysql://localhost:3306/db?useUnicode=true&serverTimezone=UTC";
    protected static String NAME = "root";
    protected static String PASS = "root";

    public static boolean Test(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASS);
            if (!connection.isClosed()) {
                //System.out.println("Соединение с БД установлено");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
           // System.out.println("Соединение с БД НЕ установлено");
        }
        return false;
    }
    public Connection getDBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection;
        connection = DriverManager.getConnection(URL, NAME, PASS);
        return  connection;
    }
    public void registration(User user){
        String inser = String.format("INSERT INTO `db`.`users` (`surname`, `name`, `password`) VALUES ('%s','%s','%s');",user.getSurname(),user.getName(),user.getPassword());
        try {
            PreparedStatement statement = getDBConnection().prepareStatement(inser);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Boolean getUser(User user){
        String select =  String.format("SELECT * FROM db.users WHERE surname = '%s' AND password = '%s';",user.getSurname(),user.getPassword());
        try {
            Statement statement = getDBConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            int x = 0;
            while (resultSet.next()){
                x++;
            }
            if(x >= 1){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ObservableList<String> getEat (String st){
        String select =  String.format("SELECT * FROM db.eat WHERE repast = '%s';",st);
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Statement statement = getDBConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                list.add(resultSet.getString("eat"));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
