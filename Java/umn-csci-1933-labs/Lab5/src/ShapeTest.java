import junit.framework.TestCase;


public class ShapeTest extends TestCase {
	private Circle c1,c2,c3,c4;
	private Square s1,s2,s3,s4;
	public void setUp() {
		s1= new Square(2.0);
		s2= new Square(3.0);
		s3= new Square(4.0);
		s4= new Square(3.0);
		c1= new Circle(2.0);
		c2= new Circle(3.0);
		c3= new Circle(4.0);
		c4= new Circle(3.0);
	}
	public void testSquareArea() {
		assertEquals(s1.getArea(),4.0);
		assertEquals(s2.getArea(),9.0);
		assertEquals(s3.getArea(),16.0);
	}
	public void testCircleArea() {
		assertEquals(c1.getArea(),Math.PI * Math.pow(2.0,2));
		assertEquals(c2.getArea(),Math.PI * Math.pow(3.0,2));
		assertEquals(c3.getArea(),Math.PI * Math.pow(4.0,2));
	}
	public void testGetSquareName() {
		assertEquals(s1.getShapeName(),"Square");
	}
	public void testGetCircleName() {
		assertEquals(c1.getShapeName(), "Circle");
	}
	public void testShapeCompareTo() {
		assertTrue(c1.compareTo(s1) > 0);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(s1.compareTo(s2) < 0);
		assertTrue(s2.compareTo(s4) == 0);
		assertTrue(c2.compareTo(c4) == 0);
	}
}
