
public class Player {

	private String name;
	private int health;
	private int damage;
	private int speed;
	private int defence;
	private int level;
	private int currentXp;
	private int neededXp;
	//Inventory
	private int money;
	private String M1;
	private String M2;
	private String M3;
	private int D1;
	private int D2;
	private int D3;
	
	public Player() { //default constructor
		this.name = null;
		this.health = 0;
		this.damage = 0;
		this.speed = 0;
		this.defence = 0;
		this.money = 0;
		this.level = 1;
		this.currentXp = 0;
		this.neededXp = 100 * level;
	}
	
	public Player(String name, int health, int speed, int defence, String M1, String M2, String M3, int D1, int D2, int D3) {
		this.name = name;
		this.health = health;
		this.speed = speed;
		this.defence = defence;
		this.M1 = M1;
		this.M2 = M2;
		this.M3 = M3;
		this.D1 = D1;
		this.D2 = D2;
		this.D3 = D3;
		
	}
	
	public void LevelUp() { //levels up the player
		if (currentXp == neededXp) {
			setLevel(+1);
		}
	}
	
	public String getM1() {
		return M1;
	}

	public void setM1(String m1) {
		M1 = m1;
	}

	public String getM2() {
		return M2;
	}

	public void setM2(String m2) {
		M2 = m2;
	}

	public String getM3() {
		return M3;
	}

	public void setM3(String m3) {
		M3 = m3;
	}

	public int getD1() {
		return D1;
	}

	public void setD1(int d1) {
		D1 = d1;
	}

	public int getD2() {
		return D2;
	}

	public void setD2(int d2) {
		D2 = d2;
	}

	public int getD3() {
		return D3;
	}

	public void setD3(int d3) {
		D3 = d3;
	}

	public void Moves(Input input, String M1, String M2, String M3, int D1, int D2, int D3) {
		System.out.println("1. " + M1);
		System.out.println("2. " + M2);
		System.out.println("3. " + M3);
		System.out.println("----------------------------------------");
		int answer = input.numInput();
		switch(answer) {
		case 1: 
			setDamage(D1);
			break;
		case 2: 
			setDamage(D2);
			break;
		case 3: 
			setDamage(D3);
			break;
		}
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
