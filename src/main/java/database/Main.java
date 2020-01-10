package database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbs:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345trip";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            Class.forName("com.mysql.cj.jdbc.Driver"); //нужен ли он ??

            System.out.println(driver.toString());
            System.out.println("Драйвер успешно зарегистрирован");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Не удалось загрузить класс драйвера");
        }

        try {

            connection = DriverManager.getConnection(URL,
                    USERNAME, PASSWORD);
            System.out.println(connection);

                if(! connection.isClosed()){
                    System.out.println("Соединение установлено");
                }
        }catch (SQLException e){
            System.err.println("Соединение не установлено");
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение закрыто");
            }

        }


    }
}
