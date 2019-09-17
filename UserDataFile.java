// this class creates the file that holds all the users information called "userData.txt"
//it uses one string for the name of the file, one printWriter for the outputStream to the file, a scanner to read the file, and two booleans
//the openFileStream method creates an outputStream so we are able to add things into userData.txt
//the printUser method print the toString of the dojoUser that has just submitted their information. the dojoUser is from the UserInterface class
//the isAnAccount method uses a scanner to scan userData.txt for the 2 strings passed in. these are the username and password of the user trying to login. the while loop makes sure if the two strings are not 
//found on a line itll move on to the next line and so on. it will return true if the strings are found and false otherwise




import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class UserDataFile {
	
	private static String fileName="userData.txt";
	private static PrintWriter outputStream=null;
	private static Scanner tempScanner=null;
	private static boolean isClosed = false;
	private static boolean taco =false;
	
	public UserDataFile()
	{
		openFileStream();
	}
	
	public static void openFileStream()// try catch method is needed because there might be an error when creating the outputStream
	{
		try
		{
			outputStream = new PrintWriter(new FileOutputStream(fileName,true));
			
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error opening the file"+fileName);
			System.exit(0);
		}
	}
	
	public static void printUser()
	{
		
			openFileStream();
			outputStream.println(UserInterface.returnUser().toString());
			outputStream.close();
			System.out.print("userData was written to"+fileName);
			
	}
	public static boolean isAnAccount(String s, String s2)
	{
		
		try{
		 tempScanner= new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error opening the file"+fileName);
			System.exit(0);
		}
		while(tempScanner.hasNextLine())
		{
			if(s.equals(tempScanner.findInLine(s))&&s2.equals(tempScanner.findInLine(s2)))
					{
						taco= true;
					}
			else 
			{
				taco=false;	
			}
				
				tempScanner.nextLine();
			
				
			if(taco==true)
				break;
		}
		return taco;
		
	}
	
	

	
}
