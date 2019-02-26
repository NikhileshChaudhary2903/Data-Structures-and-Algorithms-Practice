
public abstract class Creature {

	protected String name,sound;
	protected int weight;
	
	public abstract void setName(String name);
	public abstract String getName();
	
	abstract public int getWeight();
	abstract public void setWeight(int weight);
	
}
