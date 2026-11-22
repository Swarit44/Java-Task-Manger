package org.example;


import org.example.operation.*;

import java.util.Scanner;

public class Main {
    public static void main() {
        TaskOpr opr;
        int operation;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("!---- Welcome To Task Manger----!");

            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Show Task");
            System.out.println("4. Update status");
            System.out.println("Enter the operation");
            operation = sc.nextInt();
            switch(operation){
                case 1:
                    opr = new Add();
                    opr.operation();
                    break;
                case 2:
                    opr = new DeleteTask();
                    opr.operation();
                    break;
                case 3:
                    opr = new Show();
                    opr.operation();
                    break;
                case 4:
                    opr = new UpdateStatus();
                    opr.operation();
                    break;
                default:
                    return;
            }
        }
    }
}


/*

        String url = "jdbc:mysql://127.0.0.1:3306/taskmanger";
        String username = "root";
        String password = "MediLink@2026";
        Connection con = DriverManager.getConnection(url, username,password);
 */

/*

                    System.out.println("Enter the Task");
                    System.out.println("Enter the Priority");
                    System.out.println("Enter Due Date");
 */