package com.example.ns;

import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database extends AsyncTask<String, Void, String>{

        private Connection connection;
        private Statement statement;
        private ResultSet resultSet;
        private String result = "";

        protected String doInBackground(String... queries) {
            String query = queries[0];
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/id20624955_netsshield1", "id20624955_netsshield", "HeidyMilito*1");
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    result += resultSet.getString("column_name_1") + "\n";
                    result += resultSet.getString("column_name_2") + "\n";
                    // Add more columns as needed
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return result;
        }

        protected void onPostExecute(String result) {
            // Do something with the result
        }
    }
