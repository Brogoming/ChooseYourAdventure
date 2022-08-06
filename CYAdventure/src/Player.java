import java.util.Arrays;
import java.util.ArrayList;

public class Player {

	private String name;
	private int fullHealth;
	private int tempHealth;
	private int speed;
	private int level = 1;
	private int currentXp;
	private int neededXp;
//	//Inventory
//	private int money;
	
	private Weapon weapon;
	private Armor armor;
	private Item item;
	
	private ArrayList <Item> inventory;
	
	public Player() { //default constructor
		this.name = null;
		this.fullHealth = 0;
		this.tempHealth = 0;
		this.speed = 0;
		this.currentXp = 0;
//		this.money = 0;
		this.weapon = new Weapon();
		this.armor = new Armor();
		this.inventory = new ArrayList <Item>();
	}
	
	public Player(String name, int health, int speed, Armor armor, Weapon weapon) { //custom constructor
		this.name = name;
		this.fullHealth = health;
		this.tempHealth = health;
		this.speed = speed;
		this.weapon = weapon;
		this.armor = armor;
	}
	
//	public void AddInventory(Item item) { //add item to inventory
//		
//		if (inventory.size() != 5) {
//			inventory.add(item);
//		} else {
//			System.out.println("Inventory is full!");
//		}
//	}
//	
//	public void UseInventory() { //uses the item in inventory 
//		
//	}
//	
//	public void Inventory() { //shows inventory
////		for (int i = 0; i < inventory.size(); i++) {
////			System.out.println((i+1) + ". " + inventory.get(i).getName());
////		}
//		System.out.println(inventory.get(0).getName());
//	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void LevelUp(int addXp) { //levels up the player
		neededXp = 50 * level;
		setCurrentXp(currentXp + addXp);
		if (getCurrentXp() >= neededXp) {
			level = level + 1;
			setLevel(level);
			if (getLevel()%2 == 0) {
				setFullHealth(getFullHealth()+2);
			}
			setTempHealth(getFullHealth());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
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

//	public int getMoney() {
//		return money;
//	}
//
//	public void setMoney(int money) {
//		this.money = money;
//	}
//
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCurrentXp() {
		return currentXp;
	}

	public void setCurrentXp(int currentXp) {
		this.currentXp = currentXp;
	}
	
	
}
