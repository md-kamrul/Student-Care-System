package Teacher;

import java.io.*;
import java.util.*;

public class QUIZ {
    private String question;
    private String ans;
    private ArrayList<String> ol = new ArrayList<>();

    public QUIZ()
    {
    	
    }
    public QUIZ(String question, String ans, String[] op) {

        this.question = question;
        this.ans = ans;
        for (int i = 0; i < op.length; i++)
            ol.add(op[i]);

        Collections.shuffle(ol,new Random());
    }
    public String toOPTION(String[] op)
    {
    	String option = op[0]+"|";
    	for(int i=1;i<op.length;i++)
    	{
    		option +=op[i];
    		option +="|";
    	}
    	return option;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public ArrayList<String> getOl() {
        return ol;
    }

    public void setAl(ArrayList<String> al) {
        this.ol = ol;
    }

}