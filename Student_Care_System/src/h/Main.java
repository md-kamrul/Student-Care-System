package h;

import java.io.*;
import java.util.*;
import Teacher.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n\n\t\t\t\t\t\t\tWelcome to Student Care System");

        // Ask user to log in or sign up
        method_home_option();

    }

    public static void method_home_option() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\t\t\t\t\t<<<------- W H O  A R E  Y O U ? --------->>>\n\n\t\t\t\t\t(1)Student \n\t\t\t\t\t(2)Teacher\n\t\t\t\t\t(3)Exit");
        System.out.print("\n\n\t\t\t\t\tOption here : ");

        int home_option = input.nextInt();		// option for choosing student or teacher;

        // Log in

        switch(home_option){
            case 1:
                //Thread.sleep(2000);
                student();
                break;
            case 2:
                //Thread.sleep(2000);
                teacher();
                break;
            case 3:
                System.out.println("\t\t\t\t\tThanks for your time. BYE");
                break;
            default:
                System.out.println("\t\t\t\t\tError!!!\n\t\t\t\t\tPlease choose the correct option.\n\n");
                method_home_option();
        }

        input.close();
    }

    public static void student(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n\t\t\t\t\tWhat is your choice?\n\n\t\t\t\t\t(1)LogIn or (2)SignUp or (3)Exit");
        System.out.print("\n\t\t\t\t\tAnswer here : ");
        int inside_option_1 = input.nextInt();	// inside_option_1 for choosing login or sign-up

        switch(inside_option_1){
            case 1:
                Student_Login student_login = new Student_Login();
                try
                {
                    //Thread.sleep(2000);
                    student_login.stud_login();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;

            case 2:
                Student_Signup student_signup = new Student_Signup();
                try
                {
                    //Thread.sleep(2000);
                    student_signup.student_Data();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;

            case 3:
                System.out.println("\n\t\t\t\t\tOk. BYE");
                break;

            default:
                System.out.println("\n\t\t\t\t\tError!!!\n\t\t\t\t\tPlease enter the correct option.");
                student();
        }

        input.close();
    }

    public static void teacher(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n\t\t\t\t\tWhat is your choice?\n\n\t\t\t\t\t(1)LogIn or (2)SignUp or (3)Exit");
        System.out.print("\n\t\t\t\t\tAnswer here : ");
        int inside_option_2 = input.nextInt();

        switch(inside_option_2){
            case 1:
                Teacher_Login teacher_login = new Teacher_Login();
                try
                {
                    //Thread.sleep(2000);
                    teacher_login.teacher_login();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;

            case 2:
                Teacher_Signup teacher_signup = new Teacher_Signup();
                try
                {
                    //Thread.sleep(2000);
                    teacher_signup.teacher_Data();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                System.out.println("\n\t\t\t\t\tOk. BYE");
                break;

            default:
                System.out.println("\n\t\t\t\t\tError!!!\n\t\t\t\t\tPlease enter the correct option.");
                teacher();
        }

        input.close();
    }
}
