import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShapeSorter {
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		for (double i = 5; i < 8.0; i+= 0.5) {
			shapes.add(new Square(i));
			shapes.add(new Circle(i/2.0));
		}
		
		Collections.sort(shapes);
		for (Shape s : shapes) {
			System.out.println(s);
		}
	}
}
