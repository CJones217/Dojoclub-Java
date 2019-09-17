// this is the class to make the dojoUser object
// the dojoUser has three constructors one that takes in no parameters, one that takes in 2 string parameters, and one that takes in all the private variables you see under the psuedo code
//each variable is actually the users information that they input and submit in the gui. it is 5 strings, 5 ints and 1 char. their names should explain what they hold.
//there are get methods that are for each variable 
// there is a toString method that takes each variable and makes it into a string that is easy to read and understand
public class dojoUser 
{
	private String userName="";
	private String userPassword="";
	private char gender;
	private int heightInFeet;
	private int heightInches;
	private String favAnimal="";
	private String favFood="";
	private int bdayMonth;
	private int bdayDay;
	private int bdayYear;
	private String birthLocation="";
	
	
	public dojoUser()
	{
		userName="defaultUser";
		userPassword="password";
		gender='m';
		heightInFeet=6;
		heightInches=0;
		favAnimal="dog";
		favFood="apple";
		bdayMonth=1;
		bdayDay=1;
		bdayYear=2000;
		birthLocation="earth";
		
		
		
	}
	public dojoUser(String inName, String inPassword)
	{
		userName=inName;
		userPassword=inPassword;
		gender='m';
		heightInFeet=6;
		heightInches=0;
		favAnimal="dog";
		favFood="apple";
		bdayMonth=1;
		bdayDay=1;
		bdayYear=2000;
		birthLocation="earth";
		
	}
	public dojoUser(String inName, String inPassword,char gen,int feet,int inch, String animal,String food,int bmonth,int bday,int byear,String bLoc)
	{
		userName=inName;
		userPassword=inPassword;
		gender=gen;
		heightInFeet=feet;
		heightInches=inch;
		favAnimal=animal;
		favFood=food;
		bdayMonth=bmonth;
		bdayDay=bday;
		bdayYear=byear;
		birthLocation=bLoc;
		
	}
	//get methods for all info
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return userPassword;
	}
	
	public char getGender()
	{
		return gender;
	}
	
	public int getHeightFeet()
	{
		return heightInFeet;
	}
	
	public int getHeightInches()
	{
		return heightInches;
	}
	
	public String getFavAnimal()
	{
		return favAnimal;
	}
	
	public String getFavFood()
	{
		return favFood;
	}
	
	public int getbdayMonth()
	{
		return bdayMonth;
	}
	
	public int getbdayDay()
	{
		return bdayDay;
	}
	
	public int getbdayYear()
	{
		return bdayYear;
	}
	public String getbirthLocation()
	{
		return birthLocation;
	}
	public String toString()
	{
		return "UserName: "+userName+" password: "+userPassword+" gender: "+Character.toString(gender)+" height: "+heightInFeet+"'"+heightInches+"''"+
	" favorite animal: "+favAnimal+" favorite food: "+favFood+" birthday: "+bdayMonth+"/"+bdayDay+"/"+bdayYear+" birthLocation: "+birthLocation;
	}
	
	

}
