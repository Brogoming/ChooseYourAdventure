
public class Events {
	private Input input;
	private int answer;
	private String name;
	
	public Events() {
		input = new Input();
		System.out.println("What is your name?");
		name = input.stringInput();
		startUp();
	}
	
	public void startUp() { 
		System.out.println("You are at a 3 way intersection " + name + ". Where do you want to go?");
		System.out.println("1. Left");
		System.out.println("2. Right");
		System.out.println("3. Forward");
		answer = input.numInput();
		
		switch(answer) {
		case 1:
			event1();
			break;
		case 2:
			
		case 3:
			
		}
		
	}
	
	private void event1() {
		System.out.println("You are at a 4 way intersection. Where do you want to go?");
		System.out.println("1. Left");
		System.out.println("2. Right");
		System.out.println("3. Forward");
		
		answer = input.numInput();
		switch(answer) {
		case 1:
			
		case 2:
			
		case 3:
			
		}
	}

	
}
