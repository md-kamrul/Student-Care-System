package h;

import Teacher.*;

//import java.rmi.dgc.Lease;
import java.util.*;
import java.io.*;
import Teacher.*;

public class Student_Panel {
    public static void student_panel_start(String stud_id, String name) throws IOException {
        Scanner sc = new Scanner(System.in);

        student_menu();
        int choice = sc.nextInt();
        student_menu_option(choice, stud_id,name);

    }

    public static void student_menu() {
        System.out.println();
        System.out.println("\n\t\t\t\t\t\tS T U D E N T :");
        System.out.println();
        System.out.println("\n\t\t\t\t\t<<<------- M E N U --------->>>");
        System.out.println("\n");
        System.out.println("\t\t\t\t\t 1. Profile");
        System.out.println("\t\t\t\t\t 2. Leaderboard");
        System.out.println("\t\t\t\t\t 3. Quiz");
        System.out.println("\t\t\t\t\t 4. CGPA Calculator");
        System.out.println("\t\t\t\t\t 5. Play Game");
        System.out.println("\t\t\t\t\t 6. Educational Material");
        System.out.println("\t\t\t\t\t 7. Back");
        System.out.println("\t\t\t\t\t-------------------------------");
        System.out.println();
        System.out.print("\n\t\t\t\t\t Press Key :");
    }

    public static void student_menu_option(int choice, String stud_id, String name) throws IOException {

        switch (choice) {
            case 1:
                Profile(stud_id,name);
                break;
            case 2:
                Leaderboard(stud_id,name);
                break;
            case 3:
                Quiz(stud_id,name);
                break;
            case 4:
                CGPA_Calculator(stud_id,name);
                break;
            case 5:
                Play_Game(stud_id,name);
                break;
            case 6:
                Educational_Material(stud_id,name);
                break;
            case 7:
            	Main m = new Main();
                System.out.println("\n\t\t\t\t\tThanks For your time. BYE");
                break;
            default:
                System.out.println("\n\t\t\t\t\tPlease choice the right option.");
                student_panel_start(stud_id,name);

        }
    }

    public static void Profile(String stud_id, String name) throws IOException{

        ArrayList<Student_Bio> Al = new ArrayList<>();
        try {
            // Teacher_List List = new Teacher_List();

            File File_Student = new File("Student_Signup_Data.txt");
            Scanner Access_Student_bio = new Scanner(File_Student);

            while (Access_Student_bio.hasNextLine()) {
                String line = Access_Student_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Student_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4]));
                //System.out.println(Al);

            }
        } catch (IOException e) {

        }
