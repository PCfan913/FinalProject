import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Driver implements ActionListener {
	ArrayList<Info> collegeList;
	
	JComboBox<String> colleges;
	
	JFrame frame;
	
	JButton getInfo;
	JButton clear;
	JButton exit;
	
	final JLabel NAME = new JLabel("Name:");
	final JLabel TUITION = new JLabel("Tuition:");
	final JLabel STUDENTS = new JLabel("Students:");
	final JLabel TEACHERS = new JLabel("Teachers:");
	final JLabel AVERAGECLASSSIZE = new JLabel("Average class size:");
	final JLabel GPA = new JLabel("GPA:");
	final JLabel ACCEPTANCERATE = new JLabel("Acceptance rate:");
	final JLabel SATSCORE = new JLabel("SAT score:");
	final JLabel ACTSCORE = new JLabel("ACT score:");
	
	JLabel name;
	JLabel tuition;
	JLabel students;
	JLabel teachers;
	JLabel averageClassSize;
	JLabel gpa;
	JLabel acceptanceRate;
	JLabel satScore;
	JLabel actScore;
	JLabel imageLabel;
	JPanel imagePanel;
	
	public static void main(String[] args) {
		Driver d = new Driver();
		d.setup();
	}
	
	public void setup() {
		// TODO Auto-generated method stub
		//Create colleges and add to list
		collegeList = new ArrayList<Info>();
		//name,tuition,students,teachers,averageClassSize,gpa,acceptanceRate,satScore,actScore
		Info Princeton = new Info("Princeton University");
		Princeton.setTuition(45320);
		Princeton.setStudents(8138);
		Princeton.setImageLocation("src\\Princeton.jpg");
		collegeList.add(Princeton);
		
		Info Purdue = new Info("Purdue University");
		Purdue.setTuition(10002);
		Purdue.setStudents(39409);
		Purdue.setImageLocation("src\\Purdue.jpg");
		collegeList.add(Purdue);
		
		Info IU = new Info("Indiana University");
		IU.setTuition(10388);
		IU.setStudents(48514);
		IU.setImageLocation("src\\Indiana.jpg");
		collegeList.add(IU);
		
		Info test = new Info ("Test");
		test.setTuition(70000);
		test.setAcceptanceRate(1);
		test.setStudents(1000);
		test.setGPA(3.4);
		test.setTeachers(900);
		collegeList.add(test);
		
		
		/*for (int i = 0; i < 4; i++) {
			System.out.println(collegeList.get(i));
		}*/
		//Sort the list by name
		insertionSort(collegeList);
		/*for (int i = 0; i < 4; i++) {
			System.out.println(collegeList.get(i));
		}*/
		
		frame = new JFrame("College Information");
		frame.setLayout(null);
		frame.setSize(600, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		String[] names = new String[collegeList.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = collegeList.get(i).getName();
		}
		
		colleges = new JComboBox<String>(names);
		colleges.setBounds(20,20,200,20);
		frame.add(colleges);
		
		//Info button
		getInfo = new JButton("Get Information");
		getInfo.setBounds(220,380,130,20);
		getInfo.addActionListener(this);
		frame.add(getInfo);
		
		//Clear button
		clear = new JButton("Clear");
		clear.setBounds(10,380,100,20);
		clear.addActionListener(this);
		frame.add(clear);
		
		//Exit button
		exit = new JButton("Exit");
		exit.setBounds(460,380,130,20);
		exit.addActionListener(this);
		frame.add(exit);
		
		//Permanent labels
		NAME.setBounds(20,70,40,20);
		frame.add(NAME);
		TUITION.setBounds(20,100,50,20);
		frame.add(TUITION);
		STUDENTS.setBounds(20,130,60,20);
		frame.add(STUDENTS);
		TEACHERS.setBounds(20,160,60,20);
		frame.add(TEACHERS);
		AVERAGECLASSSIZE.setBounds(20,190,110,20);
		frame.add(AVERAGECLASSSIZE);
		GPA.setBounds(20,220,30,20);
		frame.add(GPA);
		ACCEPTANCERATE.setBounds(20,250,100,20);
		frame.add(ACCEPTANCERATE);
		SATSCORE.setBounds(20,280,70,20);
		frame.add(SATSCORE);
		ACTSCORE.setBounds(20,310,70,20);
		frame.add(ACTSCORE);
		
		//Variable labels
		name = new JLabel();
		name.setBounds(70,70,250,20);
		frame.add(name);
		tuition = new JLabel();
		tuition.setBounds(80,100,200,20);
		frame.add(tuition);
		students = new JLabel();
		students.setBounds(90,130,200,20);
		frame.add(students);
		teachers = new JLabel();
		teachers.setBounds(90,160,200,20);
		frame.add(teachers);
		averageClassSize = new JLabel();
		averageClassSize.setBounds(140,190,200,20);
		frame.add(averageClassSize);
		gpa = new JLabel();
		gpa.setBounds(60,220,200,20);
		frame.add(gpa);
		acceptanceRate = new JLabel();
		acceptanceRate.setBounds(130,250,200,20);
		frame.add(acceptanceRate);
		satScore = new JLabel();
		satScore.setBounds(100,280,200,20);
		frame.add(satScore);
		actScore = new JLabel();
		actScore.setBounds(100,310,200,20);
		frame.add(actScore);
		
		//image panel
		imagePanel = new JPanel();
		imagePanel.setBounds(250, 25, 300, 350);
		frame.add(imagePanel);
		
		//image label
		imageLabel = new JLabel();
		imageLabel.setBounds(imagePanel.getBounds());
		imagePanel.add(imageLabel);
		
		frame.setVisible(true);
	}
	
	
	//Sorting algorithm to sort colleges alphabetically
	public static void insertionSort(ArrayList<Info> list){
		for(int index = 1; index < list.size(); index++){
			Info key = list.get(index);
			int position = index;
			
			//shift larger values to the right
			while(position > 0 && (list.get(position-1).getName()).compareTo(key.getName()) > 0){
				list.set(position, list.get(position-1));
				position--;
			}
			list.set(position, key);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getInfo) {
			int index = colleges.getSelectedIndex();
			String strName = collegeList.get(index).getName();
			name.setText(strName);
			String strTuition = "$" + String.valueOf(collegeList.get(index).getTuition());
			if (strTuition.substring(1,strTuition.indexOf(".")).length() > 3) {
				for (int i = strTuition.indexOf(".")-4; i > 0; i-=3) {
					strTuition = strTuition.substring(0, i+1) + "," + strTuition.substring(i+1);
				}
			}
			if (strTuition.substring(strTuition.length()-1).equals("0")) {
				strTuition += "0";
			}
			if (strTuition.equals("$0.00")) {
				tuition.setText("Unknown");
			} else {
			tuition.setText(strTuition);
			}
			String strStudents = String.valueOf(collegeList.get(index).getStudents());
			if (strStudents.length() > 3) {
				for (int i = strStudents.length()-4; i >= 0; i-=3) {
					strStudents = strStudents.substring(0, i+1) + "," + strStudents.substring(i+1);
				}
			}
			if (strStudents.equals("0")) {
				students.setText("Unknown");
			} else {
			students.setText(strStudents);
			}
			String strTeachers = String.valueOf(collegeList.get(index).getTeachers());
			if (strTeachers.equals("0")) {
				teachers.setText("Unknown");
			} else {
			teachers.setText(strTeachers);
			}
			String strAverageClassSize = String.valueOf(collegeList.get(index).getAverageClassSize());
			if (strAverageClassSize.equals("0")) {
				averageClassSize.setText("Unknown");
			} else {
			averageClassSize.setText(strAverageClassSize);
			}
			String strGPA = String.valueOf(collegeList.get(index).getGPA());
			if (strGPA.substring(strGPA.length()-1).equals("0")) {
				strGPA = strGPA.substring(0, strGPA.length()-1);
			}
			if (strGPA.substring(strGPA.length()-1).equals(".")) {
				strGPA = strGPA.substring(0,strGPA.length()-1);
			}
			if (strGPA.equals("0")) {
				gpa.setText("Unknown");
			} else {
			gpa.setText(strGPA);
			}
			String strAcceptanceRate = String.valueOf(collegeList.get(index).getAcceptanceRate());
			if (strAcceptanceRate.substring(strAcceptanceRate.length()-1).equals("0")) {
				strAcceptanceRate = strAcceptanceRate.substring(0, strAcceptanceRate.length()-1);
			}
			if (strAcceptanceRate.substring(strAcceptanceRate.length()-1).equals(".")) {
				strAcceptanceRate = strAcceptanceRate.substring(0,strAcceptanceRate.length()-1);
			}
			if (strAcceptanceRate.equals("0")) {
				acceptanceRate.setText("Unknown");
			} else {
			acceptanceRate.setText(strAcceptanceRate);
			}
			String strSatScore = String.valueOf(collegeList.get(index).getSATScore());
			if (strSatScore.equals("0")) {
				satScore.setText("Unknown");
			} else {
			satScore.setText(strSatScore);
			}
			String strActScore = String.valueOf(collegeList.get(index).getACTScore());
			if (strActScore.equals("0")) {
				actScore.setText("Unknown");
			} else {
			actScore.setText(strActScore);
			}
			ImageIcon image = new ImageIcon(collegeList.get(index).getImageLocation());
			imageLabel.setIcon(image);
		}
		
		if (e.getSource() == clear) {
			name.setText("");
			tuition.setText("");
			students.setText("");
			teachers.setText("");
			averageClassSize.setText("");
			gpa.setText("");
			acceptanceRate.setText("");
			satScore.setText("");
			actScore.setText("");
			imageLabel.setIcon(null);
			
		}
		
		if (e.getSource() == exit) {
			frame.dispose();
		}
	}

}
