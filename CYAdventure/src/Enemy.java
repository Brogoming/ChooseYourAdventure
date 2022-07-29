import java.util.Random;

public class Enemy {
	
	private String name;
	private int health;
	private int damage;
	private int speed;
	private int defence;
	private int money;
	private int XpDrop;
	private Random random = new Random();
	
	public Enemy() { //default constructor
		this.name = null;
		this.health = 0;
		this.damage = 0;
		this.speed = 0;
		this.defence = 0;
		this.money = 0;
		this.XpDrop = 0;
	}
	
	public Enemy(String name, int health, int damage, int speed, int defence, String type) { //sets up the basic enemy
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.defence = defence;
		enemyType(type);
	}

	private void enemyType(String type) { //determines Experience drop, money drop, and loot drop
		if (type == "easy") {
			setXpDrop(random.nextInt(10) + 1);
		} else if (type == "medium") {
			setXpDrop(random.nextInt(75) + 10);
		} else if (type == "hard") {
			setXpDrop(random.nextInt(150) + 75);
		}
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

	public int getDamage() {
		return damage;
	}

	public int getSpeed() {
		return speed;
	}

	public int getDefence() {
		return defence;
	}

	public int getMoney() {
		return money;
	}

	public int getXpDrop() {
		return XpDrop;
	}

	public Random getRandom() {
		return random;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setXpDrop(int xpDrop) {
		XpDrop = xpDrop;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
}
