import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
    private static Scanner scan = new Scanner(System.in);
    private int id;
    private String name;

    public Student(int id, String name) {
           setId(id);
           setName(name);
    }
    public Student(int id){
        setId(id);
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

    public static void search() {
        System.out.println("Enter student id");
        int id1 = scan.nextInt();

        try {
            Connection conn = Admin.getConnection();
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery("SELECT stdid,name,marks.physics,marks.chemistry,marks.maths from student inner join marks on student.stdid = marks.id");
            while(result.next()){
                int id = result.getInt("stdid");
                String name = result.getString("name");
                String p = result.getString("physics");
                String c = result.getString("chemistry");
                String m = result.getString("maths");
                System.out.println("id\t\tname\t\tphysics\t\tchemistry\t\tmaths\n"+id+"\t    "+name+" \t\t   "+p+"      \t\t "+c+"    \t\t"+m);
            }
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
