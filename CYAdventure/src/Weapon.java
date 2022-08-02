
public class Weapon {
	
	private String name;
	private int MaxD;
	private int MinD;
	
	public Weapon() {
		this.name = null;
		this.MaxD = 0;
		this.MinD = 0;
	}
	
	public Weapon(String name, int MaxD, int MinD) {
		this.name = name;
		this.MaxD = MaxD;
		this.MinD = MinD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxD() {
		return MaxD;
	}

	public void setMaxD(int maxD) {
		MaxD = maxD;
	}

	public int getMinD() {
		return MinD;
	}

	public void setMinD(int minD) {
		MinD = minD;
	}

}
