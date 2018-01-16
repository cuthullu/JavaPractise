package demo;

import demo.dbs.SimpleConnection;

public class ConnectionRunner {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SimpleConnection simpleConnection = new SimpleConnection();

        simpleConnection.runStatement();
        simpleConnection.runPreparedStatement();
        simpleConnection.runCallableStatement();
    }
}
