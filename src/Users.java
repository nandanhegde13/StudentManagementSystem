import java.util.Scanner;

public class Users {
    private static Scanner scan = new Scanner(System.in);

    public static void userOptions(){

         System.out.println(" 1.Student\n2.Employee");
         System.out.println("Enter your choice");

         String choice = scan.nextLine();
         if(choice.equals("1")){
             System.out.println(" 1.Search Student");
             String ch = scan.nextLine();
             Student.search();

         }
         else{
               System.out.println(" 1.Search Record");
             String ch = scan.nextLine();
             Employee.search();
             }
    }
}
