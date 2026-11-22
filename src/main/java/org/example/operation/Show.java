package org.example.operation;

import org.example.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Show implements TaskOpr {
    String url = "jdbc:mysql://127.0.0.1:3306/taskmanger";
    String username = "root";
    String password = "MediLink@2026";

    List<Task> list = new ArrayList<>();
    @Override
    public void operation(){
       String sql = """
               SELECT * FROM task;
               """;

       try(
               Connection con = DriverManager.getConnection(url, username,password);
               PreparedStatement st = con.prepareStatement(sql);
               ){
           ResultSet rs = st.executeQuery();

           while (rs.next()) {
             Task task = new Task();
             task.setId(rs.getInt(1));
               task.setTask(rs.getString(2));
               task.setPrioroty(rs.getInt(3));
               task.setDueDtae(rs.getString(4));
               task.setStatus(rs.getString(5));
             list.add(task);
           }

       }
       catch (SQLException e) {
           System.out.println("Database Error: " + e.getMessage());
           e.printStackTrace();
       }

       for(Task task:list){
           System.out.print("{"+task.getId()+", "+task.getTask()+", "+task.getPrioroty()+", "+task.getDueDtae()+

                   ", "+task.getStatus());
           System.out.println();
       }

    }

}
