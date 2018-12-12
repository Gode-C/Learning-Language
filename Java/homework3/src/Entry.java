
public class Entry {
	private int score;
	private int month;
	private int day;
	
	public Entry(int score, int month, int day) {
		this.score = score;
		this.month = month;
		this.day = day;
	}
	
	public String toString() {
		return "Score: " + this.score + ", Date: " + this.month + "/" + this.day;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}

}
