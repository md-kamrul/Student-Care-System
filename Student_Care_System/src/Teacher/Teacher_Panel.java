package Teacher;

import java.io.*;
import java.util.*;
import h.*;


public class Teacher_Panel {

    static String all_quiz_count = "total_math_quiz.txt";

    // static int total_math_quiz = 0;
    // static int total_quiz = 0;

    public static void teacher_panel_start(String teacher_username, String teacher_department) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        final String id = teacher_username;
        teacher_menu();

        int choice = sc.nextInt();
        menu(choice, id, teacher_department);

    }

    public static void menu(int choice, String teacher_username, String teacher_department) throws FileNotFoundException {

        switch (choice) {
            
            case 1:
                Profile(teacher_username, teacher_department);
                break;
            case 2:
                Add_Teacher(teacher_username, teacher_department);
                break;
            case 3:LeaderBoard_Quiz(teacher_username, teacher_department);
                  break;
                  
            case 4:LeaderBoard_Game(teacher_username, teacher_department);
                  break; 
            case 5:LeaderBoard_Puzzle_BrainStroming(teacher_username, teacher_department);
            	   break;
            
            case 6:
                Show_User_Info(teacher_username, teacher_department);
                break;
            case 7:
                Set_Quiz(teacher_username, teacher_department);
                break;
            case 8:
                UpdateGame(teacher_username, teacher_department);
                break;
            case 9:
                Update_Educational_Material(teacher_username, teacher_department);
                break;
            case 10:
                System.out.println("\n\t\t\t\t\tThanks For your time. BYE");
                break;
            default:
                System.out.println("\n\t\t\t\t\tPlease choice the right option.");
                teacher_panel_start(teacher_username, teacher_department);

        }
    }

    public static void teacher_menu() {
        System.out.println();
        System.out.println("\n\t\t\t\t\t\tT E A C H E R :");
        System.out.println();
        System.out.println("\n\t\t\t\t\t<<<------- M E N U --------->>>");
        System.out.println("\n");
        System.out.println("\t\t\t\t\t 1. Profile");//profile->1
        System.out.println("\t\t\t\t\t 2. Add Admin");//Add Admin->2
        System.out.println("\t\t\t\t\t 3. LeaderBoard(Quiz)");//Leaderboard(quiz)->3
        System.out.println("\t\t\t\t\t 4. LeaderBoard(Game)");//Leaderboard(Game)->4
        System.out.println("\t\t\t\t\t 5. LeaderBoard(Puzzle-BrainStroming");//leaderBoard(Puzzle)->5
        System.out.println("\t\t\t\t\t 6. Show Users Info");//Show user info->6
        System.out.println("\t\t\t\t\t 7. Set Quiz");//set quiz->7
        System.out.println("\t\t\t\t\t 8. Set Game");//set game->8
        System.out.println("\t\t\t\t\t 9. Update Educational Material");//study material->9
        System.out.println("\t\t\t\t\t 10. Back");//back->10
        System.out.println("\t\t\t\t\t-------------------------------");
        System.out.println();
        System.out.print("\n\t\t\t\t\t Press Key :");
    }

    public static void quiz_menu() {
        System.out.println("\n\t\t\t\t\t<<<------- Q U I Z --------->>>");
        System.out.println();
        System.out.println("\t\t\t\t\tYour Quiz-->>>");
        System.out.println("\n\t\t\t\t\t 1Show Your Past Quiz");
        System.out.println("\t\t\t\t\t 2.Math ");
        System.out.println("\t\t\t\t\t 3.CSE");
        System.out.println("\t\t\t\t\t 4.Physic");
        System.out.println("\t\t\t\t\t 5.Back");
        System.out.print("\t\t\t\t\t Press key:");
    }

    public static void Add_Teacher(String teacher_username, String teacher_department) throws FileNotFoundException /// ADD teacher
    {
        System.out.println("\n\t\t\t\t\tComing soon!!!");
        teacher_panel_start(teacher_username,teacher_department);
    }

    public static void Profile(String teacher_username, String teacher_department) throws FileNotFoundException /// profile

    {
    	Scanner sc = new Scanner(System.in);

        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        try {
            // Teacher_List List = new Teacher_List();

            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        } catch (IOException e) {

        }

        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getUser_name().equals(teacher_username)) {
                System.out.println("\n\t\t\t\t\t<<<------P R O F I L E----------->>");
                System.out.println("\t\t\t\t\tName         : " + Al.get(i).getName() + "\nUser Name : "
                        + Al.get(i).getUser_name());
                System.out.println("\t\t\t\t\tPhone Number : " + Al.get(i).getPhone_number());
                System.out.println("\t\t\t\t\tE-mail       : " + Al.get(i).getE_mail());
                System.out.println("\t\t\t\t\tPassword     : " + Al.get(i).getPassword());
            }
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);
            
            
        }

    }

    public static void LeaderBoard_Quiz(String teacher_username,String teacher_department) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(System.in);
    	
    	File f_std_bio = new File("Student_Signup_Data.txt");
    	File f_cse = new File("CSE_quiz_leaderBoard.txt");
    	File f_math = new File("Math_quiz_leaderBoard.txt");
    	File f_phy = new File("Phy_quiz_leaderBoard.txt");
    	
    	ArrayList<String>std_list = new ArrayList<>();
    	
    	Scanner f_read_std_bio = new Scanner(f_std_bio);
    	while(f_read_std_bio.hasNextLine())
    	{
    		String line =f_read_std_bio.nextLine();
    		String[] data = line.split(",");
    		std_list.add(data[0]);
    		
    	}
    	
    	Scanner f_read_cse = new Scanner(f_cse);
    	Scanner f_read_phy = new Scanner(f_phy);
    	Scanner f_read_math = new Scanner(f_math);
    	
    	String sub1="cse",sub2="math",sub3="phy";
    	
    	ArrayList<Quiz_Leader_Board>phy_list = new ArrayList<>();
    	ArrayList<Quiz_Leader_Board>cse_list = new ArrayList<>();
    	ArrayList<Quiz_Leader_Board>math_list = new ArrayList<>();
    	
    	while(f_read_cse.hasNextLine())
    	{
    		String line = f_read_cse.nextLine();
            String[] T_Data = line.split("\\|");
            
               cse_list.add(new Quiz_Leader_Board(T_Data[0],T_Data[1], T_Data[2], T_Data[3], T_Data[4]) ) ;
        
    	}
    	while(f_read_math.hasNextLine())
    	{
    		String line = f_read_math.nextLine();
            String[] T_Data = line.split("\\|");
            
            
            
           math_list.add(new Quiz_Leader_Board(T_Data[0],T_Data[1], T_Data[2], T_Data[3], T_Data[4])) ;
              
            
    	}
    	while(f_read_phy.hasNextLine())
    	{
    		String line = f_read_phy.nextLine();
            String[] T_Data = line.split("\\|");
            
           phy_list.add(new Quiz_Leader_Board(T_Data[0],T_Data[1], T_Data[2], T_Data[3], T_Data[4])) ;
              
            
    	}
    	sort_Array_list(cse_list);
    	sort_Array_list(math_list);
    	sort_Array_list(phy_list);
    	
    	System.out.println("\t\t\t\t\t<<<---------L E A D E R  B O A R D---------->>>");
    	
    	display_leader_Board(cse_list,sub1);
    	display_leader_Board(math_list, sub2);
    	display_leader_Board(phy_list, sub3);
    	
    	
    	System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
        teacher_panel_start(teacher_username,teacher_department);
    	
    	
    	
    	
    }
    public static void display_leader_Board(ArrayList<Quiz_Leader_Board>al,String subject)
    {
    	
    	
    	System.out.println("\t\t\t\t\t<<<---------  "+subject+"  --------->>>>");
    	System.out.println("\t\t\t\t\tID\tName\tTotal Quiz\tCorrect\tPercentage");
    	for(Quiz_Leader_Board p :al)
    	{
    		System.out.println("\t\t\t\t\t"+p.getId()+"\t"+p.getName()+"\t"+p.getTotal_quiz()+"\t"+p.getCorrect_quiz()+"/"+p.getTotal_quiz()+"\t"+p.getPercentage());
    		
    	}
    	System.out.println("\t\t\t\t\t------------------------------------------------------------------------");
    }
    public static void sort_Array_list(ArrayList<Quiz_Leader_Board>al)
    {
    	Collections.sort(al,new Comparator<Quiz_Leader_Board>() {


			@Override
			public int compare(Quiz_Leader_Board o1, Quiz_Leader_Board o2) {
				// TODO Auto-generated method stub
				return Double.valueOf(o2.getPercentage()).compareTo(o1.getPercentage());
			}
		});
    }
    public static void LeaderBoard_Game(String teacher_username, String teacher_department) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("C O M I N G   S O O N");
    	System.out.println("Mybe in semester break,Inshallah---- :) :)");
    	System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
        teacher_panel_start(teacher_username,teacher_department);
    }
    public static void LeaderBoard_Puzzle_BrainStroming(String teacher_username, String teacher_department) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("C O M I N G   S O O N");
    	System.out.println("Mybe in semester break,Inshallah---- :) :)");
    	System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
        teacher_panel_start(teacher_username,teacher_department);
    }
    
    public static void Show_User_Info(String teacher_username, String teacher_department) throws FileNotFoundException // show user
    {

    	Scanner sc = new Scanner(System.in);
        ArrayList<Student_Bio> Al = new ArrayList<>();

        try {
            // Teacher_List List = new Teacher_List();

            File File_Student = new File("Student_Signup_Data.txt");
            Scanner Access_Student_bio = new Scanner(File_Student);

            while (Access_Student_bio.hasNextLine()) {
                String line = Access_Student_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Student_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4]));

            }
        } catch (IOException e) {

        }

        System.out.println("\n\t\t\t\t\t<<<------- S T U D E N T   I N F O --------->>>");
        for (int i = 0; i < Al.size(); i++) {

            System.out.println("\t\t\t\t\tName : " + Al.get(i).getName() + "\tId          : " + Al.get(i).getId());
            System.out
                    .println("\t\t\t\t\tPhone: " + Al.get(i).getPhone_Number() + "\tE-mail : " + Al.get(i).geteMail());
            System.out.println("\t\t\t\t\t-------------------------------------------------------------");
        }
        System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
        teacher_panel_start(teacher_username,teacher_department);
        
        
    }

    public static void Set_Quiz(String teacher_username, String teacher_department) throws FileNotFoundException // update quiz
    {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        quiz_menu();

        int c = sc.nextInt();

        switch (c) {
            case 1:
                Quiz_past(teacher_username, teacher_department);
                break;
            case 2:
                Quiz_Math(teacher_username, teacher_department);
                break;
            case 3:
                Quiz_Cse(teacher_username, teacher_department);
                break;
            case 4:
                Quiz_Phy(teacher_username, teacher_department);
                break;
            case 5:
                teacher_menu();

                int choice = sc.nextInt();
                menu(choice, teacher_username, teacher_department);
                break;

        }

    }

    public static void Quiz_past(String teacher_username, String teacher_department) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String teacher_math_quiz_file = teacher_username;

        // Teacher file read
        ArrayList<Teacher_Bio> Al = new ArrayList<>();

        // for QUIZ
        ArrayList<QUIZ> A__L = new ArrayList<>();
        try {
            // Teacher_List List = new Teacher_List();

            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        } catch (IOException e) {

        }

        String file_address;
        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getUser_name().equals(teacher_username) && Al.get(i).getDepartment().equals(teacher_department))
                teacher_math_quiz_file += "_math_quiz.txt";
            else
                System.out.println("\n\t\t\t\t\tSomething wrong !!!");
        }
        file_address = teacher_math_quiz_file;
        File f = new File(file_address);
        Scanner sc11 = new Scanner(f);

        while (sc11.hasNextLine()) {

            String que = sc11.nextLine();
            String ans = sc11.nextLine();
            String option = sc11.nextLine();
            String[] line = option.split("\\|");
            A__L.add(new QUIZ(que, ans, line));

        }
        Collections.shuffle(A__L, new Random());

        for (int i = 0; i < A__L.size(); i++) {
            System.out.println(A__L.get(i).getQuestion());
            System.out.println(A__L.get(i).getAns());

            for (int j = 0; j < A__L.get(i).getOl().size(); j++) {
                System.out.println(A__L.get(i).getOl().get(j));
            }
        }
        System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
        teacher_panel_start(teacher_username,teacher_department);
        // System.out.println("Total quiz :" + total_math_quiz);
    }

    public static void Quiz_Math(String teacher_username, String teacher_department) {

        // String quiz_count = teacher_username + "_math_quiz_count.txt";
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String teacher_math_quiz_file = teacher_username;

        // Teacher file read
        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        try

        {
            // Teacher_List List = new Teacher_List();

            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        } catch (IOException e) {

        }

        String file_address;
        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getUser_name().equals(teacher_username) && Al.get(i).getDepartment().equals(teacher_department))
                teacher_math_quiz_file += "_math_quiz.txt";
            else
                System.out.println("\n\t\t\t\t\tSomething wrong!!!");
        }
        file_address = teacher_math_quiz_file;

        try {


            System.out.println("\t\t\t\t\t5 question must");


            for (int i = 1; i <= 5; i++) {

                FileWriter fw = new FileWriter(teacher_math_quiz_file,true);
                System.out.println("\t\t\t\t\tQuestion -->> " + i);//
                System.out.print("\t\t\t\t\tQuestion : ");
                // sc1.nextLine();
                String question = sc1.nextLine();
                System.out.print("\t\t\t\t\tAns : ");//
                String ans = sc1.nextLine();

                System.out.print("\t\t\t\t\tHow many option do u want? ");//
                int size = sc.nextInt();

                String[] option = new String[size];


                for (int j = 0; j < option.length; j++) {

                    System.out.print("\t\t\t\t\tOption" + (j + 1) + " :");
                    option[j] = sc1.nextLine();

                }



                fw.write(question);
                fw.write("\n");
                fw.write(ans);
                fw.write("\n");
                QUIZ op_file = new QUIZ();
                fw.write(op_file.toOPTION(option));
                fw.write("\n");
                fw.close();

                // total_math_quiz++;
                // total_quiz++;
                // System.out.println(total_math_quiz + " " + total_quiz);

                // FileWriter fwM = new FileWriter(quiz_count, true);
                // FileWriter fwT = new FileWriter(all_quiz_count, true);

                // fwM.write(total_math_quiz + "\n");
                // fwM.close();

                // fwT.write(total_quiz + "\n");
                // fwT.close();

            }
            System.out.println("\n\t\t\t\t\tQuestion Submit Successfully Done");
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static void Quiz_Cse(String teacher_username, String teacher_department) {
        // String quiz_count = teacher_username + "_math_quiz_count.txt";
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String teacher_cse_quiz_file = teacher_username;

        // Teacher file read
        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        try

        {
            // Teacher_List List = new Teacher_List();

            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        } catch (IOException e) {

        }

        String file_address;
        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getUser_name().equals(teacher_username) && Al.get(i).getDepartment().equals(teacher_department))
                teacher_cse_quiz_file += "_cse_quiz.txt";
            else
                System.out.println("\n\t\t\t\t\tSomething wrong!!!");
        }
        file_address = teacher_cse_quiz_file;

        try {


            System.out.println("\t\t\t\t\t5 question must");


            for (int i = 1; i <= 5; i++) {

                FileWriter fw = new FileWriter(teacher_cse_quiz_file,true);
                System.out.println("\t\t\t\t\tQuestion -->> " + i);//
                System.out.print("\t\t\t\t\tQuestion : ");
                // sc1.nextLine();
                String question = sc1.nextLine();
                System.out.print("\t\t\t\t\tAns : ");//
                String ans = sc1.nextLine();

                System.out.print("\t\t\t\t\tHow many option do u want? ");//
                int size = sc.nextInt();

                String[] option = new String[size];


                for (int j = 0; j < option.length; j++) {

                    System.out.print("\t\t\t\t\tOption" + (j + 1) + " :");
                    option[j] = sc1.nextLine();

                }



                fw.write(question);
                fw.write("\n");
                fw.write(ans);
                fw.write("\n");
                QUIZ op_file = new QUIZ();
                fw.write(op_file.toOPTION(option));
                fw.write("\n");
                fw.close();

                // total_math_quiz++;
                // total_quiz++;
                // System.out.println(total_math_quiz + " " + total_quiz);

                // FileWriter fwM = new FileWriter(quiz_count, true);
                // FileWriter fwT = new FileWriter(all_quiz_count, true);

                // fwM.write(total_math_quiz + "\n");
                // fwM.close();

                // fwT.write(total_quiz + "\n");
                // fwT.close();

            }
            System.out.println("\n\t\t\t\t\tQuestion Submit Successfully Done");
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void Quiz_Phy(String teacher_username, String teacher_department) {
        // String quiz_count = teacher_username + "_math_quiz_count.txt";
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String teacher_phy_quiz_file = teacher_username;

        // Teacher file read
        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        try

        {
            // Teacher_List List = new Teacher_List();

            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        } catch (IOException e) {

        }

        String file_address;
        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getUser_name().equals(teacher_username) && Al.get(i).getDepartment().equals(teacher_department))
                teacher_phy_quiz_file += "_phy_quiz.txt";
            else
                System.out.println("\n\t\t\t\t\tSomething wrong!!!");
        }
        file_address = teacher_phy_quiz_file;

        try {


            System.out.println("\t\t\t\t\t5 question must");


            for (int i = 1; i <= 5; i++) {

                FileWriter fw = new FileWriter(teacher_phy_quiz_file,true);
                System.out.println("\t\t\t\t\tQuestion -->> " + i);//
                System.out.print("\t\t\t\t\tQuestion : ");
                // sc1.nextLine();
                String question = sc1.nextLine();
                System.out.print("\t\t\t\t\tAns : ");//
                String ans = sc1.nextLine();

                System.out.print("\t\t\t\t\tHow many option do u want? ");//
                int size = sc.nextInt();

                String[] option = new String[size];


                for (int j = 0; j < option.length; j++) {

                    System.out.print("\t\t\t\t\tOption" + (j + 1) + " :");
                    option[j] = sc1.nextLine();

                }



                fw.write(question);
                fw.write("\n");
                fw.write(ans);
                fw.write("\n");
                QUIZ op_file = new QUIZ();
                fw.write(op_file.toOPTION(option));
                fw.write("\n");
                fw.close();

                // total_math_quiz++;
                // total_quiz++;
                // System.out.println(total_math_quiz + " " + total_quiz);

                // FileWriter fwM = new FileWriter(quiz_count, true);
                // FileWriter fwT = new FileWriter(all_quiz_count, true);

                // fwM.write(total_math_quiz + "\n");
                // fwM.close();

                // fwT.write(total_quiz + "\n");
                // fwT.close();

            }
            System.out.println("\n\t\t\t\t\tQuestion Submit Successfully Done");
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void UpdateGame(String teacher_username, String teacher_department) throws FileNotFoundException // update game
    {
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("\n\t\t\t\t\tComing soon!!!");
        System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
        teacher_panel_start(teacher_username,teacher_department);
    }

    public static void Update_Educational_Material(String teacher_username, String teacher_department) throws FileNotFoundException // blog
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t\t\t\t\t<<<---------------S T U D Y   M A T E R I A L S-------->>>");
        System.out.println("\t\t\t\t\t1.Computer Science And Engineering(CSE)");
        System.out.println("\t\t\t\t\t2.Physics(phy)");
        System.out.println("\t\t\t\t\t3.Math");
        System.out.println("\t\t\t\t\t4.Show my Blog");
        System.out.println("\t\t\t\t\t5.Back");

        System.out.print("\n\t\t\t\t\tEnter your Choice:");
        int c = sc.nextInt();

        switch (c) {
            case 1:
                study_cse(teacher_username, teacher_department);
                break;
            case 2:
                study_phy(teacher_username, teacher_department);
                break;
            case 3:
                study_math(teacher_username, teacher_department);
                break;
            case 4:
                show_my_blog(teacher_username, teacher_department);
                break;
            case 5:
                teacher_panel_start(teacher_username, teacher_department);
                break;
            default:
                System.out.println("\n\t\t\t\t\tPlease enter the correct option");
                System.out.println("\n");
                Update_Educational_Material(teacher_username, teacher_department);
        }
    }

    public static void show_my_blog(String teacher_username, String teacher_department) {
        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        try

        {
            // Teacher_List List = new Teacher_List();

            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        } catch (IOException e) {

        }

        String file_address = teacher_username;
       
        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getDepartment().equals(teacher_department) && Al.get(i).getUser_name().equals(teacher_username)) {
                file_address +="_";
                file_address+=teacher_department.toLowerCase();
                file_address+="_study.txt";
            }
        }
        System.out.println(file_address);
        
        
       
        
        	 File f_read = new File(file_address);
             try {
                 Scanner fr = new Scanner(f_read);

                 while (fr.hasNextLine()) {
                     String line = fr.nextLine();
                     System.out.println(line);
                 }
                 Scanner sc = new Scanner(System.in);
                 System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
                 teacher_panel_start(teacher_username,teacher_department);

             } catch (FileNotFoundException e) {

                 e.printStackTrace();
             }
        }
    
        
       
       

    

    public static void study_cse(String teacher_username, String teacher_department) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\twhich Language/topic(C/Java/C++/DSA) : ");
        String Topic= sc.next();
        try {
            FileWriter fw = new FileWriter(teacher_username+ "_cse_study.txt", true);
            System.out.println("\t\t\t\t\tWrite some thing below :");
            System.out.println("To stop writing press (~) :");
            System.out.print("\t\t\t\t\tTile :");
            String line = sc.nextLine();
            fw.write("Topic : "+Topic+"\n");
            fw.write("Title :"+line+"\n");

            while (true) {
                if (line.equals("~"))
                    break;
                fw.write(line + "\n");
                line = sc.nextLine();
            }
            
            String author = sc.nextLine();
            fw.write("                           Written By " + author + "\n");
            fw.close();
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);

        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println();
    }

    public static void study_phy(String teacher_username, String teacher_department) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\tWhich Topic(Linear motion/Momentum/Energy/Interactions and Force) : ");
        String Topic= sc.next();
        try {
            FileWriter fw = new FileWriter(teacher_username+ "_phy_study.txt", true);
            System.out.println("\t\t\t\t\tWrite some thing below :");
            System.out.println("To stop writing press (~) :");
            System.out.print("\t\t\t\t\tTile :");
            String line = sc.nextLine();
            fw.write("Topic : "+Topic+"\n");
            fw.write("Title :"+line+"\n");

            while (true) {
                if (line.equals("~"))
                    break;
                fw.write(line + "\n");
                line = sc.nextLine();
            }
            String author = sc.nextLine();
            fw.write("                           Written By " + author + "\n");
            fw.close();
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);

        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println();
    }

    public static void study_math(String teacher_username, String teacher_department) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\tWhich Topic(Algebra/Calculus/Geometry/Probability and Statistics) : ");
        String Topic= sc.next();
       
        try {
            FileWriter fw = new FileWriter(teacher_username+ "_math_study.txt", true);
            System.out.println("\t\t\t\t\tWrite some thing below :");
            System.out.println("To stop writing press (~) :");
            System.out.print("\t\t\t\t\tTile :");
            String line = sc.nextLine();
            fw.write("Topic : "+Topic+"\n");
            fw.write("Title :"+line+"\n");

            while (true) {
                if (line.equals("~"))
                    break;
                fw.write(line + "\n");
                line = sc.nextLine();
            }
            
            String author = sc.nextLine();
            fw.write("                           Written By " + author + "\n");
            fw.close();
            System.out.print("Enter Any key to Back :");char q =sc.next().charAt(0);
            teacher_panel_start(teacher_username,teacher_department);

        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println();
    }
}
