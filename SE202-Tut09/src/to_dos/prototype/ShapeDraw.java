package to_dos.prototype;

/* Create the ShapeDraw class which uses ShapeCache class 
to get clones of shapes stored in a Hashtable. */
public class ShapeDraw {
	// TO-DO: Implement the main() method for testing purpose
	public static void main(String[] args) {
		// run loadCache() method
		ShapeCache.loadCache();
		
		/*
		 * create 3 cloned shapes with 3 different types Hint: use getShape() &
		 * getType() methods
		 */
		Shape shape1 = (Shape) ShapeCache.getShape("1");
		System.out.println("Shape: " + shape1.getType());
		
		Shape shape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape: " + shape2.getType());
		
		Shape shape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape: " + shape3.getType());
	}
}