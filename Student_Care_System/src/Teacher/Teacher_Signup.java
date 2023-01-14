package Teacher;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Teacher_Signup
{
    public static void teacher_Data() throws IOException {
        Scanner teacher_signup = new Scanner(System.in);    // Scanner class object stud_signup

        // Create a file
        File stud_data = new File("Teacher_Signup_Data.txt");        // class "File" and created object "stud_data"
        try {
            stud_data.createNewFile();                // createNewFile method of the file object (object.methodname())
        } catch (IOException e) {
            System.out.println("\t\t\t\t\tUnable to create file");
            e.printStackTrace();
        }

        //sign up from here
        System.out.println("\n\n\t\t\t\t\t<<<------- S I G N  U P  H E R E --------->>>");
        System.out.print("\n\t\t\t\t\tName : ");
        String teacher_name = teacher_signup.nextLine();
        System.out.print("\t\t\t\t\tUsername : ");
        String teacher_username = teacher_signup.nextLine();
        System.out.print("\t\t\t\t\tPhone Number : ");
        String teacher_phone = teacher_signup.nextLine();
        System.out.print("\t\t\t\t\tDepartment : ");
        String teacher_department = teacher_signup.nextLine();

        boolean yes_or_no = true;
        String teacher_email = null;
        while (yes_or_no) {
            System.out.print("\t\t\t\t\tEmail : ");
            //teacher_signup.nextLine();
            teacher_email = teacher_signup.nextLine();

            if (teacher_email.contains("@") && teacher_email.contains(".com")) {
                yes_or_no = false;
            }
            else {
                System.out.println("\n\t\t\t\t\tEmail is not correct!!!");
            }
        }

        String password = password();

        //checking teacher username exist or not and teacher department exist or not
        int found = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Teacher_Signup_Data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(teacher_username.equals(parts[1])){
                    found = -1;
                    break;
                }
                if(teacher_department.equals(parts[5])){
                    found = 1;
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("\n\t\t\t\t\tError reading users file: " + e.getMessage());
        }

        if(found == 0){
            // Write to file
            FileWriter stud_fw = new FileWriter("Teacher_Signup_Data.txt", true);
            stud_fw.write(teacher_name + "," + teacher_username + "," + teacher_phone + "," + teacher_email + "," + password + "," + teacher_department + "\n");
            stud_fw.close();

            // Print message
            System.out.println("\n\t\t\t\t\tSign up successful!");

            teacher_signup.close();
        }
        else if(found == -1){
            System.out.println("\n\t\t\t\t\tThis username is already registered, sir.....");
        }
        else if(found == 1){
            System.out.println("\n\t\t\t\t\tThis department is already reserved. Sorry....");
        }
        else{
            System.out.println("\n\t\t\t\t\tSomething went wrong. Please try again....");
            teacher_Data();
        }


    }

    public static String password(){
        Scanner teacher_signup = new Scanner(System.in);

        System.out.print("\t\t\t\t\tPassword : ");
        String stud_password = teacher_signup.nextLine();

        //isAllPresent(stud_password);

        boolean yes_or_no = true;
        while (yes_or_no) {
            System.out.print("\t\t\t\t\tConfirm Password : ");
            String confirm_password = teacher_signup.nextLine();

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


    /*
      *********************************************************************************************************************************************************
        Citation here for isAllPresent():
        Title  : Check if a string contains uppercase, lowercase, special characters and numeric values
        Author : Geeks for Geeks
        Link   : https://www.geeksforgeeks.org/check-if-a-string-contains-uppercase-lowercase-special-characters-and-numeric-values/
      *********************************************************************************************************************************************************

    */
    public static void isAllPresent(String password)
    {
        // ReGex to check if a string contains uppercase, lowercase special character & numeric value
        String regex = "^(?=.*[a-z])(?=." + "*[A-Z])(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?]).+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty then print No
        if (password == null) {
            System.out.println("\n\t\t\t\t\tNo");
            return;
        }

        // Find match between given string & regular expression
        Matcher m = p.matcher(password);

        // Print Yes if string matches ReGex
        if (!m.matches()){
            System.out.println("\n\t\t\t\t\tYour password is not strong!!!");
            password();
        }
    }

}

