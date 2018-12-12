
public abstract class Shape implements Comparable<Shape> {
	/**
	 * Calculates the area of the shape
	 * @return The area of the shape
	 */
	public abstract double getArea();
	
	/**
	 * (Triangle, Circle, Square, etc)
	 * @return The name of the shape
	 */
	public abstract String getShapeName();
	
	/**
	 * Creates a string describing the shape
	 * @return Returns the string describing the shape
	 */
	public String toString() {
		return String.format("%s has an area of %.03f", getShapeName(), getArea());
	}
	
	/**
	 * @return true if and only if o is the same shape and size as this shape
	 */
	public boolean equals(Object o) {
	    if (o != null && this.getClass() == o.getClass()) {
	        Shape s = (Shape)o;
	        if (getArea() == s.getArea()) {
	            return true;
	        } else {
	            return false;
	        }
	    } else {
	        return false;
	    }
	}
	
	/**
	 * This method is used for sorting shapes by their area.
	 * 
	 * @return less than 0 if s has a larger area than this
	 * shape, greater than 0 if s has a smaller area than
	 * this shape, and 0 if s has the same size area as
	 * this shape.
	 */
	public int compareTo(Shape s) {
        if (this.getArea()<s.getArea()){
            return -1;
        }
        if (this.getArea()>s.getArea()){
            return 1;
        }
		return 0;
	}
}
