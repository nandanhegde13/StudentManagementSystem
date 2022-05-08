import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("\n\n-----------------------------------------------------------------------STUDENT MANAGEMENT SYSTEM--------" +
                "-----------------------------------------------------------\n\n");

        System.out.println("1.Registartion\n2.Login");
        System.out.println("Enter your choice");

        int choice = Integer.parseInt(scanner.next());
        scanner.nextLine();


        if(choice == 1)
        {
          register();
        }
        if(choice == 2)
        {
               login();
        }


    }



    private static Connection getConnection(){
        try
        {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NANDAN HEGDE\\Desktop\\JAVA\\StudentManagementSystem\\sms.db");
            return conn;

        }catch(Exception e){

            System.out.println("Error :"+e.getMessage());
            return null;
        }

    }


    private static void register(){


        System.out.println("Enter name");
        String name = scanner.nextLine();


        System.out.println("Enter email");
        String email = scanner.nextLine();


        System.out.println("Enter Phone number");
        String  phone = scanner.next();
                scanner.nextLine();
        System.out.println("Enter Password");
        String  password = scanner.nextLine();


        Registration r1 = new Registration(name,email,phone,password);

        String uname = r1.getName();
        String uemail = r1.getEmail();
        String uphone = r1.getPhone();
        String upassword = r1.getPassword();

       try {
               Connection conn = getConnection();
               Statement statement = conn.createStatement();

               String insert = "insert into users(name,email,phone,password) values('" +uname+ "','" +uemail+ "','" +uphone+ "','"+upassword+"');";

               statement.execute(insert);
               System.out.println("Registration Successfull");
               login();

       }catch(Exception e){
               System.out.println(e);
       }
    }

    private static void login(){
        System.out.println(" 1.ADMIN\n 2.USER");
        System.out.println("Enter your choice");
        String choice = scanner.next();

        if(choice.equals( "1")){

            System.out.println("Enter Admin name");
            String name = scanner.next();

            System.out.println("Enter Password");
            String password = scanner.next();

            if(name.toLowerCase().equals("admin") && password.toLowerCase().equals("admin"));
            {
                System.out.println("Logging in as Administrator");

                try
                {
                        sleep(3000);

                        Admin.adminOperations();
                        Admin.adminChoice();
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

        }
        else if(choice.equals("2")){

            System.out.println("Enter email");
            String email = scanner.next();
            scanner.nextLine();


            System.out.println("Enter password");
            String pass = scanner.nextLine();
             try{
                 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
                 Statement statement = conn.createStatement();

                ResultSet result= statement.executeQuery("SELECT email,password FROM users where password = "+"'"+pass+"'");
                while(result.next()) {

                    String uemail = result.getString("email");
                    String upassword = result.getString("password");
//                    System.out.println(upassword);
//                    System.out.println(uemail);
//                    System.out.println(pass);
//                    System.out.println(email);

                    if(email.equals(uemail) && pass.equals(upassword)){
                        System.out.println("Logging in");
                        sleep(3000);
                        System.out.println("Login successfull");
                        Users.userOptions();
                    }
                    else{
                        System.out.println("user not exist");
                    }

                  }

                }catch(Exception e){
                 e.printStackTrace();
             }




        }

    }
}
