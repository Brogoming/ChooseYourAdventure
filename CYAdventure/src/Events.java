import java.util.Random;

public class Events {
	private Input input;
	private int answer;
	private Random random = new Random();
	
	private Player player;
	private Enemy goblin;
	private Enemy skeleton;
	
	private Weapon sword;
	private Weapon dagger;
	private Weapon wand;
	private Weapon fist;
	
	private Armor robe;
	private Armor plate;
	private Armor chain;
	private Armor cloth;
	
	private Item hPotion;
	
	public Events() { //temporary
		Classes();
		PlayerCharacter();
		Combat(player, skeleton);
		Playerstats(player);
	}
	
	public void Classes() { //loads all of the excess classes
		input = new Input();
		Items();
		Weapons();
		Armors();
		Characters();
	}
	
	private void Armors() { //loads all armors
		cloth = new Armor("Loin Cloth", 1);
		plate = new Armor("Plate Armor", 8);
		robe = new Armor("Robe", 5);
		chain = new Armor("Chain Mail", 6);
		
	}

	public void Weapons() { //loads all weapons
		sword = new Weapon("Sword", 5, 5); //10
		dagger = new Weapon("Dagger", 4, 4); //8
		wand = new Weapon("Wand", 12, 0); //12
		fist = new Weapon("Fist", 1, 1); //2
	}
	
	public void Characters() { //loads all characters
		player = new Player();
		goblin = new Enemy("Goblin", 7, 10, cloth, dagger, "easy");
		skeleton = new Enemy("Skeleton", 12, 7, chain, sword, "medium");
	}
	
	public void Items() { //loads all items
		hPotion = new Item("Health Potion", Effects.HEALINNG);
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
			player = new Player("Knight", 15, 5, plate, sword);
			break;
		case 2:
			player = new Player("Rogue", 12, 15, chain, dagger);
			break;
		case 3:
			player = new Player("Wizard", 8, 12, robe, sword);
			break;
		}
	}// end of Player character
	
	public void Playerstats(Player player) { //shows that players stats
		System.out.println("========================================");
		System.out.println("Player: " + player.getName());
		System.out.println("Health: " + player.getTempHealth() + "/" + player.getFullHealth() + " Speed: " + player.getSpeed() + " Defence: " + player.getArmor().getDefence() + " Level: " + player.getLevel() + " XP: " + player.getCurrentXp());
	} //end of player stats
	
	public void Enemystats(Enemy enemy) { //shows that enemy's stats
		System.out.println("========================================");
		System.out.println("Enemy: " + enemy.getName());
		System.out.println("Health: " + enemy.getTempHealth() + "/" + enemy.getFullHealth() + " Speed: " + enemy.getSpeed() + " Defence: " + enemy.getArmor().getDefence());
	} //end of enemy stats
	
	private void Combat(Player player, Enemy enemy) { //combat between 2 people: player, enemy, player weapon, enemy weapon
		boolean attacking = true;
		while(attacking){
			if (enemy.getSpeed() > player.getSpeed()) { //the enemy attacks
				EnemyTurn(player, enemy);
				if (!TestDead(player, enemy)) {
					attacking = false;
					continue;
				}
				PlayerTurn(player, enemy);
				if (!TestDead(player, enemy)) {
					attacking = false;
					continue;
				}
			} else {
				PlayerTurn(player, enemy);
				if (!TestDead(player, enemy)) {
					attacking = false; 
					continue;
				}
				EnemyTurn(player, enemy);
				if (!TestDead(player, enemy)) {
					attacking = false;
					continue;
				}
			}
		}
	} //end of combat
	
	private boolean TestDead(Player player, Enemy enemy) { //looks to see if the player or enemy is dead
		if (player.getTempHealth() <= 0 || enemy.getTempHealth() <= 0) {
			if(player.getTempHealth() <= 0) {
				System.out.println(player.getName() + " is dead!");
			}
			if(enemy.getTempHealth() <= 0) {
				System.out.println(enemy.getName() + " is dead!");
				player.LevelUp(enemy.getXpDrop());
			}
			return false;
		} else {
			return true;
		}
	} //end of test dead
	
	private void PlayerTurn(Player player, Enemy enemy) { //players turn during combat
		Playerstats(player);
		System.out.println(player.getName() + "'s Turn");
		System.out.println("----------------------------------------");
		System.out.println("1. Use " + player.getWeapon().getName());
		System.out.println("2. Open Inventory");
		answer = input.numInput();
		switch(answer) {
		case 1:
			if (random.nextInt(20) + 1 >= enemy.getSpeed()) {
				int damage = Damage(enemy.getArmor().getDefence(), (int)player.getWeapon().getMaxD(), (int)player.getWeapon().getMinD());
				System.out.println(enemy.getName() + " is delt " + damage + " damage with " + player.getWeapon().getName() + "!");
				enemy.setTempHealth(enemy.getTempHealth() - damage);
			} else {
			System.out.println("Miss!");
			}
			break;
		case 2:
			System.out.println(player.Inventory());
			break;
		}
	} //end of player turn

	private void EnemyTurn(Player player, Enemy enemy) { //enemy's turn during combat
		Enemystats(enemy);
		System.out.println(enemy.getName() + "'s Turn");
		if (random.nextInt(20) + 1 >= player.getSpeed()) {
			int damage = Damage(player.getArmor().getDefence(), (int)enemy.getWeapon().getMaxD(), (int)enemy.getWeapon().getMinD());
			System.out.println(player.getName() + " is delt " + damage + " damage with " + enemy.getWeapon().getName() + "!");
			player.setTempHealth(player.getTempHealth() - damage);
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
