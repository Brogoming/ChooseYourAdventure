import java.util.Random;

public class Enemy {
	
	private String name;
	private String type;
	private int fullHealth;
	private int tempHealth;
	private int speed;
//	private int money;
	private int XpDrop;
	
	private Random random = new Random();
	private Weapon weapon;
	private Armor armor;
	
	public Enemy() { //default constructor
		this.name = null;
		this.type = "easy";
		this.fullHealth = 0;
		this.speed = 0;
//		this.money = 0;
		this.XpDrop = 0;
		this.weapon = new Weapon();
		this.armor = new Armor();
	}
	
	public Enemy(String name, int health, int speed, Armor armor, Weapon weapon, String type) { //sets up the basic enemy
		this.name = name;
		this.fullHealth = health;
		this.tempHealth = health;
		this.speed = speed;
		this.armor = armor;
		this.weapon = weapon;
		enemyType(type);
	}

	private void enemyType(String type) { //determines Experience drop, money drop, and loot drop
		if (type == "easy") {
			setXpDrop(random.nextInt(10) + 1);
		} else if (type == "medium") {
			setXpDrop(random.nextInt(75) + 11);
		} else if (type == "hard") {
			setXpDrop(random.nextInt(150) + 76);
		}
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFullHealth() {
		return fullHealth;
	}

	public void setFullHealth(int health) {
		this.fullHealth = health;
	}

	public int getTempHealth() {
		return tempHealth;
	}

	public void setTempHealth(int tempHealth) {
		this.tempHealth = tempHealth;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getXpDrop() {
		return XpDrop;
	}

	public void setXpDrop(int xpDrop) {
		XpDrop = xpDrop;
	}
	
}
