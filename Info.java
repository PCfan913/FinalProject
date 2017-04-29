
public class Info {
	
	private String name;
	private double tuition;
	private int students;
	private int teachers;
	private int averageClassSize;
	private double gpa;
	private double acceptanceRate;
	private int satScore;
	private int actScore;
	private String imageLocation;
	
	public Info(String name) {
		this.name = name;
	}
	
	public Info(String name, double tuition, int students, int teachers, int averageClassSize, double gpa, double acceptanceRate, int satScore, int actScore, String imageLocation) {
		this.name = name;
		this.tuition = tuition;
		this.students = students;
		this.teachers = teachers;
		this.averageClassSize = averageClassSize;
		this.gpa = gpa;
		this.acceptanceRate = acceptanceRate;
		this.satScore = satScore;
		this.actScore = actScore;
		this.imageLocation = imageLocation;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getTuition() {
		return this.tuition;
	}
	
	public int getStudents() {
		return this.students;
	}
	
	public int getTeachers() {
		return this.teachers;
	}
	
	public int getAverageClassSize() {
		return this.averageClassSize;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public double getAcceptanceRate() {
		return this.acceptanceRate;
	}
	
	public int getSATScore() {
		return this.satScore;
	}
	
	public int getACTScore() {
		return this.actScore;
	}
	
	public String getImageLocation() {
		return this.imageLocation;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	
	public void setStudents(int students) {
		this.students = students;
	}
	
	public void setTeachers(int teachers) {
		this.teachers = teachers;
	}
	
	public void setAverageClassSize(int size) {
		this.averageClassSize = size;
	}
	
	public void setGPA (double gpa) {
		this.gpa = gpa;
	}
	
	public void setAcceptanceRate(double acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}
	
	public void setSATScore(int score) {
		this.satScore = score;
	}
	
	public void setACTScore(int score) {
		this.actScore = score;
	}
	
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
