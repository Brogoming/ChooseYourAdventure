
public class Events {
	private Input input;
	private int answer;
	private Player player;
	private Enemy goblin;
	
	public Events() {
		Classes();
		PlayerSetup();
		StartUp();
	}
	
	public void Classes() {
		input = new Input();
		player = new Player();
		goblin = new Enemy("Goblin", 5, 5, 5, 1, "easy");
	}
	
	public void PlayerSetup() { //sets up the player stats
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
	} //end of player stats
	
	public void Playerstats() { //shows that players stats
		System.out.println("========================================");
		System.out.println("Health: " + player.getHealth() + " Speed: " + player.getSpeed() + " Damage: " + player.getDamage() + " Defence: " + player.getDefence());
		System.out.println("========================================");
	} //end of player stats
	
	public void StartUp() { 
		Playerstats();
		Combat(player, goblin);
		
	}
	
	private void Combat(Player player, Enemy enemy) { //combat between 2 people
		boolean attacking = true;
		
		while(attacking){
			if (player.getHealth() <= 0 || enemy.getHealth() <= 0) {
				attacking = false;
			} else {
				if (enemy.getSpeed() > player.getSpeed()) { //the enemy attacks
					player.setHealth(Damage(player.getDefence(), enemy.getDamage())); //sets the players health
				} else {
					enemy.setHealth(Damage(enemy.getDefence(), player.getDamage())); //sets the goblins health
				}
			}
		}
		if (player.getHealth() > 0) {
			System.out.println("Player wins!");
		}
		else {
			System.out.println(enemy.getName() + " wins!");
		}
	} //end of combat
	
	private int Damage(int defence, int attack) { //damage inflicted during combat
		int damage = attack - defence;
		if (damage > 0) {
			return damage;
		} else {
			System.out.println("No damage");
		}
		return 0;
	} //end of dmage
}
