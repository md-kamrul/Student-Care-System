package Teacher;

public class Quiz_Leader_Board {

	private String name,id;
	private int total_quiz,correct_quiz;
	private double percentage;
	public Quiz_Leader_Board(String name, String id, String total_quiz, String correct_quiz, String percentage) {
		
		this.name = name;
		this.id = id;
		this.total_quiz = Integer.parseInt(total_quiz);
		this.correct_quiz =Integer.parseInt(correct_quiz);
		this.percentage = Double.parseDouble(percentage);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotal_quiz() {
		return total_quiz;
	}
	public void setTotal_quiz(int total_quiz) {
		this.total_quiz = total_quiz;
	}
	public int getCorrect_quiz() {
		return correct_quiz;
	}
	public void setCorrect_quiz(int correct_quiz) {
		this.correct_quiz = correct_quiz;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
}
