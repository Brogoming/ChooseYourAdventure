
public class Player {

	private String name;
	private int health;
	private int damage;
	private int speed;
	private int defence;
	private int money;
	
	public Player() { //default constructor
		this.name = null;
		this.health = 0;
		this.damage = 0;
		this.speed = 0;
		this.defence = 0;
		this.money = 0;
	}
	
	public Player(String name, int health, int damage, int speed, int defence) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.defence = defence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}