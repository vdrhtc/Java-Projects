package core;


public class Animal implements Comparable<Animal>{

	public Animal(int DNA, int size)
	{
		this.animalDNA=DNA;
		this.size = size;
	}
	
	public int compareTo(Animal a)
	{
		return this.size - a.size;
	}
	
	@Override
	public String toString() {
		return "Animal [DNA: " + animalDNA + " Size: " + size+"]";
	}
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj==null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Animal other = (Animal)obj;
		return animalDNA == other.animalDNA;
	}
	int animalDNA;
	int size;
}
