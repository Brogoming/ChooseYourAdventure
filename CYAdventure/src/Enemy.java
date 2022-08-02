import java.util.Random;

public class Enemy {
	
	private String name;
	private int health;
	private int speed;
	private int defence;
//	private int money;
//	private int XpDrop;
	
//	private Random random = new Random();
	private Weapon Eweapon;
	
	public Enemy() { //default constructor
		this.name = null;
		this.health = 0;
		this.speed = 0;
		this.defence = 0;
//		this.money = 0;
//		this.XpDrop = 0;
		this.Eweapon = new Weapon();
	}
	
	public Enemy(String name, int health, int speed, int defence, Weapon weapon) { //sets up the basic enemy
		this.name = name;
		this.health = health;
		this.speed = speed;
		this.defence = defence;
		this.Eweapon = weapon;
	}

//	private void enemyType(String type) { //determines Experience drop, money drop, and loot drop
//		if (type == "easy") {
//			setXpDrop(random.nextInt(10) + 1);
//		} else if (type == "medium") {
//			setXpDrop(random.nextInt(75) + 10);
//		} else if (type == "hard") {
//			setXpDrop(random.nextInt(150) + 75);
//		}
//	}

	public Weapon getWeapon() {
		return Eweapon;
	}

	public void setWeapon(Weapon weapon) {
		this.Eweapon = weapon;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getSpeed() {
		return speed;
	}

	public int getDefence() {
		return defence;
	}

//	public int getMoney() {
//		return money;
//	}
//
//	public int getXpDrop() {
//		return XpDrop;
//	}
//
//	public Random getRandom() {
//		return random;
//	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

//	public void setMoney(int money) {
//		this.money = money;
//	}
//
//	public void setXpDrop(int xpDrop) {
//		XpDrop = xpDrop;
//	}
//
//	public void setRandom(Random random) {
//		this.random = random;
//	}
	
}
