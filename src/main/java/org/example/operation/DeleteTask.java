package org.example.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTask implements TaskOpr {
    TaskOpr opr = new Show();
    Scanner sc = new Scanner(System.in);
    String url = "jdbc:mysql://127.0.0.1:3306/taskmanger";
    String username = "root";
    String password = "MediLink@2026";

    @Override
    public void operation() {
        opr.operation();

        System.out.println("Enter the Task id:");
        int id = sc.nextInt();

        String sql = """
                 DELETE FROM task WHERE id = ?
                """;

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);
        ) {
             st.setInt(1,id);
             int result = st.executeUpdate();
             if(result==0){
                 System.out.println("Task is not deleted");

             }
             else{
                 System.out.println("Task is deleted");
             }
        }
        catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }


    }
}


