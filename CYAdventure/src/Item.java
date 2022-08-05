
public class Item {
	
	private String name;
	private Effects effect;
	
	public Item() {
		this.name = null;
		this.effect = Effects.NONE;
	}
	
	public Item(String name, Effects effect) {
		this.name = name;
		this.effect = effect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Effects getEffect() {
		return effect;
	}

	public void setEffect(Effects effect) {
		this.effect = effect;
	}

}
