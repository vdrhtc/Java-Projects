package core;

public interface IDynamicArray {
	int size();
	boolean isEmpty();
	boolean contains(Object obj);
	Object[] toArray();
	boolean add(Object obj);
	boolean remove(Object obj);
	Object remove(int index);
	void clear();
	Object get(int index);
	Object set(int index, Object obj);
	int indexOf(Object obj);
}
