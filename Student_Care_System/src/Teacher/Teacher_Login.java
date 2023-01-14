package Teacher;

import java.io.*;
import java.util.*;

public class Teacher_Login{
    public static void teacher_login() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        ArrayList<String> userList = new ArrayList<>();

        System.out.println("\n\n\t\t\t\t\t<<<------- L O G  I N  H E R E --------->>>");
        System.out.print("\n\t\t\t\t\tEnter username : ");
        String teacher_username = input.nextLine();
        System.out.print("\t\t\t\t\tEnter password: ");
        String password = input.nextLine();

        boolean found;
        found = checking(teacher_username, password);


        if (found) {
            String teacher_department = find_teacher_department(teacher_username, password);
            System.out.println("\n\t\t\t\t\tLog in successful.");
            Teacher_Panel teacher_panel = new Teacher_Panel();
            teacher_panel.teacher_panel_start(teacher_username, teacher_department);
        }
        else {
            System.out.println("\n\t\t\t\t\tInvalid id or password.");
            teacher_login();
        }
    }

    public static boolean checking(String teacher_username, String password){
        boolean found = false;
        try{
            File stud_data = new File("Teacher_Signup_Data.txt");
            try (BufferedReader reader = new BufferedReader(new FileReader("Teacher_Signup_Data.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if(teacher_username.equals(parts[1]) && password.equals(parts[4])){
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

    public static String find_teacher_department(String teacher_username, String password){
        String teacher_department = "";
        try{
            File stud_data = new File("Teacher_Signup_Data.txt");
            try (BufferedReader reader = new BufferedReader(new FileReader("Teacher_Signup_Data.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if(teacher_username.equals(parts[1]) && password.equals(parts[4])){
                        teacher_department = parts[5];
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
        return teacher_department;
    }
}