package core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleDynamicArray implements IDynamicArray {

	public SimpleDynamicArray()
	{
		size = 0;
		logger.setLevel(Level.OFF);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public boolean contains(Object obj) {
		if (activeArray == 1) {
			for (Object o : innerArray1) {
				if (obj.equals(o))
					return true;
			}
		} else
			for (Object o : innerArray2) {
				if (obj.equals(o))
					return true;
			}
		return false;
	}

	public Object[] toArray() {
		if (activeArray == 1)
			return innerArray1;
		else
			return innerArray2;
	}

	public boolean add(Object obj) {
		if (size == 0) {
			logger.info("Initial add");
			innerArray1 = new Object[1];
			innerArray1[0] = obj;
			activeArray = 1;
			size++;
			return true;
		} else if (activeArray == 1) {
			logger.info("Adding to array2");
			innerArray2 = new Object[size + 1];
			for (int i = 0; i < size; i++) {
				innerArray2[i] = innerArray1[i];
			}
			innerArray2[size] = obj;
			activeArray = 2;
			size++;
			return true;
		} else if (activeArray == 2) {
			logger.info("Adding to array1");
			innerArray1 = new Object[size + 1];
			for (int i = 0; i < size; i++) {
				innerArray1[i] = innerArray2[i];
			}
			innerArray1[size] = obj;
			activeArray = 1;
			size++;
			return true;
		} else
			return false;

	}

	public boolean remove(Object obj) {
		if (activeArray == 1) {
			int i = 0;
			boolean wasThere = false;
			innerArray2 = new Object[size - 1];

			for (Object o : innerArray1) {
				if (!o.equals(obj)) {
					innerArray2[i] = o;
					i++;
				} else
					wasThere = true;
			}
			activeArray = 2;
			size--;
			return wasThere;
		}

		else {
			int i = 0;
			boolean wasThere = false;
			innerArray1 = new Object[size - 1];

			for (Object o : innerArray2) {
				if (!o.equals(obj)) {
					innerArray1[i] = o;
					i++;
				} else
					wasThere = true;
			}
			activeArray = 1;
			size--;
			return wasThere;
		}

	}

	public Object remove(int index) {
		if (activeArray == 1) {
			Object tmp = innerArray1[index];
			this.remove(innerArray1[index]);
			return tmp;
		} else {
			Object tmp = innerArray2[index];
			this.remove(innerArray2[index]);
			return tmp;
		}
	}

	public void clear() {
		size = 0;
	}

	public Object get(int index) {
		if (activeArray == 1) {
			return innerArray1[index];

		} else {
			return innerArray2[index];
		}
	}

	public Object set(int index, Object obj) {
		if (activeArray == 1) {
			Object tmp = innerArray1[index];
			innerArray1[index] = obj;
			return tmp;

		} else {
			Object tmp = innerArray1[index];
			innerArray1[index] = obj;
			return tmp;
		}
	}

	public int indexOf(Object obj) {
		int i=0;
		
		if (activeArray == 1) {
			for(Object o : innerArray1)
			{
				if (o.equals(obj))
					return i;
				else
					i++;
			}
			return -1;

		} else {
			for(Object o : innerArray2)
			{
				if (o.equals(obj))
					return i;
				else
					i++;
			}
			return -1;
		}
	}

	private int size;
	Object[] innerArray1;
	Object[] innerArray2;
	private int activeArray;
	Logger logger = Logger.getLogger("SimpleDynamicArray");

}
