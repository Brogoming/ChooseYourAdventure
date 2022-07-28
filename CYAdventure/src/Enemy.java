
public class Enemy {
	
	private String name;
	private int health;
	private int damage;
	private int speed;
	private int defence;
	private int money;
	
	public Enemy() { //default constructor
		this.name = null;
		this.health = 0;
		this.damage = 0;
		this.speed = 0;
		this.defence = 0;
		this.money = 0;
	}
	
	public Enemy(String name, int health, int damage, int speed, int defence, int money) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.defence = defence;
		this.money = money;
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
	
}
