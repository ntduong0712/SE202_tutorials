package todos;

public class BagTest {
	public static void main(String[] args) {
		BagInterface<String> colorBag = new ArrayBag();
		System.out.println("Initial bag size: " + colorBag.getCurrentSize());
		System.out.println("Check whether bag is empty: " + colorBag.isEmpty());
		System.out.println("Adding new objects to the bag: red, yellow, green.");
		colorBag.add("red");
		colorBag.add("yellow");
		colorBag.add("green");
		System.out.println("Now the current size is: " + colorBag.getCurrentSize());
		System.out.println("Remove color green..." );
		colorBag.remove();
		System.out.println("Check if the bag still contain color green: " + colorBag.contains("green"));
		System.out.println("Clear the bag...");
		colorBag.clear();
		System.out.println("Final bag size: " + colorBag.getCurrentSize());
		
	}
}
