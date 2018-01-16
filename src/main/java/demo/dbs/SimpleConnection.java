package demo.dbs;

import java.sql.*;

public class SimpleConnection {

    public void runCallableStatement() {
        System.out.println("Callable statement");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/appstore", "appstoredev", "appstoredev");

            String sql = "{call getUserEmail (?, ?)}";
            CallableStatement c = connection.prepareCall(sql);
            c.setInt(1, 104);
            c.executeQuery();
            String email = c.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void runPreparedStatement() {
        System.out.println("Prepared statement");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/appstore", "appstoredev", "appstoredev");

            PreparedStatement p = connection.prepareStatement("SELECT  * FROM user WHERE id > ?");

            p.setInt(1, 100);
            ResultSet rs = p.executeQuery();



            printResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void runStatement() {
        System.out.println("Statement");

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/appstore", "appstoredev", "appstoredev");

            Statement s = connection.createStatement();

            ResultSet rs = s.executeQuery("SELECT * from user");

            printResultSet(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printResultSet(ResultSet rs ) throws SQLException {
        while(rs.next()) {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String username = rs.getString("username");

            System.out.println(id + " " + email + " " + username);
        }
    }
}


