import java.util.Random;

public class Events {
	private Input input;
	private int answer;
	private Random random = new Random();
	
	private Player player;
	private Enemy enemy;
	
	private Weapon sword;
	private Weapon dagger;
	private Weapon wand;
	private Weapon fist;
	
	public Events() {
		Classes();
		PlayerCharacter();
		GoblinFight("Goblin", 7, 10, 5, dagger);
//		SkeletonFight();
	}
	
	public void Classes() { //loads all of the excess classes
		input = new Input();
		Characters();
		Weapons();
	}
	
	public void Weapons() { //loads all weapons used
		sword = new Weapon("Sword", 8, 5);
		dagger = new Weapon("Dagger", 6, 4);
		wand = new Weapon("Wand", 10, 0);
		fist = new Weapon("Fist", 2, 1);
	}
	
	public void Characters() { //loads all characters used
		player = new Player();
		enemy = new Enemy();
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
			player = new Player("Knight", 15, 5, 10, sword);
			break;
		case 2:
			player = new Player("Rogue", 12, 15, 3, dagger);
			break;
		case 3:
			player = new Player("Wizard", 8, 12, 10, wand);
			break;
		}
	}// end of Player character
	
	public void Playerstats(Player player) { //shows that players stats
		System.out.println("========================================");
		System.out.println("Player: " + player.getName());
		System.out.println("Health: " + player.getHealth() + " Speed: " + player.getSpeed() + " Defence: " + player.getDefence());
	} //end of player stats
	
	public void Enemystats(Enemy enemy) { //shows that enemy's stats
		System.out.println("========================================");
		System.out.println("Enemy: " + enemy.getName());
		System.out.println("Health: " + enemy.getHealth() + " Speed: " + enemy.getSpeed() + " Defence: " + enemy.getDefence());
	} //end of player enemy's
	
	public void GoblinFight(String name, int health, int speed, int defence, Weapon weapon) { 
		enemy = new Enemy(name, health, speed, defence, weapon);
		Combat(player, enemy);
	}
	
//	public void SkeletonFight() {
//		enemy = new Enemy("Skeleton", 12, 5, 7, sword);
//		Combat(player, enemy);
//	}
//	
//	public void DragonFight() {
//		enemy = 
//	}
	
	private void Combat(Player player, Enemy enemy) { //combat between 2 people: player, enemy, player weapon, enemy weapon
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
		System.out.println("1. Use " + player.getWeapon().getName());
		answer = input.numInput();
		switch(answer) {
		case 1:
			if (random.nextInt(20) + 1 >= enemy.getSpeed()) {
				int damage = Damage(enemy.getDefence(), (int)player.getWeapon().getMaxD(), (int)player.getWeapon().getMinD());
				System.out.println(enemy.getName() + " is delt " + damage + " damage with " + player.getWeapon().getName() + "!");
				enemy.setHealth(enemy.getHealth() - damage);
			} else {
			System.out.println("Miss!");
			}
			break;
		}
	} //end of player turn

	private void EnemyTurn(Player player, Enemy enemy) { //enemy's turn during combat
		Enemystats(enemy);
		System.out.println(enemy.getName() + "'s Turn");
		if (random.nextInt(20) + 1 >= player.getSpeed()) {
			int damage = Damage(player.getDefence(), (int)enemy.getWeapon().getMaxD(), (int)enemy.getWeapon().getMinD());
			System.out.println(player.getName() + " is delt " + damage + " damage with " + enemy.getWeapon().getName() + "!");
			player.setHealth(player.getHealth() - damage);
		} else {
			System.out.println("Miss!");
		}
		return;
	} //end of enemy turn

	private int Damage(int defence, int MaxD, int MinD) { //damage inflicted during combat
		int attack = random.nextInt(MaxD) + MinD;
		int damage = attack - defence;
		if (damage > 0) {
			return damage;
		} else {
			return 0;
		}
	} //end of damage
}
