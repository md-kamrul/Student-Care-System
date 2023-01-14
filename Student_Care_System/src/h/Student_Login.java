package h;

import Teacher.Teacher_Panel;

import java.io.*;
import java.util.*;

public class Student_Login{
    public static void stud_login() throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<String> userList = new ArrayList<>();

        System.out.println("\n\n\t\t\t\t\t<<<------- L O G  I N  H E R E --------->>>");
        System.out.print("\n\t\t\t\t\tEnter ID : ");
        String stud_id = input.nextLine();
        System.out.print("\t\t\t\t\tEnter password: ");
        String password = input.nextLine();
        File f = new File("Student_Signup_Data.txt");
        Scanner sc = new Scanner(f);
         ArrayList<Student_Bio>al = new ArrayList<>();
        while(sc.hasNextLine())
        {
        	String line = sc.nextLine();
        	String[] data= line.split(",");
        	al.add(new Student_Bio(data[0], data[1], data[2], data[3], data[4]));
        }
        boolean found;
        found = checking(stud_id, password);

        
        for(Student_Bio p:al)
        {
        	if(p.getId().equals(stud_id) && p.getPassword().equals(password))
        	{
        		System.out.println("\n\t\t\t\t\tLog in successful.");
            Student_Panel student_panel = new Student_Panel();
            student_panel.student_panel_start(stud_id,p.getName());
        	}
        }

        if (found) {
            
        } else {
            System.out.println("\n\t\t\t\t\tInvalid id or password.");
            stud_login();
        }
    }

    public static boolean checking(String stud_id, String password){
        boolean found = false;
        try{
            File stud_data = new File("Student_Signup_Data.txt");
            try (BufferedReader reader = new BufferedReader(new FileReader("Student_Signup_Data.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if(stud_id.equals(parts[1]) && password.equals(parts[4])){
                        found = true;
                        break;
                    }
                }
            }
            catch (IOException e) {
                System.out.println("\n\t\t\t\t\tError reading users file: " + e.getMessage());
            }
        }
        catch(Exception e){
            System.out.println("\n\t\t\t\t\tSomething error!!");
        }
        return found;
    }
}