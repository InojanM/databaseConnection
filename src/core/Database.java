
package core;

import java.sql.*;

public class Database {

    String username = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/student";

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public void create_commection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void select_all() {
        try {
            resultSet = statement.executeQuery("select * from students");
            System.out.println("Name \t\t Age");

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");


                System.out.println(name + " \t\t" + age);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name, int age) {
        try {
            String query = "INSERT INTO students (name , age)" + " VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String upname, String name, int age) {
        try {
            String query = "UPDATE students SET name = ? , age = ? " + "WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, upname);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String value) {

        try {
            String query = "DELETE FROM students WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}


