import java.util.Scanner;

public class Input {
	private Scanner scan;
	private int num;
	private String string;
	
	public Input(){
		scan = new Scanner(System.in);
	}
	
	public int numInput() { //gets users number input
		num = scan.nextInt();
		return num;
	}
	
	public String stringInput() { //gets users word input

		string = scan.next();
		return string;
	}
	
	public boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

}
