//the frame is what the gui shows and panel is what I use to pass in the parameters
// loginPanel is the gui that asks to sign in or make an account. panel is the gui that allows the user to make an account, panel2 is the gui the user sees
//after logging in or making an account. the Jlabels, JTextfields, and JButton are explained by their button names or the Jlabel that connects with it.
//the string int and char variables store the information of the user logging in or making an account
//the constructor creates the gui and adds all the actionlisteners of the buttons
//addAllActionListeners method adds all the action listeners for the buttons so they can do something when pressed
//setFrameAndPanel sets the size and location of the gui and then makes the loginpanel
//loginPanel method adds the labels and textfields and buttons to the panel then adds the panel to the frame and clears the textfields
//setPanel method add the labels and textfields and buttons to the panel then to the frame then clears the textfields, this is the gui for making an account
//removePanel1 method removes the panel to make a user
//removePanel2 method removes the panel that shows up after they login or submit an account
//removeLoginPanel method removes the panel that asks to login or make an account
//setFrameAndPanel2 adds the labels and buttons to the panel then the frame for panel2
//actionPerformed method runs whenever a button is pressed. the first if statement runs when buttonm is pressed and makes a checkmark for buttonm and f for buttonf
//and makes the gender variable equal to buttonm
// the second if statement is the same as the first if statement but is for buttonf
//the 3rd if statement runs when buttonFeet is pressed and runs the settingFeet method
//the 4th if statement runs when buttonInch is pressed and runs the settingInch method
//the 5th if statement runs when buttonMonth is pressed and runs the settingMonth method
//the 6th if statement runs when buttonDay is pressed and runs the settingDay method
//the 7th if statement runs when buttonYear is pressed and runs the settingYear method
//the 8th if statement runs when buttonSubmit is pressed and runs the pressSubmit method
//the 9th if statement runs when buttonLogout is pressed and removes panel2 and adds the loginPanel
//the 10th if statement runs when buttonLogin is pressed and runs the pressLogin method
// the 11th if statement runs when buttonSignUp is pressed and remvoes the loginPanel and adds the panel
//pressLogin method checks to see if the login parameters equal one of the saved users in the textfile and if it is true it removes the loginPanel and adds panel2
//the else statement sets the label to error finding user
//pressSubmit method takes all the information the user puts in and makes a dojoUser out of it and prints it to the userData.txt then removes the panel and adds panel2
//resetFieldsAndButtons method sets all buttons and textfields back to how they were before the user was created so they can be typed in and clicked again
//settingFeet method adds one to heightFeet  and adds one to the buttonFeet text everytime the button is clicked, but if heightFeet is greater than 12 set heightFeet to zero and set buttonFeet text to zero
//settingInch method does the same as settingFeet but uses heightInches instead of heightFeet and changes the text of buttonInch instead of buttonFeet
//settingMonth adds one to month and adds one to the buttonMonth text unless month goes over 12 then reset both month and buttonMonth text to 1
//setting day method adds one to day and adds one to buttonDay text unless day is over 31 then set day to one and buttonDay text to one
//settingYear method adds one to year and adds one to buttonYear text unless year is greater than 2018 then set year to 1980 and buttonYear text to 1980
//returnUser method returns the dojoUser user1

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class UserInterface extends JFrame implements ActionListener
{

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel loginPanel= new JPanel();
	
	private JLabel textLabel1 = new JLabel("type in your username:");
	private JTextField textField1= new JTextField(20);
	private JLabel textLabel2 = new JLabel("type in your password:");
	private JTextField textField2= new JTextField(20);
	private JLabel textLabel3 = new JLabel("click a button for your gender:");
	private JLabel textLabel4 = new JLabel("click each button for your height(feet and inches):");
	private JLabel textLabel5 = new JLabel("type in your favorite animal:");
	private JTextField textField5= new JTextField(15);
	private JLabel textLabel6 = new JLabel("type in your favorite food:");
	private JTextField textField6= new JTextField(15);
	private JLabel textLabel7 = new JLabel("click the buttons until it is your birth month day and year         ");
	private JLabel textLabel8 = new JLabel("type in where you were born:");
	private JTextField textField8= new JTextField(10);
	private JLabel labelSpace = new JLabel("                         ");
	private JLabel loginLabel= new JLabel("welcome!");
	private JLabel needAcc=new JLabel("need an account?");
	
	private JButton buttonLogin = new JButton("login");
	private JButton buttonSignUp = new JButton("click here");
	
	private JButton buttonm = new JButton("M");
	private JButton buttonf = new JButton("F");
	private JButton buttonFeet = new JButton("0");
	private JButton buttonInch = new JButton("0");
	private JButton buttonMonth = new JButton("1");
	private JButton buttonDay = new JButton("1");
	private JButton buttonYear = new JButton("1980");
	private JButton buttonSubmit= new JButton("submit");
	
	private JLabel panel2HelloLabel = new JLabel();
	private JButton buttonLogout=new JButton("logout");
	
	private String userName="";
	private String password="";
	private char gender='M';
	private char tempGender='M';
	private int heightFeet=0;
	private int heightInches=0;
	private String animal="";
	private String food="";
	private int month=1;
	private int day=1;
	private int year=1980;
	private String birthLoc="";
	private static dojoUser user1;
	
	
	
	public UserInterface(){
		setFrameAndPanel();
		addAllActionListeners();
		}
	public void addAllActionListeners()
	{
		buttonm.addActionListener(this);
		buttonf.addActionListener(this);
		buttonFeet.addActionListener(this);
		buttonInch.addActionListener(this);
		buttonMonth.addActionListener(this);
		buttonDay.addActionListener(this);
		buttonYear.addActionListener(this);
		buttonSubmit.addActionListener(this);
		buttonLogout.addActionListener(this);
		buttonLogin.addActionListener(this);
		buttonSignUp.addActionListener(this);
	}
	
	
	public void setFrameAndPanel()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(390, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		loginPanel();
	}
	public void loginPanel()
	{
		frame.getContentPane().add(loginPanel);
		loginPanel.add(loginLabel);
		loginPanel.add(textLabel1);
		loginPanel.add(textField1);
		loginPanel.add(labelSpace);
		loginPanel.add(textLabel2);
		loginPanel.add(textField2);
		loginPanel.add(buttonLogin);
		loginPanel.add(needAcc);
		loginPanel.add(buttonSignUp);
		resetFieldsAndButtons();
	}
	public void setPanel(){
		frame.getContentPane().add(panel);
		panel.add(textLabel1);
		panel.add(textField1);
		panel.add(textLabel2);
		panel.add(textField2);
		panel.add(textLabel3);
		panel.add(buttonm);
		panel.add(buttonf);
		panel.add(textLabel4);
		panel.add(buttonFeet);
		panel.add(buttonInch);
		panel.add(textLabel5);
		panel.add(textField5);
		panel.add(textLabel6);
		panel.add(textField6);
		panel.add(textLabel7);
		panel.add(buttonMonth);
		panel.add(buttonDay);
		panel.add(buttonYear);
		panel.add(labelSpace);
		panel.add(textLabel8);
		panel.add(textField8);
		panel.add(buttonSubmit);
		
		frame.repaint();
		frame.validate();
		resetFieldsAndButtons();
	}
	
	public void removePanel1()
	{
		frame.getContentPane().remove(panel);
		frame.repaint();
		frame.validate();
	}
	
	public void removePanel2()
	{
		frame.getContentPane().remove(panel2);
		frame.repaint();
		frame.validate();
	}
	public void removeLoginPanel()
	{
		frame.getContentPane().remove(loginPanel);
		frame.repaint();
		frame.validate();
	}
	
	public void setFrameAndPanel2()
	{
		panel2HelloLabel.setText("Hello "+textField1.getText());
		panel2.add(panel2HelloLabel);
		panel2.add(buttonLogout);
		frame.getContentPane().add(panel2);
		frame.repaint();
		frame.validate();
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==buttonm)
		{
			buttonm.setText("V");
			buttonf.setText("F");
			tempGender='m';
			
		}
		else if(event.getSource()==buttonf)
		{
			buttonm.setText("M");
			buttonf.setText("V");
			tempGender='f';
		}
		else if(event.getSource()==buttonFeet)
		{
			settingFeet();
		}
		else if(event.getSource()==buttonInch)
		{
			settingInch();
		}
		else if(event.getSource()==buttonMonth)
		{
			settingMonth();
		}
		else if(event.getSource()==buttonDay)
		{
			settingDay();
		}
		else if(event.getSource()==buttonYear)
		{
			settingYear();
		}
		else if(event.getSource()==buttonSubmit)
		{
			pressSubmit();
		}
		else if(event.getSource()==buttonLogout)
		{
			removePanel2();
			loginPanel();
			frame.repaint();
			frame.validate();
		}
		else if(event.getSource()==buttonLogin)
		{
			pressLogin();
		}
		else if(event.getSource()==buttonSignUp)
		{
			removeLoginPanel();
			setPanel();
		}
	}
	public void pressLogin()
	{
		if(UserDataFile.isAnAccount(textField1.getText(),textField2.getText())==true)
		{
		removeLoginPanel();
		setFrameAndPanel2();
		}
		else
		{
			loginLabel.setText("error finding user");
		}
		
	}
	
	public void pressSubmit(){
		userName=textField1.getText();
		password=textField2.getText();
		gender=tempGender;
		animal=textField5.getText();
		food=textField6.getText();
		birthLoc=textField8.getText();
		user1 =new dojoUser(userName,password,gender,heightFeet,heightInches,animal,food,month,day,year,birthLoc);
		
		UserDataFile.printUser();
		removePanel1();
		setFrameAndPanel2();
	}
	
	public void resetFieldsAndButtons()
	{
		textField1.setText("");
		textField2.setText("");
		textField5.setText("");
		textField6.setText("");
		textField8.setText("");
		buttonm.setText("M");
		buttonf.setText("F");
		buttonFeet.setText("0");
		buttonInch.setText("0");
		buttonMonth.setText("1");
		buttonDay.setText("1");
		buttonYear.setText("1980");
		heightFeet=0;
		heightInches=0;
		month=1;
		day=1;
		year=1980;
	}
	public void settingFeet()
	{
		if(heightFeet>=0&&heightFeet<12)
		{
			heightFeet++;
			buttonFeet.setText(String.valueOf(heightFeet));
		}
		else
		{
			heightFeet=0;
			buttonFeet.setText(String.valueOf(heightFeet));
		}
	}
	public void settingInch()
	{
		if(heightInches>=0&&heightInches<11)
		{
			heightInches++;
			buttonInch.setText(String.valueOf(heightInches));
		}
		else
		{
			heightInches=0;
			buttonInch.setText(String.valueOf(heightInches));
		}
	}
	public void settingMonth() 
	{
		if(month>0&&month<12)
		{
			month++;
			buttonMonth.setText(String.valueOf(month));
		}
		else
		{
			month=1;
			buttonMonth.setText(String.valueOf(month));
		}
	}
	public void settingDay()
	{
		if(day>0&&day<31)
		{
			day++;
			buttonDay.setText(String.valueOf(day));
		}
		else
		{
			day=1;
			buttonDay.setText(String.valueOf(day));
		}
	}
	public void settingYear()
	{
		if(year>1979&&year<2018)
		{
			year++;
			buttonYear.setText(String.valueOf(year));
		}
		else
		{
			year=1;
			buttonYear.setText(String.valueOf(year));
		}
	}
	
	public static dojoUser returnUser()
	{
		return user1;
	}
	
	

}
