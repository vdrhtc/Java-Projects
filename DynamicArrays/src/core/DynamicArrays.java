package core;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public final class DynamicArrays {

	public static void sort(IDynamicArray array) {
		Object[] arr = array.toArray();
		Arrays.sort(arr);
		int i=0;
		for(Object o : arr)
		{
			array.set(i, o);
			i++;
		}
	}

	public static void print(IDynamicArray array) {
		Object[] arr = array.toArray();
		if (arr[0] == null)
			System.out.println("Empty");
		for (Object obj : arr) {
			System.out.println(obj.toString());
		}
	}

	public static IDynamicArray readFromConsole() {
		Scanner in = new Scanner(System.in);
		if (in.next().equals("Simple")) {
			IDynamicArray array = new SimpleDynamicArray();
			String nextClassName = in.next();
			while (!nextClassName.equals("stopFilling")) {

				if (nextClassName.equals("Animal")) {
					array.add(new Animal(in.nextInt(), in.nextInt()));
				} else if (nextClassName.equals("Human")) {
					array.add(new Human(in.nextInt(), in.nextInt(), in.next()));
				}
				nextClassName = in.next();
			}
			return array;
		} else {
			IDynamicArray array = new LinkedDynamicArray();
			String nextClassName = in.next();
			while (!nextClassName.equals("stopFilling")) {

				if (nextClassName.equals("Animal")) {
					array.add(new Animal(in.nextInt(), in.nextInt()));
				} else if (nextClassName.equals("Human")) {
					array.add(new Human(in.nextInt(), in.nextInt(), in.next()));
				}
				nextClassName = in.next();
			}
			return array;
		}
	}

	public static void controlArray(IDynamicArray arr) {
		Scanner in = new Scanner(System.in);
		String nextCommand = in.next();

		while (!nextCommand.equals("disp")) {
			if (nextCommand.equals("remove")) {
				String type = in.next();
				if (type.equals("Animal")) {
					int DNA = in.nextInt();
					Animal toRemove = new Animal(DNA, -1);
					arr.remove(toRemove);
				} else if (type.equals("Human")) {
					int DNA = in.nextInt();
					Human toRemove = new Human(DNA, -1, null);
					arr.remove(toRemove);
				}
				nextCommand = in.next();

			} else if (nextCommand.equals("sort")) {
				DynamicArrays.sort(arr);
				nextCommand = in.next();
			} else if (nextCommand.equals("removeByIndex")) {
				int index = in.nextInt();
				arr.remove(index);
				nextCommand = in.next();
			} else if (nextCommand.equals("getSize")) {
				System.out.println(arr.size());
				nextCommand = in.next();
			} else if (nextCommand.equals("isEmpty")) {
				if (arr.isEmpty() == true)
					System.out.println("Yes");
				else
					System.out.println("No");
				nextCommand = in.next();
			} else if (nextCommand.equals("contains")) {
				int DNA = in.nextInt();
				Animal test = new Animal(DNA, -1);
				if (arr.contains(test) == true)
					System.out.println("Yes");
				else
					System.out.println("No");
				nextCommand = in.next();
			} else if (nextCommand.equals("add")) {
				String type = in.next();
				if (type.equals("Animal")) {
					arr.add(new Animal(in.nextInt(), in.nextInt()));
				} else if (type.equals("Human")) {
					arr.add(new Human(in.nextInt(), in.nextInt(), in.next()));
				}
				nextCommand = in.next();
			} else if (nextCommand.equals("clear")) {
				arr.clear();
				nextCommand = in.next();
			} else if (nextCommand.equals("get")) {
				System.out.println(arr.get(in.nextInt()).toString());
				nextCommand = in.next();

			} else if (nextCommand.equals("set")) {
				int index = in.nextInt();
				String type = in.next();
				if (type.equals("Animal")) {
					arr.set(index, new Animal(in.nextInt(), in.nextInt()));
				} else if (type.equals("Human")) {
					arr.set(index,
							new Human(in.nextInt(), in.nextInt(), in.next()));
				}
				nextCommand = in.next();
			} else if(nextCommand.equals("indexOf")) {
				String type= in.next();
				if (type.equals("Animal")) {
					System.out.println(""+arr.indexOf(new Animal(in.nextInt(), in.nextInt())));
				} else if (type.equals("Human")) {
					System.out.println(""+arr.indexOf(new Human(in.nextInt(), in.nextInt(), in.next())));
				}
			} else if (nextCommand.equals("exit"))
				System.exit(0);
		}
	}

	Logger logger = Logger.getLogger("DynamicArrays");
}