//System.out.println(stud_id);
        for (int i = 0; i < Al.size(); i++) {
             
        	if(Al.get(i).getId().equals(stud_id)){
                System.out.println("\n\t\t\t\t\t<<<------P R O F I L E----------->>");
                System.out.println("\t\t\t\t\tName         : " + Al.get(i).getName());
                System.out.println("\t\t\t\t\tID Number    : " + Al.get(i).getId());
                System.out.println("\t\t\t\t\tPhone Number : " + Al.get(i).getPhone_Number());
                System.out.println("\t\t\t\t\tE-mail       : " + Al.get(i).geteMail());
                System.out.println("\t\t\t\t\tPassword     : " + Al.get(i).getPassword());
            }
        	//System.out.println(name);
            //else System.out.println("something wrong");
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc.next().charAt(0);
        student_panel_start(stud_id,name);

    }

    public static void Leaderboard(String stud_id, String name) throws IOException{
       

        Scanner sc = new Scanner(System.in);
    	//System.out.println("dhukesi");
    	File f_std_bio = new File("Student_Signup_Data.txt");
    	File f_cse = new File("CSE_quiz_leaderBoard.txt");
    	File f_math = new File("Math_quiz_leaderBoard.txt");
    	File f_phy = new File("Phy_quiz_leaderBoard.txt");
    	
    	/*
    	ArrayList<String>std_list = new ArrayList<>();
    	
    	Scanner f_read_std_bio = new Scanner(f_std_bio);
    	while(f_read_std_bio.hasNextLine())
    	{
    		String line =f_read_std_bio.nextLine();
    		String[] data = line.split(",");
    		std_list.add(data[0]);
    		
    	}
    	*/
    	
    	Scanner f_read_cse = new Scanner(f_cse);
    	Scanner f_read_phy = new Scanner(f_phy);
    	Scanner f_read_math = new Scanner(f_math);
    	
    	String sub1="cse",sub2="math",sub3="phy";
    	
    	ArrayList<Quiz_Leader_Board>phy_list = new ArrayList<>();
    	ArrayList<Quiz_Leader_Board>cse_list = new ArrayList<>();
    	ArrayList<Quiz_Leader_Board>math_list = new ArrayList<>();
    	//System.out.println("first read");
    	
    	while(f_read_cse.hasNextLine())
    	{
    		String line = f_read_cse.nextLine();
    		//System.out.println(line);
            String[] T_Data = line.split("\\|");
            
               cse_list.add(new Quiz_Leader_Board(T_Data[0],T_Data[1], T_Data[2], T_Data[3], T_Data[4]) ) ;
        
    	}
    	System.out.println("cse");
    	while(f_read_math.hasNextLine())
    	{
    		String line = f_read_math.nextLine();
    		//System.out.println(line);
            String[] T_Data = line.split("\\|");
            
            
            
           math_list.add(new Quiz_Leader_Board(T_Data[0],T_Data[1], T_Data[2], T_Data[3], T_Data[4])) ;
              
            
    	}
    	//System.out.println("math");
    	while(f_read_phy.hasNextLine())
    	{
    		String line = f_read_phy.nextLine();
    		//System.out.println(line);
            String[] T_Data = line.split("\\|");
            
           phy_list.add(new Quiz_Leader_Board(T_Data[0],T_Data[1], T_Data[2], T_Data[3], T_Data[4])) ;
           //System.out.println("ekhane");   
            
    	}
    	//System.out.println("phy");
    	sort_Array_list(cse_list);
    	sort_Array_list(math_list);
    	sort_Array_list(phy_list);
    	
    	System.out.println("\t\t\t\t\t<<<---------L E A D E R  B O A R D---------->>>");
    	
    	display_leader_Board(cse_list,sub1);
    	display_leader_Board(math_list, sub2);
    	display_leader_Board(phy_list, sub3);
    	
    	Scanner sc1 = new Scanner(System.in);
        System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
        student_panel_start(stud_id,name);
    	
    }
    
    public static void display_leader_Board(ArrayList<Quiz_Leader_Board>al,String subject)
    {
    	
    	
    	System.out.println("\t\t\t\t\t<<<---------  "+subject+"  --------->>>>");
    	System.out.println("\t\t\t\t\tName\tID\tTotal Quiz\tCorrect\tPercentage");
    	
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
    
    public static void Quiz(String stud_id, String name) throws IOException {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Teacher_Panel teacher_panel = new Teacher_Panel();

        teacher_panel.quiz_menu();

        int c = sc.nextInt();

        switch (c) {
            case 1:
                Quiz_past(stud_id,name);
                break;
            case 2:
                Quiz_Math(stud_id,name);
                break;
            case 3:
            	Quiz_Cse(stud_id,name);
                break;
            case 4:
                Quiz_Phy(stud_id,name);
                break;
            case 5:
                student_menu();

                int choice = sc.nextInt();
                student_menu_option(choice, stud_id,name);
                break;
            default:
                System.out.println("Please enter the correct input...");
                teacher_panel.quiz_menu();

        }

    }

    public static void Quiz_past(String stud_id, String name) throws IOException{

        System.out.println("Coming Soon!!!");

    	Scanner sc1 = new Scanner(System.in);
        System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
        student_panel_start(stud_id,name);

    }
    public static void Quiz_Math(String stud_id, String name) throws IOException{
        

    	String sub ="Math";
    	ArrayList<QUIZ> A__L = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("hello");
        String fname =teacher_name(sub);
        System.out.println("hhhh");
        System.out.println();
        fname+="_math_quiz.txt";
        System.out.println(fname);
         
       File fread = new File(fname);
       Scanner sc11 = new Scanner(fread);
       
       while(sc11.hasNextLine())
       {

           String que = sc11.nextLine();
           String ans = sc11.nextLine();
           String option = sc11.nextLine();
           String[] line = option.split("\\|");
           A__L.add(new QUIZ(que, ans, line));
       }
      System.out.println("loop par");
      
       Collections.shuffle(A__L, new Random());
       
       System.out.println("shuffel");
       int correct=0;
       for (int i = 0; i < A__L.size(); i++) {
           System.out.println("Q"+(i+1)+". "+A__L.get(i).getQuestion());
           //System.out.println(A__L.get(i).getAns());
           System.out.println();
           for (int j = 0; j < A__L.get(i).getOl().size(); j++) {
               System.out.println((j+1)+")."+(A__L.get(i).getOl().get(j)));
           }
           System.out.print("Enter your ans :");int choice =sc.nextInt();
           if(A__L.get(i).getAns().equals(A__L.get(i).getOl().get(choice-1)))
        	   {
        	   ++correct;
        	   
        	   }
           else System.out.println(A__L.get(i).getOl().get(choice-1));
       }
       System.out.println(correct);
       int total_quiz =A__L.size();
       double percentage =(double)correct*100.0/(double)total_quiz;
       FileWriter fw = new FileWriter("Math_quiz_leaderBoard.txt",true);
       fw.write(stud_id+"|"+name+"|"+ total_quiz+"|"+correct+"|"+percentage+"\n");
       fw.close();
       

   	Scanner sc111 = new Scanner(System.in);
       System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc111.next().charAt(0);
       student_panel_start(stud_id,name);
        // for QUIZ
         
         
         
        
    }
    public static String teacher_name(String sub) throws FileNotFoundException {
    	
    	ArrayList<Teacher_Bio>teacher_list = new ArrayList<>();
    	File f_teacher = new File("Teacher_Signup_Data.txt");
    	Scanner f_read_teacher_bio = new Scanner(f_teacher);
    	while(f_read_teacher_bio.hasNextLine())
    	{
    		String line = f_read_teacher_bio.nextLine();
    		String[] data = line.split(",");
    		teacher_list.add(new Teacher_Bio(data[0], data[1], data[2], data[3], data[4], data[5]));
    	}
    
    	
    	String[] a = new String[1];
    	System.out.println(teacher_list.size());
    	for(Teacher_Bio p:teacher_list)
    	{
    		if(p.getDepartment().equals(sub))
    		{
    			//System.out.println(p.getUser_name());
    		//System.out.println(p.getDepartment());
    		a[0]= p.getUser_name();
    		System.out.println("------");
    		}
    		
    		
    	}
    	return a[0];
    	
    	/*
    	for(int i=0;i<teacher_list.size();i++)
    	{
    		if(teacher_list.get(i).getDepartment().equals(sub))a[0]= teacher_list.get(i).getUser_name();
    		else 
    			{
    			System.out.println(teacher_list.get(i).getDepartment());
    			System.out.println(sub);
    			a[0]= null;
    			}
    	}
    	*/
		
    	
    }
    public static void Quiz_Cse(String stud_id,String name) throws IOException{
        


    	String sub ="Cse";
    	ArrayList<QUIZ> A__L = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("hello");
        String fname=teacher_name(sub);
        System.out.println(fname);
        
        	
        System.out.println("hhhh");
        System.out.println();
        fname+="_cse_quiz.txt";
        System.out.println(fname);
        // Teacher file read
       File fread = new File(fname);
       Scanner sc11 = new Scanner(fread);
       
      
       while(sc11.hasNextLine())
       {

           String que = sc11.nextLine();
           String ans = sc11.nextLine();
           String option = sc11.nextLine();
           String[] line = option.split("\\|");
           A__L.add(new QUIZ(que, ans, line));
       }
      System.out.println("loop par");
       Collections.shuffle(A__L, new Random());
       System.out.println("shuffel");
       int correct=0;
       for (int i = 0; i < A__L.size(); i++) {
           System.out.println("Q"+(i+1)+". "+A__L.get(i).getQuestion());
           //System.out.println(A__L.get(i).getAns());
           System.out.println();
           for (int j = 0; j < A__L.get(i).getOl().size(); j++) {
               System.out.println((j+1)+")."+(A__L.get(i).getOl().get(j)));
           }
           System.out.print("Enter your ans :");int choice =sc.nextInt();
           if(A__L.get(i).getAns().equals(A__L.get(i).getOl().get(choice-1)))
        	   {
        	   ++correct;
        	   
        	   }
           else System.out.println(A__L.get(i).getOl().get(choice-1));
       }
       System.out.println(correct);
       int total_quiz =A__L.size();
       double percentage =(double)correct*100.0/(double)total_quiz;
       FileWriter fw = new FileWriter("Cse_quiz_leaderBoard.txt",true);
       fw.write(stud_id+"|"+name+"|"+ total_quiz+"|"+correct+"|"+percentage+"\n");
       fw.close();
       

   	Scanner sc111 = new Scanner(System.in);
       System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc111.next().charAt(0);
       student_panel_start(stud_id,name);
        // for QUIZ
        
    }
    public static void Quiz_Phy(String stud_id,String name) throws IOException{
      


    	String sub ="phy";
    	ArrayList<QUIZ> A__L = new ArrayList<>();
    	
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("hello");
        String fname=teacher_name(sub);
        System.out.println(fname);
        
        	
        System.out.println("hhhh");
        System.out.println();
        fname+="_phy_quiz.txt";
        System.out.println(fname);
        // Teacher file read
       File fread = new File(fname);
       Scanner sc11 = new Scanner(fread);
       
       while(sc11.hasNextLine())
       {

           String que = sc11.nextLine();
           String ans = sc11.nextLine();
           String option = sc11.nextLine();
           String[] line = option.split("\\|");
           A__L.add(new QUIZ(que, ans, line));
       }
      //System.out.println("loop par");
       Collections.shuffle(A__L, new Random());
       //System.out.println("shuffel");
       int correct=0;
       for (int i = 0; i < A__L.size(); i++) {
           System.out.println("Q"+(i+1)+". "+A__L.get(i).getQuestion());
           //System.out.println(A__L.get(i).getAns());
           System.out.println();
           for (int j = 0; j < A__L.get(i).getOl().size(); j++) {
               System.out.println((j+1)+")."+(A__L.get(i).getOl().get(j)));
           }
           System.out.print("Enter your ans :");int choice =sc.nextInt();
           if(A__L.get(i).getAns().equals(A__L.get(i).getOl().get(choice-1)))
        	   {
        	   ++correct;
        	   
        	   }
           else System.out.println(A__L.get(i).getOl().get(choice-1));
       }
       System.out.println(correct);
       int total_quiz =A__L.size();
       double percentage =(double)correct*100.0/(double)total_quiz;
       FileWriter fw = new FileWriter("Phy_quiz_leaderBoard.txt",true);
       fw.write(stud_id+"|"+name+"|"+ total_quiz+"|"+correct+"|"+percentage+"\n");
       fw.close();
       

   	Scanner sc111 = new Scanner(System.in);
       System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc111.next().charAt(0);
       student_panel_start(stud_id,name);
    	
    }

    public static void CGPA_Calculator(String stud_id, String name) throws IOException{
        System.out.println("Coming Soon!!!");

    	Scanner sc1 = new Scanner(System.in);
        System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
        student_panel_start(stud_id,name);

    }
    public static void Play_Game(String stud_id, String name) throws IOException{

        System.out.println("Coming Soon!!!");

    	Scanner sc1 = new Scanner(System.in);
        System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
        student_panel_start(stud_id,name);

    }
    public static void Educational_Material(String stud_id, String name) throws IOException{
    	 Scanner sc = new Scanner(System.in);

         System.out.println("\n\t\t\t\t\t<<<---------------S T U D Y   M A T E R I A L S-------->>>");
         System.out.println("\t\t\t\t\t1.Computer Science And Engineering(CSE)");
         System.out.println("\t\t\t\t\t2.Physics(phy)");
         System.out.println("\t\t\t\t\t3.Math");
         System.out.println("\t\t\t\t\t4.Back");

         System.out.print("\n\t\t\t\t\tEnter your Choice:");
         int c = sc.nextInt();

         switch (c) {
             case 1:
                 study_cse(stud_id,name);
                 break;
             case 2:
                 study_phy(stud_id,name);
                 break;
             case 3:
                 study_math(stud_id,name);
                 break;
                 
             case 4:
                 student_panel_start(stud_id,name);
                 break;
             default:
            	 
                 System.out.println("\n\t\t\t\t\tPlease enter the correct option");
                 System.out.println("\n");
                 Educational_Material(stud_id,name);
         }

    }
    public static void study_cse(String stud_id, String name) throws IOException{
        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        try

        {
            File File_Teacher = new File("Teacher_Signup_Data.txt");
            Scanner Access_teacher_bio = new Scanner(File_Teacher);

            while (Access_teacher_bio.hasNextLine()) {
                String line = Access_teacher_bio.nextLine();
                String[] T_Data = line.split(",");

                Al.add(new Teacher_Bio(T_Data[0], T_Data[1], T_Data[2], T_Data[3], T_Data[4], T_Data[5]));

            }
        }
        catch (IOException e) {

        }

        Scanner sc = new Scanner(System.in);

        System.out.print("\t\t\t\t\tEnter faculty username : ");
        String teacher_username = sc.nextLine();

        String file_address_cse = teacher_username;
        String file_address_math = teacher_username;
        String file_address_phy = teacher_username;
        for (int i = 0; i < Al.size(); i++) {
            if (Al.get(i).getUser_name().equals(teacher_username)) {
                file_address_cse += "_cse_study.txt";
                file_address_math += "_math_study.txt";
                file_address_phy += "_phy_study.txt";
            }
        }
        File f_cse = new File(file_address_cse);
        try {
            Scanner f_read = new Scanner(f_cse);

            while (f_read.hasNextLine()) {
                String line = f_read.nextLine();
                System.out.println(line);
            }
            Scanner sc1 = new Scanner(System.in);
            System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
            student_panel_start(stud_id,name);

        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
    public static void study_phy(String stud_id,String name) throws IOException{
        ArrayList<Teacher_Bio> Al = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("\t\t\t\t\tEnter faculty username : ");
        String teacher_username = sc.nextLine();
        teacher_username+="_phy_study.txt";
        File f_cse = new File(teacher_username);
        try {
            Scanner f_read = new Scanner(f_cse);

            while (f_read.hasNextLine()) {
                String line = f_read.nextLine();
                System.out.println(line);
            }
            Scanner sc1 = new Scanner(System.in);
            System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
            student_panel_start(stud_id,name);

        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
    public static void study_math(String stud_id,String name) throws IOException{
        ArrayList<Teacher_Bio> Al = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("\t\t\t\t\tEnter faculty username : ");
        String teacher_username = sc.nextLine();
        teacher_username+="_math_study.txt";
        File f_cse = new File(teacher_username);
        try {
            Scanner f_read = new Scanner(f_cse);

            while (f_read.hasNextLine()) {
                String line = f_read.nextLine();
                System.out.println(line);
            }
            Scanner sc1 = new Scanner(System.in);
            System.out.print("\t\t\t\t\tPress any key to continue :");char x=sc1.next().charAt(0);
            student_panel_start(stud_id,name);

        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
}
