
public class Item {
	
	private String name;
	private String effect;
	
	public Item() {
		this.name = null;
		this.effect = null;
	}
	
	public Item(String name, String effect) {
		this.name = name;
		this.effect = effect;
	}
	
	public void useItem() {
		if(effect == "h") {
			
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
