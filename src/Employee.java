import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
    private static Scanner scan = new Scanner(System.in);
    private int id;
    private String name;
    private String salary;

    public Employee(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    public static void search(){
        System.out.println("Enter employee id");
        int id1 = scan.nextInt();

        try {
            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery("SELECT * from employee");
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String salary = result.getString("salary");

                System.out.println("id\t\tname\t\tsalary\n"+id+"\t    "+name+" \t\t   "+salary);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
