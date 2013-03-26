package core;

public class DynamicArrayTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IDynamicArray array;
		array = DynamicArrays.readFromConsole();
		DynamicArrays.print(array);
		while(1>0) {
		DynamicArrays.controlArray(array);
		DynamicArrays.print(array);
		}
	}

}
