import java.util.Random;

public class Events {
	private Input input;
	private int answer;
	private Player player;
	private Enemy goblin;
	private Random random = new Random();
	
	public Events() {
		Classes();
		PlayerCharacter();
		StartUp();
	}
	
	public void Classes() { //loads all of the excess classes
		input = new Input();
		player = new Player();
		goblin = new Enemy("Goblin", 7, 5, 10, 5, "easy");
	}
	
	public void PlayerCharacter() { //basic classes to start with
		System.out.println("========================================");
		System.out.println("What would you like to play as?");
		System.out.println("1. Knight");
		System.out.println("2. Rogue");
		System.out.println("3. Wizard");
		System.out.println("----------------------------------------");
		int answer = input.numInput();
		switch (answer) {
		case 1: 
			player = new Player("Knight", 15, 5, 10, "Strike", "Shoulder Bump", "Impale", 8, 4, 7);
			break;
		case 2:
			player = new Player("Rogue", 12, 15, 3, "Stab", "Trip", "Slice", 5, 2, 6);
			break;
		case 3:
			player = new Player("Wizard", 8, 12, 10, "Fire Ball", "Lightening Strike", "Extra Hands", 8, 9, 6);
			break;
		}
	}
	
	public void Playerstats(Player player) { //shows that players stats
		System.out.println("========================================");
		System.out.println("Player: " + player.getName());
		System.out.println("Health: " + player.getHealth() + " Speed: " + player.getSpeed() + " Defence: " + player.getDefence());
		System.out.println("========================================");
	} //end of player stats
	
	public void Enemystats(Enemy enemy) { //shows that enemy's stats
		System.out.println("========================================");
		System.out.println("Enemy: " + enemy.getName());
		System.out.println("Health: " + enemy.getHealth() + " Speed: " + enemy.getSpeed() + " Defence: " + enemy.getDefence());
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
				if (TestDead(player, enemy)) {
					attacking = false; 
					continue;
				}
				PlayerTurn(player, enemy);
				if (TestDead(player, enemy)) {
					attacking = false; 
					continue;
				}
			} else {
				PlayerTurn(player, enemy);
				if (TestDead(player, enemy)) {
					attacking = false; 
					continue;
				}
				EnemyTurn(player, enemy);
				if (TestDead(player, enemy)) {
					attacking = false; 
					continue;
				}
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
			return true;
		} else {
			return false;
		}
	}
	
	private void PlayerTurn(Player player, Enemy enemy) { //players turn during combat
		Playerstats(player);
		System.out.println(player.getName() + "'s Turn");
		System.out.println("----------------------------------------");
			player.Moves(input, player.getM1(), player.getM2(), player.getM3(), player.getD1(), player.getD2(), player.getD3());
			if (random.nextInt(20) + 1 >= enemy.getSpeed()) {
				int damage = Damage(enemy.getDefence(), player.getDamage());
				System.out.println(enemy.getName() + " is delt " + damage + " damage!");
				enemy.setHealth(enemy.getHealth() - damage);
			} else {
			System.out.println("Miss!");
			}
		return;
	} //end of player turn

	private void EnemyTurn(Player player, Enemy enemy) { //enemy's turn during combat
		Enemystats(enemy);
		System.out.println(enemy.getName() + "'s Turn");
		System.out.println("----------------------------------------");
		if (random.nextInt(20) + 1 >= player.getSpeed()) {
			int damage = Damage(player.getDefence(), enemy.getDamage());
			System.out.println(player.getName() + " is delt " + damage + " damage!");
			player.setHealth(player.getHealth() - damage);
		} else {
			System.out.println("Miss!");
		}
		return;
	} //end of enemy turn

	private int Damage(int defence, int attack) { //damage inflicted during combat
		if(random.nextInt(20) + 1 < defence) {
			System.out.println("No damage!");
			return 0;
		} else {
			int damage = attack - defence;
			if (damage > 0) {
				return damage;
			} else {
				System.out.println("No damage!");
				return 0;
			}
		}
	} //end of damage
}
