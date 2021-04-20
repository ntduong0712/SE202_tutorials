package to_dos.prototype;

import java.util.Hashtable;

/* Create the ShapeCache class to get concrete classes from database 
   and store them in a Hashtable. */
public class ShapeCache {

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	/*
	 * TO-DO: Implement the loadCache() method 
	 * For each shape run database query and
	 * create shape shapeMap.put(shapeKey, shape);
	 */
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);

	}
}