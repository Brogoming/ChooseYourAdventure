
public class Armor {
	
	private String name;
	private int defence;
	
	public Armor() {
		this.name = null;
		this.defence = 0;
	}
	
	public Armor(String name, int defence) {
		this.name = name;
		this.defence = defence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

}
