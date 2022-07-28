
public class Events {
	private Input input;
	private int answer;
	private Player player;
	private Enemy goblin;
	
	public Events() {
		Entities();
		PlayerSetup();
		startUp();
	}
	
	public void Entities() {
		input = new Input();
		player = new Player();
		goblin = new Enemy("Goblin", 5, 5, 5, 1, 5);
	}
	
	public void PlayerSetup() {
		System.out.println("What is your name?");
		player.setName(input.stringInput());
		System.out.println("How much health do you have?");
		player.setHealth(input.numInput());
		System.out.println("How much speed do you have?");
		player.setSpeed(input.numInput());
		System.out.println("How much damage do you have?");
		player.setDamage(input.numInput());
		System.out.println("How much defence do you have?");
		player.setDefence(input.numInput());
	}
	
	public void Playerstats() { //shows that players stats
		System.out.println("========================================");
		System.out.println("Health: " + player.getHealth() + " Speed: " + player.getSpeed() + " Damage: " + player.getDamage() + " Defence: " + player.getDefence());
		System.out.println("========================================");
	}
	
	public void startUp() { 
		Playerstats();
		System.out.println("You are at a 3 way intersection " + player.getName() + ". Where do you want to go?");
		System.out.println("1. Left");
		System.out.println("2. Right");
		System.out.println("3. Forward");
		answer = input.numInput();
		System.out.println("========================================");
		
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
		System.out.println("========================================");
		
		switch(answer) {
		case 1:
			
		case 2:
			
		case 3:
			
		}
	}

	
}
