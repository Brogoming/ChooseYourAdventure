import java.util.Scanner;

public class Input {
	private Scanner scan;
	private int num;
	private String string;
	
	public Input(){
		scan = new Scanner(System.in);
	}
	
	public int numInput() { //gets users number input
		System.out.println("========================================");
		num = scan.nextInt();
		System.out.println("========================================");
		return num;
	}
	
	public String stringInput() { //gets users word input
		System.out.println("========================================");
		string = scan.next();
		System.out.println("========================================");
		return string;
	}

}
