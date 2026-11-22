package org.example.operation;

import org.example.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Add implements TaskOpr{
    Task obj = new Task();
    Scanner sc = new Scanner(System.in);
    String url = "jdbc:mysql://127.0.0.1:3306/taskmanger";
    String username = "root";
    String password = "MediLink@2026";
    @Override
    public void operation() {
        System.out.println("Enter the id");
        int id = sc.nextInt();
        sc.nextLine();  // Consume leftover newline
        obj.setId(id);

        System.out.println("Enter the Task");
        String task = sc.nextLine();
        obj.setTask(task);

        System.out.println("Enter the Priority");
        int pr = sc.nextInt();
        sc.nextLine();  // Consume leftover newline
        obj.setPrioroty(pr);

        System.out.println("Enter Due Date");
        String date = sc.nextLine();
        obj.setDueDtae(date);

        obj.setStatus("Pending");

        String sql = """
                      INSERT INTO task VALUES(?,?,?,?,?)
                 """;

        try(
                Connection con = DriverManager.getConnection(url, username,password);
                PreparedStatement st = con.prepareStatement(sql);
                ) {
                  st.setInt(1,obj.getId());
                  st.setString(2,obj.getTask());
                  st.setInt(3,obj.getPrioroty());
                  st.setString(4,obj.getDueDtae());
                  st.setString(5,obj.getStatus());
                  int result = st.executeUpdate();

                  if(result == 0){
                      System.out.println("Task is not Added");

                  }
                  else {
                      System.out.println("Task is Added");
                  }
        }
        catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
