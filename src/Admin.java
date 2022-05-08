import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
    private static Scanner scan = new Scanner(System.in);
    private static Connection conn1;
    private static Statement statement;

    public static void adminOperations(){
        System.out.println(" 0.View students\t 1.Add Student\t 2.Update student\t 3.Delete student\n" +
                " 4.Add Employee\t 5.Update Employee \t 6.Delete Employee \n" +
                " 7.Add Marks \t 8.Update Marks \t 9.Delete Marks \t 10.viewMarks \t 11.viewEmployees ");
    }

   public static Connection getConnection(){
        try
        {
            conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
            return conn1;
        }
        catch(Exception e)
        {
            System.out.println("Connection failed");
            return null;
        }

   }

   public static void adminChoice(){
        System.out.println("Enter your choice");
        String choice = scan.nextLine();
        switch(choice){
            case "0": viewStudent();
                      break;
            case "1": addStudent();
                      break;
            case "2": updateStudent();
                      break;
            case "3": deleteStudent();
                      break;
            case "4": addEmployee();
                      break;
            case "5": updateEmployee();
                      break;
            case "6": deleteEmployee();
                      break;
            case "7": addMarks();
                      break;
            case "8": updateMarks();
                      break;
            case "9": deleteMarks();
                      break;
            case "10": viewMarks();
                      break;
            case "11": viewEmployee();
                break;
            default :
                System.out.println("Invalid choice");

        }

   }

   public static void viewStudent(){
        try{
            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM student");
            System.out.println("id\t name\n ");
            while(result.next()){
                String sid = result.getString("stdid");
                String name = result.getString("name");
                System.out.println(sid+"\t"+name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
   }


   public static void addStudent(){

          System.out.println("Enter student id");
          int id = scan.nextInt();
          scan.nextLine();
          System.out.println("Enter student name");
          String name = scan.nextLine();

          Student st = new Student(id,name);

          int sid = st.getId();
          String sname = st.getName();
          System.out.println(sid);
          System.out.println(sname);

         try
         {
             getConnection();
             statement = conn1.createStatement();
             statement.execute("Insert into Student(stdid,name) values('"+sid+"','"+sname+"');");

         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());

         }finally{
            try{ statement.close();}catch(Exception e){}
         }

   }



   public static void updateStudent(){
       System.out.println("Enter student id");
       int id = scan.nextInt();
       scan.nextLine();


       System.out.println("Enter new value for student name");
       String newValue = scan.nextLine();

        try{

            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();
            statement.execute("update student set name='"+newValue+"' where stdid="+id);
            System.out.println("updated successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
   }

   public static void deleteStudent(){

       System.out.println("Enter student id");
       int id = scan.nextInt();
       Student st1 = new Student(id);

       int sid = st1.getId();
       System.out.println(sid);
       try
       {
           getConnection();
           statement = conn1.createStatement();
           statement.execute("delete from Student where stdid="+sid+";");

       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());

       }finally{
           try{ statement.close();}catch(Exception e){}
       }

   }


    public static void addEmployee(){
        System.out.println("Enter employee id");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter employee name");
        String name = scan.nextLine();
        System.out.println("Enter salary");
        String salary = scan.nextLine();

        Employee emp = new Employee(id,name,salary);

        int empid = emp.getId();
        String empname = emp.getName();
        String empsalary = emp.getSalary();
        System.out.println(empid);
        System.out.println(empname);
        System.out.println(empsalary);

        try
        {
            getConnection();
            statement = conn1.createStatement();
            statement.execute("Insert into Employee(id,name,salary) values('"+empid+"','"+empname+"','"+empsalary+"');");

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }finally{
            try{ statement.close();}catch(Exception e){}
        }
    }



    public static void updateEmployee(){
        System.out.println("Enter employee id");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter field to be updated name or salary");
        String field = scan.next();
        scan.nextLine();

        System.out.println("Enter new value");
        String newValue = scan.nextLine();

        try{
            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();
            statement.execute("update employee set "+field+ " = '"+newValue+"' where id="+id);
            System.out.println("updated successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(){
        System.out.println("Enter employee id");
        int id = scan.nextInt();
        Student st1 = new Student(id);

        int sid = st1.getId();
        System.out.println(sid);
        try
        {
            getConnection();
            statement = conn1.createStatement();
            statement.execute("delete from Employee where id="+id+";");

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }finally{
            try{ statement.close();}catch(Exception e){}
        }

    }


    public static void addMarks(){
        System.out.println("Enter student id");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter physics marks");
        int marks1 = scan.nextInt();
        System.out.println("Enter chemistry marks");
        int marks2 = scan.nextInt();
        System.out.println("Enter maths marks");
        int marks3 = scan.nextInt();

        Marks m = new Marks(id,marks1,marks2,marks3);

        int sid = m.getSid();
        int pmarks = m.getPhysicsMarks();
        int cmarks = m.getChemistryMarks();
        int mmarks = m.getMathsMarks();
        System.out.println(sid);


        try
        {
            getConnection();
            statement = conn1.createStatement();
            String sname = " ";
            statement.execute("Insert into Marks(id,physics,chemistry,maths) values("+sid+","+pmarks+","+cmarks+","+mmarks+");");

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }finally{
            try{ statement.close();}catch(Exception e){}
        }

    }


    public static void updateMarks(){
        System.out.println("Enter student id ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter field to be updated");
        String field = scan.next();
        scan.nextLine();
        System.out.println(field);
        System.out.println("Enter new value");
        int newVal = scan.nextInt();



        try {
            getConnection();
            statement = conn1.createStatement();

            statement.execute("update Marks set "+field+" = "+newVal+" where id ="+id);
//
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally{
            try{ statement.close();}catch(Exception e){}
        }



    }


    public static void deleteMarks(){
        System.out.println("Enter student id ");
        int id = scan.nextInt();

        try {
            getConnection();
            statement = conn1.createStatement();

            statement.execute("delete from Marks  where id ="+id);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally{
            try{ statement.close();}catch(Exception e){}
        }

    }
    public static void viewMarks(){
        try{
            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Marks");
            while(result.next()){
                String sid = result.getString("id");
                String physics = result.getString("physics");
                String chemistry = result.getString("chemistry");
                String maths = result.getString("maths");
                System.out.println("id\t physics\tchemistry\t maths \n"+sid+"      \t"+physics+"\t\t\t"+chemistry+"\t\t\t"+maths);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void viewEmployee(){
        try{
            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employee");
            while(result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String salary = result.getString("salary");

                System.out.println("id\t\t name\t\t\tsalary \n"+id+"      \t"+name+"\t\t\t"+salary+"\t\t\t");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
