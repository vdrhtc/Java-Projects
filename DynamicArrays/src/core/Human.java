package core;

public class Human extends Animal {

	public Human(int DNA, int size, String name)
	{
		super(DNA, size);
		this.name=name;
	}
	
	@Override
	public String toString() {
		return "Human [DNA: " + animalDNA + " Size: " + size + " Name: "+name+ "]";
	}
	String name;
}
