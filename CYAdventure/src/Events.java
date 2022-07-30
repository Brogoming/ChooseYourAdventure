import java.util.Random;

public class Events {
	private Input input;
	private int answer;
	private Player player;
	private Enemy goblin;
	private Random random = new Random();
	
	public Events() {
		Classes();
		PlayerSetup();
		StartUp();
	}
	
	public void Classes() { //loads all of the excess classes
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
		System.out.println("Player: " + player.getName());
		System.out.println("Health: " + player.getHealth() + " Speed: " + player.getSpeed() + " Damage: " + player.getDamage() + " Defence: " + player.getDefence());
		System.out.println("========================================");
	} //end of player stats
	
	public void Enemystats(Enemy enemy) { //shows that enemy's stats
		System.out.println("========================================");
		System.out.println("Enemy: " + enemy.getName());
		System.out.println("Health: " + enemy.getHealth() + " Speed: " + enemy.getSpeed() + " Damage: " + enemy.getDamage() + " Defence: " + enemy.getDefence());
		System.out.println("========================================");
	} //end of player enemy's
	
	public void StartUp() { 
		Combat(player, goblin);
	}
	
	private void Combat(Player player, Enemy enemy) { //combat between 2 people
		boolean attacking = true;
		while(attacking){
			if (enemy.getSpeed() > player.getSpeed()) { //the enemy attacks
				EnemyTurn(player, enemy);
				PlayerTurn(player, enemy);
			} else {
				PlayerTurn(player, enemy);
				EnemyTurn(player, enemy);
			}
		}
	} //end of combat
	
	private boolean TestDead(Player player, Enemy enemy) {
		if (player.getHealth() <= 0 || enemy.getHealth() <= 0) {
			if(player.getHealth() <= 0) {
				System.out.println(player.getName() + " is dead!");
			}
			if(enemy.getHealth() <= 0) {
				System.out.println(enemy.getName() + " is dead!");
			}
			return false;
		} else {
			return true;
		}
	}
	
	private void PlayerTurn(Player player, Enemy enemy) { //players turn during combat
		Playerstats();
		System.out.println(player.getName() + "'s Turn");
		System.out.println("Enter 1 to continue");
		if (input.isStringInt(input.stringInput())) {
			System.out.println("----------------------------------------");
			if (random.nextInt(20) + 1 >= enemy.getSpeed()) {
				int damage = Damage(enemy.getDefence(), player.getDamage());
				System.out.println(enemy.getName() + " is delt " + damage + "!");
				enemy.setHealth(enemy.getHealth() - damage);
			} else {
				System.out.println("Miss!");
			}
			return;
		}
	} //end of player turn

	private void EnemyTurn(Player player, Enemy enemy) { //enemy's turn during combat
		Enemystats(enemy);
		System.out.println(enemy.getName() + "'s Turn");
		System.out.println("----------------------------------------");
		if (random.nextInt(20) + 1 >= player.getSpeed()) {
			int damage = Damage(player.getDefence(), enemy.getDamage());
			System.out.println("Player is delt " + damage + "!");
			player.setHealth(player.getHealth() - damage);
		} else {
			System.out.println("Miss!");
		}
		return;
	} //end of enemy turn

	private int Damage(int defence, int attack) { //damage inflicted during combat
		int damage = attack - defence;
		if (damage > 0) {
			return damage;
		} else {
			System.out.println("No damage!");
			return 0;
		}
	} //end of damage
}
