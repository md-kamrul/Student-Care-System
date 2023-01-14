package h;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Student_Signup
{
    public static void student_Data() throws IOException {
        Scanner stud_signup = new Scanner(System.in);    // Scanner class object stud_signup

        // Create a file
        File stud_data = new File("Student_Signup_Data.txt");        // class "File" and created object "stud_data"
        try {
            stud_data.createNewFile();                // createNewFile method of the file object (object.methodname())
        } catch (IOException e) {
            System.out.println("\t\t\t\t\tUnable to create file");
            e.printStackTrace();
        }

        System.out.println("\n\n\t\t\t\t\t<<<------- S I G N  U P  H E R E --------->>>");
        System.out.print("\n\t\t\t\t\tName : ");
        String stud_name = stud_signup.nextLine();
        System.out.print("\t\t\t\t\tID : ");
        String stud_id = stud_signup.nextLine();
        System.out.print("\t\t\t\t\tPhone Number : ");
        String stud_phone = stud_signup.nextLine();

        boolean yes_or_no = true;
        String stud_email = null;
        while (yes_or_no) {
            System.out.print("\t\t\t\t\tEmail : ");
            //stud_signup.nextLine();
            stud_email = stud_signup.nextLine();

            if (stud_email.contains("@") && stud_email.contains(".com")) {
                yes_or_no = false;
            }
            else {
                System.out.println("\t\t\t\t\tEmail is not correct!!!");
            }
        }

        String password = password();

        boolean found = true;
        try (BufferedReader reader = new BufferedReader(new FileReader("Student_Signup_Data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(stud_id.equals(parts[1])){
                    found = false;
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("\n\t\t\t\t\tError reading users file: " + e.getMessage());
        }

        if(found){
            // Write to file
            FileWriter stud_fw = new FileWriter("Student_Signup_Data.txt", true);
            stud_fw.write(stud_name + "," + stud_id + "," + stud_phone + "," + stud_email + "," + password + "\n");
            stud_fw.close();

            String file_creation = stud_id + ".txt";
            File new_file_creation = new File(file_creation);
            new_file_creation.createNewFile();

            // Print message
            System.out.println("\n\t\t\t\t\tSign up successful!");

            stud_signup.close();
        }
        else{
            System.out.println("\n\t\t\t\t\tThis ID is already registered.....");
        }

    }

    public static String password(){
        Scanner stud_signup = new Scanner(System.in);

        System.out.print("\t\t\t\t\tPassword : ");
        String stud_password = stud_signup.nextLine();

        boolean yes_or_no = true;
        while (yes_or_no) {
            System.out.print("\t\t\t\t\tConfirm Password : ");
            String confirm_password = stud_signup.nextLine();

            if (stud_password.equals(confirm_password)) {
                yes_or_no = false;
            }
            else {
                System.out.println("\n\t\t\t\t\tPassword does not match!!!");
                password();
            }
        }
        return stud_password;
    }

}